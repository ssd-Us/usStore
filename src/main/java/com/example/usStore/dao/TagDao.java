package com.example.usStore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Tag;


public interface TagDao {
	List<Tag> getTagList () throws DataAccessException;

	Tag getTagByTagId(int tagId) throws DataAccessException;	//태그 아이디로 태그 객체 찾기
	
	Tag getTagByItemId(int itemId) throws DataAccessException;	//아이템 아이디로 태그 객체 찾기
	
	Tag getTagByTagName(String tagName) throws DataAccessException;	//태그 이름으로 태그 객체 찾기(검색 기능에 이용?)

	void insertTag(Tag tag) throws DataAccessException;	//태그 객체 삽입
	
	void updateTag(Tag tag) throws DataAccessException;	//태그 객체 수정
	
	void deleteTag(Tag tag) throws DataAccessException;	//태그 객체 삭제	
}
