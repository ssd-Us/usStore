package com.example.usStore.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.usStore.dao.GroupBuyingDao;
import com.example.usStore.dao.mybatis.mapper.GroupBuyingMapper;
import com.example.usStore.domain.GroupBuying;
import com.example.usStore.domain.Item;

@Repository
public class MybatisGroupBuyingDao implements GroupBuyingDao {	
	
	@Autowired
	private GroupBuyingMapper groupBuyingMapper;

	@Override
	public void updateInventoryQuantity(Map<String, Object> param) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getInventoryQuantity(int itemId, int productId) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateQuantity(int qty, int itemId, int productId) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getQuantity(int itemId, int productId) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isItemInStock(int itemId, int productId) throws DataAccessException {
		// TODO Auto-generated method stub
		return false;
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
	public void joinGroupBuying(GroupBuying GroupBuying) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calculateDiscount(GroupBuying GroupBuying) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteItem(int itemId, int productId) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}
}
