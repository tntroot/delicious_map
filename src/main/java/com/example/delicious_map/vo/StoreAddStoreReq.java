package com.example.delicious_map.vo;

public class StoreAddStoreReq {

	private String name;
	private String city;

	
	public StoreAddStoreReq() {
		super();
	}

	public StoreAddStoreReq(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
