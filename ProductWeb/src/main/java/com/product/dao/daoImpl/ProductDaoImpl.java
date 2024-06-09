package com.product.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.product.dao.ProductDao;
import com.product.dbconnection.DBSingle;
import com.product.model.Product;

public class ProductDaoImpl extends DBSingle implements ProductDao
{
	public ProductDaoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Product> productList() throws SQLException {
		ArrayList<Product> productList = new ArrayList<Product>();
		String query = "select pid, pname, pdesc, pcatagory from product";
		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Product product = new Product();
			product.setPid(rs.getInt(1));
			product.setPname(rs.getString(2));
			product.setPdesc(rs.getString(3));
			product.setPcatagory(rs.getString(4));
			productList.add(product);
		}
		return productList;
	}

	@Override
	public int createProduct(Product product) throws SQLException {
		int insert;
		String query = "insert into product(pid,pname,pdesc,pcatagory) values(?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, product.getPid());
		ps.setString(2, product.getPname());
		ps.setString(3, product.getPdesc());
		ps.setString(4, product.getPcatagory());
		insert = ps.executeUpdate();
		return insert;
	}

	@Override
	public int updateProduct(Product product) throws SQLException {
		int update;
		String query = "update product set pname=?, pdesc=?, pcatagory=? where pid=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(4, product.getPid());
		ps.setString(1, product.getPname());
		ps.setString(2, product.getPdesc());
		ps.setString(3, product.getPcatagory());
		update = ps.executeUpdate();
		return update;
	}

	@Override
	public int deleteProduct(int id) throws SQLException {
		int delete;
		String query = "delete from product where pid=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, id);
		delete = ps.executeUpdate();
		return delete;
	}

	@Override
	public Product getProductById(int id) throws SQLException {
		Product product = new Product();
		String query = "select pid,pname,pdesc,pcatagory from product where pid=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			product.setPid(rs.getInt("pid"));
			product.setPname(rs.getString("pname"));
			product.setPdesc(rs.getString("pdesc"));
			product.setPcatagory(rs.getString("pcatagory"));
		}
		return product;
	}
	
	@Override
	public Product getProductByName(String name) throws SQLException {
		Product product = new Product();
		String query = "select pid,pname,pdesc,pcatagory from product where pname=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			product.setPid(rs.getInt(1));
			product.setPname(rs.getString(2));
			product.setPdesc(rs.getString(3));
			product.setPcatagory(rs.getString(4));
		}
		return product;
	}

}
