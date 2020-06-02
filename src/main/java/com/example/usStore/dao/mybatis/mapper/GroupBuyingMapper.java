package com.example.usStore.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.GroupBuying;
import com.example.usStore.domain.Item;

public interface GroupBuyingMapper {
//	void updateGroupBuyingQuantity(Map<String, Object> param);
//
//	int getGroupBuyingQuantity(int itemId);
//
//	List<GroupBuying> getGroupBuyingItemListByProduct(int productId);
//
//	Item getGroupBuyingItem(int itemId);
//
//	boolean isGroupBuyingItemInStock(int itemId);

	// 공동구매 추가 메소드
	public void insertGroupBuying(GroupBuying GroupBuying);

	// 공동구매 삭제 메소드
	public void deleteItem(int itemId);

	// 공동구매 수정 메소드
	public void updateGroupBuying(GroupBuying GroupBuying);

	// 모든 공동구매 리스트 가져오는 메소드
	List<GroupBuying> getGroupBuyingList();

	// itemId를 받아 해당하는 groupBuying 객체를 가져오는 메소드
	GroupBuying getGroupBuyingItem(int itemId);

	// 아이템 아이디로 해당 공동구매 객체 가져오는 메소드
	public void joinGroupBuying(GroupBuying GroupBuying);

	// 공동구매 가격 조정 메소드
	public void calculateDiscount(GroupBuying GroupBuying);

	/* 기존에 ItemDao에 있었던 메소드들 */
	boolean isItemInStock(int itemId, int productId);

	void updateQuantity(int qty, int itemId, int productId);

	int getQuantity(int itemId, int productId);

}
