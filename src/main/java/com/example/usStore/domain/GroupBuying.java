package com.example.usStore.domain;

import java.util.Date;

@SuppressWarnings("serial")
public class GroupBuying extends Product {
	private Number discount;	//�������� ���ΰ� - ������	
	private Date time;


	public Number getDiscount() {
		return discount;
	}

	public void setDiscount(Number discount) {
		this.discount = discount;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
}
