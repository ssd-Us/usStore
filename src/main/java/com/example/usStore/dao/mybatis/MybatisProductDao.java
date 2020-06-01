package com.example.usStore.dao.mybatis;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.usStore.dao.ProductDao;
import com.example.usStore.dao.mybatis.mapper.ProductMapper;
import com.example.usStore.domain.Product;

@Repository
public class MybatisProductDao implements ProductDao {
	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<Product> getProductListByCategory(int catId) throws DataAccessException {
		// TODO Auto-generated method stub
		return productMapper.getProductListByCategory(catId);
	}

	@Override
	public Product getProduct(int productId) throws DataAccessException {
		// TODO Auto-generated method stub
		return productMapper.getProduct(productId);
	}	

	public List<Product> searchProductList(String keywords) 
			throws DataAccessException {
	    return productMapper.searchProductList(
	    	"%" + keywords.toLowerCase() + "%");
	}

	/* Inner Classes */
	public static class ProductSearch {

		private List<String> keywordList = new ArrayList<String>();

		public ProductSearch(String keywords) {
			StringTokenizer splitter = new StringTokenizer(keywords," ",false);
			while (splitter.hasMoreTokens()) {
				this.keywordList.add("%" + splitter.nextToken() + "%");
			}
		}
		public List<String> getKeywordList() {
			return keywordList;
		}
	}
}
