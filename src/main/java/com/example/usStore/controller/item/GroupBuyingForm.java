package com.example.usStore.controller.item;

import java.util.Date;

public class GroupBuyingForm {
	/* Private Fields */
	private int itemId;
	private int discount;	//calculate at controller
	private int listPrice;
	private String date;
	private String time;
	private String deadLine;
	  
	  /* JavaBeans Properties */
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

	@Override
	public String toString() {
		return "GroupBuyingForm [itemId=" + itemId + ", discount=" + discount + ", listPrice=" + listPrice
				+ ", deadLine=" + deadLine + "]";
	}

}

