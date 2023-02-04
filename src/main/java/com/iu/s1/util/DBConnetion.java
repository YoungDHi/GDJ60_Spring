package com.iu.s1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnetion {

	public static Connection getConnection() throws Exception {
		
		String user = "USER01";
		String password = "USER01";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String diver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(diver);
		
		return DriverManager.getConnection(url, user, password);
		
	}
	
	public static void disconnect(PreparedStatement st, Connection connection) throws Exception {
		
		st.close();
		connection.close();
		
	}
	
	public static void disconnect(ResultSet rs, PreparedStatement st, Connection connection) throws Exception {
		
		rs.close();
		
		st.close();
		
		connection.close();
		
	}
	
}
