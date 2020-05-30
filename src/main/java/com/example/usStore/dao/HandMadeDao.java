package com.example.usStore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.HandMade;

public interface HandMadeDao {

	// 모든 수공예 리스트 가져오는 메소드
	List<HandMade> getHandMadeList() throws DataAccessException;
	
	// itemId 받아서 해당하는 HandMade 객체 반환
	HandMade getHandMadeItem(int itemId) throws DataAccessException;
	
	// ???
	//	boolean isHandMade(int itemId) throws DataAccessException;	
	  
	// insert HandMade
	public void insertHandMade(HandMade handmade) throws DataAccessException;
	  
	// delete HandMade
	public void deleteHandMade(int itemId) throws DataAccessException;
	  
	// update HandMade
	public void updateHandMade(HandMade handmade) throws DataAccessException;
}
