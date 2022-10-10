package com.ojas.model;

public class Vendor {
	private int  vid;
	private String vendorName;
	private String email;
	private String address;
	public Vendor()
	{
	
	}
	
	public Vendor( int vid, String vendorName,String email, String address) {
		super();
		this.vid = vid;
		this.vendorName = vendorName;
		this.email=email;
		this.address = address;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
		public String getEmail()
		{
			return email;
		}
		public void setEmail(String email)
		{ 
			this.email=email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Vendor [vid=" + vid + ", vendorName=" + vendorName + ", email="+email+", address=" + address + "]";
	}

		
	}
	


