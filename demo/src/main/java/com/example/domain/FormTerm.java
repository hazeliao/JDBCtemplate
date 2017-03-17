package com.example.domain;

import java.util.ArrayList;

//@Entity
public class FormTerm {
	
	//@Id	
	//@GeneratedValue(strategy=GenerationType.AUTO)	
	//private long id;
	private String formName;
	//@OneToMany (cascade = CascadeType.ALL, mappedBy = "termPrimary")
	private ArrayList<Term> termPrimary;
	
	//@OneToMany (cascade = CascadeType.ALL, mappedBy = "termSecondary")
	private ArrayList<Term> termSecondary;
	//private String freeChoice;
	
	public FormTerm(){
		
	}
	
	public FormTerm(String formName, ArrayList<Term> termPrimary, ArrayList<Term> termSecondary) {
		super();
		this.formName = formName;
		this.termPrimary = termPrimary;
		this.termSecondary = termSecondary;
	}


	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public ArrayList<Term> getTermPrimary() {
		return termPrimary;
	}

	public void setTermPrimary(ArrayList<Term> termPrimary) {
		this.termPrimary = termPrimary;
	}

	public ArrayList<Term> getTermSecondary() {
		return termSecondary;
	}

	public void setTermSecondary(ArrayList<Term> termSecondary) {
		this.termSecondary = termSecondary;
	}

//	public String getFreeChoice() {
//		return freeChoice;
//	}
//
//	public void setFreeChoice(String freeChoice) {
//		this.freeChoice = freeChoice;
//	}

	@Override
	public String toString() {
		return "Form [formName=" + formName + ", termPrimary=" + termPrimary + ", termSecondary=" + termSecondary
				+ "]";
	}
	
	

}
