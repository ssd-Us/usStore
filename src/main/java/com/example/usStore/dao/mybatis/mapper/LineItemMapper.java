package com.example.usStore.dao.mybatis.mapper;

import java.util.List;

import com.example.usStore.domain.LineItem;

public interface LineItemMapper {

	List<LineItem> getLineItemsByOrderId(int orderId);

	void insertLineItem(LineItem lineItem);

}