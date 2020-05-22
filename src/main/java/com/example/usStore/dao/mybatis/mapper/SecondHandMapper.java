package com.example.usStore.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.example.usStore.domain.SecondHand;
import com.example.usStore.domain.Item;

public interface SecondHandMapper {
	  void updateSecondHandQuantity(Map<String, Object> param);

	  int getSecondHandQuantity(String itemId);

	  List<SecondHand> getSecondHandItemListByProduct(String productId);

	  Item getSecondHandItem(String itemId);
	  
	  boolean isSecondHandItemInStock(String itemId);	
}
