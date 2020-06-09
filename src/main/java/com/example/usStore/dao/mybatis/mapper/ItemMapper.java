
package com.example.usStore.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Item;

public interface ItemMapper {

	void updateInventoryQuantity(Map<String, Object> param);

	int getInventoryQuantity(int itemId, int productId);

	// 위에 두개랑 차이를 모르겠음. 일단 둘다 살림.
	// 구매 개수 수정
	void updateQuantity(int qty, int itemId, int productId);
	
	int getQuantity(int itemId, int productId);

	boolean isItemInStock(int itemId, int productId);

	void deleteItem(int itemId, int productId);
}

