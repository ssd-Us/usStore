package com.example.usStore.domain;

import java.io.Serializable;

/*
 * UsStore - Item(SecondHand) Domain Class
 * */
@SuppressWarnings("serial")
public class SecondHand extends Item implements Serializable {

	private int itemId;
	private int discount;
	private int listPrice;
	
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
	
	
}
