package org.jroche.persistence.model.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "subscription")
public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true)
	private boolean sales = false;
	private boolean purchases = false;
	private boolean orders = false;
	private boolean thirdParties = false;
	private String companyId;
	
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	@Temporal(TemporalType.DATE)
	private Date modifiedDate;
	private int createadBy;
	private int modifiedBy;
	@Temporal(TemporalType.DATE)
	private Date lastLoggedIn;

	public static enum COLUMNS {
		ID, COMPANYID, SALES, PURCHASES, ORDER, THIRDPARTIES, CREATEDDATE, MODIFIEDBY, MODIFIEDDATE, LASTLOGGEDIN
	}
	
	public Subscription() {
	}

	public Subscription(final String companyId, final boolean sales, final boolean purchases, final boolean orders, final boolean thirdParties) {
		this.setCompanyId(companyId);
		this.sales = sales;
		this.purchases = purchases;
		this.orders = orders;
		this.thirdParties = thirdParties;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public boolean isSales() {
		return sales;
	}

	public void setSales(boolean sales) {
		this.sales = sales;
	}

	public boolean isPurchases() {
		return purchases;
	}

	public void setPurchases(boolean purchases) {
		this.purchases = purchases;
	}

	public boolean isOrders() {
		return orders;
	}

	public void setOrders(boolean orders) {
		this.orders = orders;
	}

	public boolean isThirdParties() {
		return thirdParties;
	}

	public void setThirdParties(boolean thirdParties) {
		this.thirdParties = thirdParties;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	public String toString() {
		StringBuffer result = new StringBuffer();
			
		result.append(" companyId:" + companyId);
		result.append(" sales:" + sales);
		result.append(" purchases:" + purchases);
		result.append(" orders:" + orders);
		result.append(" thirdParties:" + thirdParties);
		
		return result.toString();
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

}
