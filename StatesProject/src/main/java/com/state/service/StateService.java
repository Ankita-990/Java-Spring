package com.state.service;

import java.sql.SQLException;
import java.util.List;

import com.state.model.States;

public interface StateService 
{
	List<States> listOfStates() throws Exception;
	int newState(States state) throws Exception;
	int updateState(States state) throws Exception;
	int deleteState(int id) throws Exception;
	States getStateById(int sid) throws SQLException;
}
