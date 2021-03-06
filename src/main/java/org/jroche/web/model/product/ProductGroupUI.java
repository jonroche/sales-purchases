package org.jroche.web.model.product;

import java.util.Date;

import org.springframework.security.core.context.SecurityContextHolder;

public class ProductGroupUI {

	private Long id;
	private String groupName;
	private String description;
	private Date createdDate;
	private Date modifiedDate;
	private int createadBy;
	private int modifiedBy;
	private String companyId;

	public ProductGroupUI(Long id, String groupName, String description,
			Date createdDate, Date modifiedDate, int createadBy, int modifiedBy, String companyId) {
		super();
		this.id = id;
		this.groupName = groupName;
		this.description = description;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.createadBy = createadBy;
		this.modifiedBy = modifiedBy;
		this.companyId = companyId;
	}

	public ProductGroupUI() {
		this.companyId = SecurityContextHolder.getContext().getAuthentication().getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return "ProductGroupUI [id=" + id + ", groupName=" + groupName
				+ ", description=" + description + ", createdDate="
				+ createdDate + ", modifiedDate=" + modifiedDate
				+ ", createadBy=" + createadBy + ", modifiedBy=" + modifiedBy
				+ "]";
	}

}
