package com.example.delicious_map.constants;

public enum RtnCode {

	SUCCESSFUL("200","successful!"),
	REVISE_SUCCESSFUL("200","revise successful!"),
	TRANSACTION_SUCCESSFUL("200","transaction successful"),
	DATA_ERROR("400","data_error!"),
	DATA_NOT_REVISE("400","data not revise!"),
	STORE_EXISTED("400","store existed!"),
	THE_STORE_DOES_NOT_EXIST("400","The store does not exist!"),
	MEAL_EXISTED("400","meal existed!"),
	MEAl_NOT_FOUND("404","meal not found!"),
	NOT_FOUND("404","not found!");
	
    private String code;
	
	private String message;

	private RtnCode(String code, String message) {
		this.code = code;
		this.message = message;
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
}
