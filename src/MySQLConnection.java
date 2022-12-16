package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {
	public static void main(String[] args) {

		// creates three different Connection objects
		Connection conn1 = null;
		Connection conn2 = null;
		Connection conn3 = null;

		try {
			// connect way #1
			String url1 = "jdbc:mysql://localhost:3306/sakila";
			String user = "root";
			String password = "3715";

			conn1 = DriverManager.getConnection(url1, user, password);
			if (conn1 != null) {
				System.out.println("Connected to the database test1");
			}

//			// connect way #2
//			String url2 = "jdbc:mysql://localhost:3306/test2?user=root&password=secret";
//			conn2 = DriverManager.getConnection(url2);
//			if (conn2 != null) {
//				System.out.println("Connected to the database test2");
//			}
//
//			// connect way #3
//			String url3 = "jdbc:mysql://localhost:3306/test3";
//			Properties info = new Properties();
//			info.put("user", "root");
//			info.put("password", "secret");
//
//			conn3 = DriverManager.getConnection(url3, info);
//			if (conn3 != null) {
//				System.out.println("Connected to the database test3");
//			}
			String sqlString = "Select * from actor";
			Statement statement = conn1.createStatement();
			ResultSet rs = statement.executeQuery(sqlString);
			System.out.println("          ID|         |Name|         |LastName|         |date");
			while (rs.next()) {
				int ID = rs.getInt(1);
				String firstname = rs.getString(2);
				String lastname = rs.getString(3);
				String date = rs.getString(4);

				System.out.println("|         |" + ID + "|         |" + firstname + "|         |" + lastname
						+ "|         |" + date);
			}
		} catch (SQLException ex) {
			System.out.println("An error occurred. Maybe user/password is invalid");
			ex.printStackTrace();
		}

	}
}
