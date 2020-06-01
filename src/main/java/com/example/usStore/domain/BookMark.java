package com.example.usStore.domain;

import java.io.Serializable;

/*
 * Mypage - BookMark Domain Class
 * */
@SuppressWarnings("serial")
public class BookMark  implements Serializable {
	
	private String itemId;	// (FK) itemId - BookMark Item
	private String userId;  // (FK) userId
	
	// Constructor
	public BookMark() {
		
	}
	
	// getter & setter
	public String getuserId() {
		return userId;
	}
	public void setuserId(String userId) {
		this.userId = userId;
	}
	public String getitemId() {
		return itemId;
	}
	public void setitemId(String itemId) {
		this.itemId = itemId;
	}
}
