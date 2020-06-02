
package com.example.usStore.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.example.usStore.domain.Item;

public interface ItemMapper {

	void updateInventoryQuantity(Map<String, Object> param);

	int getInventoryQuantity(int itemId);

	List<Item> getItemListByProduct(int productId);

	Item getItem(int itemId);

	boolean isItemInStock(int itemId);

}
