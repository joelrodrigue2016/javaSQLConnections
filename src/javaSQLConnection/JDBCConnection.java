package javaSQLConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCConnection {

	public static void main(String[] args) {

		// https://docs.oracle.com/javase/8/docs/api/java/sql/package-summary.html#package.description
		// auto java.sql.Driver discovery -- no longer need to load a java.sql.Driver
		// class via Class.forName

		// register JDBC driver, optional since java 1.6
		/*
		 * try { Class.forName("com.mysql.jdbc.Driver"); } catch (ClassNotFoundException
		 * e) { e.printStackTrace(); }
		 */

		// auto close connection

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sakila", "root", "3715")) {

			if (conn != null) {
				System.out.println("Connected to the database!");
			} else {
				System.out.println("Failed to make connection!");
			}
			String SQLQueryString = "Select * from actor;";
			PreparedStatement ps = conn.prepareStatement(SQLQueryString);
			ResultSet resultset = ps.executeQuery();

			while (resultset.next()) {
				// getters
				long id = resultset.getLong("actor_id");
				String name = resultset.getString("first_name");
				String lastName = resultset.getString("last_name");
				Date date = resultset.getDate("last_update");

				/// setters

				System.out.println(id + "," + name + "," + lastName + "," + date + ",");

			}

		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}