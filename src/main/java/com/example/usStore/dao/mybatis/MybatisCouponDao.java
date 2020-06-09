package com.example.usStore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.usStore.dao.AccountDao;
import com.example.usStore.dao.CouponDao;
import com.example.usStore.dao.mybatis.mapper.CouponMapper;
import com.example.usStore.domain.Coupon;

@Repository
public class MybatisCouponDao implements CouponDao {

	@Autowired
	private CouponMapper couponMapper;
	
	@Override
	public Coupon getCoupon(int couponId) throws DataAccessException {
		// TODO Auto-generated method stub
		return couponMapper.getCoupon(couponId);
	}

	@Override
	public void insertCoupon(Coupon coupon) throws DataAccessException {
		// TODO Auto-generated method stub
		couponMapper.insertCoupon(coupon);
	}

	@Override
	public void deleteCoupon(int couponId) throws DataAccessException {
		// TODO Auto-generated method stub
		couponMapper.deleteCoupon(couponId);
	}

	@Override
	public List<Coupon> getCouponList(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return couponMapper.getCouponList(userId);
	}

}
