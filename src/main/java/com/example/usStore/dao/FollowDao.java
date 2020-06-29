package com.example.usStore.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.example.usStore.domain.Follow;

public interface FollowDao {

	// 사용자의 전체 팔로잉 정보를 가져오는 메소드
	List<Follow> getFollowingList(String userId) throws DataAccessException;

	// 사용자의 전체 팔로워 정보를 가져오는 메소드
	List<Follow> getFollowerList(String userId) throws DataAccessException;

	// 팔로잉 추가 메소드
	void insertFollow(Follow follow) throws DataAccessException;

	// 팔로잉 삭제 메소드
	void deleteFollow(int following) throws DataAccessException;

	// 나를 팔로잉하는 사용자인지 알려주는 메소드
	boolean isYourFollower (String follower) throws DataAccessException;

	// 내가 팔로잉하는 사용자인지 알려주는 메소드 
	boolean isYourFollowing (String following) throws DataAccessException;
}
