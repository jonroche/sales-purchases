package org.jroche.web.model.order;

public class TransactionAmountSummary {
	private String day;
	private long amount;
	private String companyId;

	public TransactionAmountSummary() {
	}

	public TransactionAmountSummary(String companyId, int day, long amount) {
		this.day = Integer.toString(day);
		this.amount = amount;
		this.companyId = companyId;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

}
