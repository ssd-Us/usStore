package com.example.usStore.dao.mybatis;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.usStore.dao.AccountDao;
import com.example.usStore.dao.AccuseDao;
import com.example.usStore.domain.Account;
import com.example.usStore.domain.Accuse;

@Repository
public class MybatisAccuseDao implements AccuseDao {

	@Override
	public void insertAccuse(Accuse accuse) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countAccuse(Account account) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

}
