package com.example.usStore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.KeyAlarm;

public interface KeyAlarmDao {

	// Ű���� �߰��ϱ�
	void insertKeyAlarm(KeyAlarm keyAlarm) throws DataAccessException;
	
	// Ű���� �����ϱ�
	void deleteKeyAlarm(String KeyAlarm_id) throws DataAccessException;
	
	// �Ű������� ���޹��� ������ ������ Ű���� ��� Ȯ���ϱ�
	List<KeyAlarm> ListKeyAlarm(String account_id) throws DataAccessException;
}
