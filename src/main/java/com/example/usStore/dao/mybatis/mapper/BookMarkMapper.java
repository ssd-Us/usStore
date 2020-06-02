package com.example.usStore.dao.mybatis.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.BookMark;

public interface BookMarkMapper {

	// 사용자의 북마크 리스트를 가져오는 메소드
<<<<<<< HEAD
	List<BookMark> getBookMarkList(String userId);

	// 북마크 추가 메소드
	void insertBookMark(BookMark bookMark);

	// 북마크 삭제 메소드
	void deleteBookMark(String itemId);
=======
	List<BookMark> getBookMarkList(String userId) throws DataAccessException;

	// 북마크 추가 메소드
	void insertBookMark(BookMark bookMark) throws DataAccessException;

	// 북마크 삭제 메소드
	void deleteBookMark(String itemId) throws DataAccessException;
>>>>>>> branch 'test' of https://github.com/ssd-Us/usStore.git
}
