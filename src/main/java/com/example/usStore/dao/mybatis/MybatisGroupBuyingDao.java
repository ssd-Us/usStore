package com.example.usStore.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.usStore.dao.GroupBuyingDao;
import com.example.usStore.dao.mybatis.mapper.GroupBuyingMapper;
import com.example.usStore.dao.mybatis.mapper.ItemMapper;
import com.example.usStore.dao.mybatis.mapper.TagMapper;
import com.example.usStore.domain.GroupBuying;
import com.example.usStore.domain.Item;
import com.example.usStore.domain.Tag;

@Transactional
@Qualifier("mybatisGroupBuyingDao")
@Repository
public class MybatisGroupBuyingDao implements GroupBuyingDao {	
	
	@Autowired
	private GroupBuyingMapper groupBuyingMapper;
	
	@Autowired
	private ItemMapper itemMapper;
	
	@Autowired
	private TagMapper tagMapper;

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
	public void deleteItem(int itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		groupBuyingMapper.deleteItem(itemId);
	}

	@Override
	public void insertGroupBuying(GroupBuying GroupBuying) throws DataAccessException {
		// TODO Auto-generated method stub
		groupBuyingMapper.insertGroupBuying(GroupBuying);
	}

//	@Override
//	public void updateGroupBuying(GroupBuying GroupBuying) throws DataAccessException {
//		// TODO Auto-generated method stub
//		groupBuyingMapper.updateGroupBuying(GroupBuying);
//	}

	@Override
	public void updateGroupBuying(GroupBuying groupBuying) {
		// TODO Auto-generated method stub
		System.out.println("updateGroupBuying mapper 시작");
		itemMapper.updateItem((Item)groupBuying);
		groupBuyingMapper.updateGroupBuying(groupBuying);
		
		for(Tag t : groupBuying.getTags()) {
			tagMapper.insertTag(t);
		}
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
	public Item getItem(int itemId) {
		return groupBuyingMapper.getItem(itemId);
	}

	@Override
	public String getUserIdByItemId(int itemId) throws DataAccessException {
		return groupBuyingMapper.getUserIdByItemId(itemId);
	}

	@Override
	public void updateViewCount(int viewCount, int itemId) {
		// TODO Auto-generated method stub
		groupBuyingMapper.updateViewCount(viewCount, itemId);
	}

	

}
