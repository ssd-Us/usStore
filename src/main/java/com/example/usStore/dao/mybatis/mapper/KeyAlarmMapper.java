package com.example.usStore.dao.mybatis.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.KeyAlarm;

public interface KeyAlarmMapper {

	// 키워드 추가하기
	void insertKeyAlarm(KeyAlarm keyAlarm);
	
	// 키워드 삭제하기
	void deleteKeyAlarm(String KeyAlarmId);
	
	// 매개변수로 전달받은 계정이 설정한 키워드 목록 확인하기
	List<KeyAlarm> ListKeyAlarm(String userId);
}
