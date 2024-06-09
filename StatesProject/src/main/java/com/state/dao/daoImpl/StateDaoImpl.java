package com.state.dao.daoImpl;

import java.sql.Connection;	
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.state.connectiondb.ConnectionProvider;
import com.state.connectiondb.DbSingleObj;
import com.state.dao.StateDao;
import com.state.model.States;


public class StateDaoImpl extends DbSingleObj implements StateDao
{
	public StateDaoImpl(Connection connection) {
		this.connection = connection;
	}
	
	public int create(States state) throws SQLException
	{
		int newRow = 0;
		
		String insertQuery = "insert into states(sid, sname) values(?, ?)";
		PreparedStatement pstat = connection.prepareStatement(insertQuery);
		pstat.setInt(1, state.getSid());
		pstat.setString(2, state.getSname());
		newRow = pstat.executeUpdate();
		
		return newRow;
	}
	
	public int update(States state) throws SQLException
	{
		int updateRow;
		String updateQuery = "update states set sname=? where sid=?";
		PreparedStatement pstat = connection.prepareStatement(updateQuery);
		pstat.setInt(2, state.getSid());
		pstat.setString(1, state.getSname());
		updateRow = pstat.executeUpdate();
		
		return updateRow;
	}
	
	public int delete(int id) throws SQLException
	{
		int deleteRow;
		String deleteQuery = "delete from states where sid=?";
		PreparedStatement pstat = connection.prepareStatement(deleteQuery);
		pstat.setInt(1, id);
		deleteRow = pstat.executeUpdate();
		return deleteRow;
	}
	
	public List<States> stateList()
	{
		ArrayList<States> stateList = new ArrayList<States>();
		
		try {
			
			String query = "select sid, sname from states";
			PreparedStatement ps = connection.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				States state = new States();
				state.setSid(rs.getInt(1));
				state.setSname(rs.getString(2));
				
				stateList.add(state);
			}
		}	
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return stateList;
	}	
	
	public States getRowById(int id) throws SQLException
	{
		States state = new States();
		String getId = "select sid,sname from states where sid=?";
		PreparedStatement pstat = connection.prepareStatement(getId);
		pstat.setInt(1, id);
		
		ResultSet rs = pstat.executeQuery();
		state.setSid(rs.getInt("sid"));
		state.setSname(rs.getString("sname"));
//		while(rs.next()) {
//			state.setSid(rs.getInt("sid"));
//			state.setSname(rs.getString("sname"));
//		}
		
		return state;
	}

	
}


