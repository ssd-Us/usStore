package com.example.usStore.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Auction;
import com.example.usStore.domain.Item;

public interface AuctionMapper {
	
		// select Auction
<<<<<<< HEAD
		List<Auction> getAuctionList();
		
		// itemId 받아와 해당 경매 객체 반환
		Auction getAuctionItem(int itemId);
		
		// insert Auction
		public void insertAuction(Auction auction);
		 
		// delete Auction
		public void deleteItem(int itemId);
		  
		// update Auction
		public void updateAuction(Auction auction);
		
		//아이템 아이디로 해당 경매 객체 반환
		public Auction getAuctionById(int itemId);
		
		/* 기존에 ItemDao에 있었던 메소드들 */
		boolean isItemInStock(int itemId, int productId);
		
		void updateQuantity(int qty, int itemId, int productId) ;
		
		int getQuantity(int itemId, int productId) ;
	
		
		// 예전 Mapper에 있었던 것들
=======
		List<Auction> getAuctionList() throws DataAccessException;
		
		// itemId 받아와 해당 경매 객체 반환
		Auction getAuctionItem(int itemId) throws DataAccessException;
		
		// insert Auction
		public void insertAuction(Auction auction) throws DataAccessException;
		 
		// delete Auction
		public void deleteItem(int itemId) throws DataAccessException;
		  
		// update Auction
		public void updateAuction(Auction auction) throws DataAccessException;
		
		//아이템 아이디로 해당 경매 객체 반환
		public Auction getAuctionById(int itemId) throws DataAccessException;
		
		/* 기존에 ItemDao에 있었던 메소드들 */
		boolean isItemInStock(int itemId, int productId) throws DataAccessException;
		
		void updateQuantity(int qty, int itemId, int productId)  throws DataAccessException;
		
		int getQuantity(int itemId, int productId)  throws DataAccessException;
	
		
>>>>>>> branch 'test' of https://github.com/ssd-Us/usStore.git
//		void updateInventoryQuantity(Map<String, Object> param);
//
//		int getInventoryQuantity(int itemId);
//
//		List<Auction> getAuctionItemListByProduct(int productId);
//
//		Item getAuctionItem(int itemId);
//		  
//		boolean isAuctionItemInStock(int itemId);	
}
