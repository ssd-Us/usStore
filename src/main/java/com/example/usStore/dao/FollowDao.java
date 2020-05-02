package com.example.usStore.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.example.usStore.domain.Follow;

public interface FollowDao {

	// ������� ��ü �ȷ��� ������ �������� �޼ҵ�
	List<Follow> getFollowingList(String user_id) throws DataAccessException;
	
	// ������� ��ü �ȷο� ������ �������� �޼ҵ�
	List<Follow> getFollowerList(String user_id) throws DataAccessException;
	
	// �ȷ��� �߰� �޼ҵ�
	void insertFollow(Follow follow) throws DataAccessException;

	// �b���� ���� �޼ҵ�
	void deleteFollow(Follow follow) throws DataAccessException;
	
	// ���� �ȷ����ϴ� ��������� �˷��ִ� �޼ҵ�
	boolean isYourFollower (String follower_id) throws DataAccessException;
	
	// ���� �ȷ����ϴ� ��������� �˷��ִ� �޼ҵ� 
	boolean isYourFollowing (String following_id) throws DataAccessException;
}
