package com.example.usStore.controller.item;

import java.util.ArrayList;
import java.util.List;

import com.example.usStore.domain.Tag;

public class ItemForm {
	/* Private Fields */
	  private int itemId;			 //(PK) String- > int
	  private int unitCost; 		 //�ܰ�(����)
	  private String title; 		 //����
	  private String description; 	 //����
	  private int viewCount; 		 //��ȸ��
	  private int qty;			 //���
	  private String tag1;
	  private String tag2;
	  private String tag3;
	  private String tag4;
	  private String tag5;
	  private List<Tag> tags = new ArrayList<Tag>();
	  private String userId;		 //(FK) ������ ���̵�
	  private int productId;      	 //(FK) ��������/�߰�ŷ�/���/�������Ǹ� ����  
	  
	  /* JavaBeans Properties */
	  public int getItemId() {
		return itemId;
	  }

	  public void setItemId(int itemId) {
		this.itemId = itemId;
	  }

	  public int getUnitCost() {
		return unitCost;
	  }

	  public void setUnitCost(int unitCost) {
		this.unitCost = unitCost;
	  }

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

	  public int getViewCount() {
		return viewCount;
	  }

	  public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	  }

	  public int getQty() {
		return qty;
	  }

	  public void setQty(int qty) {
		this.qty = qty;
	  }

	  public String getUserId() {
		return userId;
	  }

	  public void setUserId(String userId) {
		this.userId = userId;
	  }

	  public int getProductId() {
		return productId;
	  }

	  public void setProductId(int productId) {
		this.productId = productId;
	  }
	  
	  
	public String getTag1() {
		return tag1;
	}

	public void setTag1(String tag1) {
		this.tag1 = tag1;
	}

	public String getTag2() {
		return tag2;
	}

	public void setTag2(String tag2) {
		this.tag2 = tag2;
	}

	public String getTag3() {
		return tag3;
	}

	public void setTag3(String tag3) {
		this.tag3 = tag3;
	}

	public String getTag4() {
		return tag4;
	}

	public void setTag4(String tag4) {
		this.tag4 = tag4;
	}

	public String getTag5() {
		return tag5;
	}

	public void setTag5(String tag5) {
		this.tag5 = tag5;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	 public void makeTags(int itemId, String tagName) {	//itemId를 tag의 itemId로, tagName(tag1, 2, 3, 4, 5) 지정 , tagId는 임의의 수 0 으로 지정
		Tag tag = new Tag(itemId, tagName);
		tags.add(tag);
	  }
//	  
//	public List<Tag> GetTags(Tag tag) {		//tags 리스트에 tag하나 추가	
//		return tags;
//	}

	/*
		 * private final List<String> tags = new ArrayList() { { tags.add(tag1);
		 * add("2"); add("3"); } };
		 */
	@Override
	public String toString() {
		return "ItemForm [itemId=" + itemId + ", unitCost=" + unitCost + ", title="
				+ title + ", description=" + description + ", viewCount=" + viewCount 
				+ ", qty=" + qty + ", userId=" + userId + ", productId=" + productId + "]";
	}
	  
	  
}
