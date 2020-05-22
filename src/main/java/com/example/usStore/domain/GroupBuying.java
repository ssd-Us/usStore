package com.example.usStore.domain;

import java.util.Date;

@SuppressWarnings("serial")
public class GroupBuying  extends Item {
	private int itemId;
	private int discount;	//공동구매 할인가 - 시퀀스	
	private int listPrice;
	private Date time;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getListPrice() {
		return listPrice;
	}
	public void setListPrice(int listPrice) {
		this.listPrice = listPrice;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}

	
}
