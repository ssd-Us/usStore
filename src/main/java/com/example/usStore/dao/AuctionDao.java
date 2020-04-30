package com.example.usStore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Auction;
import com.example.usStore.domain.Item;

public interface AuctionDao {
	List<Auction> getAuctionList() throws DataAccessException;
	
	public void insertAuction(Auction auction) throws DataAccessException;
	  
	public void delteAuction(Auction auction) throws DataAccessException;
	  
	public void updateAuction(Auction auction) throws DataAccessException;
}
