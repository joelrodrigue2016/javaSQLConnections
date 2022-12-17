package src.sqlite;



import java.sql.Connection;
import java.sql.DriverManager;

public class SQLiteJDBC {
	public static void main(String args[]) {
		@SuppressWarnings("unused")
		Connection c = null;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:joelDB.sqlite");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}
}