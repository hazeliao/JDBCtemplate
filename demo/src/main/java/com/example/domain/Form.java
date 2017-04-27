package com.example.domain;

import java.util.ArrayList;

public class Form {
	
	private long id;
	private String name;
	
	private IndustryField industryField;
	//@OneToMany (cascade = CascadeType.ALL, mappedBy = "terms1")
	private ArrayList<Term> terms1;
	
	//@OneToMany (cascade = CascadeType.ALL, mappedBy = "terms2")
	private ArrayList<Term> terms2;
	
	private  ArrayList<ServiceLevel> serviceLevels;

	public Form(){}

	public Form(long id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.industryField =null;
		this.terms1 = null;
		this.terms2 = null;
		this.serviceLevels = null;
	}
	
	public Form(long id, String name, IndustryField industryField, ArrayList<Term> terms1, ArrayList<Term> terms2) {
		super();
		this.id = id;
		this.name = name;
		this.industryField = industryField;
		this.terms1 = terms1;
		this.terms2 = terms2;
		this.serviceLevels = null;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public IndustryField getIndustryField() {
		return industryField;
	}

	public void setIndustryField(IndustryField industryField) {
		this.industryField = industryField;
	}

	public ArrayList<Term> getTerms1() {
		return terms1;
	}

	public void setTerms1(ArrayList<Term> terms1) {
		this.terms1 = terms1;
	}

	public ArrayList<Term> getTerms2() {
		return terms2;
	}

	public void setTerms2(ArrayList<Term> terms2) {
		this.terms2 = terms2;
	}
	
	public ArrayList<ServiceLevel> getServiceLevels() {
		return serviceLevels;
	}

	public void setServiceLevels(ArrayList<ServiceLevel> serviceLevels) {
		this.serviceLevels = serviceLevels;
	}

	@Override
	public String toString() {
		return "Form [id=" + id + ", name=" + name + "]";
	}
	
	

}
