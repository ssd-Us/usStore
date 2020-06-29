package com.example.usStore.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.example.usStore.domain.BookMark;

public interface BookMarkDao {

	// 사용자의 북마크 리스트를 가져오는 메소드
	List<BookMark> getBookMarkList(String userId) throws DataAccessException;

	// 북마크 추가 메소드
	void insertBookMark(BookMark bookMark) throws DataAccessException;

	// 북마크 삭제 메소드
	void deleteBookMark(String itemId) throws DataAccessException;
}
