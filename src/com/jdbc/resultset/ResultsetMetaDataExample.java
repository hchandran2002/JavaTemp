package com.jdbc.resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultsetMetaDataExample {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";

	// Database credentials
	static final String USER = "hr";
	static final String PASS = "admin";

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query to create statment with
			// required arguments for RS example.
			System.out.println("Creating statement...");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			// Let us select all the records and display them.
			String sql = "SELECT employee_id, salary, first_name, last_name  FROM Employees";
			ResultSet rs = stmt.executeQuery(sql);

			ResultSetMetaData rsmd = rs.getMetaData();

			System.out.println("Total cols: " + rsmd.getColumnCount());
			System.out.println("Column name: " + rsmd.getColumnName(1));
			System.out.println("Column type: " + rsmd.getColumnTypeName(1));

			// STEP 8: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		System.out.println("Goodbye!");
	}
}
