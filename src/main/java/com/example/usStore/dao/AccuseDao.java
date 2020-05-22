package com.example.usStore.dao;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Account;
import com.example.usStore.domain.Accuse;

public interface AccuseDao {

	// �Ű��ϱ�
	void insertAccuse(Accuse accuse) throws DataAccessException;
	
	// �ش� ���� �� �Ű� ���� Ƚ�� �޾ƿ���
	int countAccuse(Account account) throws DataAccessException;
}