package com.example.usStore.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.usStore.dao.HandMadeDao;
import com.example.usStore.dao.mybatis.mapper.HandMadeMapper;
import com.example.usStore.domain.HandMade;
import com.example.usStore.domain.Item;

@Qualifier("mybatisHandMadeDao")
@Repository
public class MybatisHandMadeDao implements HandMadeDao {

	@Autowired
	private HandMadeMapper handMadeMapper;

	@Override
	public void updateQuantity(int qty, int itemId, int productId) throws DataAccessException {
		// TODO Auto-generated method stub
		handMadeMapper.updateQuantity(qty, itemId, productId);
	}

	@Override
	public int getQuantity(int itemId, int productId) throws DataAccessException {
		// TODO Auto-generated method stub
		return handMadeMapper.getQuantity(itemId, productId);
	}

	@Override
	public boolean isItemInStock(int itemId, int productId) throws DataAccessException {
		// TODO Auto-generated method stub
		return handMadeMapper.isItemInStock(itemId, productId);
	}

	@Override
	public void deleteHandMade(int itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		handMadeMapper.deleteHandMade(itemId);
	}

	@Override
	public void insertHandMade(HandMade handmade) throws DataAccessException {
		// TODO Auto-generated method stub
		handMadeMapper.insertHandMade(handmade);
	}

	@Override
	public void updateHandMade(HandMade handmade) throws DataAccessException {
		// TODO Auto-generated method stub
		handMadeMapper.updateHandMade(handmade);
	}

	@Override
	public List<HandMade> getHandMadeList() throws DataAccessException {
		// TODO Auto-generated method stub
		return handMadeMapper.getHandMadeList();
	}

	@Override
	public HandMade getHandMadeById(int itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		return handMadeMapper.getHandMadeById(itemId);
	}

	@Override
	public List<HandMade> getHandMadeListByProductId(int productId) throws DataAccessException {
		// TODO Auto-generated method stub
		return handMadeMapper.getHandMadeListByProductId(productId);
	}

	@Override
	public void insertItem(Item item) {
		// TODO Auto-generated method stub
		handMadeMapper.insertItem(item);
	}

	@Override
	public void updateItem(Item item) {
		// TODO Auto-generated method stub
		handMadeMapper.updateItem(item);
	}

	@Override
	public void getItem(int itemId, int productId) {
		// TODO Auto-generated method stub
		handMadeMapper.getItem(itemId, productId);
	}

	@Override
	public void deleteItem(int itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		handMadeMapper.deleteItem(itemId);
	}

}
