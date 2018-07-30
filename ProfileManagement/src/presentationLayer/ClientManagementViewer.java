package presentationLayer;

import java.util.Scanner;

import dbOperations.ClientDataAccessor;

public class ClientManagementViewer {
	
	private Scanner sc=new Scanner(System.in);
	
	private Customer custObj=new Customer();
	private ClientDataAccessor clientDAObj=new ClientDataAccessor();

	public void clientProfileManagement()
	{
		
		ClientManagementViewer clmVObj=new ClientManagementViewer();
		
				
		System.out.println("===================================================================================================");
		System.out.println("                                        CUSTOMER PROFILE MANAGEMENT                                ");
		System.out.println("===================================================================================================");
		
		System.out.println("PRESS FUNCTION NUMBER IN FOLLOWING LIST TO IMPLEMENT CORRESPONDING SERVICE");
		
		System.out.println("1. SEARCH CUSTOMER PROFILE");
		System.out.println("2. INSERT CUSTOMER PROFILE");
		System.out.println("3. UPDATE CUSTOMER PROFILE");
		System.out.println("4. DELETE CUSTOMER PROFILE");
		
		System.out.println("FUNCTION NUMBER: ");
		int selectedFunction=sc.nextInt();
		
		switch(selectedFunction)
		{
		
		    case 1:
		    	clmVObj.searchProfile();
			   break;
			
		    case 2:
		       clmVObj.insertProfile();
			   break;
			
		    case 3:
		       clmVObj.updateProfile();
			   break;
			
		    case 4:
		       clmVObj.deleteProfile();
			   break;
			
		    default:
		       System.out.println("INVALID FUNCTION NUMBER !");
			   break;
		}
	}
	
	public void searchProfile()
	{
		
		System.out.println("============================================ SEARCH PROFILE ============================================");
		
		System.out.println("CUSTOMER ID: ");
		int customerID=sc.nextInt();
		
		custObj.setCustomerID(customerID);
		
		int custID=custObj.getCustomerID();
		clientDAObj.searchProfile(custID);
		
	}
	
	public void insertProfile()
	{
		
		System.out.println("============================================ INSERT PROFILE ============================================");
		
		System.out.println("CUSTOMER FULL NAME: ");
		String customerFullName=sc.nextLine();
		
		System.out.println("USERNAME: ");
		String username=sc.nextLine();
		
		System.out.println("PASSWORD: ");
		String password=sc.nextLine();
		
		System.out.println("OTHER DETAILS: ");
		String otherDetails=sc.nextLine();
		
		custObj.setCustomerFullName(customerFullName);
		custObj.setUsername(username);
		custObj.setPassword(password);
		custObj.setOtherDetails(otherDetails);
		
		String custFullName=custObj.getCustomerFullName();
		String user=custObj.getUsername();
		String psw=custObj.getPassword();
		String details=custObj.getOtherDetails();
		
		boolean result = clientDAObj.insertProfile(custFullName, user, psw, details);
		
		if(result == true)
		{
			System.out.println("PROFILE CREATED SUCCESSFULLY !");
		} else {
			
			System.out.println("PROFILE CREATION FAILED !");
		}
	}
	
	public void updateProfile()
	{
		
		System.out.println("============================================ UPDATE PROFILE ============================================");
		
		System.out.println("CUSTOMER ID: ");
		int customerID=sc.nextInt();
		
		System.out.println("CUSTOMER FULL NAME: ");
		String customerFullName=sc.next();
		sc.nextLine();
		
		System.out.println("USERNAME: ");
		String username=sc.nextLine();
		
		System.out.println("PASSWORD: ");
		String password=sc.nextLine();
		
		System.out.println("OTHER DETAILS: ");
		String otherDetails=sc.nextLine();
		
		custObj.setCustomerID(customerID);
		custObj.setCustomerFullName(customerFullName);
		custObj.setUsername(username);
		custObj.setPassword(password);
		custObj.setOtherDetails(otherDetails);
		
		int custID=custObj.getCustomerID();
		String custFullName=custObj.getCustomerFullName();
		String user=custObj.getUsername();
		String psw=custObj.getPassword();
		String details=custObj.getOtherDetails();

		boolean result = clientDAObj.updateProfile(custID, custFullName, user, psw, details);
		
		if(result == true)
		{
			System.out.println("PROFILE UPDATED SUCCESSFULLY !");
		} else {
			
			System.out.println("PROFILE UPDATION FAILED !");
		}
	}
	
	public void deleteProfile()
	{
		
		System.out.println("============================================ DELETE PROFILE ============================================");

		System.out.println("CUSTOMER ID: ");
		int customerID=sc.nextInt();
		
		custObj.setCustomerID(customerID);
		int custID=custObj.getCustomerID();
		boolean result = clientDAObj.deleteProfile(custID);
		
		if(result == true)
		{
			System.out.println("PROFILE DELETED SUCCESSFULLY !");
		} else {
			System.out.println("PROFILE DELETION FAILED !");
		}
		
	}
	
}
