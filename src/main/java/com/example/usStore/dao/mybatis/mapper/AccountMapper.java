package com.example.usStore.dao.mybatis.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Account;

public interface AccountMapper {

	// userId로 Account 가져오기
	Account getAccountByUsername(String userId);
	
	// userId랑 password로 Account 가져오기
	Account getAccountByUsernameAndPassword(String username, String password);
	
	// 계정 추가
	void insertAccount(Account account);
	
	// 계정 수정
	void updateAccount(Account account);
}
