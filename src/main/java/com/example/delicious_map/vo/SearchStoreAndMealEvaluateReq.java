package com.example.delicious_map.vo;

public class SearchStoreAndMealEvaluateReq {
	private float evaluate;
	
	private int mealEvaluate;
	
	public SearchStoreAndMealEvaluateReq() {
		super();
	}

	public SearchStoreAndMealEvaluateReq(float evaluate, int mealEvaluate) {
		super();
		this.evaluate = evaluate;
		this.mealEvaluate = mealEvaluate;
	}



	public float getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(float evaluate) {
		this.evaluate = evaluate;
	}

	public int getMealEvaluate() {
		return mealEvaluate;
	}

	public void setMealEvaluate(int mealEvaluate) {
		this.mealEvaluate = mealEvaluate;
	}
}
