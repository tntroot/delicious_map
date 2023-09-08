package com.example.delicious_map.vo;

public class StoreEvaluateVo {

	private String city;
	
	private String name;
	
	private float evaluate;
	
	private String storeMeal;
	
	private int mealPrice;
	
	private int mealEvaluate;
	
	
	public StoreEvaluateVo() {
		super();
	}

	public StoreEvaluateVo(String city, String name, float evaluate, String storeMeal, int mealPrice,
			int mealEvaluate) {
		super();
		this.city = city;
		this.name = name;
		this.evaluate = evaluate;
		this.storeMeal = storeMeal;
		this.mealPrice = mealPrice;
		this.mealEvaluate = mealEvaluate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(float evaluate) {
		this.evaluate = evaluate;
	}

	public String getStoreMeal() {
		return storeMeal;
	}

	public void setStoreMeal(String storeMeal) {
		this.storeMeal = storeMeal;
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
