package com.example.usStore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.usStore.dao.AttendanceDao;
import com.example.usStore.dao.CouponDao;
import com.example.usStore.dao.QuizDao;
import com.example.usStore.domain.Attendance;
import com.example.usStore.domain.Coupon;
import com.example.usStore.domain.Quiz;
import com.example.usStore.service.facade.EventFacade;

/*
 * EventImpl
 * 
 * Quiz / Coupon / Attendance
 * */
@Service("eventImpl")
@Transactional
public class EventImpl implements EventFacade {

	@Autowired
	private QuizDao quizDao;
	@Autowired
	private CouponDao couponDao;
	@Autowired
	private AttendanceDao attendanceDao;
	
	@Override
	public List<Quiz> getQuizList() {
		// TODO Auto-generated method stub
		return quizDao.getQuizList();
	}

	@Override
	public Quiz getRandomQuiz(List<Quiz> quizList) {
		// TODO Auto-generated method stub
		return quizDao.getRandomQuiz(quizList);
	}

	@Override
	public boolean isCorrect(String quizId, String answer) {
		// TODO Auto-generated method stub
		return quizDao.isCorrect(quizId, answer);
	}

	@Override
	public Coupon getCoupon(int couponId) {
		// TODO Auto-generated method stub
		return couponDao.getCoupon(couponId);
	}

	@Override
	public void insertCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		couponDao.insertCoupon(coupon);
	}

	@Override
	public void deleteCoupon(int couponId) {
		// TODO Auto-generated method stub
		couponDao.deleteCoupon(couponId);
	}

	@Override
	public List<Coupon> getCouponList(String userId) {
		// TODO Auto-generated method stub
		return couponDao.getCouponList(userId);
	}

	@Override
	public List<Attendance> getAttendanceList(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return attendanceDao.getAttendanceList(userId);
	}

	@Override
	public void insertAttendance(Attendance attendance) throws DataAccessException {
		// TODO Auto-generated method stub
		attendanceDao.insertAttendance(attendance);
	}
	
}
