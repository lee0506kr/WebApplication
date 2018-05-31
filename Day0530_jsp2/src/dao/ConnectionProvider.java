package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	// DBMS���� ������ �������ִ� Ŭ����
	// �갡 �ؾ� �Ǵ� ��� : ���� ��ȯ, Ŭ���� ����(��� ������ �̿��ؼ� ���� �۾��� �ϱ� ������, ��ü���� ������ �ʿ䰡 ����:
	// static ����)
	// ������ ����� ���� ���ؼ� �ʿ��� ���°�: url, user, password

	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER = "lee5656kr";
	private static final String PASSWORD = "qwer4512";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// 1. ����̹� �ε�
		// 2. �����ϰ�, ��ȯ
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

}
