package com.example.usStore.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.example.usStore.domain.GroupBuying;
import com.example.usStore.domain.Item;

public interface GroupBuyingMapper {
	  void updateGroupBuyingQuantity(Map<String, Object> param);

	  int getGroupBuyingQuantity(int itemId);

	  List<GroupBuying> getGroupBuyingItemListByProduct(int productId);

	  Item getGroupBuyingItem(int itemId);
	  
	  boolean isGroupBuyingItemInStock(int itemId);	
	

}
