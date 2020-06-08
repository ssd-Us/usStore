package com.example.usStore.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Item;

public interface ItemDao {

	// updateQuantity
	void updateInventoryQuantity(Map<String, Object> param) throws DataAccessException;

	// getQuantity
	int getInventoryQuantity(int itemId, int productId) throws DataAccessException;
	
	// 위에 두개랑 차이를 모르겠음. 일단 둘다 살림.
	// 구매 개수 수정
	void updateQuantity(int qty, int itemId, int productId) throws DataAccessException;
	
	// 구매 개수 받아오기
	int getQuantity(int itemId, int productId) throws DataAccessException;

	// 아이템 아이디로 해당 수공예품의 재고가 있는지 확인하는 메소드
	boolean isItemInStock(int itemId, int productId) throws DataAccessException;
	
	// 아이템 삭제 메소드
	public void deleteItem(int itemId, int productId) throws DataAccessException;
}
