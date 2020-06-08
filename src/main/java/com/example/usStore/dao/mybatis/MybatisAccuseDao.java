package com.example.usStore.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.usStore.dao.AccountDao;
import com.example.usStore.dao.AccuseDao;
import com.example.usStore.dao.mybatis.mapper.AccuseMapper;
import com.example.usStore.dao.mybatis.mapper.AuctionMapper;
import com.example.usStore.domain.Account;
import com.example.usStore.domain.Accuse;

@Repository
public class MybatisAccuseDao implements AccuseDao {

	@Autowired
	private AccuseMapper accuseMapper;

	@Override
	public void insertAccuse(Accuse accuse) throws DataAccessException {
		// TODO Auto-generated method stub
		accuseMapper.insertAccuse(accuse);
	}

	@Override
	public int countAccuse(Account account) throws DataAccessException {
		// TODO Auto-generated method stub
		return accuseMapper.countAccuse(account);
	}
}
