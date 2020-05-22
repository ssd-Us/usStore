package com.example.usStore.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.example.usStore.domain.HandMade;
import com.example.usStore.domain.Item;

public interface HandMadeMapper {
	  void updateHandMadeQuantity(Map<String, Object> param);

	  int getHandMadeQuantity(String itemId);

	  List<HandMade> getHandMadeItemListByProduct(String productId);

	  Item getHandMadeItem(String itemId);
	  
	  boolean isHandMadeItemInStock(String itemId);	
}
