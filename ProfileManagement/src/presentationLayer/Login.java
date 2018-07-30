package presentationLayer;

import java.util.*;

import dbOperations.AdminDataAccessor;
public class Login {
	
	private AdminDataAccessor adminDAObj=new AdminDataAccessor();
	private Administrator admObj=new Administrator();	
	
	public void adminValidation(String username, String password)
	{
		
		MainMenu mainMenuObj=new MainMenu();
		
		if(username.isEmpty() || password.isEmpty())
		{
			
			System.out.println("USERNAME OR PASSWORD IS EMPTY !");
			
		} else {
			
			admObj.setUsername(username);
			admObj.setPassword(password);
			
			String user=admObj.getUsername();
			String pass=admObj.getPassword();
			
			boolean result = adminDAObj.userValidation(user, pass);
			
			String resultStatus;
			
			if(result == true)
			{
				mainMenuObj.displayServiceOverview();
				
			} else {
				System.out.println("INVALID USER AUTHENTICATIONS !");
			}
		}
					
	} 

	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		Login logObj=new Login();
		
		System.out.println("ENTER USERNAME: ");
		String username=sc.nextLine();
		
		System.out.println("ENTER PASSWORD: ");
		String password=sc.nextLine();
				
	    logObj.adminValidation(username, password);
	}

		
}
