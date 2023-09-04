package model;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class PaymentAccess {
	// Create BankAccount
	public boolean createBankAccount(String name, String email, String account, String amount) {
		boolean flag = false;
		BankAccount pay = new BankAccount();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/j2eepj", "root", "");
			PreparedStatement pmt = con.prepareStatement("insert into payments values(?,?,?,?,?,?)");
			pmt.setInt(1, pay.getId());
			pmt.setString(2, name);
			pmt.setString(3, email);
			pmt.setString(4, account);
			pmt.setString(5, amount);
			pmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));

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

	// EnrollUser
	public BankAccount enrollUser(String name, String email, String accno) {

		boolean flag = false;
		BankAccount pay = new BankAccount();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/j2eepj", "root", "");
			stmt = con.createStatement();
			rs = stmt.executeQuery("select* from payments where email='" + email + "'and accno='" + accno + "'");

			while (rs.next()) {
				flag = true;
				int id = rs.getInt(1);
				String n = rs.getString(2);
				String e = rs.getString(3);
				String accn = rs.getString(4);
				int a = rs.getInt(5);
				pay = new BankAccount(id, n, e, accn, a);
			}
              System.out.println(pay.getAmount());
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pay;
	

	}

	// reduceAmount
	public boolean reduceAmount(String name, String email, String accno, int amount) {
		BankAccount pay = new BankAccount();
		boolean flag = false;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int newamount = amount - 30000;
		System.out.println(amount);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/j2eepj", "root", "");

			PreparedStatement pmt = con.prepareStatement("UPDATE payments SET amount=?,updated_at=? Where email=?");

			pmt.setInt(1, newamount);
			pmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			pmt.setString(3, email);

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

//isValid
	public boolean isValid(String email, String account, int amount) {

		boolean isValid = false;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/j2eepj", "root", "");
				stmt = con.createStatement();
				isValid = false;
                
				rs = stmt.executeQuery("select * from payments where email='" + email + "'and accno='" + account + "'");
				System.out.println(rs);
				while (rs.next()) {
					isValid = true;
				}
				
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isValid;
	}

	public boolean canJoin(String email, String account, int amount) {
		
		boolean cj=false;
		if(amount>30000) {
			cj=true;
		}
		return cj;
	}


	

	
}
