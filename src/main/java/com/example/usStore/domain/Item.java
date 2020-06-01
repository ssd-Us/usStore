package com.example.usStore.domain;

import java.io.Serializable;

/*
 * Item Domain Class
 * */
@SuppressWarnings("serial")
public class Item implements Serializable {
  /* Private Fields */
  private int itemId;			//(PK) String- > int
  private String suppId;	 	//(FK) userId
  private int unitCost;			// 정가
  private String title;			// 제목
  private String description;	// 설명
  private int viewCount; 		// 조회수
  private int qty;			 	// 재고
  private int productId;      	//(FK) productId
  
  /* JavaBeans Properties */
  public int getItemId() {
	return itemId;
  }

  public void setItemId(int itemId) {
	this.itemId = itemId;
  }

  public String getsuppId() {
	return suppId;
  }

  public void setsuppId(String suppId) {
	this.suppId = suppId;
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

  public int getqty() {
	return qty;
  }

  public void setqty(int qty) {
	this.qty = qty;
  }
  
  public int getProductId() {
	return productId;
  }

  public void setProductId(int productId) {
	this.productId = productId;
  }
  
 
  /* Public Methods */
  public String toString() {
    return "��ǰ : " + getItemId() + ", �Ǹ��� : " + getsuppId().trim();
  }

}
