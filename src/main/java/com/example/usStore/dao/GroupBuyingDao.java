package com.example.usStore.dao;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.GroupBuying;

public interface GroupBuyingDao {
	
	public void insertGroupBuying(GroupBuying GroupBuying) throws DataAccessException;
	  
	public void delteGroupBuying(GroupBuying GroupBuying) throws DataAccessException;
	  
	public void updateGroupBuying(GroupBuying GroupBuying) throws DataAccessException;
	
	public void joinGroupBuying(GroupBuying GroupBuying) throws DataAccessException; //�������� ����
	
	public void calculateDiscount(GroupBuying GroupBuying) throws DataAccessException;	//������ ���
}
