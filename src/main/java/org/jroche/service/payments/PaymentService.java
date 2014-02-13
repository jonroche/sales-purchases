package org.jroche.service.payments;

import java.util.List;

import org.apache.log4j.Logger;
import org.jroche.common.util.extjs.FilterRequest;
import org.jroche.common.util.mapper.payment.UserPaymentMapper;
import org.jroche.persistence.model.payments.QUserPayment;
import org.jroche.persistence.model.payments.UserPayment;
import org.jroche.persistence.model.product.Product.COLUMNS;
import org.jroche.persistence.model.user.Customer;
import org.jroche.persistence.repo.payments.UserPaymentRepository;
import org.jroche.persistence.repo.user.UserRepository;
import org.jroche.web.model.payments.UserPaymentUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.BooleanExpression;

@Service
public class PaymentService {

	@Autowired
	private UserPaymentRepository repository;

	@Autowired
	private UserRepository userRepository;

	private Logger logger = Logger.getLogger(PaymentService.class);

	private UserPaymentMapper mapper = new UserPaymentMapper();

	@Transactional
	public UserPaymentUI create(UserPaymentUI uiBean) {

		UserPayment newUserPayment = mapper.toPersistenceBean(uiBean);

		if (uiBean.getUserName() == null) {
			return null;
		}

		Customer customer = userRepository.findByUsername(uiBean.getUserName());
		newUserPayment.setCustomer(customer);

		UserPayment saved = repository.save(newUserPayment);
		logger.debug("Added Payment : " + saved);

		return mapper.toUIBean(saved);
	}

	public UserPaymentUI find(long paymentId) {
		return mapper.toUIBean(repository.findById(paymentId));
	}

	public Page<UserPaymentUI> findAll(Pageable pageable,
			List<FilterRequest> filters) {

		Predicate predicate = toPredicate(filters);
		return mapper.toUIBean(repository.findAll(predicate, pageable),
				pageable);
	}

	public List<UserPaymentUI> findByUser(String userName) {
		Customer customer = new Customer();
		customer.setUsername(userName);
		return mapper.toUIBean(repository.findByCustomer(customer));
	}

	public UserPaymentUI update(UserPaymentUI uiBean) {
		UserPayment existing = repository.findById(uiBean.getId());

		if (existing == null) {
			return null;
		}

		existing.setAmount(uiBean.getAmount());
		existing.setNotes(uiBean.getNotes());

		UserPayment saved = null;

		try {
			saved = repository.save(existing);
		} catch (Exception e) {
			logger.error(e);
		}

		return mapper.toUIBean(saved);
	}

	public Boolean delete(UserPaymentUI uiBean) {
		UserPayment existing = repository.findById(uiBean.getId());

		if (existing == null) {
			return false;
		}

		repository.delete(existing);
		return true;
	}
	
	private Predicate toPredicate(final List<FilterRequest> filters) {
		logger.info("Entering predicates :: " + filters);

		QUserPayment payment = QUserPayment.userPayment;
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
						expression = payment.companyId.like("%"
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
}
