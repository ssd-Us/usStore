package com.example.usStore.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.usStore.dao.HandMadeDao;
import com.example.usStore.dao.mybatis.mapper.HandMadeMapper;
import com.example.usStore.dao.mybatis.mapper.ItemMapper;
import com.example.usStore.dao.mybatis.mapper.TagMapper;
import com.example.usStore.domain.HandMade;
import com.example.usStore.domain.Item;
import com.example.usStore.domain.Tag;

@Transactional
@Qualifier("mybatisHandMadeDao")
@Repository
public class MybatisHandMadeDao implements HandMadeDao {

	@Autowired
	private HandMadeMapper handMadeMapper;

	@Autowired
	private ItemMapper itemMapper;
	
	@Autowired
	private TagMapper tagMapper;
	
	@Override
	public void updateQuantity(int qty, int itemId, int productId) throws DataAccessException {
		// TODO Auto-generated method stub
		handMadeMapper.updateQuantity(qty, itemId, productId);
	}

	@Override
	public int getQuantity(int itemId, int productId) throws DataAccessException {
		// TODO Auto-generated method stub
		return handMadeMapper.getQuantity(itemId, productId);
	}

	@Override
	public boolean isItemInStock(int itemId, int productId) throws DataAccessException {
		// TODO Auto-generated method stub
		return handMadeMapper.isItemInStock(itemId, productId);
	}

	@Override
	// transaction 구현
	public void insertHandMade(HandMade handMade) throws DataAccessException {
		// TODO Auto-generated method stub
		itemMapper.insertItem(handMade); // auto-boxing
		handMadeMapper.insertHandMade(handMade);
		for(Tag tag : handMade.getTags()) {
			tag.setItemId(handMade.getItemId());
			tagMapper.insertTag(tag);
		}
	}

	@Override
	// transaction 구현
	public void updateHandMade(HandMade handMade) throws DataAccessException {
		// TODO Auto-generated method stub
		itemMapper.updateItem(handMade);
		handMadeMapper.updateHandMade(handMade);
		
		for(Tag tag : handMade.getTags()) {
			tag.setItemId(handMade.getItemId());
			tagMapper.insertTag(tag);
		}
	}

	@Override
	public List<HandMade> getHandMadeList() throws DataAccessException {
		// TODO Auto-generated method stub
		return handMadeMapper.getHandMadeList();
	}

	@Override
	public HandMade getHandMadeById(int itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		return handMadeMapper.getHandMadeById(itemId);
	}

	@Override
	public List<HandMade> getHandMadeListByProductId(int productId) throws DataAccessException {
		// TODO Auto-generated method stub
		return handMadeMapper.getHandMadeListByProductId(productId);
	}

	@Override
	public void insertItem(Item item) {
		// TODO Auto-generated method stub
		handMadeMapper.insertItem(item);
	}

	@Override
	public void updateItem(Item item) {
		// TODO Auto-generated method stub
		handMadeMapper.updateItem(item);
	}

	@Override
	public Item getItem(int itemId) {
		return handMadeMapper.getItem(itemId);
	}

	@Override
	public void deleteItem(int itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		handMadeMapper.deleteItem(itemId);
	}

	@Override
	public String getUserIdByItemId(int itemId) throws DataAccessException {
		return handMadeMapper.getUserIdByItemId(itemId);
	}

	@Override
	public void updateViewCount(int viewCount, int itemId) {
		// TODO Auto-generated method stub
		handMadeMapper.updateViewCount(viewCount, itemId);
	}
}
