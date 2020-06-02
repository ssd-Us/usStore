package com.example.usStore.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.SecondHand;
import com.example.usStore.domain.Item;

public interface SecondHandMapper {
//	void updateSecondHandQuantity(Map<String, Object> param);
//
//	int getSecondHandQuantity(int itemId);
//
//	List<SecondHand> getSecondHandItemListByProduct(int productId);
//
//	Item getSecondHandItem(int itemId);
//
//	boolean isSecondHandItemInStock(int itemId);

	// 전체 SecondHandList 받아오기
<<<<<<< HEAD
	List<SecondHand> getSecondHandList();
=======
	List<SecondHand> getSecondHandList() throws DataAccessException;
>>>>>>> branch 'test' of https://github.com/ssd-Us/usStore.git

	// itemId 매개변수로 받아 SecondHand 객체 반환
<<<<<<< HEAD
	SecondHand getSecondHandItem(int itemId);
=======
	SecondHand getSecondHandItem(int itemId) throws DataAccessException;
>>>>>>> branch 'test' of https://github.com/ssd-Us/usStore.git

	// SecondHand 추가
<<<<<<< HEAD
	public void insertSecondHand(SecondHand secondHand);

	// SecondHand 삭제
	public void deleteItem(int itemId);

	// SecondHand 수정
	public void updateSecondHand(SecondHand secondHand);

	/* 기존에 ItemDao에 있었던 메소드들 */
	boolean isItemInStock(int itemId, int productId);

	void updateQuantity(int qty, int itemId, int productId);

	int getQuantity(int itemId, int productId);
=======
	public void insertSecondHand(SecondHand secondHand) throws DataAccessException;

	// SecondHand 삭제
	public void deleteItem(int itemId) throws DataAccessException;

	// SecondHand 수정
	public void updateSecondHand(SecondHand secondHand) throws DataAccessException;

	/* 기존에 ItemDao에 있었던 메소드들 */
	boolean isItemInStock(int itemId, int productId) throws DataAccessException;

	void updateQuantity(int qty, int itemId, int productId) throws DataAccessException;

	int getQuantity(int itemId, int productId) throws DataAccessException;
>>>>>>> branch 'test' of https://github.com/ssd-Us/usStore.git
}
