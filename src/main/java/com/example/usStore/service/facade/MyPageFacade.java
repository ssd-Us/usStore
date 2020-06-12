package com.example.usStore.service.facade;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Account;
import com.example.usStore.domain.Accuse;
import com.example.usStore.domain.BookMark;
import com.example.usStore.domain.Follow;
import com.example.usStore.domain.KeyAlarm;

/*
 * MyPageFacade
 * 
 * keyAlarm / bookMark / follow / accuse
 * */
public interface MyPageFacade {
	
	/////////////////////////////////////////////////////////////////////////
	/* keyAlarm */
	/////////////////////////////////////////////////////////////////////////
	void insertKeyAlarm(KeyAlarm keyAlarm);
	
	void deleteKeyAlarm(String KeyAlarmId);
	
	List<KeyAlarm> ListKeyAlarm(String userId);
	
	/////////////////////////////////////////////////////////////////////////
	/* bookMark */
	/////////////////////////////////////////////////////////////////////////
	List<BookMark> getBookMarkList(String userId);

	void insertBookMark(BookMark bookMark);

	void deleteBookMark(String itemId);

	/////////////////////////////////////////////////////////////////////////
	/* follow */
	/////////////////////////////////////////////////////////////////////////
	List<Follow> getFollowingList(String userId);

	List<Follow> getFollowerList(String userId);

	void insertFollow(Follow follow);

	void deleteFollow(int following);

	boolean isYourFollower (String follower);

	boolean isYourFollowing (String following);
	
	/////////////////////////////////////////////////////////////////////////
	/* accuse */
	/////////////////////////////////////////////////////////////////////////
	void insertAccuse(Accuse accuse);
	
	int countAccuseById(String accounId);
}
