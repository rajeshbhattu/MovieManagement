package com.ojas.mms.dao;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ojas.mms.db.DBUtility;
import com.ojas.model.Vendor;

public class AdminVendorImpl implements AdminVendorDao {

	public String addVendor(String vendorName, String vendorEmail, String address) {
		String msg = "";
		try {
			Connection con = DBUtility.getConnection();
			System.out.println("addvendor1");
			PreparedStatement ps = con.prepareStatement("INSERT INTO vendor(vname,vemail,vaddress) VALUES(?,?,?)");
			ps.setString(1,vendorName);
			ps.setString(2, vendorEmail);
		ps.setString(3, address);
	
			int n = ps.executeUpdate();
			
			if(n!=0) {
				msg = "Successfully Vendror added......";
			}else {
				msg = "Notable to added.Please try again...";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}

	public Vendor viewVendor(int vid) {
		Vendor v=new Vendor();
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from vendor where vid=?");
			ps.setInt(1,vid);
		
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				v.setVid(rs.getInt(1));
			v.setVendorName(rs.getString(2));
			v.setEmail(rs.getString(3));
			v.setAddress(rs.getString(4));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
return v;
}
	public List<Vendor> viewAllVendors() {
	
List<Vendor> vendor=new ArrayList<Vendor>();
		Vendor v=new Vendor();
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from vendor ");
			
		
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				v.setVid(rs.getInt(1));
			v.setVendorName(rs.getString(2));
			v.setEmail(rs.getString(3));
			v.setAddress(rs.getString(4));
			vendor.add(v);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
return vendor;
}
	public String update(int vid,String vendorname,String email,String address) {
		
		String msg="";
		
		System.out.println("hello world gm");
				
				try {
					Connection con = DBUtility.getConnection();
					PreparedStatement ps = con.prepareStatement("update vendor set vname=?,vemail=?,vaddress=? where vid=?");
						
					ps.setString(1,vendorname);
					ps.setString(2,email);
				   ps.setString(3,address);
				   ps.setInt(4, vid);
				   
		int i	=ps.executeUpdate();
				
		if(i!=0)
		{
			 msg="records inserted";
		}
		else
		{
		msg="records not inserted";
		}
		
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		return msg;
}
	public String delete(int vid)
	{
		String msg="";
	try 
	{
	Connection con = DBUtility.getConnection();
		PreparedStatement ps = con.prepareStatement("delete  from vendor where vid=?");
       ps.setInt(1,vid);
		int i	=ps.executeUpdate();
	
		
if(i!=0)
{
 msg="records deleted sucessfully";
}
else
{
	msg="records not deleted";
}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
return msg;
}

}
	
