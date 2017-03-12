package com.example.domain;


//import com.fasterxml.jackson.annotation.JsonIgnore;




public class Term {
	
 	//@Id	
 	//@GeneratedValue(strategy=GenerationType.AUTO)	
	private long id;
	private String termName;
	
 	//@ManyToOne
 	//@JsonIgnore
 	//@JoinColumn(name = "termClassId")
	private TermClass termClass;
	
	
	public Term(){}

	public Term(long id, String termName, TermClass termClass) {
		super();
		this.id = id;
		this.termName = termName;
		this.termClass = termClass;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTermName() {
		return termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}

	public TermClass getTermClass() {
		return termClass;
	}

	public void setTermClass(TermClass termClass) {
		this.termClass = termClass;
	}

	@Override
	public String toString() {
		return "Term [id=" + id + ", termName=" + termName + ", termClass=" + termClass + "]";
	}
	
	
	
	

}
