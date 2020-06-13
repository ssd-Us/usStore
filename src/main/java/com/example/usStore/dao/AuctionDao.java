package com.example.usStore.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Auction;

public interface AuctionDao extends ItemDao {

	// select Auction
	List<Auction> getAuctionList() throws DataAccessException;

	// itemId 諛쏆븘�� �빐�떦 寃쎈ℓ 媛앹껜 諛섑솚
	Auction getAuctionItem(int itemId) throws DataAccessException;

	// insert Auction
	public void insertAuction(Auction auction) throws DataAccessException;

	// update Auction
	public void updateAuction(Auction auction) throws DataAccessException;
	
	// 아이템 삭제 메소드
	public void deleteItem(int itemId) throws DataAccessException;

	// �븘�씠�뀥 �븘�씠�뵒濡� �빐�떦 寃쎈ℓ 媛앹껜 諛섑솚
	public Auction getAuctionById(int itemId) throws DataAccessException;
}
