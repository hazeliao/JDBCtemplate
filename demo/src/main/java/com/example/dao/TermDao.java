package com.example.dao;

import java.util.List;

import com.example.domain.Term;

public interface TermDao {
	
	void createTerm(Integer id, String serviceName);
	
	Term getTerm(Integer id);
	
	List<Term> listTerms();
	
	void delete(Integer id);
	
	void update(Integer id, String name);

}
