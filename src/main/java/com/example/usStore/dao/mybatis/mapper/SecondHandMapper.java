package com.example.usStore.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.SecondHand;
import com.example.usStore.domain.Item;

public interface SecondHandMapper extends ItemMapper {
	// 전체 SecondHandList 받아오기
	List<SecondHand> getSecondHandList();

	// itemId 매개변수로 받아 SecondHand 객체 반환
	SecondHand getSecondHandItem(int itemId);

	// SecondHand 추가
	public void insertSecondHand(SecondHand secondHand);

	// SecondHand 수정
	public void updateSecondHand(SecondHand secondHand);
	
}
