package com.example.usStore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.usStore.dao.TagDao;
import com.example.usStore.dao.mybatis.mapper.TagMapper;
import com.example.usStore.domain.Tag;

@Qualifier("mybatisTagDao")
@Repository
public class MybatisTagDao implements TagDao {

	@Autowired
	private TagMapper tagMapper;
	
	@Override
	public List<Tag> getTagList() throws DataAccessException {
		// TODO Auto-generated method stub
		return tagMapper.getTagList();
	}

	@Override
	public List<Tag> getTagByTagName(String tagName) throws DataAccessException {
		// TODO Auto-generated method stub
		return tagMapper.getTagByTagName("%" + tagName.toLowerCase() + "%");
	}

	@Override
	public void insertTag(Tag tag) throws DataAccessException {
		// TODO Auto-generated method stub
		tagMapper.insertTag(tag);
	}
	
	@Override
	public void deleteTag(int tagId) throws DataAccessException {
		// TODO Auto-generated method stub
		tagMapper.deleteTag(tagId);
	}

	@Override
	public List<Tag> getTagByTagId(int tagId) throws DataAccessException {
		// TODO Auto-generated method stub
		return tagMapper.getTagByTagId(tagId);
	}

	@Override
	public List<Tag> getTagByItemId(int itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		return tagMapper.getTagByItemId(itemId);
	}

	@Override
	public void insertTagList(List<Tag> tags) throws DataAccessException {
		for(Tag t : tags ) {
			tagMapper.insertTag(t);
		}
	}
}
