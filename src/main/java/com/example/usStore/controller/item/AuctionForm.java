package com.example.usStore.controller.item;

import java.util.Date;
import java.util.List;

import com.example.usStore.domain.Auction;
import com.example.usStore.domain.Tag;

public class AuctionForm {
	/*field (여기에 없는 auction field 는 default 값으로 저장*/
	private String title;
	private String description;
	private List<Tag> tag;
	private int startPrice;
	private Date deadLine; //이 날짜 어떻게 할 것인지
	
	
	
	
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
		//tag = auction.getTag(); //tag 어떻게 할 지 좀 정해야 할 듯
	}
}
