package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
/////DESKTOP-7AVUQ5G
import java.sql.Statement;

public class SQLDatabaseConnection {
	public Connection conn = null;
	private String dbName = null;

	public SQLDatabaseConnection() {
	}

	public SQLDatabaseConnection(String dbName, String dbURL) {
		this.dbName = dbName;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			this.conn = DriverManager.getConnection(dbURL);
			// here put the new simple url.
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet runSql(String sql) throws SQLException {
		Statement sta = conn.createStatement();
		return sta.executeQuery(sql);
	}

}