package com.example.usStore.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.example.usStore.domain.BookMark;

public interface BookMarkDao {

	// ������� �ϸ�ũ ����Ʈ�� �������� �޼ҵ�
	List<BookMark> getBookMarkList() throws DataAccessException;
	
	// �ϸ�ũ �߰� �޼ҵ�
	void insertBookMark(BookMark bookMark) throws DataAccessException;

	// �ϸ�ũ ����Ʈ ����� ���泻�� �����ϴ� �޼ҵ�
	void updateBookMark(BookMark bookMark) throws DataAccessException;

	// �ϸ�ũ ���� �޼ҵ�
	void deleteBookMark(BookMark bookMark) throws DataAccessException;
}
