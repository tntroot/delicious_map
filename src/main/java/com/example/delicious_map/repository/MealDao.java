package com.example.delicious_map.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.delicious_map.entity.Meal;

@Repository
public interface MealDao extends JpaRepository<Meal, String>{

	@Modifying
	@Transactional
	@Query(value ="update store_meal set store_meal = :newStoreMeal where store_meal = :oldStoreMeal", nativeQuery = true)
	public int updateStoreMeal(@Param("oldStoreMeal")String oldStoreMeal, @Param("newStoreMeal")String newStoreMeal);
	
	//­×§ïÀ\ÂIµû»ù
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value =" update store_meal set meal_evaluate= :newEvaluate  where store_meal= :storeMeal", nativeQuery = true)
	public int updateMealEvaluate(@Param("storeMeal")String storeMeal,@Param("newEvaluate")int newEvaluate);
}
