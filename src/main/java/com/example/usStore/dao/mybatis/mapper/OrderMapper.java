package com.example.usStore.dao.mybatis.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Orders;

/**
 * @author Eduardo Macarron
 */
public interface OrderMapper {

	// 해당 사용자의 주문 목록 가져오기 (userId)
	List<Orders> getOrdersByUserId(String userId);

	// 해당 사용자의 주문 목록 가져오기 (username)
	List<Orders> getOrdersByUsername(String username);

	// orderId 를 매개변수로 받아 해당하는 Order 객체 반환하기
	Orders getOrder(int orderId);

	// Order 추가
	void insertOrder(Orders order);
	
	Orders getOrderAndLineitems(int orderId);
}
