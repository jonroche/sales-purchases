package org.jroche.persistence.model.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "creditCard")
public class CreditCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true)
	private String companyId;
	private String cardNumber;
	private String cardName;
	private String cardType;
	private String issuDate;
	private String expDate;
	private String secCode;

	@Temporal(TemporalType.DATE)
	private Date createdDate;
	@Temporal(TemporalType.DATE)
	private Date modifiedDate;
	private int createadBy;
	private int modifiedBy;
	@Temporal(TemporalType.DATE)
	private Date lastLoggedIn;

	public static enum COLUMNS {
		ID, COMPANYID, CARDNUMBER, CARDNAME, CARDTYPE, ISSUDATE, EXPDATE, SECCODE, CREATEDDATE, MODIFIEDBY, MODIFIEDDATE, LASTLOGGEDIN
	}
	
	public CreditCard() {
	}

	public CreditCard(final Long id, final String companyId, final String cardNumber, final String cardName, final String cardType,
			final String issuDate, final String expDate, final String secCode, final Date createdDate,
			final Date modifiedDate, final int createadBy, final int modifiedBy, final Date lastLoggedIn) {
		super();
		this.id = id;
		this.companyId = companyId;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.issuDate = issuDate;
		this.expDate = expDate;
		this.secCode = secCode;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.createadBy = createadBy;
		this.modifiedBy = modifiedBy;
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

	public String toString()
	{
		StringBuffer result = new StringBuffer();
		
		result.append("id:" + id);		
		result.append(" companyId:" + companyId);
		result.append(" cardNumber:" + cardNumber);
		result.append(" cardName:" + cardName);
		result.append(" cardType:" + cardType);
		result.append(" issuDate:" + issuDate);
		result.append(" expDate:" + expDate);
		result.append(" secCode:" + secCode);
		result.append(" createdDate:" + createdDate);
		result.append(" modifiedDate:" + modifiedDate);
		result.append(" createadBy:" + createadBy);
		result.append(" modifiedBy:" + modifiedBy);
		result.append(" lastLoggedIn:" + lastLoggedIn);
		
		return result.toString();
	}
}


