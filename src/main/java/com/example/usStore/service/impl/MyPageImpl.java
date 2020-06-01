package com.example.usStore.service.impl;

import java.util.List;

import com.example.usStore.domain.Account;
import com.example.usStore.domain.Accuse;
import com.example.usStore.domain.BookMark;
import com.example.usStore.domain.Follow;
import com.example.usStore.domain.KeyAlarm;
import com.example.usStore.service.facade.MyPageFacade;

public class MyPageImpl implements MyPageFacade {

	@Override
	public void insertKeyAlarm(KeyAlarm keyAlarm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteKeyAlarm(String KeyAlarmId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<KeyAlarm> ListKeyAlarm(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookMark> getBookMarkList(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertBookMark(BookMark bookMark) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBookMark(String itemId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Follow> getFollowingList(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Follow> getFollowerList(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertFollow(Follow follow) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFollow(int following) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isYourFollower(String follower) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isYourFollowing(String following) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insertAccuse(Accuse accuse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countAccuse(Account account) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
