package com.example.usStore.dao.mybatis.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Tag;

public interface TagMapper {

	//아이템 아이디로 태그 객체 찾기
	List<Tag> getTagList () throws DataAccessException;

	// 태그 이름으로 태그 객체 찾기(검색 기능에 이용?)
	Tag getTagByTagId(int tagId) throws DataAccessException;

	// itemId로 태그 객체 찾기
	Tag getTagByItemId(int itemId) throws DataAccessException;	

	// tagName으로 태그 객체 찾기
	Tag getTagByTagName(String tagName) throws DataAccessException;	

	//태그 객체 삽입
	void insertTag(Tag tag) throws DataAccessException;

	//태그 객체 수정
	void updateTag(Tag tag) throws DataAccessException;	

	//태그 객체 삭제	
	void deleteTag(int tagId) throws DataAccessException;	
}
