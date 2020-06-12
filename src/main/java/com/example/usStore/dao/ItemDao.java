package com.example.usStore.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Item;

public interface ItemDao {

	// insert Item
	void insertItem(Item item);
	
	// update Item
	void updateItem(Item item);
	
	// getItem
	void getItem(int itemId, int productId);
	
	// 아이템 삭제 메소드
	public void deleteItem(int itemId, int productId) throws DataAccessException;
	
	// 구매 개수 수정
	void updateQuantity(int qty, int itemId, int productId) throws DataAccessException;
	
	// 구매 개수 받아오기
	int getQuantity(int itemId, int productId) throws DataAccessException;

	// 아이템 아이디로 해당 수공예품의 재고가 있는지 확인하는 메소드
	boolean isItemInStock(int itemId, int productId) throws DataAccessException;

}
