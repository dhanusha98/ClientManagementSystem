package presentationLayer;

public class Customer {
	
	private int customerID;
	private String customerFullName;
	private String username;
	private String password;
	private String otherDetails;
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		
		if(String.valueOf(customerID).isEmpty())
		{
			System.out.println("CUSTOMER ID IS EMPTY !");
		} else {
			this.customerID = customerID;
		}
	}
	public String getCustomerFullName() {
		return customerFullName;
	}
	public void setCustomerFullName(String customerFullName) {
		
		if(customerFullName.isEmpty())
		{
			System.out.println("CUSTOMER NAME IS EMPTY !");
			
		} else {
			this.customerFullName = customerFullName;
		}
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		
		if(username.isEmpty())
		{
			System.out.println("USERNAME IS EMPTY !");
		} else {
			this.username = username;
		}
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		
		if(password.isEmpty())
		{
			System.out.println("PASSWORD IS EMPTY !");
		} else {
			this.password = password;
		}
	}
	public String getOtherDetails() {
		return otherDetails;
	}
	public void setOtherDetails(String otherDetails) {
		
		if(otherDetails.isEmpty())
		{
			System.out.println("EMPTY DATA FOR 'OTHER DETAILS' !");
		} else {
			this.otherDetails = otherDetails;
		}
	}

}
