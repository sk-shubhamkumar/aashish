package com.pirate.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection conn = null;
	private static String url = "jdbc:oracle:thin:@10.102.51.10:1521:xe";
	private static String usn = "system";
	private static String pswd = "Capgemini123";
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	
	

	public DBUtil() {
		super();
	}


	public static Connection getCon() throws SQLException, IOException, ClassNotFoundException {
		Class.forName(driver);  
		if (conn == null) {
			conn = DriverManager.getConnection(url, usn, pswd);
		}
		return conn;
	}
}
