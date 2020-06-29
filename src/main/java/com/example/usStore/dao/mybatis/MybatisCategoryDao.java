package com.example.usStore.dao.mybatis;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.example.usStore.dao.CategoryDao;
import com.example.usStore.dao.mybatis.mapper.CategoryMapper;
import com.example.usStore.domain.Category;

@Repository
public class MybatisCategoryDao implements CategoryDao {
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	public List<Category> getCategoryList() throws DataAccessException {
		return categoryMapper.getCategoryList();
	}
	
	@Override
	public Category getCategory(int categoryId) throws DataAccessException {
		// TODO Auto-generated method stub
		return categoryMapper.getCategory(categoryId);
	}
}
