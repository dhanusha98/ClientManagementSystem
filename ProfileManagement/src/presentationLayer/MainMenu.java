package presentationLayer;

import java.util.Scanner;

public class MainMenu {
	
	private Scanner sc=new Scanner(System.in);
	
	private AdminProfileViewer admPVObj=new AdminProfileViewer();
	private ClientManagementViewer clmObj=new ClientManagementViewer();

	public void displayServiceOverview()
	{
				
		System.out.println("===================================================================================");
		System.out.println("                                   MAIN MENU                                       ");
		System.out.println("===================================================================================");
		
		System.out.println("PRESS FUNCTION NUMBER IN FOLLOWING LIST TO IMPLEMENT CORRESPONDING SERVICE");
		
		System.out.println("1. VIEW YOUR PROFILE");
		System.out.println("2. CLIENT PROFILE MANAGEMENT");
		
		System.out.println("FUNCTION NUMBER: ");
		int selectedFunction=sc.nextInt();
		
		if(selectedFunction == 1)
		{
			admPVObj.userProfileManagement();
			
		} else if(selectedFunction == 2) {
			clmObj.clientProfileManagement();
			
		} else {
			
			System.out.println("INVALID FUNCTION NUMBER !");
		}
	}
	
	
	
}
