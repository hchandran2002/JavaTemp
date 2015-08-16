package com.jdbc.resultset;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ResultsetUpdateExample {

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

			// STEP 4: Execute a query to create statement with
			// required arguments for RS example.
			System.out.println("Creating statement...");
			stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			// Let us select all the records and display them.
			String sql = "SELECT employee_id, salary, first_name, last_name, email, hire_date, job_id  FROM Employees";
			ResultSet rs = stmt.executeQuery(sql);

			System.out.println("List result set for reference....");
			printRs(rs);

			// STEP 6: Loop through result set and add 5 in age
			// Move to BFR postion so while-loop works properly
			rs.beforeFirst();
			// STEP 7: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int newSalary = rs.getInt("salary") + 5000;
				rs.updateDouble("salary", newSalary);
				rs.updateRow();
			}
			System.out.println("List result set showing new salary...");
			printRs(rs);

			// Delete second record from the table.
			// Set position to second record first
			rs.absolute(-1);
			System.out.println("List the record before deleting...");
			//Retrieve by column name
			int id = rs.getInt("employee_id");
			int salary = rs.getInt("salary");
			String first = rs.getString("first_name");
			String last = rs.getString("last_name");

			//Display values
			System.out.print("ID: " + id);
			System.out.print(", Salary: " + salary);
			System.out.print(", First: " + first);
			System.out.println(", Last: " + last);

			//Delete row
			rs.deleteRow();
			System.out.println("List result set after deleting one records...");
			printRs(rs);

			// Insert a record into the table.
			// Move to insert row and add column data with updateXXX()
			System.out.println("Inserting a new record...");
			rs.moveToInsertRow();
			rs.updateInt("employee_id", 445);
			rs.updateString("first_name", "John445");
			rs.updateString("last_name", "Paul445");
			rs.updateString("email", "Paul4445@gmail.com");
			rs.updateDate("hire_date", new Date(System.currentTimeMillis()));
			rs.updateString("job_id", "FI_ACCOUNT");
			rs.updateInt("salary", 4445);
			// Commit row
			rs.insertRow();

			System.out.println("List result set showing new set...");
			printRs(rs);

			//STEP 8: Clean-up environment
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

	public static void printRs(ResultSet rs) throws SQLException {
		// Ensure we start with first row
		rs.beforeFirst();
		while (rs.next()) {
			// Retrieve by column name
			int id = rs.getInt("employee_id");
			int salary = rs.getInt("salary");
			String first = rs.getString("first_name");
			String last = rs.getString("last_name");

			// Display values
			System.out.print("ID: " + id);
			System.out.print(", Salary: " + salary);
			System.out.print(", First: " + first);
			System.out.println(", Last: " + last);
		}
		System.out.println();
	}// end printRs()
}
