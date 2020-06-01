package com.example.usStore.service.facade;

import java.util.List;

import com.example.usStore.domain.*;

/*
 * UsStoreFacade
 * 
 * Account / Orders / Category / Product
 * */
public interface UsStoreFacade {

	/////////////////////////////////////////////////////////////////////////
	/* Account */
	/////////////////////////////////////////////////////////////////////////
	Account getAccountByUsername(String username);

	Account getAccountByUsernameAndPassword(String username, String password);
	
	String getStatus(String userId);

	void insertAccount(Account account);

	void updateAccount(Account account);

	/////////////////////////////////////////////////////////////////////////
	/* Category */
	/////////////////////////////////////////////////////////////////////////
	List<Category> getCategoryList();

	Category getCategory(int categoryId);
	
	/////////////////////////////////////////////////////////////////////////
	/* Product */
	/////////////////////////////////////////////////////////////////////////
	List<Product> getProductListByCategory(int categoryId);

	List<Product> searchProductList(String keywords);

	Product getProduct(int productId);


	/////////////////////////////////////////////////////////////////////////
	/* Orders */
	/////////////////////////////////////////////////////////////////////////
	List<Orders> getOrdersByUserId(String userId);
	
	List<Orders> getOrdersByUsername(String username);

	Orders getOrder(int orderId);
	
	void insertOrder(Orders order);
}