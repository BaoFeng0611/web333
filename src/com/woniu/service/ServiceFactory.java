package com.woniu.service;

public class ServiceFactory {
	public static IServiceDAO getServiceDAO(){
		return new ServiceDAOImpl();
	}
}
