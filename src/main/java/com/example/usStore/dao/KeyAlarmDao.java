package com.example.usStore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.KeyAlarm;

public interface KeyAlarmDao {

	// 키워드 추가하기
	void insertKeyAlarm(KeyAlarm keyAlarm) throws DataAccessException;
	
	// 키워드 삭제하기
	void deleteKeyAlarm(String KeyAlarm_id) throws DataAccessException;
	
	// 매개변수로 전달받은 계정이 설정한 키워드 목록 확인하기
	List<KeyAlarm> ListKeyAlarm(String account_id) throws DataAccessException;
}
