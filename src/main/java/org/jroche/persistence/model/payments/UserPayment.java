package org.jroche.persistence.model.payments;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.jroche.persistence.model.user.Customer;
import org.springframework.security.core.context.SecurityContextHolder;

@Entity(name = "userPayments")
public class UserPayment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String notes;
	private String paymentType;
	private int amount;

	@Temporal(TemporalType.DATE)
	private Date paymentDate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "accountId")
	private Customer customer;
	
	private String companyId;

	public static enum COLUMNS {
		PRODUCTNAME, DESCRIPTION, PRODUCTGROUP, PRICE, CREATEDBY, CREATEDDATE, MODIFIEDBY, MODIFIEDDATE, COMPANYID
	}

	public UserPayment(Long id, String notes, String paymentType, int amount,
			Date paymentDate, Customer customer) {
		super();
		this.id = id;
		this.notes = notes;
		this.paymentType = paymentType;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.customer = customer;
		this.companyId = SecurityContextHolder.getContext().getAuthentication().getName();
	}

	public UserPayment() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", notes=" + notes + ", paymentType="
				+ paymentType + ", amount=" + amount + ", paymentDate="
				+ paymentDate + ", customer=" + customer + "]";
	}

}
