package com.example.dao.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.example.dao.FormSubmissionDao;
import com.example.domain.FormSubmission;
import com.example.domain.Term;
import com.example.mapper.FormSubmissionMapper;
import com.example.mapper.TermMapper;

@Component
public class FormSubmissionDaoImpl implements FormSubmissionDao{
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		  this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	 }

	@Override
	public void create(Integer id, Integer formId, Integer serviceLevelId, String customerEmail, String textTrademark, List terms) {
		/*String SQL = "INSERT INTO FormSubmission (id, formId, serviceLevelId, customerEmail, textTrademark) VALUES (:id, :formId, :serviceLevelId, :customerEmail, :textTrademark)";
		Map namedParameters = new HashMap();
		namedParameters.put("id", id);
		namedParameters.put("formId", formId);
		namedParameters.put("serviceLevelId", serviceLevelId);
		namedParameters.put("customerEmail", customerEmail);
		namedParameters.put("textTrademark", textTrademark);
		
		SQL =  "INSERT INTO FormSubmissionTerm (formSubmissionId, termId) VALUES (:formSubmissionId, :termId)";
		for (Term term : terms){
			namedParameters.put("formSubmissionId", id);
			namedParameters.put("termId", term.getId());
		}		*/
		
	}

	@Override
	public FormSubmission getFormSubmission(Integer id) {
		String SQL = "SELECT * FROM FormSubmission WHERE id= :id";
		SqlParameterSource namedParametersource = new MapSqlParameterSource("id", Integer.valueOf(id));
		FormSubmission formSubmission = (FormSubmission) namedParameterJdbcTemplate.queryForObject(SQL, namedParametersource, new FormSubmissionMapper());
		SQL = "SELECT t.id, t.name, t.termClassId"
			+" FROM Term t JOIN FormSubmissionTerm ft ON ( t.id = ft.termId AND ft.formSubmissionId  = :id) "
			+" ORDER BY t.termClassId, t.name; ";
		//formSubmission.setTerms((ArrayList<Term>) namedParameterJdbcTemplate.query(SQL, namedParametersource, new TermMapper()));
		return formSubmission;
	}

	@Override
	public List<FormSubmission> listFormSubmission() {
		String SQL = "SELECT * FROM FormSubmission";
		List<FormSubmission> formSubmissions = (ArrayList<FormSubmission>) namedParameterJdbcTemplate.query(SQL, new FormSubmissionMapper());
		
		for (FormSubmission formSubmission: formSubmissions){
			int id = (int)formSubmission.getId();
			SqlParameterSource namedParametersource = new MapSqlParameterSource("id", Integer.valueOf(id));
			SQL = "SELECT t.id, t.name, t.termClassId"
				+" FROM Term t JOIN FormSubmissionTerm ft ON ( t.id = ft.termId AND ft.formSubmissionId  = :id) "
				+" ORDER BY t.termClassId, t.name; ";
			formSubmission.setTerms((ArrayList<Term>) namedParameterJdbcTemplate.query(SQL, namedParametersource, new TermMapper()));
		}
		return formSubmissions;
	}

	@Override
	public void delete(Integer id) {
		String SQL = "DELETE FROM FormSubmission WHERE id = :id";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", Integer.valueOf(id));
		namedParameterJdbcTemplate.update(SQL, namedParameters);
		System.out.println("Deleted FormSubmission with ID = " + id );		
	}

	@Override
	public void update(Integer id, Integer formId, Integer serviceLevelId, String customerEmail, String textTrademark) {
		String SQL = "UPDATE Form SET formId = :formId, serviceLevelId = :serviceLevelId, customerEmail = :customerEmail, textTrademark = :textTrademark, WHERE id = :id";
		SqlParameterSource namedParameters = new MapSqlParameterSource();
		((MapSqlParameterSource) namedParameters).addValue("id", id);
		((MapSqlParameterSource) namedParameters).addValue("formId", formId);
		((MapSqlParameterSource) namedParameters).addValue("serviceLevelId", serviceLevelId);
		((MapSqlParameterSource) namedParameters).addValue("customerEmail", customerEmail);
		((MapSqlParameterSource) namedParameters).addValue("textTrademark", textTrademark);
		
		namedParameterJdbcTemplate.update(SQL, namedParameters);
		System.out.println("Updated Form with ID = " + id + " FormId = " + formId);
	}

	@Override
	public void created(FormSubmission formsubmission) {
		
		String SQL = "INSERT INTO FormSubmission (id, formId, serviceLevelId, customerEmail, textTrademark) VALUES (:id, :formId, :serviceLevelId, :customerEmail, :textTrademark)";
		Map namedParameters = new HashMap();
		namedParameters.put("id", formsubmission.getId());
		namedParameters.put("formId", formsubmission.getFormId());
		namedParameters.put("serviceLevelId", formsubmission.getServiceLevelId());
		namedParameters.put("customerEmail", formsubmission.getCustomerEmail());
		namedParameters.put("textTrademark", formsubmission.getTextTrademark());
		namedParameterJdbcTemplate.update(SQL, namedParameters);
		SQL =  "INSERT INTO FormSubmissionTerm (formSubmissionId, termId) VALUES (:formSubmissionId, :termId)";
		for (Term term : formsubmission.getTerms()){
			namedParameters.put("formSubmissionId", formsubmission.getId());
			namedParameters.put("termId", term.getId());
		}		
		namedParameterJdbcTemplate.update(SQL, namedParameters);
	}
	
	

}
