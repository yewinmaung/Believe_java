package model;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class MessageAccess {
	public boolean setMessage(String name ,String email,String message) {
		boolean flag=false;
		Message msg=new Message();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/j2eepj","root","");
			
				 
			PreparedStatement pmt=con.prepareStatement("insert into messages values(?,?,?,?,?)");
			
			 pmt.setInt(1, msg.getId());
			 pmt.setString(2,name);
			 pmt.setString(3, email);
			 pmt.setString(4, message);
			 pmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			
			 int i=pmt.executeUpdate();
			 //System.out.println("pmt aung"); 
			 if(i>0) {
					flag=true;
				}
				con.close();
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	
}
	public boolean deleteMessage(String name ,String email,String message) {
		boolean flag=false;
		
		return flag;
	
}
	}
