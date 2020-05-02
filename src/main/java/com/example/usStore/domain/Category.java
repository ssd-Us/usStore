package com.example.usStore.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Category implements Serializable {

  /* Private Fields */
  private int categoryId; //(PK) String -> int
  private String name;
  private String description;

  /* JavaBeans Properties */
  //String ������ int�� �ٲ�
  public int getCategoryId() { return categoryId; }
  public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }

  
  /* Public Methods */
  public String toString() {
    return "ī�װ� : " + getCategoryId() + " (" + getName() + ")";
  }
}