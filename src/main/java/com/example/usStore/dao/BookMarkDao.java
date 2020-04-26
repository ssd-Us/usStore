package com.example.usStore.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.example.usStore.domain.BookMark;

public interface BookMarkDao {

	// 사용자의 북마크 리스트를 가져오는 메소드
	List<BookMark> getBookMarkList() throws DataAccessException;
	
	// 북마크 추가 메소드
	void insertBookMark(BookMark bookMark) throws DataAccessException;

	// 북마크 리스트 변경시 변경내용 적용하는 메소드
	void updateBookMark(BookMark bookMark) throws DataAccessException;

	// 북마크 삭제 메소드
	void deleteBookMark(BookMark bookMark) throws DataAccessException;
}
