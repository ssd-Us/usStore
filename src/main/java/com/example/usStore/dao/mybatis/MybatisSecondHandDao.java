package com.example.usStore.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.usStore.dao.SecondHandDao;
import com.example.usStore.dao.mybatis.mapper.SecondHandMapper;
import com.example.usStore.domain.Item;
import com.example.usStore.domain.SecondHand;

@Repository
public class MybatisSecondHandDao implements SecondHandDao {

	@Autowired
	private SecondHandMapper secondHandMapper;
	
	@Override
	public void updateQuantity(int qty, int itemId, int productId) throws DataAccessException {
		secondHandMapper.updateQuantity(qty, itemId, productId);
	}
	
	@Override
	public int getQuantity(int itemId, int productId) throws DataAccessException {
		return secondHandMapper.getQuantity(itemId, productId);
	}
	
	@Override
	public boolean isItemInStock(int itemId, int productId) throws DataAccessException {
		return secondHandMapper.isItemInStock(itemId, productId);
	}
	
	@Override
	public void deleteItem(int itemId, int productId) throws DataAccessException {
		secondHandMapper.deleteItem(itemId, productId);
	}
	
	@Override
	public List<SecondHand> getSecondHandList() throws DataAccessException {
		return secondHandMapper.getSecondHandList();
	}
	
	@Override
	public void insertSecondHand(SecondHand secondHand) throws DataAccessException {
		secondHandMapper.insertSecondHand(secondHand);
	}
	
	@Override
	public void updateSecondHand(SecondHand secondHand) throws DataAccessException {
		secondHandMapper.updateSecondHand(secondHand);
	}

	@Override
	public void insertItem(Item item) {
		// TODO Auto-generated method stub
		secondHandMapper.insertItem(item);
	}

	@Override
	public void updateItem(Item item) {
		// TODO Auto-generated method stub
		secondHandMapper.updateItem(item);
	}

	@Override
	public void getItem(int itemId, int productId) {
		// TODO Auto-generated method stub
		secondHandMapper.getItem(itemId, productId);
	}

	@Override
	public SecondHand getSecondHandItem(int itemId) throws DataAccessException {
		return null;
	}
}