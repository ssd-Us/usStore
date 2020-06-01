package com.example.usStore.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Auction extends Item implements Serializable {
	/* Private Fields */
	private int itemId;
	private String auctionState;
	private Date deadLine;
	private int startPrice;
	private int bidPrice;
	
	/* JavaBeans Properties */
	public int getItemId() { return itemId; }
	public void setItemId(int itemId) { this.itemId = itemId; }
	
	public String getAuctionState() { return auctionState; }
	public void setAuctionState(String auctionState) { this.auctionState = auctionState; }
	
	public Date getDeadLine() { return deadLine; }
	public void setDeadLine(Date deadLine) { this.deadLine = deadLine; }
	
	public int getStartPrice() { return startPrice; }
	public void setStartPrice(int startPrice) { this.startPrice = startPrice; }
	
	public int getBidPrice() { return bidPrice; }
	public void setBidPrice(int bidPrice) { this.bidPrice = bidPrice; }
	
	
	/* Public Methods */
	public String toString() {
		return "[��ǰ : " + getItemId() + "]";
				//"�Ǹ��� - " + getSupplier() + ", ������ - " + getBidder();
	}
}
