package com.example.delicious_map.vo;

import java.util.List;

public class SearchStoreEvaluateResponse {

	private String code;
	
	private String message;
	
	private List<StoreEvaluateVo> storeEvaluateVoList;
	
	
	public SearchStoreEvaluateResponse() {
		super();
	}

	public SearchStoreEvaluateResponse(String code, String message, List<StoreEvaluateVo> storeEvaluateVoList) {
		super();
		this.code = code;
		this.message = message;
		this.storeEvaluateVoList = storeEvaluateVoList;
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

	public List<StoreEvaluateVo> getStoreEvaluateVoList() {
		return storeEvaluateVoList;
	}

	public void setStoreEvaluateVoList(List<StoreEvaluateVo> storeEvaluateVoList) {
		this.storeEvaluateVoList = storeEvaluateVoList;
	}
}
