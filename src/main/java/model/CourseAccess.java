package model;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.servlet.http.Part;

import java.util.*;

public class CourseAccess {

	public boolean createCourse(String title, String img, String price) {
		boolean flag = false;
		Course course = new Course();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/j2eepj", "root", "");
			PreparedStatement pmt = con.prepareStatement("insert into classes values(?,?,?,?,?)");
			pmt.setInt(1, course.getId());
			pmt.setString(2, title);
			pmt.setString(3, img);
			pmt.setString(4, price);
			Timestamp date = new Timestamp(System.currentTimeMillis());
			pmt.setTimestamp(5, date);

			int i = pmt.executeUpdate();
			if (i > 0) {
				flag = true;
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

	public boolean addCourse(String name, int type, String img, String link) {
		boolean flag = false;
		Course course = new Course();
		Category category = new Category();
		
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/j2eepj", "root", "");
				PreparedStatement pmt = con.prepareStatement("insert into courses values(?,?,?,?,?,?)");
				pmt.setInt(1, course.getId());
				pmt.setString(2, name);
				pmt.setString(3, img);
				
				pmt.setInt(4, type);

				pmt.setString(5, link);
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

	public boolean updateCourse(int id,String name, int type, String img, String link) {

		boolean flag = false;
		Course course = new Course();
		Connection con;

		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/j2eepj", "root", "");
			PreparedStatement pmt = con.prepareStatement("Update courses set name=?,image=?,type=?,links=?,updated_at=? where id="+id);
			pmt.setString(1, name);
			pmt.setString(2, img);
			pmt.setInt(3, type);
			pmt.setString(4, link);

			pmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			int i = pmt.executeUpdate();

			if (i > 0) {
				flag = true;
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

	// Show Create List type Course
	
	public Category showClassobj(int course_id) {
		Category cat=new Category();
		PreparedStatement pmt = null;
		ResultSet rs = null;
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/j2eepj", "root", "");
			pmt = con.prepareStatement("select * from couses where classes.id="+course_id);
			rs = pmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String img = rs.getString(3);
				String price = rs.getString(4);
				Timestamp date = rs.getTimestamp(5);
				cat = new Category(id, title, img, price, date);
			}
			System.out.println("True"+rs.next());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cat;
	}
	public List<Category> showClass() throws ClassNotFoundException, SQLException {

		PreparedStatement pmt = null;
		ResultSet rs = null;
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/j2eepj", "root", "");

		ArrayList<Category> list = new ArrayList<>();
		pmt = con.prepareStatement("select * from classes");
		rs = pmt.executeQuery();

		Category c;
		while (rs.next()) {
			int id = rs.getInt(1);
			String title = rs.getString(2);
			String img = rs.getString(3);
			String price = rs.getString(4);
			Timestamp date = rs.getTimestamp(5);
			c = new Category(id, title, img, price, date);
			list.add(c);
		}
		System.out.println(rs.next());
		return list;
	}

///Show Course In List
	public List<Course> showCourse() throws ClassNotFoundException, SQLException {

		boolean flag = false;
		Course course = new Course();
		PreparedStatement pmt = null;
		ResultSet rs = null;

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/j2eepj", "root", "");

		ArrayList<Course> list = new ArrayList<>();
		pmt = con.prepareStatement("select * from courses");

		rs = pmt.executeQuery();

		Course c;
		while (rs.next()) {
			c = new Course(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
					rs.getTimestamp(6));
			list.add(c);
		}

		return list;

	}
//
	public Course courseData(String id) {
		Course course = new Course();
		boolean flag = false;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/j2eepj", "root", "");
			stmt = con.createStatement();
			flag = false;
			rs = stmt.executeQuery("select * from courses where id='" + id + "'");

			while (rs.next()) {
				flag = true;
				int courseid = rs.getInt(1);
				String name = rs.getString(2);
				String img = rs.getString(3);
				int type = rs.getInt(4);
				String link = rs.getString(5);
				Timestamp date = new Timestamp(System.currentTimeMillis());
				course = new Course(courseid, name, img, type, link, date);
			}
			System.out.println("for lds "+course);

			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return course;
	}

}
