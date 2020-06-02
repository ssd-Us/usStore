package com.example.usStore.dao.mybatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.usStore.dao.AccountDao;
import com.example.usStore.dao.BookMarkDao;
import com.example.usStore.domain.BookMark;

@Repository
public class MybatisBookMarkDao implements BookMarkDao {

	@Override
	public List<BookMark> getBookMarkList(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertBookMark(BookMark bookMark) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBookMark(String itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
