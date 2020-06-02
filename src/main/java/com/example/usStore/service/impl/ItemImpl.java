package com.example.usStore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.usStore.dao.AuctionDao;
import com.example.usStore.dao.GroupBuyingDao;
import com.example.usStore.dao.HandMadeDao;
import com.example.usStore.dao.SecondHandDao;
import com.example.usStore.dao.TagDao;
import com.example.usStore.domain.Auction;
import com.example.usStore.domain.GroupBuying;
import com.example.usStore.domain.HandMade;
import com.example.usStore.domain.SecondHand;
import com.example.usStore.domain.Tag;
import com.example.usStore.service.facade.ItemFacade;

/*
 * ItemFacade
 * 
 * HandMade / GroupBuying / SecondHand / Auction / Tag
 * */
public class ItemImpl implements ItemFacade {

	@Autowired
	private HandMadeDao handMadeDao;
	@Autowired
	private GroupBuyingDao groupBuyingDao;
	@Autowired
	private SecondHandDao secondHandDao;
	@Autowired
	private AuctionDao auctionDao;
	@Autowired
	private TagDao tagDao;
	
	@Override
	public void insertHandMade(HandMade handmade) {
		// TODO Auto-generated method stub
		handMadeDao.insertHandMade(handmade);
	}

	@Override
	// 이거 수정해야됨.
	public void deleteItem(int itemId) {
		// TODO Auto-generated method stub
		handMadeDao.deleteItem(itemId);
	}

	@Override
	public void updateHandMade(HandMade handmade) {
		// TODO Auto-generated method stub
		handMadeDao.updateHandMade(handmade);
	}

	
	// 이거 고처야됌
	@Override
	public boolean isItemInStock(int itemId, int productId) {
		// TODO Auto-generated method stub
		
		return handMadeDao.isItemInStock(itemId, productId);
	}

	@Override
	public List<HandMade> getHandMadeList() {
		// TODO Auto-generated method stub
		return handMadeDao.getHandMadeList();
	}

	@Override
	public HandMade getHandMadeById(int itemId) {
		// TODO Auto-generated method stub
		return handMadeDao.getHandMadeById(itemId);
	}

	@Override
	public List<HandMade> getHandMadeListByProductId(int productId) {
		// TODO Auto-generated method stub
		return handMadeDao.getHandMadeListByProductId(productId);
	}

	@Override
	public void updateQuantity(int qty, int itemId, int productId) {
		// TODO Auto-generated method stub
		switch(productId) {
			case 0:
				groupBuyingDao.updateQuantity(qty, itemId, productId);
				break;
			case 1:
				auctionDao.updateQuantity(qty, itemId, productId);
				break;
			case 2:
				secondHandDao.updateQuantity(qty, itemId, productId);
				break;
			case 3:
				handMadeDao.updateQuantity(qty, itemId, productId);
				break;
			default:
				System.err.println("updateQuantity Error !!");
		}
	}

	@Override
	public int getQuantity(int itemId, int productId) {
		// TODO Auto-generated method stub
		switch(productId) {
		case 0:
			return groupBuyingDao.getQuantity(itemId, productId);
		case 1:
			return auctionDao.getQuantity(itemId, productId);
		case 2:
			return secondHandDao.getQuantity(itemId, productId);
		case 3:
			return handMadeDao.getQuantity(itemId, productId);
		default :
			return -1;
		}
	}
	
	@Override
	public void insertGroupBuying(GroupBuying GroupBuying) {
		// TODO Auto-generated method stub
		groupBuyingDao.insertGroupBuying(GroupBuying);
	}

	@Override
	public void updateGroupBuying(GroupBuying GroupBuying) {
		// TODO Auto-generated method stub
		groupBuyingDao.updateGroupBuying(GroupBuying);
	}

	@Override
	public List<GroupBuying> getGroupBuyingList() {
		// TODO Auto-generated method stub
		return groupBuyingDao.getGroupBuyingList();
	}

	@Override
	public GroupBuying getGroupBuyingItem(int itemId) {
		// TODO Auto-generated method stub
		return groupBuyingDao.getGroupBuyingItem(itemId);
	}

	@Override
	public void joinGroupBuying(GroupBuying GroupBuying) {
		// TODO Auto-generated method stub
		groupBuyingDao.joinGroupBuying(GroupBuying);
	}

	@Override
	public void calculateDiscount(GroupBuying GroupBuying) {
		// TODO Auto-generated method stub
		groupBuyingDao.calculateDiscount(GroupBuying);
	}

	@Override
	public List<SecondHand> getSecondHandList() {
		// TODO Auto-generated method stub
		return secondHandDao.getSecondHandList();
	}

	@Override
	public SecondHand getSecondHandItem(int itemId) {
		// TODO Auto-generated method stub
		return secondHandDao.getSecondHandItem(itemId);
	}

	@Override
	public void insertSecondHand(SecondHand secondHand) {
		// TODO Auto-generated method stub
		secondHandDao.insertSecondHand(secondHand);
	}

	@Override
	public void updateSecondHand(SecondHand secondHand) {
		// TODO Auto-generated method stub
		secondHandDao.updateSecondHand(secondHand);
	}

	@Override
	public List<Auction> getAuctionList() {
		// TODO Auto-generated method stub
		return auctionDao.getAuctionList();
	}

	@Override
	public Auction getAuctionItem(int itemId) {
		// TODO Auto-generated method stub
		return auctionDao.getAuctionItem(itemId);
	}

	@Override
	public void insertAuction(Auction auction) {
		// TODO Auto-generated method stub
		auctionDao.insertAuction(auction);	
	}

	@Override
	public void updateAuction(Auction auction) {
		// TODO Auto-generated method stub
		auctionDao.updateAuction(auction);
	}

	@Override
	public Auction getAuctionById(int itemId) {
		// TODO Auto-generated method stub
		return auctionDao.getAuctionById(itemId);
	}

	@Override
	public List<Tag> getTagList() {
		// TODO Auto-generated method stub
		return tagDao.getTagList();
	}

	@Override
	public Tag getTagByTagId(int tagId) {
		// TODO Auto-generated method stub
		return tagDao.getTagByTagId(tagId);
	}

	@Override
	public Tag getTagByItemId(int itemId) {
		// TODO Auto-generated method stub
		return tagDao.getTagByItemId(itemId);
	}

	@Override
	public Tag getTagByTagName(String tagName) {
		// TODO Auto-generated method stub
		return tagDao.getTagByTagName(tagName);
	}

	@Override
	public void insertTag(Tag tag) {
		// TODO Auto-generated method stub
		tagDao.insertTag(tag);
	}

	@Override
	public void updateTag(Tag tag) {
		// TODO Auto-generated method stub
		tagDao.updateTag(tag);
	}

	@Override
	public void deleteTag(int tagId) {
		// TODO Auto-generated method stub
		tagDao.deleteTag(tagId);
	}
}
