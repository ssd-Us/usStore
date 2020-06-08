package com.example.usStore.dao.mybatis.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Attendance;

public interface AttendanceMapper {

	// 달별로 매개변수로 전달받은 사용자가 출석체크를 한 날짜들의 리스트를 받아오는 메소드
	List<Attendance> getAttendanceList(String userId);
	
	// 사용자가 출석체크를 하면 실행되는 메소드. DB에 출석체크 날짜와 사용자 id 입력
	void insertAttendance(Attendance attendance);
}
