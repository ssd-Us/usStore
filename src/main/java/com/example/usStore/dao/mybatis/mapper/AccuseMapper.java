package com.example.usStore.dao.mybatis.mapper;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Account;
import com.example.usStore.domain.Accuse;

public interface AccuseMapper {

	// 신고하기
	void insertAccuse(Accuse accuse) throws DataAccessException;
	
	// 해당 유저 별 신고 당한 횟수 받아오기
	int countAccuse(Account account) throws DataAccessException;
}
