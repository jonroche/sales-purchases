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
	private boolean payments = false;
	private boolean parties = false;
	private boolean products = false;
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

	public Subscription(final String companyId, final boolean sales, final boolean purchases, 
			final boolean payments, final boolean parties, final boolean products) {
		this.setCompanyId(companyId);
		this.sales = sales;
		this.purchases = purchases;
		this.payments = payments;
		this.parties = parties;
		this.products = products;
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

	public boolean isPayments() {
		return payments;
	}

	public void setPayments(boolean payments) {
		this.payments = payments;
	}

	public boolean isParties() {
		return parties;
	}

	public void setParties(boolean parties) {
		this.parties = parties;
	}
	
	public boolean isProducts() {
		return products;
	}

	public void setProducts(boolean products) {
		this.products = products;
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
		result.append(" payments:" + payments);
		result.append(" parties:" + parties);
		result.append(" products:" + products);
		
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
