package src.file;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreTest {

	public static void main(String args[]) throws SQLException {
		String link = "org.postgresql.Driver";
		String connector = "jdbc:postgresql://localhost:5432/practical_sql";
		String user = "postgres";
		String password = "3715";

		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName(link);
			c = DriverManager.getConnection(connector, user, password);
			c.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");
		stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM temperature_readings  ;");
		System.out.println("______________________");
		System.out.println("Date " + "      tmax" + " tmin");
		System.out.println("______________________");
		while (rs.next()) {
			String station_name = rs.getString("station_name");
			Date date = rs.getDate("date");
			int tmax = rs.getInt("tmax");
			int tmin = rs.getInt("tmin");

//			System.out.println("+----------------------------------------------+");
//			System.out.println("station_name = " + station_name);
//			System.out.println("date = " + date);
//			System.out.println("tmax = " + tmax);
//			System.out.println("tmin = " + tmin);
//			System.out.println();

			System.out.println("|" + date + " | " + tmax + " | " + tmin + "|");
		}

	}
}