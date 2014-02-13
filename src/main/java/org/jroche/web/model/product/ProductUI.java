package org.jroche.web.model.product;

import java.util.Date;

import org.springframework.security.core.context.SecurityContextHolder;

public class ProductUI {

	private Long id;

	private String productName;
	private String description;
	private String productGroup;
	private int price;

	private Date createdDate;
	private Date modifiedDate;
	private int createadBy;
	private int modifiedBy;
	private String companyId;

	public ProductUI(Long id, String productName, String description,
			String productGroup, int price, Date createdDate,
			Date modifiedDate, int createadBy, int modifiedBy, String companyId) {
		super();
		this.id = id;
		this.productName = productName;
		this.description = description;
		this.productGroup = productGroup;
		this.price = price;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.createadBy = createadBy;
		this.modifiedBy = modifiedBy;
		this.companyId = companyId;
	}

	public ProductUI() {
		this.companyId = SecurityContextHolder.getContext().getAuthentication().getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductGroup() {
		return productGroup;
	}

	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getCreateadBy() {
		return createadBy;
	}

	public void setCreateadBy(int createadBy) {
		this.createadBy = createadBy;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	public String getCompanyId() {
		return companyId;
	}
	
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName
				+ ", description=" + description + ", productGroup="
				+ productGroup + ", price=" + price + ", createdDate="
				+ createdDate + ", modifiedDate=" + modifiedDate
				+ ", createadBy=" + createadBy + ", modifiedBy=" + modifiedBy
				+ "]";
	}

}
