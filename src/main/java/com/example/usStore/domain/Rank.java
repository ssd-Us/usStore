package com.example.usStore.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "itemId", "title", "viewCount" })
public class Rank {
	private int itemId;
	private String title;
	private int viewCount;
	
	public Rank() {}
	
	public Rank(int itemId, String title, int viewCount) {
		super();
		this.itemId = itemId;
		this.title = title;
		this.viewCount = viewCount;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	@Override
	public String toString() {
		return "Rank [itemId=" + itemId + ", title=" + title + ", viewCount=" + viewCount + "]";
	}
	
}