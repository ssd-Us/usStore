package com.example.usStore.dao.mybatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.usStore.dao.AccountDao;
import com.example.usStore.dao.KeyAlarmDao;
import com.example.usStore.domain.KeyAlarm;

@Repository
public class MybatisKeyAlarmDao implements KeyAlarmDao {

	@Override
	public void insertKeyAlarm(KeyAlarm keyAlarm) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteKeyAlarm(String KeyAlarmId) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<KeyAlarm> ListKeyAlarm(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
