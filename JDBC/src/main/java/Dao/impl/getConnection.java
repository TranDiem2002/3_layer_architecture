package Dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class getConnection {
	public static Connection getconnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl = "jdbc:sqlserver://localhost;database=AdventureWorks;integratedSecurity=true;";
			String hostname = "localhost";
			String sqlInstanceName = "LAPTOP-9KTILM0J\\SQLEXPRESS";
			String sqlDatabaseName = " javasql";
			String sqlUser = "sa";
			String sqlPassword = "01022002";

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectURL = "jdbc:sqlserver://" + hostname + ":1433" + ";instance=" + sqlInstanceName
					+ ";databaseName=" + sqlDatabaseName;
			return DriverManager.getConnection(connectURL, sqlUser, sqlPassword);

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
}
