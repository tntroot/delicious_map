package com.example.delicious_map.vo;

public class CityAllStoreVo {
       
	private String name;
	
	private float evaluate;
	
	private String storeMeal;
	
	private Integer mealPrice;
	
	private Integer mealEvaluate;
	
	

	public CityAllStoreVo() {
		super();
		
	}

	public CityAllStoreVo(String name, float evaluate, String storeMeal, Integer mealPrice, Integer mealEvaluate) {
		super();
		this.name = name;
		this.evaluate = evaluate;
		this.storeMeal = storeMeal;
		this.mealPrice = mealPrice;
		this.mealEvaluate = mealEvaluate;
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

	public Integer getMealPrice() {
		return mealPrice;
	}

	public void setMealPrice(Integer mealPrice) {
		this.mealPrice = mealPrice;
	}

	public Integer getMealEvaluate() {
		return mealEvaluate;
	}

	public void setMealEvaluate(Integer mealEvaluate) {
		this.mealEvaluate = mealEvaluate;
	}
	
}
