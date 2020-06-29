package com.example.usStore.dao.mybatis.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Tag;

public interface TagMapper {

	//�븘�씠�뀥 �븘�씠�뵒濡� �깭洹� 媛앹껜 李얘린
	List<Tag> getTagList ();

	// �깭洹� �씠由꾩쑝濡� �깭洹� 媛앹껜 李얘린(寃��깋 湲곕뒫�뿉 �씠�슜?)
	List<Tag> getTagByTagId(int tagId);

	// itemId濡� �깭洹� 媛앹껜 李얘린
	List<Tag> getTagByItemId(int itemId);	

	// tagName�쑝濡� �깭洹� 媛앹껜 李얘린
	Tag getTagByTagName(String tagName);	

	//�깭洹� 媛앹껜 �궫�엯
	void insertTag(Tag tag);

	//�깭洹� 媛앹껜 �궘�젣	
	void deleteTag(int itemId);	
}
