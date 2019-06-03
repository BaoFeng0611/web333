package com.woniu.dao;

import java.util.List;

import com.woniu.bean.Team;
import com.woniu.util.BaseDao;

public class TeamDAOImpl implements ITeamDAO {
BaseDao<Team> bd = new BaseDao<Team>();
//private Integer uid;
//private String uname;
//private Integer age;
//private Double money;
	@Override
	public void save(Team team) {
		
		// TODO Auto-generated method stub
		String sql = "insert into team values(null,?,?,?)";
		Object[] objs = {team.getUname(),team.getAge(),team.getMoney()};
		bd.update(sql, objs);

	}

	@Override
	public void delete(Integer uid) {
		// TODO Auto-generated method stub
		String sql="delete from team where uid=?";
		Object[] objs={uid};
		bd.update(sql, objs);
	}

	@Override
	public void update(Team team) {
		// TODO Auto-generated method stub
		String sql = "update team set uname=?,age=?,money=? where uid=?";
		Object[] objs={team.getUname(),team.getAge(),team.getMoney(),team.getUid()};
		bd.update(sql, objs);
	}

	@Override
	public Team find(Integer uid) {
		// TODO Auto-generated method stub
		String sql = "select * from team where uid=?";
		Object[] objs={uid};
		List<Team> list = bd.select(sql, objs, Team.class);
		return list.size()==0?null:list.get(0);
	}

	@Override
	public List<Team> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from team";
		Object[] objs = {};
		List<Team> list = bd.select(sql, objs, Team.class);
		return list;
	}

}
