package com.example.usStore.service.facade;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Auction;
import com.example.usStore.domain.GroupBuying;
import com.example.usStore.domain.HandMade;
import com.example.usStore.domain.Item;
import com.example.usStore.domain.SecondHand;
import com.example.usStore.domain.Tag;

/*
 * ItemFacade
 * 
 * Item / HandMade / GroupBuying / SecondHand / Auction / Tag
 * */
public interface ItemFacade {

	/////////////////////////////////////////////////////////////////////////
	/* Item */
	/////////////////////////////////////////////////////////////////////////
	
	void insertItem(Item item);
	
	void updateItem(Item item);
	
	void getItem(int itemId, int productId);
	
	public void deleteItem(int itemId, int productId);
	
	void updateQuantity(int qty, int itemId, int productId);
	
	int getQuantity(int itemId, int productId);

	boolean isItemInStock(int itemId, int productId);

	
	/////////////////////////////////////////////////////////////////////////
	/* HandMade */
	/////////////////////////////////////////////////////////////////////////

	public void insertHandMade(HandMade handmade);
	
	public void updateHandMade(HandMade handmade);
	
	List<HandMade> getHandMadeList();
	
	HandMade getHandMadeById(int itemId);
	
	List<HandMade> getHandMadeListByProductId(int productId);
	
	/////////////////////////////////////////////////////////////////////////
	/* GroupBuying */
	/////////////////////////////////////////////////////////////////////////
	public void insertGroupBuying(GroupBuying GroupBuying);
	  
	public void updateGroupBuying(GroupBuying GroupBuying);
	
	List<GroupBuying> getGroupBuyingList();
	
	GroupBuying getGroupBuyingItem(int itemId);

	public void joinGroupBuying(GroupBuying GroupBuying);
	
	public void calculateDiscount(GroupBuying GroupBuying);
	
	/////////////////////////////////////////////////////////////////////////
	/* SecondHand */
	/////////////////////////////////////////////////////////////////////////	
	List<SecondHand> getSecondHandList();
	
	SecondHand getSecondHandItem(int itemId);
	
	public void insertSecondHand(SecondHand secondHand);
	  
	public void updateSecondHand(SecondHand secondHand);
	
	/////////////////////////////////////////////////////////////////////////
	/* Auction */
	/////////////////////////////////////////////////////////////////////////
	List<Auction> getAuctionList();
	
	Auction getAuctionItem(int itemId);
	
	public void insertAuction(Auction auction);
	 
	public void updateAuction(Auction auction);

	public Auction getAuctionById(int itemId);
	
	/////////////////////////////////////////////////////////////////////////
	/* Tag */
	/////////////////////////////////////////////////////////////////////////
	List<Tag> getTagList ();

	List<Tag> getTagByTagId(int tagId);

	List<Tag> getTagByItemId(int itemId);	

	Tag getTagByTagName(String tagName);	

	void insertTag(Tag tag);

	void updateTag(Tag tag);	

	void deleteTag(int tagId);	
	
}
