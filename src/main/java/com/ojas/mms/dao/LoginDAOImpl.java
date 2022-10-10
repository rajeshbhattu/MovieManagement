package com.ojas.mms.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ojas.mms.db.DBUtility;

public class LoginDAOImpl implements LoginDAO {
	
	public String login(String username, String password) {
		
		String rollName=null;
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"SELECT rname FROM mms.role WHERE rid = (SELECT rid FROM mms.user u WHERE u.uname=? AND u.password=?)");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			rs.next();
			rollName = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rollName;
	}

	public String forgot(String username, String rtype) {
		String password = null;
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"SELECT u.password FROM mms.users u WHERE u.username=? AND u.rid=(SELECT rid FROM mms.role WHERE roll_name=?)");
			ps.setString(1, username);
			ps.setString(2, rtype);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			password = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}

}
