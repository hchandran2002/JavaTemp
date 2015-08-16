package com.jdbc.stmt;

//STEP 1. Import required packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementExample {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";

	// Database credentials
	static final String USER = "hr";
	static final String PASS = "admin";

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");

			String sql = "UPDATE EMPLOYEES set salary=? WHERE EMPLOYEE_ID=?";
			stmt = conn.prepareStatement(sql);
			//Bind values into the parameters.
			stmt.setDouble(1, 3600.00); // This would set Salary
			stmt.setInt(2, 103); // This would set ID

			// Let us update salary of the record with EMPLOYEE_ID = 103;
			int rows = stmt.executeUpdate();
			System.out.println("Rows impacted : " + rows);
			stmt.close();
			// Let us select all the records and display them.
			sql = "SELECT employee_id, first_name, last_name, salary FROM Employees";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("employee_id");
				int salary = rs.getInt("salary");
				String first = rs.getString("first_name");
				String last = rs.getString("last_name");

				// Display values
				System.out.print("Emp ID: " + id);
				System.out.print(", Salary: " + salary);
				System.out.print(", First: " + first);
				System.out.println(", Last: " + last);
			}
			// STEP 6: Clean-up environment
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
