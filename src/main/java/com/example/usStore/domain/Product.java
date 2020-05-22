package com.example.usStore.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable {

  /* Private Fields */

  private String productId;
  private String name;
  private String categoryId;

  /* JavaBeans Properties */

  public String getProductId() { return productId; }
  public void setProductId(String productId) { this.productId = productId.trim(); }

  public String getCategoryId() { return categoryId; }
  public void setCategoryId(String categoryId) { this.categoryId = categoryId; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  /* Public Methods*/

  public String toString() {
    return getName();
  }
}
