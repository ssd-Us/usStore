package com.example.usStore.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "itemId", "title", "viewCount", "category" })
public class Rank {
   private int itemId;
   private String title;
   private int viewCount;
   private String category;
   
   public Rank() {}
   
   public Rank(int itemId, String title, int viewCount, String category) {
      super();
      this.itemId = itemId;
      this.title = title;
      this.viewCount = viewCount;
      this.category = category;
   }

   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public int getViewCount() {
      return viewCount;
   }
   public void setViewCount(int viewCount) {
      this.viewCount = viewCount;
   }
   
   public int getItemId() {
      return itemId;
   }
   
   public void setItemId(int itemId) {
      this.itemId = itemId;
   }
   
   public String getCategory() {
	return category;
   }

   public void setCategory(String category) {
		this.category = category;
   }

   @Override
   public String toString() {
      return "Rank [itemId=" + itemId + ", title=" + title + ", viewCount=" + viewCount + ", category=" + category +"]";
   }
	
}