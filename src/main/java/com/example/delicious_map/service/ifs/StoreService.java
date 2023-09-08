package com.example.delicious_map.service.ifs;

import java.util.List;

import com.example.delicious_map.entity.Store;
import com.example.delicious_map.vo.SearchCityAllStoreResponse;
import com.example.delicious_map.vo.SearchStoreEvaluateResponse;
import com.example.delicious_map.vo.StoreResponse;

public interface StoreService {

	//�s�W�浧���a
	public StoreResponse addStore(Store store);
	//�s�W�h�����a
	public StoreResponse addStores(List<Store> storeList);
	//�j�M�S�w������X�Ҧ������a�A�i������ܵ���
	public SearchCityAllStoreResponse searchCityAllStore(String city,  int row );
	//�j�M���a�����X���H�W(�t)
	public SearchStoreEvaluateResponse searchStoreEvaluate(float evaluate);
	//�j�M���a�����X���H�W(�t)�H���\�I�����X���H�W(�t)
	public SearchStoreEvaluateResponse searchStoreAndMealEvaluate(float evaluate, int mealEvaluate);
}
