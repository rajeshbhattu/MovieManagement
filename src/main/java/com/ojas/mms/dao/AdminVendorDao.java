package com.ojas.mms.dao;

import java.util.List;

import com.ojas.model.Vendor;

public interface AdminVendorDao {
	public String addVendor(String vname,String email,String address);
	public Vendor viewVendor(int vid);
	public List<Vendor> viewAllVendors();
	public String update(int vid,String vendorname,String email,String address);

	public String delete(int vid);
	
	

}
