package com.example.usStore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Auction;

public interface AuctionDao extends ItemDao {
	
	// select Auction
	List<Auction> getAuctionList() throws DataAccessException;
	
	// itemId 받아와 해당 경매 객체 반환
	Auction getAuctionItem(int itemId) throws DataAccessException;
	
	// insert Auction
	public void insertAuction(Auction auction) throws DataAccessException;
	 	  
	// update Auction
	public void updateAuction(Auction auction) throws DataAccessException;
	
	//아이템 아이디로 해당 경매 객체 반환
	public Auction getAuctionById(int itemId) throws DataAccessException;
	
	/* 기존에 ItemDao에 있었던 메소드들 */
	boolean isItemInStock(int itemId, int productId) throws DataAccessException;
	
	void updateQuantity(int qty, int itemId, int productId)  throws DataAccessException;
	
	int getQuantity(int itemId, int productId)  throws DataAccessException;
}
