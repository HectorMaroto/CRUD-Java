package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnDB {
	
	private static Connection connection=null; //Los atributos de esta clase deben ser static para poder acceder a ellos en esta clase
	
	public ConnDB() {
		
	}
	
	public static Connection getConn() throws SQLException, ClassNotFoundException {
		if(connection==null) {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/censo", "root","");
		}
		return connection;
	}

}
