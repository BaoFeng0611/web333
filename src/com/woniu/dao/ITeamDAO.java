package com.woniu.dao;

import java.util.List;

import com.woniu.bean.Team;

public interface ITeamDAO {
//	private Integer uid;
//	private String uname;
//	private Integer age;
//	private Double money;
	void save(Team team);
	void delete(Integer uid);
	void update(Team team);
	Team find(Integer uid);
	List<Team> findAll();
	
}
