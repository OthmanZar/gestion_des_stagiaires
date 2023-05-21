package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection  getConnection() throws SQLException{
		Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/pfe","root","");
		
		
		return connection;
	}
}
