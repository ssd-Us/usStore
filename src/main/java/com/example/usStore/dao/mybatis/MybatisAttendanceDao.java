package com.example.usStore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.usStore.dao.AccountDao;
import com.example.usStore.dao.AttendanceDao;
import com.example.usStore.dao.mybatis.mapper.AttendanceMapper;
import com.example.usStore.domain.Attendance;

@Repository
public class MybatisAttendanceDao implements AttendanceDao {

	@Autowired
	private AttendanceMapper attendanceMapper;
	
	@Override
	public List<Attendance> getAttendanceList(String user_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertAttendance(Attendance attendance) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
