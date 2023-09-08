package com.example.delicious_map.vo;

public class StoreSearchCityReq {

	private String city;
	
	private int row;
	
	public StoreSearchCityReq() {
		super();
	}

	
	public StoreSearchCityReq(String city, int row) {
		super();
		this.city = city;
		this.row = row;
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
}
