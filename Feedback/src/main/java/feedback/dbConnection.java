package feedback;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {

	private static String url="jdbc:mysql://localhost:3306/feedback";
	private static String userName="root";
	private static String password="sasindu";
	private static Connection con;
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url, userName, password);
			
		}
		catch (Exception e){
			System.out.println("Database connection is unsuccessfull !!");
		}
		
		return con;
	}
}
