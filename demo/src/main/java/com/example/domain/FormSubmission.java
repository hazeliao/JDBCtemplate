package com.example.domain;

import java.util.List;

public class FormSubmission {
	private long id;
	private long formId;
	private long serviceLevelId;
	private String customerEmail;
	private String textTrademark;
	
	private List<Term> terms;
	
	public FormSubmission(){}

	public FormSubmission(long id, long formId, long serviceLevelId, String customerEmail, String textTrademark, List<Term> terms) {
		super();
		this.id = id;
		this.formId = formId;
		this.serviceLevelId = serviceLevelId;
		this.customerEmail = customerEmail;
		this.textTrademark = textTrademark;
		this.terms = terms;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getFormId() {
		return formId;
	}

	public void setFormId(long formId) {
		this.formId = formId;
	}

	public long getServiceLevelId() {
		return serviceLevelId;
	}

	public void setServiceLevelId(long serviceLevelId) {
		this.serviceLevelId = serviceLevelId;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getTextTrademark() {
		return textTrademark;
	}

	public void setTextTrademark(String textTrademark) {
		this.textTrademark = textTrademark;
	}
	
	public List<Term> getTerms() {
		return terms;
	}

	public void setTerms(List<Term> terms) {
		this.terms = terms;
	}

	@Override
	public String toString() {
		return "FormSubmission [id=" + id + ", formId=" + formId + ", serviceLevelId=" + serviceLevelId
				+ ", customerEmail=" + customerEmail + ", textTrademark=" + textTrademark +  "]";
	}

	
		
}
