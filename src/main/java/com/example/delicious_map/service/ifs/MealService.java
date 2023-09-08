package com.example.delicious_map.service.ifs;

import java.util.List;

import com.example.delicious_map.entity.Meal;
import com.example.delicious_map.vo.MealEvaluateResponse;
import com.example.delicious_map.vo.MealResponse;

public interface MealService {
	
	// 新增單筆餐點
	public MealResponse addMeal(Meal meal);
	// 新增多筆餐點
	public MealResponse addMeals(List<Meal> mealList);
	// 修改餐點
	public MealResponse reviseMeal(String storeMeal,Meal newMeal);
	// 修改餐點評價
	public MealEvaluateResponse reviseMealEvaluate(String storeMeal,String storeName ,int newEvaluate);
	
   
}
