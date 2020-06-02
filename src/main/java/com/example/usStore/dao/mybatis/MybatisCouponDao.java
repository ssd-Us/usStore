package com.example.usStore.dao.mybatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.usStore.dao.AccountDao;
import com.example.usStore.dao.CouponDao;
import com.example.usStore.domain.Coupon;

@Repository
public class MybatisCouponDao implements CouponDao {

	@Override
	public Coupon getCoupon(int couponId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCoupon(Coupon coupon) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCoupon(int couponId) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Coupon> getCouponList(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
