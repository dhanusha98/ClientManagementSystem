package presentationLayer;

public class Administrator {
	
     private int adminID;
     private String adminName;
     private String username;
     private String password;
     private String otherDetails;
     
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		
		if(String.valueOf(adminID).isEmpty())
		{
			System.out.println("ADMIN ID IS EMPTY !");
		} else {
			this.adminID = adminID;
		}
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {		
		if(adminName.isEmpty()) 
		{
			System.out.println("ADMIN NAME IS EMPTY !");
		} else {
			this.adminName = adminName;
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
	    	System.out.println("EMPTY DATA FOR 'OTHER DETAILS'");
	    } else {
	    	
			this.otherDetails = otherDetails;
	    }
	}
     
}
