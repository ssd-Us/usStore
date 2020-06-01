package com.example.usStore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.usStore.dao.AuctionDao;
import com.example.usStore.dao.mybatis.mapper.AuctionMapper;
import com.example.usStore.domain.Auction;
@Repository
public class MybatisAuctionDao implements AuctionDao {

	@Autowired
	private AuctionMapper auctionMapper;
	
	@Override
	public List<Auction> getAuctionList() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Auction getAuctionItem(int itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertAuction(Auction auction) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAuction(Auction auction) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Auction getAuctionById(int itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteItem(int itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
