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
		// TODO Auto-generated method stub
		secondHandMapper.updateQuantity(qty, itemId, productId);
	}

	@Override
	public int getQuantity(int itemId, int productId) throws DataAccessException {
		// TODO Auto-generated method stub
		return secondHandMapper.getQuantity(itemId, productId);
	}

	@Override
	public boolean isItemInStock(int itemId, int productId) throws DataAccessException {
		// TODO Auto-generated method stub
		return secondHandMapper.isItemInStock(itemId, productId);
	}

	@Override
	public void deleteItem(int itemId, int productId) throws DataAccessException {
		// TODO Auto-generated method stub
		secondHandMapper.deleteItem(itemId, productId);
	}

	@Override
	public List<SecondHand> getSecondHandList() throws DataAccessException {
		// TODO Auto-generated method stub
		return secondHandMapper.getSecondHandList();
	}

	@Override
	public SecondHand getSecondHandItem(int itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		return secondHandMapper.getSecondHandItem(itemId);
	}

	@Override
	public void insertSecondHand(SecondHand secondHand) throws DataAccessException {
		// TODO Auto-generated method stub
		secondHandMapper.insertSecondHand(secondHand);
	}

	@Override
	public void updateSecondHand(SecondHand secondHand) throws DataAccessException {
		// TODO Auto-generated method stub
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
	
}
