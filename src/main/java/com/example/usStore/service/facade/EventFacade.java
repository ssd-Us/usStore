package com.example.usStore.service.facade;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Attendance;
import com.example.usStore.domain.Coupon;
import com.example.usStore.domain.Quiz;

/*
 * EventFacade
 * 
 * Quiz / Coupon / Attendance
 * */
public interface EventFacade {

	/////////////////////////////////////////////////////////////////////////
	/* Quiz */
	/////////////////////////////////////////////////////////////////////////
	List<Quiz> getQuizList();

	Quiz getRandomQuiz(List<Quiz> quizList);

	boolean isCorrect(String quizId, String answer);
	

	/////////////////////////////////////////////////////////////////////////
	/* Coupon */
	/////////////////////////////////////////////////////////////////////////
	Coupon getCoupon(int couponId);

	void insertCoupon(Coupon coupon);

	void deleteCoupon(int couponId);

	List<Coupon> getCouponList(String userId);
	
	/////////////////////////////////////////////////////////////////////////
	/* Attendance */
	/////////////////////////////////////////////////////////////////////////
	List<Attendance> getAttendanceList(String userId) throws DataAccessException;
	
	void insertAttendance(Attendance attendance) throws DataAccessException;
}
