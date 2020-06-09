package com.example.usStore.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.usStore.dao.GroupBuyingDao;
import com.example.usStore.dao.mybatis.mapper.GroupBuyingMapper;
import com.example.usStore.domain.GroupBuying;
import com.example.usStore.domain.Item;

@Qualifier("mybatisGroupBuyingDao")
@Repository
public class MybatisGroupBuyingDao implements GroupBuyingDao {	
	
	@Autowired
	private GroupBuyingMapper groupBuyingMapper;

	@Override
	public void updateQuantity(int qty, int itemId, int productId) throws DataAccessException {
		// TODO Auto-generated method stub
		groupBuyingMapper.updateQuantity(qty, itemId, productId);
	}

	@Override
	public int getQuantity(int itemId, int productId) throws DataAccessException {
		// TODO Auto-generated method stub
		return groupBuyingMapper.getQuantity(itemId, productId);
	}

	@Override
	public boolean isItemInStock(int itemId, int productId) throws DataAccessException {
		// TODO Auto-generated method stub
		return groupBuyingMapper.isItemInStock(itemId, productId);
	}

	@Override
	public void deleteItem(int itemId, int productId) throws DataAccessException {
		// TODO Auto-generated method stub
		groupBuyingMapper.deleteItem(itemId, productId);
	}

	@Override
	public void insertGroupBuying(GroupBuying GroupBuying) throws DataAccessException {
		// TODO Auto-generated method stub
		groupBuyingMapper.insertGroupBuying(GroupBuying);
	}

	@Override
	public void updateGroupBuying(GroupBuying GroupBuying) throws DataAccessException {
		// TODO Auto-generated method stub
		groupBuyingMapper.updateGroupBuying(GroupBuying);
	}

	@Override
	public List<GroupBuying> getGroupBuyingList() throws DataAccessException {
		// TODO Auto-generated method stub
		return groupBuyingMapper.getGroupBuyingList();
	}

	@Override
	public GroupBuying getGroupBuyingItem(int itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		return groupBuyingMapper.getGroupBuyingItem(itemId);
	}

	@Override
	public void joinGroupBuying(GroupBuying GroupBuying) throws DataAccessException {
		// TODO Auto-generated method stub
		groupBuyingMapper.joinGroupBuying(GroupBuying);
	}

	@Override
	public void calculateDiscount(GroupBuying GroupBuying) throws DataAccessException {
		// TODO Auto-generated method stub
		groupBuyingMapper.calculateDiscount(GroupBuying);
	}

	@Override
	public void insertItem(Item item) {
		// TODO Auto-generated method stub
		groupBuyingMapper.insertItem(item);
	}

	@Override
	public void updateItem(Item item) {
		// TODO Auto-generated method stub
		groupBuyingMapper.updateItem(item);
	}

	@Override
	public void getItem(int itemId, int productId) {
		// TODO Auto-generated method stub
		groupBuyingMapper.getItem(itemId, productId);
	}

}
