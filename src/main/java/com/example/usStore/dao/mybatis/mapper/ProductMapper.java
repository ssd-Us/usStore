package com.example.usStore.dao.mybatis.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Product;

/**
 * @author Eduardo Macarron
 *
 */
public interface ProductMapper {

	List<Product> getProductListByCategory(int catId);

	Product getProduct(int productId);

	List<Product> searchProductList(String keywords);

}
