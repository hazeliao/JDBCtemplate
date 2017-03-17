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

import com.example.dao.FormDao;
import com.example.domain.Form;
import com.example.domain.ServiceLevel;
import com.example.domain.Term;
import com.example.mapper.FormMapper;
import com.example.mapper.ServiceLevelMapper;
import com.example.mapper.TermMapper;

@Component
public class FormDaoImpl implements FormDao{
	@Autowired	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		  this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	 }
	
	@Override
	public void create(Integer id, String name) {
	      String SQL = "INSERT INTO Form (id, name) VALUES (:id, :name)";
	      Map namedParameters = new HashMap();  
	      namedParameters.put("id", id);
	      namedParameters.put("name", name); 
	      namedParameterJdbcTemplate.update(SQL, namedParameters);
	      System.out.println("Created Form Id = " + id + " Name = " + name);
	}

	@Override
	public Form getForm(Integer id){

		SqlParameterSource namedParametersource = new MapSqlParameterSource("id", Integer.valueOf(id));

		String SQL = "SELECT * FROM Form WHERE id= :id";
		Form form = (Form) namedParameterJdbcTemplate.queryForObject(SQL, namedParametersource, new FormMapper());
		
		/* Tested SQL: 
		SELECT t.id, t.name, t.termClassId 
			FROM Term t
				JOIN FormTerm ft ON ( t.id = ft.termId AND ft.formId = 101)
			WHERE ft.relevance = 1
			ORDER BY t.name;	
		 */
		
		SQL="SELECT t.id, t.name, t.termClassId "
			+" FROM Term t JOIN FormTerm ft ON ( t.id = ft.termId AND ft.formId = :id) "
			+" WHERE ft.relevance = 1 "
			+" ORDER BY t.termClassId, t.name; ";	
		form.setTerms1((ArrayList<Term>) namedParameterJdbcTemplate.query(SQL, namedParametersource, new TermMapper()) );
		
		SQL="SELECT t.id, t.name, t.termClassId "
			+" FROM Term t JOIN FormTerm ft ON ( t.id = ft.termId AND ft.formId = :id) "
			+" WHERE ft.relevance = 2 "
			+" ORDER BY t.termClassId,  t.name; ";	
		form.setTerms2((ArrayList<Term>) namedParameterJdbcTemplate.query(SQL, namedParametersource, new TermMapper()) );
		
		SQL="SELECT * FROM ServiceLevel;";
		form.setServiceLevels((ArrayList<ServiceLevel>) namedParameterJdbcTemplate.query(SQL, new ServiceLevelMapper()));
				return form;
	}

	@Override
	public List<Form> listForms() {
		String SQL = "SELECT * FROM Form";
		List<Form> forms= (ArrayList<Form>) namedParameterJdbcTemplate.query(SQL, new FormMapper());
		return forms;
	}

	@Override
	public void delete(Integer id) {		
		String SQL = "DELETE FROM Form WHERE id = :id";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", Integer.valueOf(id));
		namedParameterJdbcTemplate.update(SQL, namedParameters);
		System.out.println("Deleted Form with ID = " + id );
	}

	@Override
	public void update(Integer id, String name) {		
		String SQL = "UPDATE Form SET name = :name WHERE id = :id";
		SqlParameterSource namedParameters = new MapSqlParameterSource();
		((MapSqlParameterSource) namedParameters).addValue("id", id);
		((MapSqlParameterSource) namedParameters).addValue("name", name);
		namedParameterJdbcTemplate.update(SQL, namedParameters);
		System.out.println("Updated Form with ID = " + id + " Name = " + name);
	}


}
