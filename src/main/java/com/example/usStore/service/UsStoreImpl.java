package com.example.usStore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.usStore.dao.*;
import com.example.usStore.domain.*;

@Service
@Transactional
public class UsStoreImpl implements UsStoreFacade { 
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private HandMadeDao handMadeDao;
	@Autowired
	private GroupBuyingDao groupBuyingDao;
	@Autowired
	private SecondHandDao secondHandDao;
	@Autowired
	private AuctionDao auctionDao;
	
	@Autowired
	private OrderDao orderDao;

	public Account getAccountByUsername(String username) {
		return accountDao.getAccountByUsername(username);
	}

	public Account getAccountByUsernameAndPassword(String username, String password) {
		return accountDao.getAccountByUsernameAndPassword(username, password);
	}

	public void insertAccount(Account account) {
		accountDao.insertAccount(account);
	}

	public void updateAccount(Account account) {
		accountDao.updateAccount(account);
	}

	public List<Category> getCategoryList() {
		return categoryDao.getCategoryList();
	}

	public Category getCategory(int categoryId) {
		return categoryDao.getCategory(categoryId);
	}

	public List<Product> getProductListByCategory(String categoryId) {
		return productDao.getProductListByCategory(categoryId);
	}

	public List<Product> searchProductList(String keywords) {
		return productDao.searchProductList(keywords);
	}

	/*
	 * public Product getProduct(int productId) { return
	 * productDao.getProduct(productId); }
	 * 
	 * public List<Item> getItemListByProduct(int productId) { return
	 * itemDao.getItemListByProduct(productId); }
	 */
	
	public SecondHand getSecondHandItem(int itemId) {
		return secondHandDao.getSecondHandItem(itemId);
	}
	
	public Auction getAuctionItem(int itemId) {
		return auctionDao.getAuctionItem(itemId);
	}
	
	public GroupBuying getGroupBuyingItem(int itemId) {
		return groupBuyingDao.getGroupBuyingItem(itemId);
	}

	/*
	 * public boolean isItemInStock(int itemId) { return
	 * itemDao.isItemInStock(itemId); }
	 */

	public void insertOrder(Orders order) {
		//itemDao.updateQuantity(order);	    
		orderDao.insertOrder(order);
	}
	
	public Orders getOrder(int orderId) {
		return orderDao.getOrder(orderId);
	}

	public List<Orders> getOrdersByUsername(String username) {
		return orderDao.getOrdersByUsername(username);
	}

	@Override
	public Category getCategory(String categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProduct(String productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getItemListByProduct(String productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item getItem(String itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isItemInStock(String itemId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getStatus(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
}