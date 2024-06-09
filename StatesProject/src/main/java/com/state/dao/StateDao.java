package com.state.dao;

import java.sql.SQLException;
import java.util.List;

import com.state.model.States;

public interface StateDao 
{	
	List<States> stateList() throws SQLException;
	int create(States state) throws SQLException; 
	int update(States state) throws SQLException;
	int delete(int id) throws SQLException;
	States getRowById(int id) throws SQLException;
}
