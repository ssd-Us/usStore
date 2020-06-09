package com.example.usStore.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.usStore.dao.SecondHandDao;
import com.example.usStore.dao.mybatis.mapper.SecondHandMapper;
import com.example.usStore.domain.SecondHand;

//Dao를 구현한 클래스 세컨핸드랑 아이템DAO 모두 구현 
@Repository
public class MybatisSecondHandDao implements SecondHandDao {

	@Autowired
	private SecondHandMapper secondHandMapper;

	public void updateInventoryQuantity(Map<String, Object> param) throws DataAccessException {
		secondHandMapper.updateInventoryQuantity(param);
	}

	public int getInventoryQuantity(int itemId, int productId) throws DataAccessException {
		return secondHandMapper.getInventoryQuantity(itemId, productId);
	}

	public void updateQuantity(int qty, int itemId, int productId) throws DataAccessException {
		secondHandMapper.updateQuantity(qty, itemId, productId);
	}

	public int getQuantity(int itemId, int productId) throws DataAccessException {
		return secondHandMapper.getQuantity(itemId, productId);
	}

	public boolean isItemInStock(int itemId, int productId) throws DataAccessException {
		return secondHandMapper.isItemInStock(itemId, productId);
	}

	public void deleteItem(int itemId, int productId) throws DataAccessException {
		secondHandMapper.deleteItem(itemId, productId);
	}

	public List<SecondHand> getSecondHandList() throws DataAccessException {
		return secondHandMapper.getSecondHandList();
	}

	public void insertSecondHand(SecondHand secondHand) throws DataAccessException {
		secondHandMapper.insertSecondHand(secondHand);
	}

	public void updateSecondHand(SecondHand secondHand) throws DataAccessException {
		secondHandMapper.updateSecondHand(secondHand);
	}

	public SecondHand getSecondHandItem(int itemId) throws DataAccessException {
		return null;
	}

	
}