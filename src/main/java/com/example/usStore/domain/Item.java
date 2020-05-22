package com.example.usStore.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Item implements Serializable {
  /* Private Fields */
  private int itemId;			 //(PK) String- > int
  private String supplierId;	 //(FK) 판매자 아이디
  private int unitCost; 		 //단가(세일)
  private String title; 		 //제목
  private String description; 	 //내용
  private int viewCount; 		 //조회수
  private int tagId;	 		 //(FK) 태그아이디 
  private int quantity;			 //재고
  private String userId;		 //(FK) 구매자 아이디
  private int productId;      	 //(FK) 공동구매/중고거래/경매/수공예판매 구분  
  
  /* JavaBeans Properties */
  public int getItemId() {
	return itemId;
  }

  public void setItemId(int itemId) {
	this.itemId = itemId;
  }

  public String getSupplierId() {
	return supplierId;
  }

  public void setSupplierId(String supplierId) {
	this.supplierId = supplierId;
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

  public int getTagId() {
	return tagId;
  }

  public void setTagId(int tagId) {
	this.tagId = tagId;
  }

  public int getQuantity() {
	return quantity;
  }

  public void setQuantity(int quantity) {
	this.quantity = quantity;
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
  
 
  /* Public Methods */
  public String toString() {
    return "제품 : " + getItemId() + ", 판매자 : " + getSupplierId().trim();
  }

}
