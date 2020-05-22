package com.example.usStore.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.example.usStore.domain.Auction;
import com.example.usStore.domain.Item;

public interface AuctionMapper {
	
	  void updateInventoryQuantity(Map<String, Object> param);

	  int getInventoryQuantity(String itemId);

	  List<Auction> getAuctionItemListByProduct(String productId);

	  Item getAuctionItem(String itemId);
	  
	  boolean isAuctionItemInStock(String itemId);	

}
