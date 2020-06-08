package com.example.usStore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.usStore.dao.TagDao;
import com.example.usStore.dao.mybatis.mapper.TagMapper;
import com.example.usStore.domain.Tag;

@Repository
public class MybatisTagDao implements TagDao {

	@Autowired
	private TagMapper tagMapper;
	
	@Override
	public List<Tag> getTagList() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tag getTagByTagId(int tagId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tag getTagByItemId(int itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tag getTagByTagName(String tagName) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertTag(Tag tag) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTag(Tag tag) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTag(int tagId) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
