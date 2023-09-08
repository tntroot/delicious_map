package com.example.delicious_map.vo;

import com.example.delicious_map.entity.Meal;

public class MealReviseMealReq {
	
	private String storeMeal;
	
	private Meal newMeal;

	public String getStoreMeal() {
		return storeMeal;
	}

	public void setStoreMeal(String storeMeal) {
		this.storeMeal = storeMeal;
	}

	public Meal getNewMeal() {
		return newMeal;
	}

	public void setNewMeal(Meal newMeal) {
		this.newMeal = newMeal;
	}
}
