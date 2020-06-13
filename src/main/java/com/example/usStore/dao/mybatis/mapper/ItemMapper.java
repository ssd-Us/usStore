
package com.example.usStore.dao.mybatis.mapper;

import com.example.usStore.domain.Item;

public interface ItemMapper {

	void insertItem(Item item);
	
	void updateItem(Item item);
	
	void deleteItem(int itemId);
	
	void getItem(int itemId, int productId);
	
	void updateQuantity(int qty, int itemId, int productId);
	
	int getQuantity(int itemId, int productId);

	boolean isItemInStock(int itemId, int productId);

}

