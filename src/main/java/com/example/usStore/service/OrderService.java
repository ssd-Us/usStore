package com.example.usStore.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.usStore.domain.Orders;

@Service("OrderService") 
public interface OrderService {

	Orders getOrder(int orderId);
	
	public List<Orders> getOrdersByUserId(String userId);

}
