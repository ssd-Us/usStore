package com.example.usStore.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.example.usStore.domain.HandMade;
import com.example.usStore.domain.Item;

public interface HandMadeMapper {
	  void updateHandMadeQuantity(Map<String, Object> param);

	  int getHandMadeQuantity(int itemId);

	  List<HandMade> getHandMadeItemListByProduct(int productId);

	  Item getHandMadeItem(int itemId);
	  
	  boolean isHandMadeItemInStock(int itemId);	
}
