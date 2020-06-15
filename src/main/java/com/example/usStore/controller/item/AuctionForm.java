package com.example.usStore.controller.item;

import java.util.Date;
import java.util.List;

import com.example.usStore.domain.Auction;
import com.example.usStore.domain.Tag;

public class AuctionForm {
	/*field (���⿡ ���� auction field �� default ������ ����*/
	private String title;
	private String description;
	private List<Tag> tag;
	private int startPrice;
	private Date deadLine; //�� ��¥ ��� �� ������
	
	
	
	
	public AuctionForm(String title, String description, List<Tag> tag, int startPrice, Date deadLine) {
		super();
		this.title = title;
		this.description = description;
		this.tag = tag;
		this.startPrice = startPrice;
		this.deadLine = deadLine;
	}

	/*getter setter*/
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Tag> getTag() {
		return tag;
	}

	public void setTag(List<Tag> tag) {
		this.tag = tag;
	}
		
	public int getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(int startPrice) {
		this.startPrice = startPrice;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}
	
	
	
	
	

	/*Constructor*/
	public AuctionForm(Auction auction) {
		title = auction.getTitle();
		description = auction.getDescription();
		//tag = auction.getTag(); //tag ��� �� �� �� ���ؾ� �� ��
	}
}
