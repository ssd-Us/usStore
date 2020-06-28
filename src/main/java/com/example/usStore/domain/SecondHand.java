package com.example.usStore.domain;

import java.io.Serializable;

/*
 * UsStore - Item(SecondHand) Domain Class
 * */
@SuppressWarnings("serial")
public class SecondHand extends Item implements Serializable {

	private int itemId; //FK 
	private int discount;
	private int listPrice;
	private String university;
		
	public SecondHand() {
		super();
	}
	
	public SecondHand(Item item, int discount, int listPrice, String university) {
	      super(item.getItemId(), item.getUnitCost(), item.getTitle(), item.getDescription(), item.getViewCount(), item.getQty(), item.getTags(), 
	            item.getUserId(), item.getProductId());
	      this.itemId = item.getItemId();
	      this.discount = discount;
	      this.listPrice = listPrice;
	      this.university = university;
	   }
	
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

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	@Override
	public String toString() {
		return "SecondHand [itemId=" + itemId + ", discount=" + discount + ", listPrice=" + listPrice + ", university="
				+ university + "]";
	}

	
	
}
