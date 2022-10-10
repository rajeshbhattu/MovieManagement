package com.ojas.mms.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtility {

	public static  Connection con=null;

	public static Connection getConnection() {
		try {
			File path = new File("C:\\Users\\rb22003\\Desktop\\MovieManagementSystem1\\src\\main\\resources\\db.properties");
			FileInputStream fis = new FileInputStream(path);
			Properties p = new Properties();
			p.load(fis);
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mms", "root","root");
			if(con!=null) {
				System.out.println("---connection established----");
			}else {
				System.out.println("---Not connected----");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return con;

	}

}
