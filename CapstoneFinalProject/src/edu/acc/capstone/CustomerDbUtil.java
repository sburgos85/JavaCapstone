package edu.acc.capstone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import javax.sql.DataSource;

import edu.acc.capstone.CustomerOrder;

public class CustomerDbUtil {

	private DataSource dataSource;
	
		public CustomerDbUtil(DataSource theDataSource) {
			dataSource = theDataSource;
		}

	public List<CustomerOrder> getOrders() throws Exception {
		
		List<CustomerOrder> orders = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
		
		// get a connection
		myConn = dataSource.getConnection();
		
		// create a sql statement
		String sql = "select * from orderhistory order by id";
		
		myStmt = myConn.createStatement();
		
		// execute query
		myRs = myStmt.executeQuery(sql);
		
		// process result set
		while (myRs.next()) {
			
			// retrieve data from result set row
			int id = myRs.getInt("id");
			String firstName = myRs.getString("firstName");
			String lastName = myRs.getString("lastName");
			String email = myRs.getString("email");
			String phoneNumber = myRs.getString("phoneNumber");
			String orderNumber = myRs.getString("orderNumber");
			String orderDescription = myRs.getString("orderDescription");
			
			// create new order object
			CustomerOrder newOrder = new CustomerOrder(id, firstName, lastName, email, phoneNumber, orderNumber, orderDescription);
			
			// add it to the list of orders
			orders.add(newOrder);
			
		}
		
			return orders;			
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
			
		}
		
		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		
		try {
			if (myRs !=null) {
				myRs.close();
			}
			
			if (myStmt !=null) {
				myStmt.close();
			}
			
			if (myConn !=null) {
				myConn.close();
			}
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void addCustomerOrder(CustomerOrder newOrder) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
				
		try {
			
			
		// get db connection
			myConn= dataSource.getConnection();
		
		//  Create sql for insert
			String sql = "insert into orderhistory " +
						"(firstName, lastName, email, phoneNumber, orderNumber, orderDescription) " +
						"values(?, ?, ?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
		
		// set the param values for the newOrder
		
		myStmt.setString(1, newOrder.getFirstName());
		myStmt.setString(2, newOrder.getLastName());
		myStmt.setString(3, newOrder.getEmail());
		myStmt.setString(4, newOrder.getPhoneNumber());
		myStmt.setString(5, newOrder.getOrderNumber());
		myStmt.setString(6, newOrder.getOrderDescription());
		
		// execute sql insert
		myStmt.execute();
		}
		finally {
		//clean up JDBC objects, null for result set because we are not using one.
		close(myConn, myStmt, null);	
		}
	}

	public CustomerOrder getCustomerOrder(String customerOrderNumber) throws Exception {
		
		CustomerOrder theCustomerOrder= null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int custOrderNumber;
		
		try {
			// convert custOrderNumber to int
			custOrderNumber = Integer.parseInt(customerOrderNumber);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to get select
			String sql ="select * from orderhistory where id=?";
			
			// create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, custOrderNumber);
			
			// execute statement
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if(myRs.next()) {
				
				String firstName = myRs.getString("firstName");
				String lastName = myRs.getString("lastName");
				String email = myRs.getString("email");
				String phoneNumber = myRs.getString("phoneNumber");
				String orderNumber = myRs.getString("orderNumber");
				String orderDescription = myRs.getString("orderDescription");
				
				// use the custOrderNumber during construction
				
				theCustomerOrder = new CustomerOrder(custOrderNumber, firstName, lastName, email, phoneNumber, orderNumber, orderDescription);
				
			}
			else {
				throw new Exception("Could not find order number:  " + custOrderNumber);
			}
			return theCustomerOrder;
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void updateCustomerOrder(CustomerOrder theFoodOrder) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
	try {	
		// get db connection
		myConn = dataSource.getConnection();
		
		// create a sql update statement
		String sql = "update orderhistory "
					+ "set firstName=?, lastName=?, email=?, phoneNumber=?, orderNumber=?, orderDescription=? "
					+ "where id=?";
		
		// prepare statement
		myStmt = myConn.prepareStatement(sql);
		
		// set params
		myStmt.setString(1, theFoodOrder.getFirstName());
		myStmt.setString(2, theFoodOrder.getLastName());
		myStmt.setString(3, theFoodOrder.getEmail());
		myStmt.setString(4, theFoodOrder.getPhoneNumber());
		myStmt.setString(5, theFoodOrder.getOrderNumber());
		myStmt.setString(6, theFoodOrder.getOrderDescription());
		myStmt.setInt(7, theFoodOrder.getId());
		
				
		// execute SQL statement
		myStmt.execute();
		}
	finally {
		// clean up JDBC objects
		close(myConn, myStmt, null);
		}
	}

	public void deleteFoodOrder(String theCustOrderNumber) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt= null;
		
		try {
			// convert theCustOrderNumber to int
			int custOrderNumber = Integer.parseInt(theCustOrderNumber);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to delete the order
			String sql = "delete from orderhistory where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1,  custOrderNumber);
			
			// execute sql statement
			myStmt.execute();
			
		}
		finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}
	}
	
}
