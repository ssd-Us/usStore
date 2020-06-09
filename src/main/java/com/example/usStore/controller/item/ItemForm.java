package com.example.usStore.controller.item;

public class ItemForm {
	/* Private Fields */
	  private int itemId;			 //(PK) String- > int
	  private int unitCost; 		 //�ܰ�(����)
	  private String title; 		 //����
	  private String description; 	 //����
	  private int viewCount; 		 //��ȸ��
	  private int qty;			 //���
	  private String userId;		 //(FK) ������ ���̵�
	  private int productId;      	 //(FK) ��������/�߰�ŷ�/���/�������Ǹ� ����  
	  
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

	@Override
	public String toString() {
		return "ItemForm [itemId=" + itemId + ", unitCost=" + unitCost + ", title="
				+ title + ", description=" + description + ", viewCount=" + viewCount 
				+ ", qty=" + qty + ", userId=" + userId + ", productId=" + productId + "]";
	}
	  
	  
}
