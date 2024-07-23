package feedback;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class feedbackDBUtil {
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	 public static boolean addFeedback(String name,String email,String comment) {
		 
		 
		 boolean isSuccess=false;
		 
		 //create db connection
		 
		 	String url="jdbc:mysql://localhost:3306/feedback";
			String user="root";
			String pass="sasindu";
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con=DriverManager.getConnection(url,user,pass);
				Statement stmt=con.createStatement();
				
				String sql="Insert into feedback values (0,'"+name+"','"+email+"','"+comment+"')";
				int rs= stmt.executeUpdate(sql);
				
				if(rs>0) {
					isSuccess=true;
				}
				else {
					isSuccess=false;
				}
				
			}
		    catch (Exception e){
		    	 e.printStackTrace();
		    }
		 
		 return isSuccess;
	 }
	 public static List<Feedback> getFeedbacks(){
		 ArrayList<Feedback> feedback= new ArrayList<>();
		 
		 try {
				
			    con = dbConnection.getConnection();
				stmt = con.createStatement();
				String sql = "select * from feedback";
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String  email= rs.getString(3);
					String comment= rs.getString(4);
					
					
					Feedback f = new Feedback(id,name,email,comment);
					
					feedback.add(f);
				}
			}
		    catch (Exception e){
		    	 e.printStackTrace();
		    }
		 
		 return feedback;
	 }
	 
	public static boolean deleteFeedback(String id) {
		 
		 try {
				
			 con = dbConnection.getConnection();
			 stmt = con.createStatement();
				System.out.println(id);
			 String sql="Delete from feedback  Where FID='"+id+"'";		 
			 int rs= stmt.executeUpdate(sql);
			 
			 if(rs>0) {
				 isSuccess=true;
			 }
			 else {
					isSuccess=false;
				}
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		
		 
		 return isSuccess;
	 }

}
