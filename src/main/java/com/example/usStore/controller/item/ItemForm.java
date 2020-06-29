package com.example.usStore.controller.item;

import java.util.List;

import com.example.usStore.domain.Tag;

public class ItemForm {
   /* Private Fields */
     private int itemId;          //(PK) String- > int
     private int unitCost;        // 뜝 뙟怨ㅼ삕( 뜝 룞 삕 뜝 룞 삕)
     private String title;        // 뜝 룞 삕 뜝 룞 삕
     private String description;     // 뜝 룞 삕 뜝 룞 삕
     private int viewCount;        // 뜝 룞 삕 쉶 뜝 룞 삕
     private int qty;          // 뜝 룞 삕 뜝占 
     private List<Tag> tags;
     private String userId;       //(FK)  뜝 룞 삕 뜝 룞 삕 뜝 룞 삕  뜝 룞 삕 뜝 떛 벝 삕
     private int productId;          //(FK)  뜝 룞 삕 뜝 룞 삕 뜝 룞 삕 뜝 룞 삕/ 뜝 뙥怨ㅼ삕 궧 뜝占 / 뜝 룞 삕 뜝占 / 뜝 룞 삕 뜝 룞 삕 뜝 룞 삕 뜝 떎紐뚯삕  뜝 룞 삕 뜝 룞 삕  
     
     public ItemForm() {}

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
     
     public List<Tag> getTags() {
      return tags;
     }

     public void setTags(List<Tag> tags) {
      this.tags = tags;
     }

     @Override
     public String toString() {
      return "ItemForm [itemId=" + itemId + ", unitCost=" + unitCost + ", title=" + title + ", description="
            + description + ", viewCount=" + viewCount + ", qty=" + qty + ",tags = " + tags + ", userId=" + userId
            + ", productId=" + productId + "]";
     }
}