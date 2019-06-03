package com.woniu.service;

import java.util.List;

import com.woniu.bean.Team;
import com.woniu.dao.ITeamDAO;
import com.woniu.dao.TeamDAOImpl;

public class ServiceDAOImpl implements IServiceDAO {
	ITeamDAO td  = new TeamDAOImpl();
	@Override
	public void Save(Team t) {
		// TODO Auto-generated method stub
		td.save(t);
	}

	@Override
	public void Delete(int uid) {
		// TODO Auto-generated method stub
		td.delete(uid);
	}

	@Override
	public void Update(Team t) {
		// TODO Auto-generated method stub
		td.update(t);
	}

	@Override
	public Team FindOne(int uid) {
		// TODO Auto-generated method stub
		Team t = td.find(uid);
		return t;
	}

	@Override
	public List<Team> FindAll() {
		// TODO Auto-generated method stub
		List<Team> list= td.findAll();
		return list;
	}

}
