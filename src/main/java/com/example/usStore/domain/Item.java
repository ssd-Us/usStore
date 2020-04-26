package com.example.usStore.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Item implements Serializable {
  /* Private Fields */
  private int itemId;			 //(PK) String- > int
  private String supplierId;	 //(FK)
  private String listPrice; 	 //����(����)
  private String unitCost; 		 //�ܰ�(����)
  private String title; 		 //����
  private String description; 	 //����
  private int viewCount; 		 //��ȸ��

  /* JavaBeans Properties */
  public int getItemId() { return itemId; }
  public void setItemId(int itemId) { this.itemId = itemId; }
  
  public String getSupplierId() { return supplierId; }
  public void setSupplierId(String supplierId) { this.supplierId = supplierId; }

  public String getListPrice() { return listPrice; }
  public void setListPrice(String listPrice) { this.listPrice = listPrice; }

  public String getUnitCost() { return unitCost; }
  public void setUnitCost(String unitCost) { this.unitCost = unitCost; }

  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }
  
  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }

  public int getViewCount() { return viewCount; }
  public void setViewCount(int viewCount) { this.viewCount = viewCount; }

  /* Public Methods */
  public String toString() {
    return "��ǰ : " + getItemId() + ", �Ǹ��� : " + getSupplierId().trim();
  }
}
