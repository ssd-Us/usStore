package com.example.usStore.service.facade;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Account;
import com.example.usStore.domain.Auction;
import com.example.usStore.domain.Bidder;
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
	
	Item getItem(int itemId);
	
	public void deleteItem(int itemId);
	
	void updateQuantity(int qty, int itemId, int productId);
	
	int getQuantity(int itemId, int productId);

	boolean isItemInStock(int itemId, int productId);

	String getUserIdByItemId(int itemId);
	
	void updateViewCount(int viewCount, int itemId);
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
	
	public void insertAuction(Auction auction);
	 
	public void updateAuction(Auction auction);

	public Auction getAuctionById(int itemId);
	
	public void testScheduler(Date deadLine);
	
	public void updateAuctionUnitCost(int unitCost, int itemId);
	
	public void updateBidder(String bidder, int itemId);
	
	public void insertBidder(Bidder bidder);
	
	public String isBidderExist(int itemId);
	
	public void updateBidPrice(int unitCost, int itemId);
	
	public List<Bidder> getBidderList();
	
	/////////////////////////////////////////////////////////////////////////
	/* Tag */
	/////////////////////////////////////////////////////////////////////////
	List<Tag> getTagList ();
	
	List<Tag> getTagByTagId(int tagId);
	
	List<Tag> getTagByItemId(int itemId);	
	
	List<Tag> getTagByTagName(String tagName);	
	
	void insertTag(Tag tag);	
	
	void deleteTag(int itemId);
}
