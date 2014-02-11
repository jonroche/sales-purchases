package org.jroche.web.model.user;

public class SubscriptionUI {
	
	private Long id;
	private boolean sales = false;
	private boolean purchases = false;
	private boolean orders = false;
	private boolean thirdParties = false;
	private String companyId;

	public SubscriptionUI() {
	}

	public SubscriptionUI(final String companyId, final boolean sales, final boolean purchases, final boolean orders, final boolean thirdParties) {
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

}
