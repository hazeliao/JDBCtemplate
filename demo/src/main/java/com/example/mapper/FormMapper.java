package com.example.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.domain.Form;

public class FormMapper implements RowMapper{
	
	public Form mapRow(ResultSet rs, int rowNum) throws SQLException{
		Form form= new Form();
		form.setId(rs.getLong("id"));
		form.setFormName("formName");
		return form;
	}

}
