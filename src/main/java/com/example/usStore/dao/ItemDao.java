package com.example.usStore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Item;

public interface ItemDao {

  public void insertItem(Item item) throws DataAccessException;
  
  public void delteItem(Item item) throws DataAccessException;
  
  //public void updateQuantity(Order order) throws DataAccessException;
  public void updateItem(Item item) throws DataAccessException;

  boolean isItemInStock(int itemId) throws DataAccessException;	//제품 재고가 있는지..?

  //List<Item> getItemListByProduct(String productId) throws DataAccessException;
  List<Item> getItemList() throws DataAccessException;

  Item getItem(int itemId) throws DataAccessException;
}

