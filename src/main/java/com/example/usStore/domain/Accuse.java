package com.example.usStore.domain;

/*
 * �Ű� ���̺� Domain Class
 * */
public class Accuse {

	// variable
	private int accuse_id;   // �Ű��� ����� ���� ���̵�
	private String user_id;  // �Ű��� ����� ���� ���̵�
	
	
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
