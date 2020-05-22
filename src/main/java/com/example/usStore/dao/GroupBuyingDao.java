package com.example.usStore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.GroupBuying;

public interface GroupBuyingDao {
	
	List<GroupBuying> getGroupBuyingList() throws DataAccessException;
	
	GroupBuying getGroupBuyingItem(int itemId) throws DataAccessException;
	
	public void insertGroupBuying(GroupBuying GroupBuying) throws DataAccessException;
	  
	public void delteGroupBuying(GroupBuying GroupBuying) throws DataAccessException;
	  
	public void updateGroupBuying(GroupBuying GroupBuying) throws DataAccessException;
	
	public void joinGroupBuying(GroupBuying GroupBuying) throws DataAccessException; //공동구매 참여
	
	public void calculateDiscount(GroupBuying GroupBuying) throws DataAccessException;	//할인율 계산
}
