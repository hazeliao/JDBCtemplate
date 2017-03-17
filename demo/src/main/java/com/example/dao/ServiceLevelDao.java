package com.example.dao;

import java.util.List;

import com.example.domain.ServiceLevel;

public interface ServiceLevelDao {
	
void create(Integer id, String serviceName, double price);
	
	ServiceLevel getServiceLevel(Integer id);
	
	List<ServiceLevel> listServiceLevels();
	
	void delete(Integer id);
	
	void update(Integer id, String name, double price);

}
