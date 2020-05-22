package com.example.usStore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.usStore.dao.SecondHandDao;
import com.example.usStore.dao.mybatis.mapper.SecondHandMapper;
import com.example.usStore.domain.SecondHand;

@Repository
public class MybatisSecondHandDao implements SecondHandDao{

	@Autowired
	private SecondHandMapper secondHandMapper;
	
	@Override
	public List<SecondHand> getSecondHandList() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SecondHand getSecondHandItem(int itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertSecondHand(SecondHand secondHand) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delteSecondHand(SecondHand secondHand) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSecondHand(SecondHand secondHand) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
