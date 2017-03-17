package com.example.dao;

import java.util.List;

import com.example.domain.IndustryField;


public interface IndustryFieldDao {
	
	void create(int id, String name, int priority);
	
	IndustryField getIndustryField(int id);
	
	List<IndustryField> listIndustryFields();
	
	void delete(int id);
	
	void update(int id, String name);
}
