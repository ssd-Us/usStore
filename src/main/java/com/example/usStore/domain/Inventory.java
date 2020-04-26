package com.example.usStore.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Inventory  implements Serializable {
	/* Private Fields */
	private int itemId;		//(PK) Item �� �⺻Ű
	private int quantity;	//����
	
	/* JavaBeans Properties */
	public int getItemId() { return itemId; }
	public void setItemId(int itemId) { this.itemId = itemId; }
	
	public int getQuantity() { return quantity; }
	public void setQuantity(int quantity) { this.quantity = quantity; }
	
	/* Public Methods */
	public String toString() {
		return "��� : " + getItemId() + " - " + getQuantity();
	}
}

