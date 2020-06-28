package com.example.usStore.dao.mybatis.mapper;

import java.util.List;

import com.example.usStore.domain.Account;
import com.example.usStore.domain.SecondHand;


public interface SecondHandMapper extends ItemMapper {

	List<SecondHand> getSecondHandList(Account account);

	SecondHand getSecondHandItem(int itemId);
	
	public void insertSecondHand(SecondHand secondHand);
	
	public void updateSecondHand(SecondHand secondHand);
	
	public void deleteSecondHand(int itemId);
	
	
	
}
