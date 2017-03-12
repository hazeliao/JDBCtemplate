package com.example.domain;



public class Services {
	
	
	private long id;
	private String serviceType;
	
	
	
	
	public Services(){}

	public Services(long id, String serviceType) {
		super();
		this.id = id;
		this.serviceType = serviceType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	

}
