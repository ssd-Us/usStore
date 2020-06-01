package com.example.usStore.service.impl;

import java.util.List;

import com.example.usStore.domain.Auction;
import com.example.usStore.domain.GroupBuying;
import com.example.usStore.domain.HandMade;
import com.example.usStore.domain.SecondHand;
import com.example.usStore.domain.Tag;
import com.example.usStore.service.facade.ItemFacade;

public class ItemImpl implements ItemFacade {

	@Override
	public void insertHandMade(HandMade handmade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteItem(int itemId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateHandMade(HandMade handmade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemInStock(int itemId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<HandMade> getHandMadeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HandMade getHandMadeById(int itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HandMade> getHandMadeListByProductId(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateQuantity(int qty, int itemId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getQuantity(int itemId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insertGroupBuying(GroupBuying GroupBuying) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGroupBuying(GroupBuying GroupBuying) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GroupBuying> getGroupBuyingList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupBuying getGroupBuyingItem(int itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void joinGroupBuying(GroupBuying GroupBuying) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calculateDiscount(GroupBuying GroupBuying) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SecondHand> getSecondHandList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SecondHand getSecondHandItem(int itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertSecondHand(SecondHand secondHand) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSecondHand(SecondHand secondHand) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Auction> getAuctionList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Auction getAuctionItem(int itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertAuction(Auction auction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAuction(Auction auction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Auction getAuctionById(int itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tag> getTagList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tag getTagByTagId(int tagId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tag getTagByItemId(int itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tag getTagByTagName(String tagName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertTag(Tag tag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTag(Tag tag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTag(int tagId) {
		// TODO Auto-generated method stub
		
	}
	
}
