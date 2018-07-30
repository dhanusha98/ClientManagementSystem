package presentationLayer;

import java.util.Scanner;

import dbOperations.AdminDataAccessor;

public class AdminProfileViewer {
	
	private AdminDataAccessor admDAObj=new AdminDataAccessor();
	
	private Administrator admObj=new Administrator();
	
	private Scanner sc=new Scanner(System.in);
		
	public void userProfileManagement() 
	{
				
		AdminProfileViewer admViewerObj=new AdminProfileViewer();
				
		System.out.println("==============================================================================================");
		System.out.println("                                        USER PROFILE MANAGEMENT                               ");
		System.out.println("==============================================================================================");
		
		System.out.println("PRESS FOLLOWING FUNCTION NUMBER TO IMPLEMENT CORRESPONDING SERVICE");
		
		System.out.println("1. VIEW USER PROFILE DETAILS");
		System.out.println("2. UPDATE YOUR PROFILE ");
		
		System.out.println("PRESS FUNCTION NUMBER: ");
		int selectedFunction=sc.nextInt();
		
		switch(selectedFunction) {
		
		case 1:
			admViewerObj.searchProfileDetails();
			break;
			
		case 2:
			admViewerObj.updateProfileDetails();
			break;
			
		default:
			System.out.println("INVALID FUNCTION NUMBER ! PLEASE TRY AGAIN !");
			break;
		}
		
	}
	
	public void searchProfileDetails()
	{
				
		System.out.println("======================================= SEARCH PROFILE DETAILS =======================================");

		System.out.println("ENTER USERNAME: ");
		String username=sc.nextLine();
		
		System.out.println("ENTER PASSWORD: ");
		String password=sc.nextLine();
		
		if(username.isEmpty() || password.isEmpty())
		{
			System.out.println("USERNAME OR PASSWORD IS EMPTY !");
		} else {
			
			admObj.setUsername(username);
			admObj.setPassword(password);
			
			String user=admObj.getUsername();
			String pass=admObj.getPassword();
			
			admDAObj.viewProfile(user, pass);
		}
	}
	
	public void updateProfileDetails()
	{
				
		System.out.println("======================================= UPDATE PROFILE DETAILS =======================================");

		System.out.println("ENTER ADMIN ID: ");
		int adminID=sc.nextInt();
		
		System.out.println("ENTER ADMIN NAME: ");
		String adminName=sc.next();
		sc.nextLine();
		
		System.out.println("ENTER USERNAME: ");
		String username=sc.nextLine();
		
		System.out.println("ENTER PASSWORD: ");
		String password=sc.nextLine();
		
		System.out.println("ENTER OTHER DETAILS: ");
		String otherDetails=sc.nextLine();
		
		if(String.valueOf(adminID).isEmpty() || adminName.isEmpty() || username.isEmpty() 
		   || password.isEmpty() || otherDetails.isEmpty())
		{
			
			System.out.println("MANDATORY FIELDS ARE EMPTY !");
			
		} else {
			
			admObj.setAdminID(adminID);
			admObj.setAdminName(adminName);
			admObj.setUsername(username);
			admObj.setPassword(password);
			admObj.setOtherDetails(otherDetails);
			
			int admID=admObj.getAdminID();
			String admName=admObj.getAdminName();
			String userName=admObj.getUsername();
			String pwd=admObj.getPassword();
			String details=admObj.getOtherDetails();
			
			boolean result = admDAObj.updateProfile(admID, admName, userName, pwd, details);
			
			if(result == true)
			{
				System.out.println("PROFILE UPDATED SUCCESSFULLY !");
			} else {
				
				System.out.println("PROFILE UPDATION FAILED !");
			}
		}
		
	}
	
	

}
