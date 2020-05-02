package com.example.usStore.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Inventory  implements Serializable {
	/* Private Fields */
	private int itemId;		//(PK) Item 의 기본키
	private int quantity;	//수량
	
	/* JavaBeans Properties */
	public int getItemId() { return itemId; }
	public void setItemId(int itemId) { this.itemId = itemId; }
	
	public int getQuantity() { return quantity; }
	public void setQuantity(int quantity) { this.quantity = quantity; }
	
	/* Public Methods */
	public String toString() {
		return "재고 : " + getItemId() + " - " + getQuantity();
	}
}

