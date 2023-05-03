package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class JDBCUtil {
	public static Connection getConnection1() {
		Connection connection = null;
		try {
			// Đăng kí MySQL 
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			String url = "jdbc:mysql://localhost:3306/ailatrieuphu";
			String username = "root";
			String password = "";
			
			// Tạo kết nối
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection(Connection connection) {
		try {
			if (connection != null) { 
				connection.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printInfo(Connection connection) {
		try {
			if (connection != null) {
				DatabaseMetaData mtdt = connection.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
