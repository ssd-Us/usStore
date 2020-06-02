package com.example.usStore.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.HandMade;
import com.example.usStore.domain.Item;

public interface HandMadeMapper {
//	void updateHandMadeQuantity(Map<String, Object> param);
//
//	int getHandMadeQuantity(int itemId);
//
//	List<HandMade> getHandMadeItemListByProduct(int productId);
//
//	Item getHandMadeItem(int itemId);
//
//	boolean isHandMadeItemInStock(int itemId);

	// insert HandMade
	public void insertHandMade(HandMade handmade) throws DataAccessException;

	// delete HandMade
	public void deleteItem(int itemId) throws DataAccessException;

	// update HandMade
	public void updateHandMade(HandMade handmade) throws DataAccessException;

	// 아이템 아이디로 해당 수공예품의 재고가 있는지 확인하는 메소드
	boolean isItemInStock(int itemId, int productId) throws DataAccessException;

	// 모든 수공예 리스트 가져오는 메소드
	List<HandMade> getHandMadeList() throws DataAccessException;

	// itemId 받아서 해당하는 HandMade 객체 반환
	HandMade getHandMadeById(int itemId) throws DataAccessException;

	// Product_id를 받아 HandMade 전체 list 가져오기
	List<HandMade> getHandMadeListByProductId(int productId) throws DataAccessException;

	// 구매 개수 수정
	void updateQuantity(int qty, int itemId, int productId) throws DataAccessException;

	// 구매 개수 받아오기
	int getQuantity(int itemId, int productId) throws DataAccessException;
}
