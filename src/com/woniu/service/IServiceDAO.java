package com.woniu.service;

import java.util.List;

import com.woniu.bean.Team;

public interface IServiceDAO {
	void Save(Team t);
	void Delete(int uid);
	void Update(Team t);
	Team FindOne(int uid);
	List<Team> FindAll();
}
