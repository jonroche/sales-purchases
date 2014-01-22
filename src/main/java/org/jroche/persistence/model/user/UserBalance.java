package org.jroche.persistence.model.user;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "userBalance")
public class UserBalance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String notes;
	private long amount;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "accountId")
	private Customer customer;

	public UserBalance(Long id, String notes, long amount, Customer customer) {
		super();
		this.id = id;
		this.notes = notes;
		this.amount = amount;
		this.customer = customer;
	}

	public UserBalance() {

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

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "UserBalance [id=" + id + ", notes=" + notes + ", amount="
				+ amount + ", customer=" + customer + "]";
	}
}
