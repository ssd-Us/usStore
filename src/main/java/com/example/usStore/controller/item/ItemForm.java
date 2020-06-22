package com.example.usStore.controller.item;

import java.util.ArrayList;
import java.util.List;

import com.example.usStore.domain.Tag;

public class ItemForm {
	/* Private Fields */
	  private int itemId;			 //(PK) String- > int
	  private int unitCost; 		 //�뜝�뙟怨ㅼ삕(�뜝�룞�삕�뜝�룞�삕)
	  private String title; 		 //�뜝�룞�삕�뜝�룞�삕
	  private String description; 	 //�뜝�룞�삕�뜝�룞�삕
	  private int viewCount; 		 //�뜝�룞�삕�쉶�뜝�룞�삕
	  private int qty;			 //�뜝�룞�삕�뜝占�
	  private String tag1;
	  private String tag2;
	  private String tag3;
	  private String tag4;
	  private String tag5;
	  private String userId;		 //(FK) �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�떛�벝�삕
	  private int productId;      	 //(FK) �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕/�뜝�뙥怨ㅼ삕�궧�뜝占�/�뜝�룞�삕�뜝占�/�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�떎紐뚯삕 �뜝�룞�삕�뜝�룞�삕  
	  
	  public ItemForm() {}
	  
	  public ItemForm(String title, String userId, int productId, String description, int unitCost, int qty, String tag1, String tag2, String tag3,
			String tag4, String tag5) {
		super();
		this.unitCost = unitCost;
		this.title = title;
		this.userId = "exampleId";	// for Test
		this.description = description;
		this.qty = qty;
		this.tag1 = tag1;
		this.tag2 = tag2;
		this.tag3 = tag3;
		this.tag4 = tag4;
		this.tag5 = tag5;
	}

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

	@Override
	public String toString() {
		return "ItemForm [itemId=" + itemId + ", unitCost=" + unitCost + ", title=" + title + ", description="
				+ description + ", viewCount=" + viewCount + ", qty=" + qty + ", tag1=" + tag1 + ", tag2=" + tag2
				+ ", tag3=" + tag3 + ", tag4=" + tag4 + ", tag5=" + tag5 + ", userId=" + userId
				+ ", productId=" + productId + "]";
	}
	
	  
}