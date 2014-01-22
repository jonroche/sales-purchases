package org.jroche.web.model.user;

import java.util.Date;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class CompanyUI {

	private final static Md5PasswordEncoder encoder = new Md5PasswordEncoder(); 
	
	private Long id;
	private String companyId;
	private String companyName;

	private String password;


	private String companyAddress;
	private String companyPhone;

	private String email;
	private String description;
	private String notes;

	private Date createdDate;
	private Date modifiedDate;
	private int createadBy;
	private int modifiedBy;
	private Date lastLoggedIn;


	public CompanyUI() {
	}

	public CompanyUI(Long id, String companyId, String companyName,
			 String password, 
			String companyAddress, String companyPhone,
			String email, String description, String notes, Date createdDate,
			Date modifiedDate, int createadBy, int modifiedBy,
			Date lastLoggedIn) {
		super();
		this.id = id;
		this.companyId = companyId;
		this.companyName = companyName;
		
		this.password = password;
		
		this.companyAddress = companyAddress;
		this.companyPhone = companyPhone;
		
		this.email = email;
		this.description = description;
		this.notes = notes;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.createadBy = createadBy;
		this.modifiedBy = modifiedBy;
		this.lastLoggedIn = lastLoggedIn;
	
	}

	public CompanyUI(String companyName) {
		this.companyName = companyName;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = encoder.encodePassword(password, null);
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

	public String toString()
	{
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
