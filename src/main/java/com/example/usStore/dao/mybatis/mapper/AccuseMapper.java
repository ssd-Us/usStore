package com.example.usStore.dao.mybatis.mapper;

import com.example.usStore.domain.Accuse;

public interface AccuseMapper {

	// 신고하기
	void insertAccuse(Accuse accuse);
	
	// 해당 유저 별 신고 당한 횟수 받아오기
	int countAccuseById(String attacker);
	
	boolean isAccuseAlready(String attacker, String victim);
}
