package com.example.usStore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.GroupBuying;
import com.example.usStore.domain.Item;

public interface GroupBuyingDao extends ItemDao {
	
	// 공동구매 추가 메소드
	public void insertGroupBuying(GroupBuying GroupBuying) throws DataAccessException;
	  
	// 공동구매 수정 메소드  
	public void updateGroupBuying(GroupBuying GroupBuying) throws DataAccessException;
	
	// 모든 공동구매 리스트 가져오는 메소드
	List<GroupBuying> getGroupBuyingList() throws DataAccessException;
	
	// itemId를 받아 해당하는 groupBuying 객체를 가져오는 메소드
	GroupBuying getGroupBuyingItem(int itemId) throws DataAccessException;
	
	// 아이템 아이디로 해당 공동구매 객체 가져오는 메소드 
	public void joinGroupBuying(GroupBuying GroupBuying) throws DataAccessException;
	
	// 공동구매 가격 조정 메소드
	public void calculateDiscount(GroupBuying GroupBuying) throws DataAccessException;

}
