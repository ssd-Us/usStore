package com.example.usStore.dao.mybatis;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.usStore.dao.AccountDao;
import com.example.usStore.dao.mybatis.mapper.AccountMapper;
import com.example.usStore.domain.Account;

@Repository
public class MybatisAccountDao implements AccountDao {

	@Autowired
	private AccountMapper accountMapper;
	
	public Account getAccountByUsername(String username) throws DataAccessException {
		return accountMapper.getAccountByUsername(username);
	}

	public Account getAccountByUsernameAndPassword(String username, String password) 
			throws DataAccessException {
		return accountMapper.getAccountByUsernameAndPassword(username, password);
	}

	public void insertAccount(Account account) throws DataAccessException {
		accountMapper.insertAccount(account);
	}

	public void updateAccount(Account account) throws DataAccessException {
		accountMapper.updateAccount(account);
		if (account.getPassword() != null && account.getPassword().length() > 0) 
		{
			accountMapper.updateAccount(account);
		}
	}
	
	
}