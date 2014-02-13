package org.jroche.service.order.purchase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.jroche.common.util.extjs.FilterRequest;
import org.jroche.common.util.mapper.order.purchase.PurchaseOrderItemsMapper;
import org.jroche.common.util.mapper.order.purchase.PurchaseOrderMapper;
import org.jroche.persistence.model.order.purchase.PurchaseOrder;
import org.jroche.persistence.model.order.purchase.PurchaseOrderItems;
import org.jroche.persistence.model.order.purchase.QPurchaseOrder;
import org.jroche.persistence.model.product.Product;
import org.jroche.persistence.model.product.QProductGroup;
import org.jroche.persistence.model.user.Customer;
import org.jroche.persistence.repo.order.purchase.PurchaseOrderItemsRepository;
import org.jroche.persistence.repo.order.purchase.PurchaseOrderRepository;
import org.jroche.persistence.repo.product.ProductRepository;
import org.jroche.persistence.repo.user.UserRepository;
import org.jroche.service.product.ProductService;
import org.jroche.web.model.order.TransactionAmountSummary;
import org.jroche.web.model.order.purchase.PurchaseOrderItemsUI;
import org.jroche.web.model.order.purchase.PurchaseOrderUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.BooleanExpression;

@Service
public class PurchaseOrderService {

	@Autowired
	private PurchaseOrderRepository poRepository;
	@Autowired
	private PurchaseOrderItemsRepository itemsRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;
	@PersistenceContext
	private EntityManager entityManager;

	private PurchaseOrderMapper poMapper = new PurchaseOrderMapper();
	private PurchaseOrderItemsMapper itemsMapper = new PurchaseOrderItemsMapper();

	private Logger logger = Logger.getLogger(ProductService.class);

	@Transactional
	public PurchaseOrderUI create(PurchaseOrderUI uiBean) {
		PurchaseOrder po = poMapper.toPersistenceBean(uiBean);
		Set<PurchaseOrderItems> items = po.getItems();
		po.setItems(null);

		Customer customer = userRepository.findByUsername(uiBean.getUserName());
		po.setCustomer(customer);

		long total = 0;
		if (items != null && items.size() > 0) {
			for (PurchaseOrderItems item : items) {
				total += item.getQuantity() * item.getUnitPrice() * ( 100 - item.getDiscount() ) / 100 ;
			}
		}
		po.setTotal(total);

		
		PurchaseOrder saved = poRepository.save(po);

		if (items != null && items.size() > 0) {
			for (PurchaseOrderItems item : items) {
				logger.debug("Item :: " + item);
				Product product = productRepository.findByProductName(item
						.getProduct().getProductName());
				item.setProduct(product);
				PurchaseOrder order = poRepository.findByOrderId(uiBean
						.getOrderId());
				item.setPo(order);
				logger.debug("Item :: " + item);
			}
			itemsRepository.save(items);
		}
		logger.debug("Created Account : " + saved);

		return poMapper.toUIBean(saved);
	}

	public PurchaseOrderUI find(PurchaseOrderUI uiBean) {
		return poMapper
				.toUIBean(poRepository.findByOrderId(uiBean.getOrderId()));
	}

	public List<PurchaseOrderUI> findAll() {
		return poMapper.toUIBean(poRepository.findAll());
	}

	public Page<PurchaseOrderUI> findAll(Pageable pageable,
			List<FilterRequest> filters) {
		Predicate predicate = toPredicate(filters);
		return poMapper.toUIBean(poRepository.findAll(predicate, pageable),
				pageable);
	}

	public PurchaseOrderUI findByOrderId(String orderId) {
		return poMapper.toUIBean(poRepository.findByOrderId(orderId));
	}

	public List<PurchaseOrderItemsUI> findItemsByOrderId(int orderId) {
		return itemsMapper.toUIBean(itemsRepository.findByPo(new PurchaseOrder(
				new Long(orderId))));
	}

	@Transactional
	public PurchaseOrderUI update(PurchaseOrderUI uiBean) {
		PurchaseOrder po = poMapper.toPersistenceBean(uiBean);
		Set<PurchaseOrderItems> items = po.getItems();

		PurchaseOrder existing = poRepository
				.findByOrderId(uiBean.getOrderId());
		if (existing == null) {
			return null;
		}

		existing.setComments(po.getComments());
		existing.setDiscount(po.getDiscount());
		existing.setDueDate(po.getDueDate());
		existing.setOrderDate(po.getOrderDate());
		existing.setReferenceNumber(po.getReferenceNumber());

		Customer customer = userRepository.findByUsername(uiBean.getUserName());
		existing.setCustomer(customer);
		existing.setItems(null);

		PurchaseOrder saved = poRepository.save(existing);
		
		long total = 0;
		if (items != null && items.size() > 0) {
			List<PurchaseOrderItems> existingItems = itemsRepository
					.findByPo(saved);

			Map<String, PurchaseOrderItems> purchasedItemsMap = new HashMap<String, PurchaseOrderItems>();
			for (PurchaseOrderItems pim : items) {
				purchasedItemsMap.put(pim.getProduct().getProductName(), pim);
			}
			Map<String, PurchaseOrderItems> existingItemsMap = new HashMap<String, PurchaseOrderItems>();
			for (PurchaseOrderItems i : existingItems) {
				existingItemsMap.put(i.getProduct().getProductName(), i);
			}

			/* Delete Purchase Order Items */
			List<PurchaseOrderItems> deleteItems = new ArrayList<PurchaseOrderItems>();
			for (PurchaseOrderItems deleteItem : existingItems) {
				if (!purchasedItemsMap.containsKey(deleteItem.getProduct()
						.getProductName())) {
					deleteItems.add(deleteItem);
				}
			}
			itemsRepository.delete(deleteItems);

			/* Updating/Inserting Purchase Order Items */
			List<PurchaseOrderItems> toBeSavedItems = new ArrayList<PurchaseOrderItems>();
			for (PurchaseOrderItems item : items) {
				PurchaseOrderItems existingItem = existingItemsMap.get(item
						.getProduct().getProductName());
				Product product = productRepository.findByProductName(item
						.getProduct().getProductName());
				PurchaseOrder order = poRepository.findByOrderId(uiBean
						.getOrderId());
				if (existingItem != null) {
					existingItem.setQuantity(item.getQuantity());
					existingItem.setUnitPrice(item.getUnitPrice());
					existingItem.setDiscount(item.getDiscount());
					toBeSavedItems.add(existingItem);
					item = existingItem;
				} else {
					item.setProduct(product);
					item.setPo(order);
					toBeSavedItems.add(item);
				}
				total += item.getQuantity() * item.getUnitPrice() * ( 100 - item.getDiscount() ) / 100 ;
			}
			saved.setTotal(total);
			itemsRepository.save(toBeSavedItems);

		}
		logger.debug("update purchase order : " + saved);

		return poMapper.toUIBean(saved);
	}

	public Boolean delete(PurchaseOrderUI uiBean) {
		return true;
	}
	
	public static enum COLUMNS {
		COMPANYID
	}

	private Predicate toPredicate(final List<FilterRequest> filters) {
		logger.info("Entering predicates :: " + filters);

		QPurchaseOrder order = QPurchaseOrder.purchaseOrder;
		BooleanExpression result = null;

		try {
			for (FilterRequest filter : filters) {

				COLUMNS column = COLUMNS.valueOf(filter.getProperty()
						.toUpperCase());
				BooleanExpression expression = null;

				switch (column) {
				case COMPANYID:
					if (filter.getValue() != null
							&& !"".equals(filter.getValue())) {
						expression = order.companyId.like("%"
								+ filter.getValue() + "%");
					}
					break;
				}
				if (expression != null) {
					if (result != null) {
						result = result.and(expression);
					} else {
						result = expression;
					}
				}
			}
		} catch (Exception ex) {
			logger.error(ex);
		}
		logger.info("Result Predicate :: "
				+ (result != null ? result.toString() : ""));

		logger.info("Exiting predicates");
		return result;
	}

	public List<TransactionAmountSummary> monthlyPurchases(int month, int year) {

		String query = "select new org.jroche.web.model.order.TransactionAmountSummary(p.companyId,day(orderDate), sum(total)) "
				+ " from purchaseOrder p where month(orderDate) = " + month + 
				" and " + " year(orderDate) = " + year + 
				" and " + " p.companyId = \'" + SecurityContextHolder.getContext().getAuthentication().getName() + "\'" +
				" group by orderDate,p.companyId";

		return entityManager.createQuery(query).getResultList();
	}

	public List<TransactionAmountSummary> yearlyPurchases(int year) {

		String query = "select new org.jroche.web.model.order.TransactionAmountSummary(p.companyId, month(orderDate), sum(total)) "
				+ " from purchaseOrder p where year(orderDate) = " + year + 
				" and " + " p.companyId = \'" + SecurityContextHolder.getContext().getAuthentication().getName() + "\'" +
				" group by month(orderDate),p.companyId";

		return entityManager.createQuery(query).getResultList();
	}

	public List<TransactionAmountSummary> allYearPurchases() {

		String query = "select new org.jroche.web.model.order.TransactionAmountSummary(p.companyId, year(orderDate), sum(total)) "
				+ " from purchaseOrder p " + 
				" where " + " p.companyId = \'" + SecurityContextHolder.getContext().getAuthentication().getName() + "\'" +
				" group by year(orderDate),p.companyId";

		return entityManager.createQuery(query).getResultList();
	}

}
