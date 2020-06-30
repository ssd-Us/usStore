
package com.example.usStore.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.example.usStore.domain.Item;

public interface ItemMapper {

	void insertItem(Item item);
	  
	void updateItem(Item item);
		 
	void deleteItem(int itemId);
	
	Item getItem(int itemId);
	
	void updateInventoryQuantity(Map<String, Object> param);
	
	int getQuantity(int itemId, int productId);

	boolean isItemInStock(int itemId, int productId);

	String getUserIdByItemId(int itemId);
	
	void updateViewCount(int viewCount, int itemId);
	
	List<Item> getItemByPId(int productId);
	
	List<Item> getItemByTitle(String title);
}

