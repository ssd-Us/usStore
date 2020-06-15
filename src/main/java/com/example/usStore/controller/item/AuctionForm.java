package com.example.usStore.controller.item;

import java.util.Date;
import java.util.List;

import com.example.usStore.domain.Auction;
import com.example.usStore.domain.Tag;

public class AuctionForm {
	/* Private Fields */
	private int itemId;
	private int startPrice;
	private String date;
	private String time;
	private String deadLine;
	
	public AuctionForm(int itemId, int startPrice, String date, String time, String deadLine) {
		super();
		this.itemId = itemId;
		this.startPrice = startPrice;
		this.date = date;
		this.time = time;
		this.deadLine = deadLine;
	}

	/*getter setter*/
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
		
	public int getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(int startPrice) {
		this.startPrice = startPrice;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public String getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
	}
}
