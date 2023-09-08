package com.example.delicious_map.vo;

import java.util.List;

import com.example.delicious_map.entity.Meal;

public class MealAddMealsReq {

	private List<Meal> mealList;

	public List<Meal> getMealList() {
		return mealList;
	}

	public void setMealList(List<Meal> mealList) {
		this.mealList = mealList;
	}
	
}
