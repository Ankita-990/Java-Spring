package com.product.service;

import java.sql.SQLException;
import java.util.List;

import com.product.model.Product;

public interface ServiceProduct 
{
	List<Product> productServiceList() throws SQLException, ClassNotFoundException;
	int createServiceProduct(Product product) throws SQLException, ClassNotFoundException;
	int updateServiceProduct(Product product) throws SQLException, ClassNotFoundException;
	int deleteServiceProduct(int id) throws SQLException, ClassNotFoundException;
	Product getById(int id) throws SQLException, ClassNotFoundException;
	Product getByName(String name) throws SQLException, ClassNotFoundException;
}
