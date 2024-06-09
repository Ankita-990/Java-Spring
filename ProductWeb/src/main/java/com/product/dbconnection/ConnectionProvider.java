package com.product.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider 
{
	public static Connection getConnection() //throws SQLException, ClassNotFoundException
	{
		Connection connection = null;
		try {
			Class.forName(Const.url);
			connection = DriverManager.getConnection(Const.path, Const.user, Const.pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
}
