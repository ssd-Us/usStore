package com.example.usStore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Orders;

public interface OrderDao {

  List<Orders> getOrdersByUsername(String username) throws DataAccessException;

  Orders getOrder(int orderId) throws DataAccessException;

  void insertOrder(Orders order) throws DataAccessException;

}
