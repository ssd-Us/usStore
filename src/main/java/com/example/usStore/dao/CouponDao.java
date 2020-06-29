package com.example.usStore.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.example.usStore.domain.Coupon;

public interface CouponDao {

	// couponId로 해당 쿠폰의 객체를 받아오는 메소드
	Coupon getCoupon(int couponId) throws DataAccessException;

	// 쿠폰 추가 메소드
	void insertCoupon(Coupon coupon) throws DataAccessException;

	// 쿠폰 삭제 메소드
	void deleteCoupon(int couponId) throws DataAccessException;

	// 사용자가 가지고 있는 쿠폰의 전체 리스트를 가져오는 메소드
	List<Coupon> getCouponList(String userId) throws DataAccessException;
}
