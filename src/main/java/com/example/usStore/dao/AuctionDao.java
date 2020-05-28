package com.example.usStore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Auction;

public interface AuctionDao {
	// selete Auction
	List<Auction> getAuctionList() throws DataAccessException;

	// insert Auction
	public void insertAuction(Auction auction) throws DataAccessException;

	// delete Auction
	public void deleteAuction(int itemId) throws DataAccessException;

	// update Auction
	public void updateAuction(Auction auction) throws DataAccessException;

	//아이템 아이디로 해당 경매 객체 반환
	public Auction getAuctionById(int itemId) throws DataAccessException;
}
