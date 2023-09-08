package com.example.delicious_map.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "store_meal")
public class Meal {

	@Id
	@Column(name = "store_meal")
	private String storeMeal;
	
	@Column(name = "store_name")
	private String storeName;
	
	@Column(name = "meal_price")
	private int mealPrice;
	
	@Column(name = "meal_evaluate")
	private int mealEvaluate ;

	public Meal() {
		super();
	}

	public Meal(String storeMeal, String storeName, int mealPrice, int mealEvaluate) {
		super();
		this.storeMeal = storeMeal;
		this.storeName = storeName;
		this.mealPrice = mealPrice;
		this.mealEvaluate = mealEvaluate;
	}

	public String getStoreMeal() {
		return storeMeal;
	}

	public void setStoreMeal(String storeMeal) {
		this.storeMeal = storeMeal;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public int getMealPrice() {
		return mealPrice;
	}

	public void setMealPrice(int mealPrice) {
		this.mealPrice = mealPrice;
	}

	public int getMealEvaluate() {
		return mealEvaluate;
	}

	public void setMealEvaluate(int mealEvaluate) {
		this.mealEvaluate = mealEvaluate;
	}

}
