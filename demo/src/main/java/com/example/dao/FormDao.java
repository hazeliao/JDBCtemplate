package com.example.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.domain.Form;
import com.example.domain.ServiceLevel;
import com.example.domain.Term;

public interface FormDao {
	
	void createForm(Form form);
	
	void createFormTerm(Form form);
	
	void createIndustryFieldForm(Form form, HashMap<Integer, Integer> priorityMap);
	
	Form getForm(Integer id);
	
	List<Form> listForms();
	
	void delete(Integer id);
	
	void update(Integer id, String name);

	

}
