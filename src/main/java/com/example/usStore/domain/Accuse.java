package com.example.usStore.domain;

/*
 * �Ű� ���̺� Domain Class
 * */
public class Accuse {

	// variable
	private int accuse_id;   // �Ű��� ����� ���� ���̵�
	private String victim;   //(FK)
	private String attacker; //(FK)
	private String reason;  // �Ű� ����
	
	// setter & getter
	public int getAccuse_id() {
		return accuse_id;
	}
	public void setAccuse_id(int accuse_id) {
		this.accuse_id = accuse_id;
	}
	public String getVictim() {
		return victim;
	}
	public void setVictim(String victim) {
		this.victim = victim;
	}
	public String getAttacker() {
		return attacker;
	}
	public void setAttacker(String attacker) {
		this.attacker = attacker;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
		
	
}
