package com.example.usStore.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.usStore.dao.AuctionDao;
import com.example.usStore.dao.mybatis.mapper.AuctionMapper;
import com.example.usStore.domain.Auction;
import com.example.usStore.domain.Item;

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
	public void deleteItem(int itemId, int productId) throws DataAccessException {
		// TODO Auto-generated method stub
		auctionMapper.deleteItem(itemId, productId);
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
	public void getItem(int itemId, int productId) {
		// TODO Auto-generated method stub
		auctionMapper.getItem(itemId, productId);
	}

}
