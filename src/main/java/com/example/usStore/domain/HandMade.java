package com.example.usStore.domain;

import java.io.Serializable;

/*
 * UsStore - Item(HandMade) Domain Class
 * */
@SuppressWarnings("serial")
public class HandMade extends Item implements Serializable {

	// Field
	private int itemId;
	private int listPrice;
	
	// Getter & Setter
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getListPrice() {
		return listPrice;
	}
	public void setListPrice(int listPrice) {
		this.listPrice = listPrice;
	}
	
	
}
