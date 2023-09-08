package com.example.delicious_map.service.ifs;

import java.util.List;

import com.example.delicious_map.entity.Store;
import com.example.delicious_map.vo.SearchCityAllStoreResponse;
import com.example.delicious_map.vo.SearchStoreEvaluateResponse;
import com.example.delicious_map.vo.StoreResponse;

public interface StoreService {

	//新增單筆店家
	public StoreResponse addStore(Store store);
	//新增多筆店家
	public StoreResponse addStores(List<Store> storeList);
	//搜尋特定城市找出所有的店家，可限制顯示筆數
	public SearchCityAllStoreResponse searchCityAllStore(String city,  int row );
	//搜尋店家評價幾等以上(含)
	public SearchStoreEvaluateResponse searchStoreEvaluate(float evaluate);
	//搜尋店家評價幾等以上(含)以及餐點評價幾等以上(含)
	public SearchStoreEvaluateResponse searchStoreAndMealEvaluate(float evaluate, int mealEvaluate);
}
