package org.jroche.common.util.mapper.product;

import java.util.ArrayList;
import java.util.List;

import org.jroche.persistence.model.product.Product;
import org.jroche.persistence.model.product.ProductGroup;
import org.jroche.web.model.product.ProductUI;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;

public class ProductMapper {

	public ProductUI toUIBean(Product product) {
		ProductUI uiBean = null;

		if (product != null) {
			uiBean = new ProductUI();
			uiBean.setCreateadBy(product.getCreateadBy());
			uiBean.setCreatedDate(product.getCreatedDate());
			uiBean.setDescription(product.getDescription());
			uiBean.setId(product.getId());
			uiBean.setModifiedBy(product.getModifiedBy());
			uiBean.setModifiedDate(product.getModifiedDate());
			uiBean.setPrice(product.getPrice());
			if (product.getGroup() != null) {
				uiBean.setProductGroup(product.getGroup().getGroupName());
			}
			uiBean.setProductName(product.getProductName());
			uiBean.setCompanyId(SecurityContextHolder.getContext().getAuthentication().getName());
		}

		return uiBean;
	}

	public List<ProductUI> toUIBean(List<Product> products) {
		List<ProductUI> uiBeans = new ArrayList<ProductUI>();

		for (Product product : products) {
			uiBeans.add(toUIBean(product));
		}
		return uiBeans;
	}

	public Page<ProductUI> toUIBean(Page<Product> products, Pageable pageable) {
		Page<ProductUI> uiBeans = new PageImpl<ProductUI>(
				toUIBean(products.getContent()), pageable,
				products.getTotalElements());

		return uiBeans;
	}

	public Product toPersistenceBean(ProductUI uiBean) {
		Product product = null;

		if (uiBean != null) {
			product = new Product();

			product.setCreateadBy(uiBean.getCreateadBy());
			product.setCreatedDate(uiBean.getCreatedDate());
			product.setDescription(uiBean.getDescription());
			product.setId(uiBean.getId());
			product.setModifiedBy(uiBean.getModifiedBy());
			product.setModifiedDate(uiBean.getModifiedDate());
			product.setPrice(uiBean.getPrice());
			product.setProductName(uiBean.getProductName());

			ProductGroup group = new ProductGroup();
			group.setGroupName(uiBean.getProductGroup());
			product.setGroup(group);
			product.setCompanyId(SecurityContextHolder.getContext().getAuthentication().getName());

		}
		return product;
	}

	public List<Product> toPersistenceBean(List<ProductUI> uiBeans) {
		List<Product> products = new ArrayList<Product>();

		for (ProductUI uiBean : uiBeans) {
			products.add(toPersistenceBean(uiBean));
		}
		return products;
	}

}
