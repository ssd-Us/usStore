package com.example.usStore.domain;

/*
 * 신고 테이블 Domain Class
 * */
public class Accuse {

	// variable
	private int accuse_id;   // 신고할 사람의 계정 아이디
	private String user_id;  // 신고한 사람의 계정 아이디
	
	
	// setter & getter
	public int getAccuse_id() {
		return accuse_id;
	}
	public void setAccuse_id(int accuse_id) {
		this.accuse_id = accuse_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}
