package com.example.usStore.domain;

/*
 * Ű���� �˸� ���̺� Domain Class
 * */
public class KeyAlarm {

	// variable
	private int KeyAlarm_id;  // Ű���� �˶� ���� ���̵�
	private String user_id;   // Ű���带 ������ ������ ���̵�
	private String keyword;   // Ű����
	
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
