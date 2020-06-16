package com.example.usStore.domain;

@SuppressWarnings("serial")
public class Bidder {
	/* Private Fields */
	private int itemId;
	private String bidder;
		
	/* JavaBeans Properties */
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getBidder() {
		return bidder;
	}
	public void setBidder(String bidder) {
		this.bidder = bidder;
	}
}
