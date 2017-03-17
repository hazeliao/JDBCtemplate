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

import com.example.dao.ServiceLevelDao;
import com.example.domain.ServiceLevel;
import com.example.mapper.ServiceLevelMapper;

@Component
public class ServiceLevelDaoImpl implements ServiceLevelDao{
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		  this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	 }
	
	@Override
	public void create(Integer id, String name, double price) {
		// TODO Auto-generated method stub
		String SQL = "INSERT INTO Form (id, name, price) VALUES (:id, :name, :price)";
	    Map namedParameters = new HashMap(); 
		namedParameters.put("id", id);
		namedParameters.put("name", name);
		namedParameters.put("price", price);
		namedParameterJdbcTemplate.update(SQL, namedParameters);
		System.out.println("Created ServiceLevel Id = " + id + " serviceName = " + name + " price = " + price);
	}

	@Override
	public ServiceLevel getServiceLevel(Integer id) {
		String SQL = "INSERT INTO Form (id, serviceName, price) VALUES (:id, :name, :price)";
		SqlParameterSource namedParametersource = new MapSqlParameterSource("id", Integer.valueOf(id));
		ServiceLevel serviceLevel = (ServiceLevel) namedParameterJdbcTemplate.queryForObject(SQL, namedParametersource, new ServiceLevelMapper());
		return serviceLevel;
	}

	@Override
	public List<ServiceLevel> listServiceLevels() {
		String SQL = "SELECT * FROM ServiceLevel";
		List<ServiceLevel> serviceLevels = (ArrayList<ServiceLevel>) namedParameterJdbcTemplate.query(SQL, new ServiceLevelMapper());
		return serviceLevels;
	}

	@Override
	public void delete(Integer id) {
		String SQL = "DELETE FROM ServiceLevel WHERE id = :id";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", Integer.valueOf(id));
		namedParameterJdbcTemplate.update(SQL, namedParameters);
		System.out.println("Deleted ServiceLevel with ID = " + id );
	}

	@Override
	public void update(Integer id, String name, double price) {
		String SQL = "UPDATE ServiceLevel SET name = :name, price = :price WHERE id = :id";
		SqlParameterSource namedParameters = new MapSqlParameterSource();
		((MapSqlParameterSource) namedParameters).addValue("id", id);
		((MapSqlParameterSource) namedParameters).addValue("name", name);
		((MapSqlParameterSource) namedParameters).addValue("price", price);
		namedParameterJdbcTemplate.update(SQL, namedParameters);
		System.out.println("Updated ServiceLevel with ID = " + id + " Name = " + name + " Price = " + price);
		
	}
	
	

}
