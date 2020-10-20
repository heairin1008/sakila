package sakila.util;

import java.sql.*;

public class DBUtil {
	public Connection getConnection() throws Exception{
		Connection conn = null;
		
		String url= "jdbc:mariadb://localhost:3306/sakila";
		String user = "root";
		String password = "java1004";
		
		conn = DriverManager.getConnection(url, user, password);
		conn.setAutoCommit(false);
		
		return conn;
	}
}
