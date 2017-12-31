package edu.acc.capstone;

public class CustomerOrder {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String orderDescription;
	private String orderNumber;
	
	
	
	public CustomerOrder(String firstName, String lastName, String email, String phoneNumber, String orderNumber,
			String orderDescription) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.orderNumber = orderNumber;
		this.orderDescription = orderDescription;
	}


	public CustomerOrder(String firstName, String lastName, String email, String phoneNumber, String orderDescription) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.orderDescription = orderDescription;
	}


	public CustomerOrder(int id, String firstName, String lastName, String email, String phoneNumber, String orderNumber,
			String orderDescription) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.orderNumber = orderNumber;
		this.orderDescription = orderDescription;
	}

	
	public CustomerOrder(int id, String firstName, String lastName, String email, String phoneNumber,
			String orderDescription) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.orderDescription = orderDescription;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOrderNumber() {
		return orderNumber;
	}


	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}


	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}


	@Override
	public String toString() {
		return "CustomerOrder [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", orderDescription=" + orderDescription + ", orderNumber="
				+ orderNumber + "]";
	}


}
