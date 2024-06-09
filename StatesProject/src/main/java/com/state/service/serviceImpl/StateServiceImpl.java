package com.state.service.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.state.connectiondb.ConnectionProvider;
import com.state.dao.StateDao;
import com.state.dao.daoImpl.StateDaoImpl;
import com.state.model.States;
import com.state.service.StateService;

public class StateServiceImpl implements StateService //throws Exception
{
	Connection connection = ConnectionProvider.getConnection();
	
	public List<States> listOfStates() throws Exception
	{
//		Connection connection = ConnectionProvider.getConnection();
		
		ArrayList<States> states = new ArrayList<>();		
		
		StateDao dao = new StateDaoImpl(connection);
		
		states = (ArrayList<States>) dao.stateList();
		
		return states;	
	}
	
	public int newState(States state) throws Exception
	{	
		StateDao dao = new StateDaoImpl(connection);
		int newRow = dao.create(state);
		
		return newRow;
	}
	
	public int updateState(States state) throws Exception
	{
		StateDao dao = new StateDaoImpl(connection);
		int update = dao.update(state);
		return update;
	}
	
	public int deleteState(int id) throws Exception
	{
		StateDao dao = new StateDaoImpl(connection);
		int delete = dao.delete(id);
		return delete;
	}
	
	
	public States getStateById(int sid) throws SQLException 
	{
		States state = new States();
		Connection connection = ConnectionProvider.getConnection();
		StateDao dao = new StateDaoImpl(connection);
		state = dao.getRowById(sid);
		return state;
	}
	
}
