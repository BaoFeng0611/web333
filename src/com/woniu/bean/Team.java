package com.woniu.bean;

public class Team {
	private Integer uid;
	private String uname;
	private Integer age;
	private Double money;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	
	public Team() {
		super();
	}
	public Team(Integer uid, String uname, Integer age, Double money) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.age = age;
		this.money = money;
	}
	@Override
	public String toString() {
		return "team [uid=" + uid + ", uname=" + uname + ", age=" + age + ", money=" + money + "]";
	}
	
}
