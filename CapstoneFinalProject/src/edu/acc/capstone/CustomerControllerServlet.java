package edu.acc.capstone;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/CustomerControllerServlet")
public class CustomerControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private CustomerDbUtil customerDbUtil;
	
	@Resource(name="jdbc/food_order")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our customer db util ... and pass in the conn pool / datasource
		try {
			customerDbUtil = new CustomerDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
		// read the "command" parameter
			String theCommand = request.getParameter("command");
			
		// if the command is missing, then default to listing orders
			if(theCommand == null) {
				theCommand = "LIST";
			}
		
		// route to the appropriate method
		switch (theCommand) {
		case "LIST":
			listCustomers(request,response);
			break;
		
		case "ADD":
			addFoodOrder(request,response);
			break;
			
		case "LOAD":
			loadFoodOrder(request,response);
			break;
			
		case "UPDATE":
			updateFoodOrder(request,response);
			break;
			
		case "DELETE":
			deleteFoodOrder(request,response);
			break;
		
		default:
			listCustomers(request,response);
		}
	}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void deleteFoodOrder(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		
		// read custOrderNumber from form data
		String theCustOrderNumber = request.getParameter("custOrderNumber");
		
		// delete order from database
		customerDbUtil.deleteFoodOrder(theCustOrderNumber);
		
		// send them back to "list orders" page
		listCustomers(request,response);		
		
	}

	private void updateFoodOrder(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		
		// read food order info from form data
		int id = Integer.parseInt(request.getParameter("custOrderNumber"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String orderNumber = request.getParameter("orderNumber");
		String orderDescription = request.getParameter("orderDescription");
		
		// create a new customer order object
		CustomerOrder theFoodOrder = new CustomerOrder(id, firstName, lastName, email, phoneNumber, orderNumber, orderDescription);
		
		// perform update on database
		customerDbUtil.updateCustomerOrder(theFoodOrder);
		
		// send them back to the list-orders page
		listCustomers(request, response);
		
		
	}

	private void loadFoodOrder(HttpServletRequest request, HttpServletResponse response) 
		throws Exception{
		
		// read order number from form data
		String customerOrderNumber = request.getParameter("custOrderNumber");
		
		// get newOrder from database (db util)
		CustomerOrder theFoodOrder = customerDbUtil.getCustomerOrder(customerOrderNumber);
		
		// place newOrder in the request attribute
		request.setAttribute("THE_CUSTOMER_ORDER", theFoodOrder);
		
		// send to jsp page: update-order-form.jsp
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/update-order-form.jsp");
		dispatcher.forward(request, response);
	
	}

	private void addFoodOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// read order info from form data
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String orderNumber = request.getParameter("orderNumber");
		String orderDescription = request.getParameter("orderDescription");
		
		// create a new customer order object
		
		CustomerOrder theFoodOrder = new CustomerOrder(firstName, lastName, email, phoneNumber, orderNumber, orderDescription);
		
		// add the customer order to the database
		customerDbUtil.addCustomerOrder(theFoodOrder);
		
		// send back to main page (the add order form or home page)
		listCustomers(request, response);
		
	}

	private void listCustomers(HttpServletRequest request, HttpServletResponse response) 
	throws Exception {
		
		// get customer order info from db util
		List<CustomerOrder> custOrder = customerDbUtil.getOrders();
		
		// add customer orders to the request
		request.setAttribute("CUSTOMER_ORDERLIST", custOrder);
		
		// send to JSP page (view)
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-orders.jsp");
		dispatcher.forward(request, response);
	
	}
}
