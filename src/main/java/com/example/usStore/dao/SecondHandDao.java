package com.example.usStore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Account;
import com.example.usStore.domain.SecondHand;


public interface SecondHandDao extends ItemDao {
	
	// ��ü SecondHandList �޾ƿ���
	List<SecondHand> getSecondHandList(Account account) throws DataAccessException;
	
	// itemId �Ű������� �޾� SecondHand ��ü ��ȯ
	SecondHand getSecondHandItem(int itemId) throws DataAccessException;
	
	// SecondHand ����
	public void updateSecondHand(SecondHand secondHand) throws DataAccessException;

	public void insertSecondHand(SecondHand secondHand) throws DataAccessException;

}