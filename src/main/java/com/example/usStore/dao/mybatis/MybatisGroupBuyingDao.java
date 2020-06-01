package com.example.usStore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.usStore.dao.GroupBuyingDao;
import com.example.usStore.dao.mybatis.mapper.GroupBuyingMapper;
import com.example.usStore.domain.GroupBuying;

@Repository
public class MybatisGroupBuyingDao implements GroupBuyingDao{	
	
	@Autowired
	private GroupBuyingMapper groupBuyingMapper;

	@Override
	public List<GroupBuying> getGroupBuyingList() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupBuying getGroupBuyingItem(int itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertGroupBuying(GroupBuying GroupBuying) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void updateGroupBuying(GroupBuying GroupBuying) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void joinGroupBuying(GroupBuying GroupBuying) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calculateDiscount(GroupBuying GroupBuying) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void deleteItem(int itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
