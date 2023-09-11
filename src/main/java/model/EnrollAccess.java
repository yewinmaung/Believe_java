package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class EnrollAccess {
	public boolean getenrollStu(int userid,int classid) {
		Enroll enroll=new Enroll();
		boolean flag = false;
		Connection con;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/j2eepj", "root", "");
				PreparedStatement pmt = con.prepareStatement("select * from enrolls where user_id='" + userid +"'and class_id='"+classid+"'");
				System.out.println(pmt);
				rs = pmt.executeQuery();
				while (rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					int cid= rs.getInt(3);
					String email = rs.getString(4);
					int uid=rs.getInt(5);
					Timestamp date = rs.getTimestamp(6);
					enroll = new Enroll(id,name,cid,email,uid,date);
					flag=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;	
	}
	public Enroll enrollStu(int userid,int classid) {
		Enroll enroll=new Enroll();
		boolean flag = false;
		Connection con;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/j2eepj", "root", "");
				PreparedStatement pmt = con.prepareStatement("SELECT * FROM `enrolls` WHERE class_id="+classid+" and user_id="+userid);
				rs = pmt.executeQuery();
				while (rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					int cid= rs.getInt(3);
					String email = rs.getString(4);
					int uid=rs.getInt(5);
					Timestamp date = rs.getTimestamp(6);
					enroll = new Enroll(id,name,cid,email,uid,date);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return enroll;	
	}
	public boolean stu(int userid) {
		Enroll enroll=new Enroll();
		boolean flag = false;
		Connection con;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/j2eepj", "root", "");
				PreparedStatement pmt = con.prepareStatement("select * from enrolls where user_id="+userid);
				rs = pmt.executeQuery();
				while (rs.next()) {
					flag=true;
					int id = rs.getInt(1);
					String name = rs.getString(2);
					int cid= rs.getInt(3);
					String email = rs.getString(4);
					int uid=rs.getInt(5);
					Timestamp date = rs.getTimestamp(6);
					enroll = new Enroll(id,name,cid,email,uid,date);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
public boolean getEnroll(int userid,int classid,String name,String email) {
	Enroll enroll=new Enroll();
	boolean flag = false;
	Connection con;
	Statement stmt = null;
	ResultSet rs = null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/j2eepj", "root", "");
			PreparedStatement pmt = con.prepareStatement("insert into enrolls values(?,?,?,?,?,?)");
			
			pmt.setInt(1, enroll.getId());
			pmt.setString(2, name);
			pmt.setInt(3, classid);
			pmt.setString(4,email);
			pmt.setInt(5, userid);
			Timestamp date = new Timestamp(System.currentTimeMillis());
			pmt.setTimestamp(6, date);
			int i = pmt.executeUpdate();
			if (i > 0) {
				flag = true;
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return flag;
}


}
