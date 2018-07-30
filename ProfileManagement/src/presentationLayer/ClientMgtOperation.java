package presentationLayer;

import java.sql.Connection;

import dbOperations.ClientDataAccessor;

public class ClientMgtOperation {
	
	private ClientDataAccessor clientDAObj=new ClientDataAccessor();
	
	private Customer custObj=new Customer();
		
	public void searchProfile()
	{
		int customerID=custObj.getCustomerID();
		clientDAObj.searchProfile(customerID);
		
	}
	
	public String insertProfile()
	{
		
		String customerFullName=custObj.getCustomerFullName();
		String username=custObj.getUsername();
		String password=custObj.getPassword();
		String otherDetails=custObj.getOtherDetails();
		
		boolean result=clientDAObj.insertProfile(customerFullName, username, password, otherDetails);
		
		String resultStatus="";
		
		if(result == true)
		{
			resultStatus="PROFILE INSERTED SUCCESSFULLY !";
		} else {
			resultStatus="PROFILE INSERTION FAILED !";
		}
		
		return resultStatus;
	}
	
	public String updateProfile()
	{
		
		int customerID=custObj.getCustomerID();
		String customerFullName=custObj.getCustomerFullName();
		String username=custObj.getUsername();
		String password=custObj.getPassword();
		String otherDetails=custObj.getOtherDetails();
		
		boolean result=clientDAObj.updateProfile(customerID, customerFullName, username, password, otherDetails);
		
        String resultStatus="";
		
		if(result == true)
		{
			resultStatus="PROFILE UPDATION SUCCESSFULLY !";
		} else {
			resultStatus="PROFILE UPDATION FAILED !";
		}
		
		return resultStatus;
	}
	
	public String deleteProfile()
	{
		
		int customerID=custObj.getCustomerID();
		boolean result=clientDAObj.deleteProfile(customerID);
		
		String resultStatus="";
		
		if(result == true)
		{
			resultStatus="PROFILE DELETED SUCCESSFULLY !";
			
		} else {
			resultStatus="PROFILE DELETION FAILED !";
		}
		
		return resultStatus;
	}

}
