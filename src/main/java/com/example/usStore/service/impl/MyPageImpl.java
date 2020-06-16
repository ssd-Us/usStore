package com.example.usStore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.usStore.dao.AccuseDao;
import com.example.usStore.dao.BookMarkDao;
import com.example.usStore.dao.FollowDao;
import com.example.usStore.dao.KeyAlarmDao;
import com.example.usStore.domain.Accuse;
import com.example.usStore.domain.BookMark;
import com.example.usStore.domain.Follow;
import com.example.usStore.domain.KeyAlarm;
import com.example.usStore.service.facade.MyPageFacade;

/*
 * MyPageFacade
 * 
 * keyAlarm / bookMark / follow / accuse
 * */
@Service("mypageImpl")
@Transactional
public class MyPageImpl implements MyPageFacade {

	@Autowired
	private KeyAlarmDao keyAlarmDao;
	@Autowired
	private BookMarkDao bookMarkDao;
	@Autowired
	private FollowDao followDao;
	@Autowired
	private AccuseDao accuseDao;
	
	@Override
	public void insertKeyAlarm(KeyAlarm keyAlarm) {
		// TODO Auto-generated method stub
		keyAlarmDao.insertKeyAlarm(keyAlarm);
	}

	@Override
	public void deleteKeyAlarm(String KeyAlarmId) {
		// TODO Auto-generated method stub
		keyAlarmDao.deleteKeyAlarm(KeyAlarmId);
	}

	@Override
	public List<KeyAlarm> ListKeyAlarm(String userId) {
		// TODO Auto-generated method stub
		return keyAlarmDao.ListKeyAlarm(userId);
	}

	@Override
	public List<BookMark> getBookMarkList(String userId) {
		// TODO Auto-generated method stub
		return bookMarkDao.getBookMarkList(userId);
	}

	@Override
	public void insertBookMark(BookMark bookMark) {
		// TODO Auto-generated method stub
		bookMarkDao.insertBookMark(bookMark);
	}

	@Override
	public void deleteBookMark(String itemId) {
		// TODO Auto-generated method stub
		bookMarkDao.deleteBookMark(itemId);
	}

	@Override
	public List<Follow> getFollowingList(String userId) {
		// TODO Auto-generated method stub
		return followDao.getFollowerList(userId);
	}

	@Override
	public List<Follow> getFollowerList(String userId) {
		// TODO Auto-generated method stub
		return followDao.getFollowerList(userId);
	}

	@Override
	public void insertFollow(Follow follow) {
		// TODO Auto-generated method stub
		followDao.insertFollow(follow);
	}

	@Override
	public void deleteFollow(int following) {
		// TODO Auto-generated method stub
		followDao.deleteFollow(following);
	}

	@Override
	public boolean isYourFollower(String follower) {
		// TODO Auto-generated method stub
		return followDao.isYourFollower(follower);
	}

	@Override
	public boolean isYourFollowing(String following) {
		// TODO Auto-generated method stub
		return followDao.isYourFollowing(following);
	}

	@Override
	public void insertAccuse(Accuse accuse) {
		accuse.setAttacker("B");
		accuse.setReason("신고이유 원래는 자바스크립트에서 넘겨줌");
		accuse.setVictim("A");
		accuseDao.insertAccuse(accuse);
	}

	@Override
	public int countAccuseById(String accountId) {
		// TODO Auto-generated method stub
		return accuseDao.countAccuseById(accountId);
	}

	@Override
	public boolean isAccuseAlready(String attacker, String victim) {
		return accuseDao.isAccuseAlready(attacker, victim);
	}

}
