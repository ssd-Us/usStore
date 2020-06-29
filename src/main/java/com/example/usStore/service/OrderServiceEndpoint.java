package com.example.usStore.service;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.usStore.domain.Orders;

/**
 * @author Chang-Sup Park
 */
@Component
@WebService(serviceName="OrderService") 
public class OrderServiceEndpoint {
	@Autowired
	OrderService orderService;		// inject orderSeviceImpl
	
	@WebMethod
	public Orders getOrder(int orderId) {
		return orderService.getOrder(orderId);
	}

	@WebMethod
	public List<Orders> getOrdersByUsername(String username) {
		return orderService.getOrdersByUsername(username);
	}
}
