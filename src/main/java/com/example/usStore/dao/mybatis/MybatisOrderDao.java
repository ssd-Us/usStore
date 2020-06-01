package com.example.usStore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.usStore.dao.OrderDao;
import com.example.usStore.dao.SequenceDao;
import com.example.usStore.dao.mybatis.mapper.LineItemMapper;
import com.example.usStore.dao.mybatis.mapper.OrderMapper;
import com.example.usStore.domain.LineItem;
import com.example.usStore.domain.Orders;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisOrderDao implements OrderDao {
	
	@Autowired
	protected OrderMapper orderMapper;
	@Autowired
	protected LineItemMapper lineItemMapper;
	@Autowired
	private SequenceDao sequenceDao;

	public List<Orders> getOrdersByUsername(String username) 
			throws DataAccessException {
	    return orderMapper.getOrdersByUsername(username);
	}
	
	@Transactional
	public Orders getOrder(int orderId) throws DataAccessException {
		Orders order = orderMapper.getOrder(orderId);
		if (order != null) {
			order.setLineItems(lineItemMapper.getLineItemsByOrderId(orderId));
		}
	    return order;
	}
	
	@Transactional
	public void insertOrder(Orders order) throws DataAccessException {  
    	order.setOrderId(sequenceDao.getSequence("ordernum"));
    	orderMapper.insertOrder(order);
    	orderMapper.insertOrderStatus(order);
    	for (int i = 0; i < order.getLineItems().size(); i++) {
    		LineItem lineItem = (LineItem) order.getLineItems().get(i);
    		lineItem.setOrderId(order.getOrderId());
    		lineItemMapper.insertLineItem(lineItem);
    	}
	}

	@Override
	public List<Orders> getOrdersByUserId(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
}