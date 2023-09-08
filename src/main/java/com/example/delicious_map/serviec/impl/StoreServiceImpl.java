package com.example.delicious_map.serviec.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.delicious_map.constants.RtnCode;
import com.example.delicious_map.entity.Store;
import com.example.delicious_map.repository.StoreDao;
import com.example.delicious_map.service.ifs.StoreService;
import com.example.delicious_map.vo.CityAllStoreVo;
import com.example.delicious_map.vo.SearchCityAllStoreResponse;
import com.example.delicious_map.vo.SearchStoreEvaluateResponse;
import com.example.delicious_map.vo.StoreEvaluateVo;
import com.example.delicious_map.vo.StoreResponse;

@Service
public class StoreServiceImpl implements StoreService{
	
	@Autowired
	private StoreDao storeDao;
	
	@Override
	public StoreResponse addStore(Store store) {
		//新增單筆店家
		List<Store> storeList = new ArrayList<>(Arrays.asList(store));
		if (!StringUtils.hasText(store.getName()) || !StringUtils.hasText(store.getCity()) ||store.getEvaluate() < 1 ||store.getEvaluate() > 5) {
			return new StoreResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage(), storeList);
		}
		if (storeDao.existsById(store.getName())) {
			return new StoreResponse(RtnCode.STORE_EXISTED.getCode(), RtnCode.STORE_EXISTED.getMessage(), storeList);
		}
		storeDao.save(store);
		return new StoreResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), storeList);
	}
	
	@Override
	public StoreResponse addStores(List<Store> storeList) {
		//新增多筆店家	
		if(CollectionUtils.isEmpty(storeList)) {
			return new StoreResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage(),storeList);
		}
		for (Store item:storeList) {
			if (!StringUtils.hasText(item.getName()) || !StringUtils.hasText(item.getCity()) || item.getEvaluate() < 1 ||item.getEvaluate() > 5) {
				return new StoreResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage(),storeList);
			}
			if (storeDao.existsById(item.getName())) {
				return new StoreResponse(RtnCode.STORE_EXISTED.getCode(), RtnCode.STORE_EXISTED.getMessage(), storeList);
			}
		}
		storeDao.saveAll(storeList);
		return new StoreResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), storeList);
	}

	@Override
	public SearchCityAllStoreResponse searchCityAllStore(String city,int row) {
		//搜尋特定城市找出所有的店家，可限制顯示筆數
		if (!StringUtils.hasText(city)||row<1) {
			return new SearchCityAllStoreResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage(), null);
		}
		Pageable pageable = PageRequest.of(0, row);
		Page<CityAllStoreVo> result = storeDao.searchCityAllStore(city, pageable);
		if(result.isEmpty()) {
			return new SearchCityAllStoreResponse(RtnCode.NOT_FOUND.getCode(), RtnCode.NOT_FOUND.getMessage(),null);
		}
		return new SearchCityAllStoreResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), result.getContent());
	}

	@Override
	public SearchStoreEvaluateResponse searchStoreEvaluate(float evaluate) {
		//搜尋店家評價幾等以上(含)
		if (evaluate<1) {
			return new SearchStoreEvaluateResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage(), null);
		}
		List<StoreEvaluateVo> resDate = storeDao.searchStoreEvaluate(evaluate);
		if(CollectionUtils.isEmpty(resDate)) {
			return new SearchStoreEvaluateResponse(RtnCode.NOT_FOUND.getCode(), RtnCode.NOT_FOUND.getMessage(),null);
		}
		
		return new SearchStoreEvaluateResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), resDate);
	}

	@Override
	public SearchStoreEvaluateResponse searchStoreAndMealEvaluate(float evaluate, int mealEvaluate) {
		//搜尋店家評價幾等以上(含)以及餐點評價幾等以上(含)
		if (evaluate<1 || mealEvaluate<1) {
			return new SearchStoreEvaluateResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage(), null);
		}
		List<StoreEvaluateVo> resDate = storeDao.searchStoreAndMealEvaluate(evaluate,mealEvaluate);
		if(CollectionUtils.isEmpty(resDate)) {
			return new SearchStoreEvaluateResponse(RtnCode.NOT_FOUND.getCode(), RtnCode.NOT_FOUND.getMessage(),null);
		}
		return new SearchStoreEvaluateResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), resDate);
		
	}
	
	
}
