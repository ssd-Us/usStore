package com.example.usStore.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.usStore.dao.ItemDao;
import com.example.usStore.dao.mybatis.mapper.ItemMapper;
import com.example.usStore.domain.Item;
import com.example.usStore.domain.LineItem;
import com.example.usStore.domain.Order;

@Repository
public class MybatisItemDao implements ItemDao {
	@Autowired
	private ItemMapper itemMapper;
	
	public void updateQuantity(Order order) throws DataAccessException {
		for (int i = 0; i < order.getLineItems().size(); i++) {
			LineItem lineItem = (LineItem) order.getLineItems().get(i);
			int itemId = lineItem.getItemId();
			Integer increment = new Integer(lineItem.getQuantity());
			Map<String, Object> param = new HashMap<String, Object>(2);
			param.put("itemId", itemId);
			param.put("increment", increment);
			itemMapper.updateInventoryQuantity(param);
		}
	}

	public boolean isItemInStock(String itemId) throws DataAccessException {
		return (itemMapper.getInventoryQuantity(itemId) > 0);
	}

	public List<Item> getItemListByProduct(String productId) 
			throws DataAccessException {
		return itemMapper.getItemListByProduct(productId);
	}

	public Item getItem(String itemId) throws DataAccessException {
		return itemMapper.getItem(itemId);
	}

	@Override
	public void insertItem(Item item) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delteItem(Item item) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateItem(Item item) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemInStock(int itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Item> getItemList() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item getItem(int itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
}
