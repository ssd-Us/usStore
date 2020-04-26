package com.example.usStore.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.example.usStore.domain.Coupon;

public interface CouponDao {

	// coupon_id�� �ش� ������ ��ü�� �޾ƿ��� �޼ҵ�
	Coupon getCoupon(String coupon_id) throws DataAccessException;

	// ���� �߰� �޼ҵ�
	void insertCoupon(Coupon coupon) throws DataAccessException;
	
	// ���� ���� �޼ҵ�
	void deleteCoupon(String coupon_id) throws DataAccessException;

	// ����ڰ� ������ �ִ� ������ ��ü ����Ʈ�� �������� �޼ҵ�
	List<Coupon> getCouponList(String user_id) throws DataAccessException;
}
