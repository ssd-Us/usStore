package com.example.usStore.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Auction implements Serializable {
	/* Private Fields */
	private int itemId;
	private String title;
	private String description;
	private String auctionState;
	private Date time;
	private String supplier;
	private String bidder;
	private int startPrice;
	private int bidPrice;
	
	/* JavaBeans Properties */
	public int getItemId() { return itemId; }
	public void setItemId(int itemId) { this.itemId = itemId; }
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
	public String getAuctionState() { return auctionState; }
	public void setAuctionState(String auctionState) { this.auctionState = auctionState; }
	
	public Date getTime() { return time; }
	public void setTime(Date time) { this.time = time; }
	
	public String getSupplier() { return supplier; }
	public void setSupplier(String supplier) { this.supplier = supplier; }
	
	public String getBidder() { return bidder; }
	public void setBidder(String bidder) { this.bidder = bidder; }
	
	public int getStartPrice() { return startPrice; }
	public void setStartPrice(int startPrice) { this.startPrice = startPrice; }
	
	public int getBidPrice() { return bidPrice; }
	public void setBidPrice(int bidPrice) { this.bidPrice = bidPrice; }
	
	
	/* Public Methods */
	public String toString() {
		return "[»óÇ° : " + getItemId() + "] ÆÇ¸ÅÀÚ - " + getSupplier() + ", ³«ÂûÀÚ - " + getBidder();
	}
}
