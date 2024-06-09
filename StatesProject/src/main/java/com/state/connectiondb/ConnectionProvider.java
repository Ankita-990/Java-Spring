package com.state.connectiondb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider 
{
	public static Connection getConnection() 	{
		Connection connection = null;
		try {
			Class.forName(ConData.Driver);
			connection = DriverManager.getConnection(ConData.URL, ConData.USER, ConData.PASSWORD);
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
