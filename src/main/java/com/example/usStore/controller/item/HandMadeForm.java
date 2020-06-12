package com.example.usStore.controller.item;

import java.io.Serializable;

@SuppressWarnings("serial")
public class HandMadeForm implements Serializable  {

	/* Private Fields */
	private int itemId; // (PK) String- > int
	private int unitCost;
	private String title;
	private String description;
	private int viewCount;
	private int qty;
	private String userId; // (FK)
	private int productId; // (FK)

	private int listPrice;
	
	/* JavaBeans Properties */
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(int unitCost) {
		this.unitCost = unitCost;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getListPrice() {
		return listPrice;
	}
	public void setListPrice(int listPrice) {
		this.listPrice = listPrice;
	}
	
	/* Public Methods */
	public String toString() {
		return "HandMadeForm [itemId=" + itemId + ", unitCost=" + unitCost
				+ ", title=" + title + ", description=" + description + ", viewCount=" + viewCount
				+ ", quantity=" + qty + ", userId=" + userId + ", productId=" + productId + ", listPrice=" + listPrice + "]";
	}
}
