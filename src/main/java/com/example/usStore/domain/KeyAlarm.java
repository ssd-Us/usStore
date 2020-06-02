package com.example.usStore.domain;

import java.io.Serializable;

/*
 * UsStore - KeyAlarm Domain Class
 * */
@SuppressWarnings("serial")
public class KeyAlarm implements Serializable {

	// variable
	private int keyAlarmId;  // Sequence
	private String userId;   // (FK) userId
	private String keyword;	 // Keyword for Alarm
	
	// setter & getter
	public int getkeyAlarmId() {
		return keyAlarmId;
	}
	public void setkeyAlarmId(int keyAlarmId) {
		this.keyAlarmId = keyAlarmId;
	}
	public String getuserId() {
		return userId;
	}
	public void setuserId(String userId) {
		this.userId = userId;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
