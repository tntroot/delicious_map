package com.example.delicious_map.vo;

import com.example.delicious_map.entity.Meal;
import com.example.delicious_map.entity.Store;

public class MealEvaluateResponse {
	
    private String code;
	
	private String message;
	
	private Store beforeStore;
	
	private Store afterStore;

	private Meal meal;

	
	public MealEvaluateResponse() {
		super();
	}

	
	public MealEvaluateResponse(String code, String message, Store beforeStore, Store afterStore, Meal meal) {
		super();
		this.code = code;
		this.message = message;
		this.beforeStore = beforeStore;
		this.afterStore = afterStore;
		this.meal = meal;
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

	public Store getBeforeStore() {
		return beforeStore;
	}

	public void setBeforeStore(Store beforeStore) {
		this.beforeStore = beforeStore;
	}

	public Store getAfterStore() {
		return afterStore;
	}

	public void setAfterStore(Store afterStore) {
		this.afterStore = afterStore;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	} 

}
