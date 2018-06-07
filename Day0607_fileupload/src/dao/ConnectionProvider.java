package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	private static final String URL = "jdbc:oracl:thin:@localhost:1521:XE";
	private static final String USER = "lee5656kr";
	private static final String PASSWORD = "qwer4512";
	
	public static Connection getConnection() throws ClassNotFoundException,SQLException{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
}
