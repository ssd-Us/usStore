package com.example.usStore.controller.item;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class GroupBuyingForm {
	/* Private Fields */
	private int itemId;
	private int discount;	//calculate at controller
	private int listPrice;
	private Date deadLine;
	  
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
		
	  public Date getDeadLine() {
		  return deadLine;
	  }
	  
	  public void setDeadLine(Date deadLine) {
		  this.deadLine = deadLine;
	  }

	@Override
	public String toString() {
		return "GroupBuyingForm [itemId=" + itemId + ", discount=" + discount + ", listPrice=" + listPrice
				+ ", deadLine=" + deadLine + "]";
	}

}
