package com.example.usStore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Supplier;

public interface SupplierDao {
	List<Supplier> getSupplierList() throws DataAccessException;				//�Ǹ��� ����Ʈ �ޱ�
	
	Supplier getSupplier(String supplierId) throws DataAccessException; 		//id �� �ش� �Ǹ��� ã��
	
	public void updateSupplier (String supplierId) throws DataAccessException;  //�Ǹ��� ���� ����
}
