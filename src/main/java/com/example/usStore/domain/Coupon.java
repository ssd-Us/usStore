package com.example.usStore.domain;

/*
 * Event Function - Coupon
 * */
public class Coupon {
	private String coupon_id;		// Coupon�� id
	private String coupon_name;		// Coupon�� �̸�
	private int discountRate;		// Coupon�� ������
	private String user_id;			// Coupon�� �߱޹��� user�� Id
	
	// �⺻ ������
	public Coupon() {
		
	}
	
	// getter & setter
	public String getCoupon_id() {
		return coupon_id;
	}
	public void setCoupon_id(String coupon_id) {
		this.coupon_id = coupon_id;
	}
	public String getCoupon_name() {
		return coupon_name;
	}
	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}
	public int getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}
