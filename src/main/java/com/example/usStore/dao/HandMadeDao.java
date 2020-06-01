package com.example.usStore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.HandMade;

public interface HandMadeDao {

	// insert HandMade
	public void insertHandMade(HandMade handmade) throws DataAccessException;
	  
	// delete HandMade
	public void deleteItem(int itemId) throws DataAccessException;
	  
	// update HandMade
	public void updateHandMade(HandMade handmade) throws DataAccessException;
	
	// 아이템 아이디로 해당 수공예품의 재고가 있는지 확인하는 메소드
	boolean isItemInStock(int itemId) throws DataAccessException;
	
	// 모든 수공예 리스트 가져오는 메소드
	List<HandMade> getHandMadeList() throws DataAccessException;
	
	// itemId 받아서 해당하는 HandMade 객체 반환
	HandMade getHandMadeById(int itemId) throws DataAccessException;
	
	// Product_id를 받아 HandMade 전체 list 가져오기
	List<HandMade> getHandMadeListByProductId(int productId) throws DataAccessException;

	// 구매 개수 수정
	void updateQuantity(int qty, int itemId) throws DataAccessException;
	
	// 구매 개수 받아오기
	int getQuantity(int itemId) throws DataAccessException;
}
