package com.example.usStore.domain;

import java.io.Serializable;

/*
 * MyPage - Accuse Domain Class
 * */
@SuppressWarnings("serial")
public class Accuse  implements Serializable {

	// variable
	private int accuseId;   // Sequence
	private String victim;   // (FK) userId : 피해자(로그인한, 신고한사람)
	private String attacker; // (FK) userId : 판매자(신고 대상자)
	private String reason;  // 신고 이유
	
	// setter & getter
	public int getAccuseId() {
		return accuseId;
	}
	public void setAccuseId(int accuseId) {
		this.accuseId = accuseId;
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
