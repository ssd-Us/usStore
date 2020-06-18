package com.example.usStore.dao;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Accuse;

public interface AccuseDao {

	void insertAccuse(Accuse accuse) throws DataAccessException;
	
	int countAccuseById(String accountId) throws DataAccessException;
	
	String isAccuseAlready(String attacker, String victim) throws DataAccessException;
}
