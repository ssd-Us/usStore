package com.example.usStore.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.usStore.domain.Accuse;

public interface AccuseMapper {

	// 신고하기
	void insertAccuse(Accuse accuse);
	
	// 해당 유저 별 신고 당한 횟수 받아오기
	int countAccuseById(String attacker);
	
	// 판매자와 로그인한 세션유저의 관계가 신고관계인지 아닌지 판단
	String isAccuseAlready(@Param("attacker") String attacker, @Param("victim") String victim);

	//마이페이지에서 로그인유저가 신고한 사람들과 신고이유를 리스트로 받아오기 
	List<Accuse> selectAccuseList(String victim);
	
}
