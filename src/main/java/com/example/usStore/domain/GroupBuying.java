package com.example.usStore.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/*
 * UsStore - Item(GroupBuying) Domain Class
 * */
@SuppressWarnings("serial")
public class GroupBuying extends Item implements Serializable {
	
	// Field
	private int itemId;
	private int discount;
	private int listPrice;
	private String deadLine;
	
	// Getter & Setter
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
	public String getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
	}
}
