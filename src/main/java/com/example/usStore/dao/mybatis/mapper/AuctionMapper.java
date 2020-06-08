package com.example.usStore.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Auction;
import com.example.usStore.domain.Item;

public interface AuctionMapper extends ItemMapper {
	
	// select Auction
	List<Auction> getAuctionList();

	// itemId 받아와 해당 경매 객체 반환
	Auction getAuctionItem(int itemId);

	// insert Auction
	public void insertAuction(Auction auction);

	// update Auction
	public void updateAuction(Auction auction);

	// 아이템 아이디로 해당 경매 객체 반환
	public Auction getAuctionById(int itemId);
}
