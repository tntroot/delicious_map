package com.example.delicious_map.serviec.impl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.delicious_map.constants.RtnCode;
import com.example.delicious_map.entity.Meal;
import com.example.delicious_map.entity.Store;
import com.example.delicious_map.repository.MealDao;
import com.example.delicious_map.repository.StoreDao;
import com.example.delicious_map.service.ifs.MealService;
import com.example.delicious_map.vo.MealEvaluateResponse;
import com.example.delicious_map.vo.MealResponse;

@Service
public class MealServiceImpl implements MealService {
	
	@Autowired
	private MealDao mealDao;
	
	@Autowired
	private StoreDao storeDao;
	@Override
	public MealResponse addMeal(Meal meal) {
		//新增單筆餐點
		List<Meal> mealList = new ArrayList<>(Arrays.asList(meal));
		if (!StringUtils.hasText(meal.getStoreMeal()) || !StringUtils.hasText(meal.getStoreName()) ||meal.getMealPrice() <0 ||meal.getMealEvaluate() <1 ||meal.getMealEvaluate()> 5) {
			return new MealResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage(), mealList);
		}
		Optional<Store> opStore = storeDao.findById(meal.getStoreName());
		if (!opStore.isPresent()) {
			return new MealResponse(RtnCode.THE_STORE_DOES_NOT_EXIST.getCode(), RtnCode.THE_STORE_DOES_NOT_EXIST.getMessage(),mealList);
		}
		if (mealDao.existsById(meal.getStoreMeal())) {
			return new MealResponse(RtnCode.MEAL_EXISTED.getCode(), RtnCode.MEAL_EXISTED.getMessage(), mealList);
		}
		mealDao.save(meal);
		storeDao.updateStoreEvaluate(meal.getStoreName());
		return new  MealResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), mealList);
	}

	@Override
	public MealResponse addMeals(List<Meal> mealList) {
		//新增多筆餐點
		if(CollectionUtils.isEmpty(mealList)) {
			return new MealResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage(), mealList);
		}
		for (Meal item :mealList) {
			if (!StringUtils.hasText(item.getStoreMeal()) || !StringUtils.hasText(item.getStoreName()) || item.getMealPrice() <0 ||item.getMealEvaluate() <1 ||item.getMealEvaluate()> 5) {
				return new MealResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage(),mealList);
			}
			Optional<Store> opStore = storeDao.findById(item.getStoreName());
			if (!opStore.isPresent()) {
				return new MealResponse(RtnCode.THE_STORE_DOES_NOT_EXIST.getCode(), RtnCode.THE_STORE_DOES_NOT_EXIST.getMessage(),mealList);
			}
			if (mealDao.existsById(item.getStoreMeal())) {
				return new MealResponse(RtnCode.MEAL_EXISTED.getCode(), RtnCode.MEAL_EXISTED.getMessage(), mealList);
			}

		}
		mealDao.saveAll(mealList);
		for (Meal item :mealList) {
			storeDao.updateStoreEvaluate(item.getStoreName());
		}	
		return new  MealResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), mealList);
	}

	@Override
	public MealResponse reviseMeal(String storeMeal,Meal newMeal) {
		// 修改餐點
		List<Meal> mealList = new ArrayList<>(Arrays.asList(newMeal));
		if (!StringUtils.hasText(storeMeal)||!StringUtils.hasText(newMeal.getStoreMeal()) || !StringUtils.hasText(newMeal.getStoreName()) ||newMeal.getMealPrice() <0 ||newMeal.getMealEvaluate() <1 ||newMeal.getMealEvaluate()> 5) {
			return new MealResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage(), mealList);
		}
		Optional<Meal> op = mealDao.findById(storeMeal);
		if (!op.isPresent()) {
			return new MealResponse(RtnCode.MEAl_NOT_FOUND.getCode(), RtnCode.MEAl_NOT_FOUND.getMessage(), null);
		}
		Meal mealData = op.get();
		if(!mealData.getStoreName().equals(newMeal.getStoreName()) || mealData.getMealEvaluate() != newMeal.getMealEvaluate()) {
			return new MealResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage(), mealList);
		}
		if(mealData.getStoreMeal().equals(newMeal.getStoreMeal()) && mealData.getMealPrice() == newMeal.getMealPrice()) {
			return new MealResponse(RtnCode.DATA_NOT_REVISE.getCode(), RtnCode.DATA_NOT_REVISE.getMessage(), mealList);
		}
		String newStoreMeal = newMeal.getStoreMeal();
		mealDao.updateStoreMeal(storeMeal,newStoreMeal);
		mealData.setMealPrice(newMeal.getMealPrice());
		mealDao.save(mealData);
		mealData.setStoreMeal(newMeal.getStoreMeal());
		List <Meal> mealListData = new ArrayList<>(Arrays.asList(mealData));
		return new MealResponse(RtnCode.REVISE_SUCCESSFUL.getCode(), RtnCode.REVISE_SUCCESSFUL.getMessage(), mealListData);
	}
	
	
	@Override
	public MealEvaluateResponse reviseMealEvaluate(String storeMeal,String storeName, int newEvaluate) {
		// 修改餐點評價
		if (!StringUtils.hasText(storeMeal)||!StringUtils.hasText(storeName)|| newEvaluate >5 || newEvaluate<1) {
			return new MealEvaluateResponse (RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage(),null,null,null);
		}
		Optional<Meal> opMeal = mealDao.findById(storeMeal);
		Meal resMeal = opMeal.get();
		if(!resMeal.getStoreName().equals(storeName)) {
			return new MealEvaluateResponse (RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage(),null,null,null);
		}
		Optional<Store> opStore = storeDao.findById(storeName);
		//更新前的店家評價
		Store beforeStore = opStore.get();
		
		if (!opMeal.isPresent()) {
			return new MealEvaluateResponse(RtnCode.MEAl_NOT_FOUND.getCode(), RtnCode.MEAl_NOT_FOUND.getMessage(),null,null,null);
		}
		mealDao.updateMealEvaluate(storeMeal,newEvaluate);
		storeDao.updateStoreEvaluate(storeName);
		
		Optional<Meal> opUpdatedMeal = mealDao.findById(storeMeal);
		//更新後的餐點評價
		Meal updatedMeal = opUpdatedMeal.get();		
		Optional<Store> opUpdatedStore = storeDao.findById(storeName);
		//更新後的店家評價
		Store afterStore = opUpdatedStore.get();
		return new MealEvaluateResponse(RtnCode.REVISE_SUCCESSFUL.getCode(), RtnCode.REVISE_SUCCESSFUL.getMessage(), beforeStore,afterStore,updatedMeal);
	}

}
