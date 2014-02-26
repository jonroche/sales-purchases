package org.jroche.persistence.model.user;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	private String companyId;
	private String password;
	private String companyName;

	private String companyAddress;
	private String companyPhone;
	private String email;
	private String description;
	private String notes;

	private String cardNumber;
	private String cardName;
	private String cardType;
	private String issuDate;
	private String expDate;
	private String secCode;
	
	private Boolean sales = false;
	private Boolean purchases = false;
	private Boolean payments = false;
	private Boolean parties = false;
	private Boolean products = false;

	@Temporal(TemporalType.DATE)
	private Date createdDate;
	@Temporal(TemporalType.DATE)
	private Date modifiedDate;
	private int createadBy;
	private int modifiedBy;
	@Temporal(TemporalType.DATE)
	private Date lastLoggedIn;
	
	/*@OneToMany(mappedBy = "customer" , fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<Customer> customer;*/

	public static enum COLUMNS {
		COMPANYID, PASSWORD, COMPANYNAME, COMPANYADDRESS, COMPANYPHONE, EMAIL, DESCRIPTION, NOTES, CREATEDBY, CREATEDDATE, MODIFIEDBY, MODIFIEDDATE, LASTLOGGEDIN,
		CARDNUMBER, CARDNAME, CARDTYPE, ISSUDATE, EXPDATE, SECCODE,
		SALES, PURCHASES, ORDER, THIRDPARTIES
	}

	public Company(Long id, String companyId, String password,
			String companyName, String companyAddress, String companyPhone,
			String email, String description, String notes, final String cardNumber, final String cardName, final String cardType,
			final String issuDate, final String expDate, final String secCode, final boolean sales, 
			final boolean purchases, final boolean payments, final boolean parties, final Boolean products) {
		super();
		this.id = id;
		this.companyId = companyId;
		this.password = password;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.companyPhone = companyPhone;
		this.email = email;
		this.description = description;
		this.notes = notes;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.issuDate = issuDate;
		this.expDate = expDate;
		this.secCode = secCode;
		this.sales = sales;
		this.purchases = purchases;
		this.payments = payments;
		this.parties = parties;
		this.products = products;
	}

	public Company() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyPhone() {
		return companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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

	public Date getLastLoggedIn() {
		return lastLoggedIn;
	}

	public void setLastLoggedIn(Date lastLoggedIn) {
		this.lastLoggedIn = lastLoggedIn;
	}
	

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getIssuDate() {
		return issuDate;
	}

	public void setIssuDate(String issuDate) {
		this.issuDate = issuDate;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getSecCode() {
		return secCode;
	}

	public void setSecCode(String secCode) {
		this.secCode = secCode;
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
	
	/*public Set<Customer> getCustomers() {
		return customer;
	}

	public void setCustomers(Set<Customer> customer) {
		this.customer = customer;
	}*/

	public String toString() {
		StringBuffer result = new StringBuffer();

		result.append("id:" + id);
		result.append(" companyName:" + companyName);

		result.append(" companyId:" + companyId);
		result.append(" password:" + password);

		result.append(" companyAddress:" + companyAddress);
		result.append(" companyPhone:" + companyPhone);

		result.append(" email:" + email);
		result.append(" description:" + description);
		result.append(" notes:" + notes);
		result.append(" createdDate:" + createdDate);
		result.append(" modifiedDate:" + modifiedDate);
		result.append(" createadBy:" + createadBy);
		result.append(" modifiedBy:" + modifiedBy);
		result.append(" lastLoggedIn:" + lastLoggedIn);

		return result.toString();
	}
}
