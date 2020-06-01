package com.example.usStore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Product;

public interface ProductDao {

	// 카테고리 아이디 별 Product List 받아오기
	List<Product> getProductListByCategory(String categoryId) throws DataAccessException;

	// keyword 받아서 product search
	List<Product> searchProductList(String keywords) throws DataAccessException;

	// ProductId로 Product 가져오기
	Product getProduct(String productId) throws DataAccessException;

}
