package model;

import java.io.FileNotFoundException;
import java.net.http.HttpRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

public class UserAccess {
	
//regUser
	public boolean regUser(String name, String password, String email, String img) {
		boolean flag = false;

		User user = new User();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/j2eepj", "root", "");
				PreparedStatement pmt = con.prepareStatement("insert into users values(?,?,?,?,?,?,?)");
				pmt.setInt(1, user.getId());
				pmt.setString(2, name);
				pmt.setString(3, img);
				pmt.setString(4, email);
				pmt.setString(5, password);
				pmt.setInt(6, user.getType());
				pmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
				int i = pmt.executeUpdate();
				if (i > 0) {
					flag = true;
				}
				con.close();
			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public boolean isValid(String email, String password) {
		boolean isvalid = false;
		User user = new User();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/j2eepj", "root", "");
				stmt = con.createStatement();
				isvalid = false;
				rs = stmt.executeQuery(
						"select * from users where email='" + email + "' and password='" + password + "'");
				while (rs.next()) {
					isvalid = true;
				}
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isvalid;
	}

	public boolean isVilid(String email) {
		boolean isvilid = false;
		User user = new User();

		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/j2eepj", "root", "");
				stmt = con.createStatement();
				isvilid = false;
				rs = stmt.executeQuery("select * from users where email='" + email + "'");

				while (rs.next()) {
					isvilid = true;
				}
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isvilid;
	}

//Change Profile
	public User changeProfile(String name, String img, String password,int id) {
		User user = new User();
		boolean flag = false;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/j2eepj", "root", "");
				PreparedStatement pmt = con
						.prepareStatement("UPDATE users SET name=?,img=?,password=? Where id=?");

				pmt.setString(1, name);
				pmt.setString(2, img);
				pmt.setString(3, password);
                pmt.setInt(4, id);
				int i = pmt.executeUpdate();
				if (i > 0) {
					flag = true;
				}
				System.out.println("Ua changeProfile :"+flag);
				
				con.close();
				
			}
			

			catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;

	}
//getuser
	public User selectUser(int userid) {
		User user=new User();
		boolean flag=false;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost/j2eepj", "root", "");
					stmt = con.createStatement();
					flag = false;
					rs = stmt.executeQuery("select * from users where id="+userid);

					while (rs.next()) {
						flag = true;
						int id = rs.getInt(1);
						String img = rs.getString(2);
						String name = rs.getString(3);
						String e = rs.getString(4);
						String p = rs.getString(5);
						int t = rs.getInt(6);
						user = new User(id, img, name, e, p, t);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
				
				
					
		return user;
	}
//LoginUser
	public User loginUser(String email, String password) {
		boolean flag = false;
		User user = new User();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/j2eepj", "root", "");
				stmt = con.createStatement();
				flag = false;
				rs = stmt.executeQuery(
						"select * from users where email='" + email + "' and password='" + password + "'");

				while (rs.next()) {
					flag = true;
					int id = rs.getInt(1);
					String img = rs.getString(2);
					String name = rs.getString(3);
					String e = rs.getString(4);
					String p = rs.getString(5);
					int t = rs.getInt(6);
					user = new User(id, img, name, e, p, t);
				}

				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;

	}

}
