package com.example.usStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usStore.dao.OrderDao;
import com.example.usStore.domain.Orders;

/**
 * @author Chang-Sup Park
 */
@Service("orderServiceImpl")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	public Orders getOrder(int orderId) {
		return orderDao.getOrder(orderId);
	}

	public List<Orders> getOrdersByUsername(String username) {
		return orderDao.getOrdersByUsername(username);
	}
}
