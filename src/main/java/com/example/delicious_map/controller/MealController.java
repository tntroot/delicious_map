package com.example.delicious_map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.delicious_map.entity.Meal;
import com.example.delicious_map.service.ifs.MealService;
import com.example.delicious_map.vo.MealAddMealReq;
import com.example.delicious_map.vo.MealAddMealsReq;
import com.example.delicious_map.vo.MealEvaluateResponse;
import com.example.delicious_map.vo.MealResponse;
import com.example.delicious_map.vo.MealReviseMealEvaluateReq;
import com.example.delicious_map.vo.MealReviseMealReq;

@RestController
public class MealController {

	@Autowired
	private MealService mealService;
	
	@PostMapping(value = "meal/addMeal")
	public MealResponse addMeal(@RequestBody MealAddMealReq req ) {
		//新增單筆餐點
		return mealService.addMeal(new Meal(req.getStoreMeal(),req.getStoreName(),req.getMealPrice(),req.getMealEvaluate()));
	}
	
	@PostMapping(value = "meal/addMeals")
	public MealResponse addMeals(@RequestBody MealAddMealsReq req ) {
		//新增多筆餐點
		return mealService.addMeals(req.getMealList());
	}
	
	@PostMapping(value = "meal/reviseMeal")
	public MealResponse reviseMeal(@RequestBody MealReviseMealReq req ) {
		//修改餐點
		return mealService.reviseMeal(req.getStoreMeal(),req.getNewMeal());
	}
	
	@PostMapping(value = "meal/reviseMealEvaluate")
	public MealEvaluateResponse reviseMealEvaluate(@RequestBody MealReviseMealEvaluateReq req ) {
		//修改餐點評價
		return mealService.reviseMealEvaluate(req.getStoreMeal(),req.getStoreName(),req.getMealEvaluate());
	}
}
