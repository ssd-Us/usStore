package com.example.usStore.domain;

import java.util.Date;

/*
 * Event Function - Attendance (출석체크)
 * */
public class Attendance {
	
	private Date attendance_date;	// 출석체크한 날짜
	private String user_id; 		// 출석체크한 사용자 ID
	
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
}
