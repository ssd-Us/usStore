package com.example.usStore.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * Item Domain Class
 * */
@SuppressWarnings("serial")
public class Item implements Serializable {
	/* Private Fields */
	private int itemId; // (PK) String- > int
	private int unitCost;
	private String title;
	private String description;
	private int viewCount;
	private int qty;
	private List<Tag> tags = new ArrayList<Tag>();
	private String userId; // (FK)
	private int productId; // (FK)

	public Item() {}
	
	public Item(int unitCost, String title, String description, int qty, String userId,	int productId) {
		this.unitCost = unitCost;
		this.title = title;
		this.description = description;
		this.qty = qty;
		this.userId = userId;
		this.productId = productId;
	}

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
	
	public void makeTags(int itemId, String tagName) {	//itemId�몴占� tag占쎌벥 itemId嚥∽옙, tagName(tag1, 2, 3, 4, 5) 筌욑옙占쎌젟 , tagId占쎈뮉 占쎌뿫占쎌벥占쎌벥 占쎈땾 0 占쎌몵嚥∽옙 筌욑옙占쎌젟
		if(tagName != null && tagName.trim() != "") {
			Tag tag = new Tag(itemId, tagName);
			tags.add(tag);
		}	
	  }
	
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", unitCost=" + unitCost + ", title=" + title + ", description=" + description
				+ ", viewCount=" + viewCount + ", qty=" + qty + ", userId=" + userId + ", productId="
				+ productId + "]";
	}

	

}
