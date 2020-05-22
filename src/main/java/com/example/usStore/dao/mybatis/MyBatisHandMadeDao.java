package com.example.usStore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.usStore.dao.HandMadeDao;
import com.example.usStore.dao.mybatis.mapper.HandMadeMapper;
import com.example.usStore.domain.HandMade;

@Repository
public class MyBatisHandMadeDao implements HandMadeDao{

	@Autowired
	private HandMadeMapper handMadeMapper;
	
	@Override
	public List<HandMade> getHandMadeList() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HandMade getHandMadeItem(int itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isHandMade(int itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insertHandMade(HandMade handmade) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delteHandMade(HandMade handmade) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateHandMade(HandMade handmade) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
