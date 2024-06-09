package com.product.dao;

import java.sql.SQLException;
import java.util.List;

import com.product.model.Product;

public interface ProductDao 
{
	List<Product> productList() throws SQLException;
	int createProduct(Product product) throws SQLException;
	int updateProduct(Product product) throws SQLException;
	int deleteProduct(int id) throws SQLException;
	Product getProductById(int id) throws SQLException;
	Product getProductByName(String name) throws SQLException; 
}
