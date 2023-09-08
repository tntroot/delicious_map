package com.example.delicious_map.service.ifs;

import java.util.List;

import com.example.delicious_map.entity.Meal;
import com.example.delicious_map.vo.MealEvaluateResponse;
import com.example.delicious_map.vo.MealResponse;

public interface MealService {
	
	// �s�W�浧�\�I
	public MealResponse addMeal(Meal meal);
	// �s�W�h���\�I
	public MealResponse addMeals(List<Meal> mealList);
	// �ק��\�I
	public MealResponse reviseMeal(String storeMeal,Meal newMeal);
	// �ק��\�I����
	public MealEvaluateResponse reviseMealEvaluate(String storeMeal,String storeName ,int newEvaluate);
	
   
}
