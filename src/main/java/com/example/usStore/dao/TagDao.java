package com.example.usStore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Tag;


public interface TagDao {
	List<Tag> getTagList () throws DataAccessException;

	Tag getTagByTagId(int tagId) throws DataAccessException;	//�±� ���̵�� �±� ��ü ã��
	
	Tag getTagByItemId(int itemId) throws DataAccessException;	//������ ���̵�� �±� ��ü ã��
	
	Tag getTagByTagName(String tagName) throws DataAccessException;	//�±� �̸����� �±� ��ü ã��(�˻� ��ɿ� �̿�?)

	void insertTag(Tag tag) throws DataAccessException;	//�±� ��ü ����
	
	void updateTag(Tag tag) throws DataAccessException;	//�±� ��ü ����
	
	void deleteTag(Tag tag) throws DataAccessException;	//�±� ��ü ����	
}
