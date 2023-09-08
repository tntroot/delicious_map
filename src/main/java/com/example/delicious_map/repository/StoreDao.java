package com.example.delicious_map.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.delicious_map.entity.Store;
import com.example.delicious_map.vo.CityAllStoreVo;
import com.example.delicious_map.vo.StoreEvaluateVo;

@Repository
public interface StoreDao extends JpaRepository<Store, String>{
	
	//э┍產蝶基
	@Modifying(clearAutomatically = true )
	@Transactional
	@Query(value =" update store_map set evaluate = (select round(avg(store_meal.meal_evaluate),1) from store_meal where store_name = :name) where store_map.name = :name", nativeQuery = true)
	public int updateStoreEvaluate (@Param("name")String name);
	
	
	//穓碝疭﹚カт┮Τ┍產陪ボ掸计
	@Query(value ="SELECT NEW com.example.delicious_map.vo.CityAllStoreVo (map.name,map.evaluate,m.storeMeal,m.mealPrice,m.mealEvaluate) " 
	+ " FROM  Store as map  left JOIN  Meal as m on map.name = m.storeName "
	+" where map.city = :inputCity ")
	public Page<CityAllStoreVo> searchCityAllStore(@Param("inputCity") String city , Pageable pageable);
	
	//穓碝┍產蝶基碭单()
	@Query(value ="select NEW com.example.delicious_map.vo.StoreEvaluateVo(map.city, map.name , map.evaluate , meal.storeMeal, meal.mealPrice, meal.mealEvaluate)"
	+" from  Store as map  left  join Meal as meal on map.name = meal.storeName  "
	+" where map.evaluate >= :inputEvaluate order by  map.evaluate desc ")
	public List<StoreEvaluateVo> searchStoreEvaluate(@Param("inputEvaluate")float evaluate);
	
	//穓碝┍產蝶基碭单()の繺翴蝶基碭单()
	@Query(value =
		    " SELECT NEW com.example.delicious_map.vo.StoreEvaluateVo(map.city, map.name, map.evaluate, meal.storeMeal, meal.mealPrice, meal.mealEvaluate) " +
		    " FROM Store AS map " +
		    " left JOIN Meal AS meal ON map.name = meal.storeName " +
		    " WHERE map.evaluate >= :inputEvaluate " +
		    " AND meal.mealEvaluate >= :inputMealEvaluate " +
		    " ORDER BY map.evaluate  DESC , meal.mealEvaluate DESC"
		)
	public List<StoreEvaluateVo> searchStoreAndMealEvaluate(@Param("inputEvaluate") float evaluate,@Param("inputMealEvaluate") int mealEvaluate);

}
