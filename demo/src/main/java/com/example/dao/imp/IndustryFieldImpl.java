package com.example.dao.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.example.dao.IndustryFieldDao;
import com.example.domain.Form;
import com.example.domain.IndustryField;
import com.example.mapper.FormMapper;
import com.example.mapper.IndustryFieldRowMapper;



@Component
public class IndustryFieldImpl implements IndustryFieldDao {
	
	@Autowired	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		  this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	public void create(int id, String name, int priority) {
	      String SQL = "INSERT INTO IndustryField (id, name, priority) VALUES (:id, :name, :priority)";
	      Map namedParameters = new HashMap();  
	      namedParameters.put("id", id);
	      namedParameters.put("name", name); 
	      namedParameters.put("priority", priority);
	      namedParameterJdbcTemplate.update(SQL, namedParameters);
	      System.out.println("Createsd Form Id = " + id + " Name = " + name);
	}
	
	@Override
	public IndustryField getIndustryField(int id){

		SqlParameterSource namedParametersource = new MapSqlParameterSource("id", Integer.valueOf(id));

		String SQL = "SELECT * FROM IndustryField WHERE id= :id";
		IndustryField industryField = (IndustryField) namedParameterJdbcTemplate.queryForObject(SQL, namedParametersource, new IndustryFieldRowMapper());
		
		/* Tested SQL: 
		SELECT t.id, t.name, t.termClassId 
			FROM Term t
				JOIN FormTerm ft ON ( t.id = ft.termId AND ft.formId = 101)
			WHERE ft.relevance = 1
			ORDER BY t.name;	
		 */
		
		SQL="SELECT f.id, f.name, iff.industryFieldId "
			+" FROM Form f JOIN IndustryFieldForm iff ON ( f.id = iff.formId AND iff.industryFieldId = :id) "
			+" ORDER BY f.name ";	
		industryField.setForms((ArrayList<Form>) namedParameterJdbcTemplate.query(SQL, namedParametersource, new FormMapper()) );
		
		return industryField;
	}
	
	@Override
	public List<IndustryField> listIndustryFields() {
			
		String SQL = "SELECT ifd.id, ifd.name, ifd.priority, ifd.iconFilePath FROM IndustryField ifd ORDER BY ifd.priority ASC, ifd.name ASC;";
		List<IndustryField> industryFields= (ArrayList<IndustryField>) namedParameterJdbcTemplate.query(SQL, new IndustryFieldRowMapper());
		
		
		for (IndustryField industryField : industryFields){
			
			int id = industryField.getId();
			SqlParameterSource namedParametersource = new MapSqlParameterSource("id", Integer.valueOf(id));
			
			SQL="SELECT f.id, f.name, ifdf.industryFieldId AS 'industryFieldId', ifdf.priority"
					+" FROM Form f JOIN IndustryFieldForm ifdf ON ( f.id = ifdf.formId AND ifdf.industryFieldId = :id)"
					+" ORDER BY f.name ";
			
			industryField.setForms((ArrayList<Form>) namedParameterJdbcTemplate.query(SQL, namedParametersource , new FormMapper()) );
		}
		
		return industryFields;
	}
	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String SQL = "DELETE FROM IndustryField WHERE id = :id";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", Integer.valueOf(id));
		namedParameterJdbcTemplate.update(SQL, namedParameters);
		System.out.println("Deleted IndustryField with ID = " + id );
	}

	@Override
	public void update(int id, String name) {
		// TODO Auto-generated method stub
		String SQL = "UPDATE Employee SET name = :name WHERE id = :id";
		SqlParameterSource namedParameters = new MapSqlParameterSource();
		((MapSqlParameterSource) namedParameters).addValue("id", id);
		((MapSqlParameterSource) namedParameters).addValue("name", name);
		namedParameterJdbcTemplate.update(SQL, namedParameters);
		System.out.println("Updated Form with ID = " + id + " Name = " + name);
	}

}
