package com.example.usStore.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.example.usStore.domain.Auction;
import com.example.usStore.domain.Item;

public interface AuctionMapper {
	
	  void updateInventoryQuantity(Map<String, Object> param);

	  int getInventoryQuantity(int itemId);

	  List<Auction> getAuctionItemListByProduct(int productId);

	  Item getAuctionItem(int itemId);
	  
	  boolean isAuctionItemInStock(int itemId);	

}
