package com.example.usStore.domain;

import java.io.Serializable;

/*
 * Item Domain Class
 * */
@SuppressWarnings("serial")
public class Item implements Serializable {
  /* Private Fields */
  private int itemId;			 //(PK) String- > int
  private String supplierId;	 //(FK) �Ǹ��� ���̵�
  private int unitCost; 		 //�ܰ�(����)
  private String title; 		 //����
  private String description; 	 //����
  private int viewCount; 		 //��ȸ��
  private int tagId;	 		 //(FK) �±׾��̵� 
  private int quantity;			 //���
  private String userId;		 //(FK) ������ ���̵�
  private int productId;      	 //(FK) ��������/�߰�ŷ�/���/�������Ǹ� ����  
  
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
    return "��ǰ : " + getItemId() + ", �Ǹ��� : " + getSupplierId().trim();
  }

}
