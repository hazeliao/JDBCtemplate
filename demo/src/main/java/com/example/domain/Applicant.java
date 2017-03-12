package com.example.domain;

public class Applicant {
	
	
	private long id;
	private String fullName;
	private String countryOfIncorporation;
	private String legalForm;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	private String contactorFirstName;
	private String contactorLastName;
	private String contactorEmail;
	
	public Applicant(){}

	public Applicant(long id, String fullName, String countryOfIncorporation, String legalForm, String address1,
			String address2, String city, String state, String zipCode, String country, String contactorFirstName,
			String contactorLastName, String contactorEmail) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.countryOfIncorporation = countryOfIncorporation;
		this.legalForm = legalForm;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
		this.contactorFirstName = contactorFirstName;
		this.contactorLastName = contactorLastName;
		this.contactorEmail = contactorEmail;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCountryOfIncorporation() {
		return countryOfIncorporation;
	}

	public void setCountryOfIncorporation(String countryOfIncorporation) {
		this.countryOfIncorporation = countryOfIncorporation;
	}

	public String getLegalForm() {
		return legalForm;
	}

	public void setLegalForm(String legalForm) {
		this.legalForm = legalForm;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getContactorFirstName() {
		return contactorFirstName;
	}

	public void setContactorFirstName(String contactorFirstName) {
		this.contactorFirstName = contactorFirstName;
	}

	public String getContactorLastName() {
		return contactorLastName;
	}

	public void setContactorLastName(String contactorLastName) {
		this.contactorLastName = contactorLastName;
	}

	public String getContactorEmail() {
		return contactorEmail;
	}

	public void setContactorEmail(String contactorEmail) {
		this.contactorEmail = contactorEmail;
	}

	@Override
	public String toString() {
		return "Applicant [id=" + id + ", fullName=" + fullName + ", countryOfIncorporation=" + countryOfIncorporation
				+ ", legalForm=" + legalForm + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city
				+ ", state=" + state + ", zipCode=" + zipCode + ", country=" + country + ", contactorFirstName="
				+ contactorFirstName + ", contactorLastName=" + contactorLastName + ", contactorEmail=" + contactorEmail
				+ "]";
	}
	
	
	


}
