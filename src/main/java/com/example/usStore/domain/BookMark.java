package com.example.usStore.domain;

/*
 * Mypage Function - BookMark
 * */
public class BookMark {

	private String user_id;		// BookMark를 설정한 유저의 Id
	private String item_id;		// 유저가 BookMark를 설정한 아이템의 Id
	
	// 기본 생성자
	public BookMark() {
		
	}
	
	// getter & setter
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
}
