package com.example.usStore.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.example.usStore.domain.Attendance;

public interface AttendanceDao {

	// �޺��� �Ű������� ���޹��� ����ڰ� �⼮üũ�� �� ��¥���� ����Ʈ�� �޾ƿ��� �޼ҵ�
	List<Attendance> getAttendanceList(String user_id) throws DataAccessException;
	
	// ����ڰ� �⼮üũ�� �ϸ� ����Ǵ� �޼ҵ�. DB�� �⼮üũ ��¥�� ����� id �Է�
	void insertAttendance(Attendance attendance) throws DataAccessException;
}
