package com.woniu.dao;

public class DAOFactory {
	public static ITeamDAO getTeamDAO(){
		return new TeamDAOImpl();
	}
}
