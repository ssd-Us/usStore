package com.example.usStore.domain;

import java.io.Serializable;
import java.util.Date;

/*
 * UsStore - Item(Auction) Domain Class
 * */
@SuppressWarnings("serial")
public class Auction extends Item implements Serializable {
	/* Private Fields */
	private int itemId;
	private int auctionState;
	private String deadLine;			// 경매 마감일
	private int startPrice;			// 경매 시작가
	private int bidPrice;
	
	/* JavaBeans Properties */
	public int getItemId() { return itemId; }
	public void setItemId(int itemId) { this.itemId = itemId; }
	
	public int getAuctionState() { return auctionState; }
	public void setAuctionState(int auctionState) { this.auctionState = auctionState; }
	
	public String getDeadLine() { return deadLine; }
	public void setDeadLine(String deadLine) { this.deadLine = deadLine; }
	
	public int getStartPrice() { return startPrice; }
	public void setStartPrice(int startPrice) { this.startPrice = startPrice; }
	
	public int getBidPrice() { return bidPrice; }
	public void setBidPrice(int bidPrice) { this.bidPrice = bidPrice; }
}
