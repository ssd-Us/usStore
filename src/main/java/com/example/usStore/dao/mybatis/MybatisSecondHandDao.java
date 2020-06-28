package com.example.usStore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.usStore.dao.SecondHandDao;
import com.example.usStore.dao.mybatis.mapper.ItemMapper;
import com.example.usStore.dao.mybatis.mapper.SecondHandMapper;
import com.example.usStore.dao.mybatis.mapper.TagMapper;
import com.example.usStore.domain.Item;
import com.example.usStore.domain.SecondHand;
import com.example.usStore.domain.Tag;

@Primary
@Qualifier("mybatisSecondHandDao")
@Repository
@Transactional
public class MybatisSecondHandDao implements SecondHandDao {

	@Autowired
	private SecondHandMapper secondHandMapper;
	
	@Autowired
	private ItemMapper itemMapper;
	
	@Autowired
	private TagMapper tagMapper;
	
	@Override
	public void insertSecondHand(SecondHand secondHand) throws DataAccessException {
		itemMapper.insertItem(secondHand);
		secondHandMapper.insertSecondHand(secondHand); //새컨핸드랑 아이템 디비 테일 두개 모두 삽입 
		for(Tag t : secondHand.getTags()) {
			t.setItemId(secondHand.getItemId()); 
			tagMapper.insertTag(t);
		}
	}
	
	@Override
	public void updateQuantity(int qty, int itemId, int productId) throws DataAccessException {
		secondHandMapper.updateQuantity(qty, itemId, productId);
	}
	
	@Override
	public int getQuantity(int itemId, int productId) throws DataAccessException {
		return secondHandMapper.getQuantity(itemId, productId);
	}
	
	@Override
	public boolean isItemInStock(int itemId, int productId) throws DataAccessException {
		return secondHandMapper.isItemInStock(itemId, productId);
	}
	
	@Override
	public void deleteItem(int itemId) throws DataAccessException {
		secondHandMapper.deleteItem(itemId);
	}
	

	@Override
	public List<SecondHand> getSecondHandList(String university) throws DataAccessException {
		return secondHandMapper.getSecondHandList(university);
	}
	
	@Override
	public void updateSecondHand(SecondHand secondHand) throws DataAccessException {
		itemMapper.updateItem(secondHand);
		secondHandMapper.updateSecondHand(secondHand);
		for(Tag t : secondHand.getTags()) {
			t.setItemId(secondHand.getItemId());
			tagMapper.insertTag(t);
		}
	}

	@Override
	public SecondHand getSecondHandItem(int itemId) throws DataAccessException {
		return secondHandMapper.getSecondHandItem(itemId);
	}
	
	@Override
	public String getUserIdByItemId(int itemId) throws DataAccessException {
		return secondHandMapper.getUserIdByItemId(itemId);
	}

	@Override
	public void insertItem(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateItem(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Item getItem(int itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateViewCount(int viewCount, int itemId) {
		secondHandMapper.updateViewCount(viewCount, itemId);
	}


	

}