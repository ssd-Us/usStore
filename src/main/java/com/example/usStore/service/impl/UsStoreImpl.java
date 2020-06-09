package com.example.usStore.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.usStore.dao.*;
import com.example.usStore.domain.*;
import com.example.usStore.service.facade.UsStoreFacade;

/*
 * UsStoreImpl
 * 
 * Account / Orders / Category
 * */

@Service
@Transactional
public class UsStoreImpl implements UsStoreFacade { 
	
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private OrderDao orderDao;

	@Override
	public Account getAccountByUsername(String username) {
		// TODO Auto-generated method stub
		return accountDao.getAccountByUsername(username);
	}

	@Override
	public Account getAccountByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return accountDao.getAccountByUsernameAndPassword(username, password);
	}

	@Override
	public String getStatus(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertAccount(Account account) {
		// TODO Auto-generated method stub
		accountDao.insertAccount(account);
	}

	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		accountDao.updateAccount(account);
	}

	@Override
	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryList();
	}

	@Override
	public Category getCategory(int categoryId) {
		// TODO Auto-generated method stub
		return categoryDao.getCategory(categoryId);
	}

	@Override
	public List<Orders> getOrdersByUserId(String userId) {
		// TODO Auto-generated method stub
		return orderDao.getOrdersByUserId(userId);
	}

	@Override
	public List<Orders> getOrdersByUsername(String username) {
		// TODO Auto-generated method stub
		return orderDao.getOrdersByUsername(username);
	}

	@Override
	public Orders getOrder(int orderId) {
		// TODO Auto-generated method stub
		return orderDao.getOrder(orderId);
	}

	@Override
	public void insertOrder(Orders order) {
		//itemDao.updateQuantity(order);	    
		orderDao.insertOrder(order);
	}
	 
}