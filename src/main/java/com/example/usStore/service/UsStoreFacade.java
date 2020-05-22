package com.example.usStore.service;

import java.util.List;

import com.example.usStore.domain.*;

/**
 * usStore's central business interface.
 *
 * @author Juergen Hoeller
 * @since 30.11.2003
 */
public interface UsStoreFacade {

	Account getAccount(String username);

	Account getAccount(String username, String password);
	
	String getStatus(String userId);

	void insertAccount(Account account);

	void updateAccount(Account account);

	List<String> getUsernameList();


	List<Category> getCategoryList();

	Category getCategory(String categoryId);
	

	List<Product> getProductListByCategory(String categoryId);

	List<Product> searchProductList(String keywords);

	Product getProduct(String productId);


	List<Item> getItemListByProduct(String productId);

	Item getItem(String itemId);

	boolean isItemInStock(String itemId);


	void insertOrder(Orders order);

	Orders getOrder(int orderId);

	List<Orders> getOrdersByUsername(String username);

}