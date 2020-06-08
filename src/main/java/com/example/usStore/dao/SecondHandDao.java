package com.example.usStore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.SecondHand;


public interface SecondHandDao extends ItemDao {
	
	// 전체 SecondHandList 받아오기
	List<SecondHand> getSecondHandList() throws DataAccessException;
	
	// itemId 매개변수로 받아 SecondHand 객체 반환
	SecondHand getSecondHandItem(int itemId) throws DataAccessException;
	
	// SecondHand 추가
	public void insertSecondHand(SecondHand secondHand) throws DataAccessException;
	  
	// SecondHand 수정
	public void updateSecondHand(SecondHand secondHand) throws DataAccessException;
}