package com.example.usStore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Supplier;

public interface SupplierDao {
	List<Supplier> getSupplierList() throws DataAccessException;				//판매자 리스트 받기
	
	Supplier getSupplier(String supplierId) throws DataAccessException; 		//id 로 해당 판매자 찾기
	
	public void updateSupplier (String supplierId) throws DataAccessException;  //판매자 정보 수정
}
