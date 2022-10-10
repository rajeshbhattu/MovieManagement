package com.ojas.mms.dao;

public interface LoginDAO {
	
	public String login(String username,String password);
	public String forgot(String username,String rtype);

}
