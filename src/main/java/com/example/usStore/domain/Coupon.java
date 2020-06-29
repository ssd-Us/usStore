package com.example.usStore.domain;

import java.io.Serializable;

/*
 * Event - Coupon Domain Class
 * */
@SuppressWarnings("serial")
public class Coupon  implements Serializable {
	private String couponId;		// Sequence
	private String couponName;		
	private int discountRate;		
	private String userId;			// (FK) userId;
	
	// Constructor
	public Coupon() {	
	}
	
	// getter & setter
	public String getcouponId() {
		return couponId;
	}
	public void setcouponId(String couponId) {
		this.couponId = couponId;
	}
	public String getcouponName() {
		return couponName;
	}
	public void setcouponName(String couponName) {
		this.couponName = couponName;
	}
	public int getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
	public String getuserId() {
		return userId;
	}
	public void setuserId(String userId) {
		this.userId = userId;
	}
}
