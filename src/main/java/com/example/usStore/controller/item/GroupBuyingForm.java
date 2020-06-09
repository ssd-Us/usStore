package com.example.usStore.controller.item;

import java.util.Date;

public class GroupBuyingForm {
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
	  private int discount;
	  private int listPrice;
	  private Date deadLine;
	  
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
		
	  public Date getDeadLine() {
		  return deadLine;
	  }
	  
	  public void setDeadLine(Date deadLine) {
		  this.deadLine = deadLine;
	  }

	@Override
	public String toString() {
		return "GroupBuyingForm [itemId=" + itemId + ", supplierId=" + supplierId + ", unitCost=" + unitCost
				+ ", title=" + title + ", description=" + description + ", viewCount=" + viewCount + ", tagId=" + tagId
				+ ", quantity=" + quantity + ", userId=" + userId + ", productId=" + productId + ", discount="
				+ discount + ", listPrice=" + listPrice + ", deadLine=" + deadLine + "]";
	} 
	  
}
