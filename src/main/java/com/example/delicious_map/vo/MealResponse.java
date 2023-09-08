package com.example.delicious_map.vo;

import java.util.List;
import com.example.delicious_map.entity.Meal;

public class MealResponse {

	private String code;
	
	private String message;
	
	private List<Meal> mealList;

	public MealResponse() {
		super();
	}

	public MealResponse(String code, String message, List<Meal> mealList) {
		super();
		this.code = code;
		this.message = message;
		this.mealList = mealList;
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

	public List<Meal> getMealList() {
		return mealList;
	}

	public void setMealList(List<Meal> mealList) {
		this.mealList = mealList;
	}
}
