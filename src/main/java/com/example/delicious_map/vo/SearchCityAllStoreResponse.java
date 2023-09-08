package com.example.delicious_map.vo;

import java.util.List;


public class SearchCityAllStoreResponse {
	
	private String code;
	
	private String message;
	
	private List<CityAllStoreVo> cityAllStoreVoList;
	

	public SearchCityAllStoreResponse() {
		super();
	}

	
	public SearchCityAllStoreResponse(String code, String message, List<CityAllStoreVo> cityAllStoreVoList) {
		super();
		this.code = code;
		this.message = message;
		this.cityAllStoreVoList = cityAllStoreVoList;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<CityAllStoreVo> getCityAllStoreVoList() {
		return cityAllStoreVoList;
	}

	public void setCityAllStoreVoList(List<CityAllStoreVo> cityAllStoreVoList) {
		this.cityAllStoreVoList = cityAllStoreVoList;
	}
	
}
