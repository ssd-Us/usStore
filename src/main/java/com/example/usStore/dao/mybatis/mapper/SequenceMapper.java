package com.example.usStore.dao.mybatis.mapper;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Sequence;

public interface SequenceMapper {
//  Sequence getSequence(Sequence sequence);
//  Sequence getOracleSequence(Sequence sequence);
//  void updateSequence(Sequence sequence);
  
	// 시퀀스 받아오기
	public int getSequence(String name);
	
	// 시퀀스 수정하기
	public void updateSequence(int nextId, int name);
}
