package com.example.usStore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.HandMade;

public interface HandMadeDao {

	List<HandMade> getHandMadeList() throws DataAccessException;
	
	HandMade getHandMadeItem(int itemId) throws DataAccessException;
	
	boolean isHandMade(int itemId) throws DataAccessException;	
	  
	public void insertHandMade(HandMade handmade) throws DataAccessException;
	  
	public void delteHandMade(HandMade handmade) throws DataAccessException;
	  
	public void updateHandMade(HandMade handmade) throws DataAccessException;
}
