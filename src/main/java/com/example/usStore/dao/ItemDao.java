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
	Item getItem(int itemId);
	
	// �븘�씠�뀥 �궘�젣 硫붿냼�뱶
	public void deleteItem(int itemId) throws DataAccessException;
	
	// 援щℓ 媛쒖닔 �닔�젙
	void updateQuantity(int qty, int itemId, int productId) throws DataAccessException;
	
	// 援щℓ 媛쒖닔 諛쏆븘�삤湲�
	int getQuantity(int itemId, int productId) throws DataAccessException;

	// �븘�씠�뀥 �븘�씠�뵒濡� �빐�떦 �닔怨듭삁�뭹�쓽 �옱怨좉� �엳�뒗吏� �솗�씤�븯�뒗 硫붿냼�뱶
	boolean isItemInStock(int itemId, int productId) throws DataAccessException;

	String getUserIdByItemId(int itemId) throws DataAccessException;

}
