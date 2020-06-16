package com.example.usStore.service.facade;

import java.util.List;

import com.example.usStore.domain.*;

/*
 * UsStoreFacade
 * 
 * Account / Orders / Category 
 * */
public interface UsStoreFacade {

	/////////////////////////////////////////////////////////////////////////
	/* Account */
	/////////////////////////////////////////////////////////////////////////
	Account getAccountByUserId(String userId);

	Account getAccountByUserIdAndPassword(String userId, String password);
	
	String getStatus(String userId);

	void insertAccount(Account account);

	void updateAccount(Account account);
	
	Account getAccountByUsername(String userName);

	/////////////////////////////////////////////////////////////////////////
	/* Category */
	/////////////////////////////////////////////////////////////////////////
	List<Category> getCategoryList();

	Category getCategory(int categoryId);
	

	/////////////////////////////////////////////////////////////////////////
	/* Orders */
	/////////////////////////////////////////////////////////////////////////
	List<Orders> getOrdersByUserId(String userId);
	
	List<Orders> getOrdersByUsername(String username);

	Orders getOrder(int orderId);
	
	void insertOrder(Orders order);
}