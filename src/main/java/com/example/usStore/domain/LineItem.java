package com.example.usStore.domain;

import java.io.Serializable;

/*
 * UsStore - LineItem Domain Class
 * */
@SuppressWarnings("serial")
public class LineItem implements Serializable {

  /* Private Fields */
  private int orderId;
  private int lineNum;
  private int itemId;
  private int quantity;

  /* Constructors */

  public LineItem() {}

  public LineItem(int lineNum, CartItem cartItem) {
    this.orderId = cartItem.getOrderId();
	this.lineNum = lineNum;
    this.itemId = cartItem.getItem().getItemId();
    this.quantity = cartItem.getQuantity();
  }

  /* JavaBeans Properties */

	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public int getLineNum() {
		return lineNum;
	}
	
	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}
	
	public int getItemId() {
		return itemId;
	}
	
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

  
}
