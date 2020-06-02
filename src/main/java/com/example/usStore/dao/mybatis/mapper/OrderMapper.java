/*
 *    Copyright 2010-2013 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.example.usStore.dao.mybatis.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Orders;

/**
 * @author Eduardo Macarron
 */
public interface OrderMapper {

//	List<Orders> getOrdersByUsername(String username);
//
//	Orders getOrder(int orderId);
//
//	void insertOrder(Orders order);
//
//	void insertOrderStatus(Orders order);
//
//	int msSqlServerInsertOrder(Orders order);

	// 해당 사용자의 주문 목록 가져오기 (userId)
	List<Orders> getOrdersByUserId(String userId);

	// 해당 사용자의 주문 목록 가져오기 (username)
	List<Orders> getOrdersByUsername(String username);

	// orderId 를 매개변수로 받아 해당하는 Order 객체 반환하기
	Orders getOrder(int orderId);

	// Order 추가
	void insertOrder(Orders order);
}
