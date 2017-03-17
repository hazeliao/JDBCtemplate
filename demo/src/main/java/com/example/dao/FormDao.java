package com.example.dao;

import java.util.List;

import com.example.domain.Form;

public interface FormDao {
	
	void create(Integer id, String name);
	
	Form getForm(Integer id);
	
	List<Form> listForms();
	
	void delete(Integer id);
	
	void update(Integer id, String name);

	

}
