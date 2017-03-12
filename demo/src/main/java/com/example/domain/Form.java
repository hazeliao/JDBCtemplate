package com.example.domain;

public class Form {
	
	private long id;
	private String formName;
	
	public Form(){}

	public Form(long id, String formName) {
		super();
		this.id = id;
		this.formName = formName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	@Override
	public String toString() {
		return "Form [id=" + id + ", formName=" + formName + "]";
	}
	
	

}
