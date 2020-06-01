package com.example.usStore.domain;

import java.util.Date;

@SuppressWarnings("serial")
public class GroupBuying  extends Item {
	private int itemId;
	private int discount;	//�������� ���ΰ� - ������	
	private int listPrice;
	private Date deadLine;
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
	public Date getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	
}
