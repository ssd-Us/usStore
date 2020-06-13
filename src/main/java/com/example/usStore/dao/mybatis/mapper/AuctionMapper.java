package com.example.usStore.dao.mybatis.mapper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Auction;
import com.example.usStore.domain.Item;

public interface AuctionMapper extends ItemMapper {
	
	// select Auction
	List<Auction> getAuctionList();

	// itemId 諛쏆븘�� �빐�떦 寃쎈ℓ 媛앹껜 諛섑솚
	Auction getAuctionItem(int itemId);

	// insert Auction
	public void insertAuction(Auction auction);

	// update Auction
	public void updateAuction(Auction auction);

	// �븘�씠�뀥 �븘�씠�뵒濡� �빐�떦 寃쎈ℓ 媛앹껜 諛섑솚
	public Auction getAuctionById(int itemId);
	
	public void insertNewEvent(HashMap<String, Date> map);
	
	public void closeEvent(Date curTime);
}
