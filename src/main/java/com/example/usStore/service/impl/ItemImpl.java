package com.example.usStore.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.usStore.dao.AuctionDao;
import com.example.usStore.dao.GroupBuyingDao;
import com.example.usStore.dao.HandMadeDao;
import com.example.usStore.dao.ItemDao;
import com.example.usStore.dao.SecondHandDao;
import com.example.usStore.dao.TagDao;
import com.example.usStore.domain.Auction;
import com.example.usStore.domain.Bidder;
import com.example.usStore.domain.GroupBuying;
import com.example.usStore.domain.HandMade;
import com.example.usStore.domain.Item;
import com.example.usStore.domain.SecondHand;
import com.example.usStore.domain.Tag;
import com.example.usStore.service.facade.ItemFacade;

/*
 * ItemFacade
 * 
 * Item / HandMade / GroupBuying / SecondHand / Auction / Tag
 * */
@Repository
@Service("itemImpl")
@Transactional
public class ItemImpl implements ItemFacade {

	@Autowired
	private ItemDao itemDao;
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
	@Autowired		// applicationContext.xml占쎈퓠 占쎌젟占쎌벥占쎈쭆 scheduler 揶쏆빘猿쒐몴占� 雅뚯눘�뿯 獄쏆룇�벉
	private ThreadPoolTaskScheduler scheduler;
	
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
			System.err.println("getQuantity Error !!");
			return -1;
		}
	}
	
	@Override
	public void deleteItem(int itemId) {
		// TODO Auto-generated method stub
		itemDao.deleteItem(itemId);
	}
	
	// �뜝�럩逾졿ㅀ袁ъ삕 占썩뫁伊숃뜎洹⑥삕�뜮�쉻�삕�뵳占�
	@Override
	public boolean isItemInStock(int itemId, int productId) {
		// TODO Auto-generated method stub
		switch(productId) {
		case 0:
			return groupBuyingDao.isItemInStock(itemId, productId);
		case 1:
			return auctionDao.isItemInStock(itemId, productId);
		case 2:
			return secondHandDao.isItemInStock(itemId, productId);
		case 3:
			return handMadeDao.isItemInStock(itemId, productId);
		default :
			System.err.println("isItemInStock Error !!");
			return false;
		}
	}
	
	@Override
	public void insertHandMade(HandMade handmade) {
		// TODO Auto-generated method stub
		handMadeDao.insertHandMade(handmade);
	}

	@Override
	public void updateHandMade(HandMade handmade) {
		// TODO Auto-generated method stub
		handMadeDao.updateHandMade(handmade);
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
		return secondHandDao.getSecondHandList();
	}

	@Override
	public SecondHand getSecondHandItem(int itemId) {
		return secondHandDao.getSecondHandItem(itemId);
	}


	@Override
	public void insertSecondHand(SecondHand secondHand) {
		secondHandDao.insertSecondHand(secondHand);
	}
	
	@Override
	public void updateSecondHand(SecondHand secondHand) {
		secondHandDao.updateSecondHand(secondHand);
	}

	@Override
	public List<Auction> getAuctionList() {
		// TODO Auto-generated method stub
		return auctionDao.getAuctionList();
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

	
	public void testScheduler(Date deadLine) {
		Runnable updateTableRunner = new Runnable() {	
			@Override
			public void run() {  	
				Date curTime = new Date();
				auctionDao.closeAuction(curTime);
				
				List<Auction> auctionList = auctionDao.getAuctionList();
				for(int i = 0; i < auctionList.size(); i++) {
					if (auctionList.get(i).getAuctionState() == 1) {
						int unitCost = auctionList.get(i).getUnitCost();
						int itemId = auctionList.get(i).getItemId();
						
						auctionDao.updateBidPrice(unitCost, itemId);
					}
				}
			}
		};
		scheduler.schedule(updateTableRunner, deadLine);  
		
		System.out.println("updateTableRunner has been scheduled to execute at " + deadLine);
	}
	
	public void updateAuctionUnitCost(int unitCost, int itemId) {
		auctionDao.updateAuctionUnitCost(unitCost, itemId);
	}
	
	public void updateBidder(String bidder, int itemId) {
		auctionDao.updateBidder(bidder, itemId);
	}
	
	public void insertBidder(Bidder bidder) {
		auctionDao.insertBidder(bidder);
	}
	
	public String isBidderExist(int itemId) {
		return auctionDao.isBidderExist(itemId);
	}
	
	public void updateBidPrice(int unitCost, int itemId) {
		auctionDao.updateBidPrice(unitCost, itemId);
	}
	
	public List<Bidder> getBidderList() {
		return auctionDao.getBidderList();
	}

	@Override
	public List<Tag> getTagList() {
		// TODO Auto-generated method stub
		return tagDao.getTagList();
	}

	@Override
	public List<Tag> getTagByTagId(int tagId) {
		// TODO Auto-generated method stub
		return tagDao.getTagByTagId(tagId);
	}

	@Override
	public List<Tag> getTagByItemId(int itemId) {
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
	public void deleteTag(int itemId) {
		// TODO Auto-generated method stub
		tagDao.deleteTag(itemId);
	}

	@Override
	public void insertItem(Item item) {
		// TODO Auto-generated method stub
		itemDao.insertItem(item);
	}

	@Override
	public void updateItem(Item item) {
		// TODO Auto-generated method stub
		itemDao.updateItem(item);
	}

	@Override
	public Item getItem(int itemId) {
		// TODO Auto-generated method stub
		return itemDao.getItem(itemId);
	}

	@Override
	public String getUserIdByItemId(int itemId) {
		return itemDao.getUserIdByItemId(itemId);
	}

	@Override
	public List<Item> searchItemList(String keywords) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateViewCount(int viewCount, int itemId) {
		// TODO Auto-generated method stub
		itemDao.updateViewCount(viewCount, itemId);
	}

	

}
