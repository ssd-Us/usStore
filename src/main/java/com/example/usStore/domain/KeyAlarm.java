package com.example.usStore.domain;

/*
 * 키워드 알림 테이블 Domain Class
 * */
public class KeyAlarm {

	// variable
	private int KeyAlarm_id;  // 키워드 알람 고유 아이디
	private String user_id;   // 키워드를 설정한 계정의 아이디
	private String keyword;   // 키워드
	
	// setter & getter
	public int getKeyAlarm_id() {
		return KeyAlarm_id;
	}
	public void setKeyAlarm_id(int keyAlarm_id) {
		KeyAlarm_id = keyAlarm_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
