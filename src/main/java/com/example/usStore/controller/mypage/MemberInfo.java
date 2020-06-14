package com.example.usStore.controller.mypage;

import java.util.Date;

//////////////////////////
//중간고사 대첵과제 코드 복붙
/////////////////////////
public class MemberInfo {
	private String id;
	private String name;
	private String password;
	private String phone;
	private String title;
	private int length;
	private boolean newPerformer;
	private Date regTime;
	
	public MemberInfo(String id, String name, String password, String phone,
			String title, int length, boolean newPerformer, Date regTime) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.title = title;
		this.length = length;
		this.newPerformer = newPerformer;
		this.regTime = regTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public boolean isNewPerformer() {
		return newPerformer;
	}

	public void setNewPerformer(boolean newPerformer) {
		this.newPerformer = newPerformer;
	}
	
	public boolean matchPassword(String inputPassword) {
		return password.equals(inputPassword);
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

}
