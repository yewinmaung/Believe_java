package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CounterAccess {
	public Counter getReport() {
		Counter cat=new Counter();
		boolean flag=false;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/j2eepj", "root", "");
				PreparedStatement pmt = con.prepareStatement("SELECT COUNT(id) as reportno FROM messages;");
				rs = pmt.executeQuery();
				
				if (rs.next()) {
					int ss = rs.getInt(1);
					cat=new Counter(ss);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return cat;
	}
	public Counter getUser() {
		Counter cat=new Counter();
		boolean flag=false;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/j2eepj", "root", "");
				PreparedStatement pmt = con.prepareStatement("SELECT COUNT(id) as classno FROM users;");
				rs = pmt.executeQuery();
				
				if (rs.next()) {
					int ss = rs.getInt(1);
					cat=new Counter(ss);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return cat;
	}
	public Counter getenrollstu() {
		Counter cat=new Counter();
		boolean flag=false;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/j2eepj", "root", "");
				PreparedStatement pmt = con.prepareStatement("SELECT COUNT(id) as classno FROM enrolls;");
				rs = pmt.executeQuery();
				
				if (rs.next()) {
					int ss = rs.getInt(1);
					cat=new Counter(ss);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return cat;
	}
public Counter getClasse() {
	Counter cat=new Counter();
	boolean flag=false;
	ResultSet rs = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/j2eepj", "root", "");
			PreparedStatement pmt = con.prepareStatement("SELECT COUNT(id) as classno FROM classes;");
			rs = pmt.executeQuery();
			
			if (rs.next()) {
				int ss = rs.getInt(1);
				cat=new Counter(ss);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return cat;
}
}
