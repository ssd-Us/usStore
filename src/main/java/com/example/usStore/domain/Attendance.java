package com.example.usStore.domain;

import java.util.Date;

/*
 * Event Function - Attendance (출석체크)
 * */
public class Attendance {
	
	private String user_id; 		// 출석체크한 사용자 ID
	private int catId;				//(FK) 카테고리 아이디 
	private Date attendance_date;	// 출석체크한 날짜
	
	// 기본 생성자
	public Attendance() {
		
	}
	
	// getter & setter
	public Date getAttendance_date() {
		return attendance_date;
	}
	public void setAttendance_date(Date attendance_date) {
		this.attendance_date = attendance_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}
	
}
