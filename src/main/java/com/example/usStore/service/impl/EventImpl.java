package com.example.usStore.service.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Attendance;
import com.example.usStore.domain.Coupon;
import com.example.usStore.domain.Quiz;
import com.example.usStore.service.facade.EventFacade;

public class EventImpl implements EventFacade {

	@Override
	public List<Quiz> getQuizList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Quiz getRandomQuiz(List<Quiz> quizList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCorrect(String quizId, String answer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Coupon getCoupon(int couponId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCoupon(int couponId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Coupon> getCouponList(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

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
