package com.woniu.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDao<T> {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	public void update(String sql,Object[] objs){
		try {
			conn=JdbcUtil.getConn();
			ps=conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				ps.setObject(i+1, objs[i]);
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.closeConn(null, ps, conn);
		}
	}
	public List<T> select(String sql,Object[] objs,Class<T> c){
		List<T> list = new ArrayList<T>();
		try {
			conn=JdbcUtil.getConn();
			ps=conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				ps.setObject(i+1, objs[i]);
			}
			rs=ps.executeQuery();
			while(rs.next()){
					T t = c.newInstance();
					Method[] methods = c.getMethods();
					for (int i = 0; i < methods.length; i++) {
						//ȡ��ÿ����������
						Method m = methods[i];
						//ȡ��������
						String mName = m.getName();
						//������е�set����  setCname
						if (mName.startsWith("set")) {
							//cname cno tno �������
							String fieldName =mName.substring(3);
							//�����Լ�  course.setCno(rs.getString("cno"));
							Class[] cs = m.getParameterTypes();
							if (cs[0]==Integer.class) {
								m.invoke(t, rs.getInt(fieldName));
							}else if (cs[0]==String.class) {
								m.invoke(t, rs.getString(fieldName));
							}else if (cs[0]==Double.class) {
								m.invoke(t, rs.getDouble(fieldName));
							}
						}
				}
					list.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.closeConn(rs, ps, conn);
		}
		return list;
	}
}
