package com.example.dao;

import java.util.List;

import com.example.domain.FormSubmission;
import com.example.domain.Term;

public interface FormSubmissionDao {
	
	void create(Integer id, Integer formId, Integer serviceLevelId, String customerEmail, String textTrademark, List<Term> terms) ;
	
	void createFormSubmission(FormSubmission formsubmission);
	
	void createFormSubmissionTerm(FormSubmission formsubmission);
	
	FormSubmission getFormSubmission(Integer id);
	
	List<FormSubmission> listFormSubmission();
	
	void delete(Integer id);
	
	void update(Integer id, Integer formId, Integer serviceLevelId, String customerEmail, String textTrademark);

}
