package com.example.dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.example.dao.FormDao;
import com.example.domain.Form;
import com.example.mapper.FormMapper;

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
	public Form getForm(Integer formId){
		String SQL = "SELECT * FROM Form WHERE id= :id";
		SqlParameterSource namedParameters = new MapSqlParameterSource("empid", Integer.valueOf(formId));
		Form form = (Form) namedParameterJdbcTemplate.queryForObject(SQL, namedParameters, new FormMapper());
		return form;
	}

	@Override
	public List listForms() {
		// TODO Auto-generated method stub
		String SQL = "SELECT * FROM Form";
		List forms= (List) namedParameterJdbcTemplate.query(SQL, new FormMapper());
		return forms;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String SQL = "DELETE FROM Form WHERE id = :id";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", Integer.valueOf(id));
		namedParameterJdbcTemplate.update(SQL, namedParameters);
		System.out.println("Deleted Form with ID = " + id );
	}

	@Override
	public void update(Integer id, String name) {
		// TODO Auto-generated method stub
		String SQL = "UPDATE Employee SET name = :name WHERE id = :id";
		SqlParameterSource namedParameters = new MapSqlParameterSource();
		((MapSqlParameterSource) namedParameters).addValue("id", id);
		((MapSqlParameterSource) namedParameters).addValue("name", name);
		namedParameterJdbcTemplate.update(SQL, namedParameters);
		System.out.println("Updated Form with ID = " + id + " Name = " + name);
	}


}
