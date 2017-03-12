package com.example.domain;



public class ServiceLevel {
	
	
	private long id;
	
	private String serviceName;
	private double price;
	
	public ServiceLevel(){}

	public ServiceLevel(long id, String serviceName, double price) {
		super();
		this.id = id;
		this.serviceName = serviceName;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ServiceLevel [id=" + id + ", serviceName=" + serviceName + ", price=" + price + "]";
	}
	
	

}
