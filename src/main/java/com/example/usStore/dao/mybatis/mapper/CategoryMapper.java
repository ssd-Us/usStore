
package com.example.usStore.dao.mybatis.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Category;

public interface CategoryMapper {

	List<Category> getCategoryList();

	Category getCategory(int catId);
}
