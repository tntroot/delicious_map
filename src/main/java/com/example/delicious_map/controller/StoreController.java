package com.example.delicious_map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.delicious_map.entity.Store;
import com.example.delicious_map.service.ifs.StoreService;
import com.example.delicious_map.vo.SearchCityAllStoreResponse;
import com.example.delicious_map.vo.SearchStoreAndMealEvaluateReq;
import com.example.delicious_map.vo.SearchStoreEvaluateResponse;
import com.example.delicious_map.vo.StoreAddStoreReq;
import com.example.delicious_map.vo.StoreAddStoresReq;
import com.example.delicious_map.vo.SearchStoreEvaluateReq;
import com.example.delicious_map.vo.StoreResponse;
import com.example.delicious_map.vo.StoreSearchCityReq;

@RestController
public class StoreController {

	@Autowired
	private StoreService storeService;
	
	@PostMapping(value = "store/addStore")
	public StoreResponse addStore(@RequestBody StoreAddStoreReq req) {
		//�s�W�浧���a
		return storeService.addStore(new Store(req.getName(),req.getCity(),5));
	}
	
	@PostMapping(value = "store/addStores")
	public StoreResponse addStores(@RequestBody StoreAddStoresReq req) {
		//�s�W�h�����a
		return storeService.addStores(req.getStoreList());
	}
	
	@PostMapping(value = "store/searchCityAllStore")
	public  SearchCityAllStoreResponse searchCityAllStore(@RequestBody StoreSearchCityReq req) {
		//�j�M�S�w������X�Ҧ������a�A�i������ܵ���
		return storeService.searchCityAllStore(req.getCity(),req.getRow());
	}
	
	//�j�M���a�����X���H�W(�t)
	@PostMapping(value = "store/searchStoreEvaluate")
	public SearchStoreEvaluateResponse searchStoreEvaluate(@RequestBody SearchStoreEvaluateReq req) {
		return storeService.searchStoreEvaluate(req.getEvaluate());
	}
	//�j�M���a�����X���H�W(�t)�H���\�I�����X���H�W(�t)
	
	@PostMapping(value = "store/searchStoreAndMealEvaluate")
	public SearchStoreEvaluateResponse searchStoreAndMealEvaluate(@RequestBody SearchStoreAndMealEvaluateReq req) {
		return storeService.searchStoreAndMealEvaluate(req.getEvaluate(),req.getMealEvaluate());
	}
}
