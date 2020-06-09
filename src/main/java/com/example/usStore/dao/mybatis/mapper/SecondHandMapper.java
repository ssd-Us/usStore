package com.example.usStore.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.SecondHand;
import com.example.usStore.domain.Item;

public interface SecondHandMapper extends ItemMapper {
	// �쟾泥� SecondHandList 諛쏆븘�삤湲�
	List<SecondHand> getSecondHandList();

	// itemId 留ㅺ컻蹂��닔濡� 諛쏆븘 SecondHand 媛앹껜 諛섑솚
	SecondHand getSecondHandItem(int itemId);

	// SecondHand 異붽�
	public void insertSecondHand(SecondHand secondHand);

	// SecondHand �닔�젙
	public void updateSecondHand(SecondHand secondHand);
	
}
