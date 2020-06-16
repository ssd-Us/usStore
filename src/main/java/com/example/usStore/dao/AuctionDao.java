package com.example.usStore.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Auction;
import com.example.usStore.domain.Bidder;

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
	
	//경매 종료 (scheduler)
	public void closeAuction(Date curTime);

	//경매 최대 가격 변경
	public void updateAuctionUnitCost(int unitCost, int itemId);
	
	//경매 낙찰자 수정
	public void updateBidder(String bidder, int itemId);
	
	//낙찰자 테이블 삽입
	public void insertBidder(Bidder bidder);
	
	//해당 아이템이 낙찰자 테이블에 존재하는지
	public String isBidderExist(int itemId);
}
