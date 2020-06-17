package com.example.usStore.dao.mybatis;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.usStore.dao.AuctionDao;
import com.example.usStore.dao.mybatis.mapper.AuctionMapper;
import com.example.usStore.domain.Auction;
import com.example.usStore.domain.Bidder;
import com.example.usStore.domain.Item;

@Qualifier("mybatisAuctionDao")
@Repository
public class MybatisAuctionDao implements AuctionDao {

   @Autowired
   private AuctionMapper auctionMapper;

   @Override
   public void updateQuantity(int qty, int itemId, int productId) throws DataAccessException {
      // TODO Auto-generated method stub
      auctionMapper.updateQuantity(qty, itemId, productId);
   }

   @Override
   public int getQuantity(int itemId, int productId) throws DataAccessException {
      // TODO Auto-generated method stub
      return auctionMapper.getQuantity(itemId, productId);
   }

   @Override
   public boolean isItemInStock(int itemId, int productId) throws DataAccessException {
      // TODO Auto-generated method stub
      return auctionMapper.isItemInStock(itemId, productId);
   }

   @Override
   public void deleteItem(int itemId) throws DataAccessException {
      // TODO Auto-generated method stub
      auctionMapper.deleteItem(itemId);
   }

   @Override
   public List<Auction> getAuctionList() throws DataAccessException {
      // TODO Auto-generated method stub
      return auctionMapper.getAuctionList();
   }

   @Override
   public Auction getAuctionItem(int itemId) throws DataAccessException {
      // TODO Auto-generated method stub
      return auctionMapper.getAuctionItem(itemId);
   }

   @Override
   public void insertAuction(Auction auction) throws DataAccessException {
      // TODO Auto-generated method stub
      auctionMapper.insertAuction(auction);
   }

   @Override
   public void updateAuction(Auction auction) throws DataAccessException {
      // TODO Auto-generated method stub
      auctionMapper.updateAuction(auction);
   }

   @Override
   public Auction getAuctionById(int itemId) throws DataAccessException {
      // TODO Auto-generated method stub
      return auctionMapper.getAuctionById(itemId);
   }

   @Override
   public void insertItem(Item item) {
      // TODO Auto-generated method stub
      auctionMapper.insertItem(item);
   }

   @Override
   public void updateItem(Item item) {
      // TODO Auto-generated method stub
      auctionMapper.updateItem(item);
   }

   @Override
   public Item getItem(int itemId) {
      return auctionMapper.getItem(itemId);
   }
   
   public void closeAuction(Date curTime) {
	   auctionMapper.closeAuction(curTime);
   }

   public void updateAuctionUnitCost(int unitCost, int itemId) {
	   auctionMapper.updateAuctionUnitCost(unitCost, itemId);
   }
	
   public void updateBidder(String bidder, int itemId) {
	   auctionMapper.updateBidder(bidder, itemId);
   }
	
   public void insertBidder(Bidder bidder) {
	   auctionMapper.insertBidder(bidder);
   }
   
   public String isBidderExist(int itemId) {
	   return auctionMapper.isBidderExist(itemId);
   }

   public void updateBidPrice(int unitCost, int itemId) {
	   auctionMapper.updateBidPrice(unitCost, itemId);
   }

   @Override
   public String getUserIdByItemId(int itemId) throws DataAccessException {
	return auctionMapper.getUserIdByItemId(itemId);
   }
   

}