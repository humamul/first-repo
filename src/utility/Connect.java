package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

	public static Connection getCon() {
		Connection con = null;
		// mysql-connector-mvn  search it on google;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e ) {
			System.err.println(e.getMessage());
		}
		
		String url = "jdbc:mysql://localhost:3306/db2";
		
		
		
		
		try {
			
			con = DriverManager.getConnection(url,"root","root");
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		System.out.println(con);
		return con;
	}
}
