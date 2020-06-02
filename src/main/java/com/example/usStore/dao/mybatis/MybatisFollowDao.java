package com.example.usStore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.usStore.dao.AccountDao;
import com.example.usStore.dao.FollowDao;
import com.example.usStore.dao.mybatis.mapper.FollowMapper;
import com.example.usStore.domain.Follow;

@Repository
public class MybatisFollowDao implements FollowDao {

	@Autowired
	private FollowMapper followMapper;
	
	@Override
	public List<Follow> getFollowingList(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Follow> getFollowerList(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertFollow(Follow follow) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFollow(int following) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isYourFollower(String follower) throws DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isYourFollowing(String following) throws DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}

}
