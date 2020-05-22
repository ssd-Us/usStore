package com.example.usStore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Item;
import com.example.usStore.domain.SecondHand;


public interface SecondHandDao {
	
	List<SecondHand> getSecondHandList() throws DataAccessException;
	
	SecondHand getSecondHandItem(int itemId) throws DataAccessException;
	
	public void insertSecondHand(SecondHand secondHand) throws DataAccessException;
	  
	public void delteSecondHand(SecondHand secondHand) throws DataAccessException;
	  
	public void updateSecondHand(SecondHand secondHand) throws DataAccessException;
}