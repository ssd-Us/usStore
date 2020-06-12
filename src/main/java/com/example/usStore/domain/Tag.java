package com.example.usStore.domain;

import java.io.Serializable;

/*
 * Mypage, Item - Tag Domain Class
 * */
@SuppressWarnings("serial")
public class Tag  implements Serializable {
	/* Private Fields */
	private int tagId; 			// Sequence
	private int itemId; 		// (FK) itemId
	private String tagName = null;
 
	public Tag() {}
	
	public Tag(int itemId, String tagName) {
		this.itemId = itemId;	
		this.tagName = tagName;
	}
		
	/* JavaBeans Properties */
	public int getTagId() { return tagId; }
	public void setTagId(int tagId) {	this.tagId = tagId; }
	
	public int getItemId() { return itemId; }
	public void setItemId(int itemId) { this.itemId = itemId; }
	
	public String getTagName() { return tagName; }
	public void setTagName(String tagName) { this.tagName = tagName; }
	
	/* Public Methods */
	public String toString() {
		return "�±� : " + getTagId() +  " - " + getTagName();
	}
}
