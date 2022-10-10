
<%@ page import="com.ojas.mms.dao.AdminVendorImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ojas.mms.dao.*" %>
<%@ page import="com.ojas.mms.db.*" %>
<%@ page import="java.sql.*,java.util.*"%>


<%@ page import="java.util.List" %>
<%!ResultSet rs = null;%>
<%
String msg="";

int vid1=Integer.parseInt(request.getParameter("vid"));
Connection con = DBUtility.getConnection();
	PreparedStatement ps = con.prepareStatement("delete  from vendors where vid=?");
   ps.setInt(1,vid1);
	int i	=ps.executeUpdate();


	
if(i!=0)
{
out.println ("records deleted sucessfully");
}
else{
out.println("not deleted");
}
%>

    