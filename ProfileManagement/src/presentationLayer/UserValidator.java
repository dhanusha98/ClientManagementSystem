package presentationLayer;

import dbOperations.AdminDataAccessor;

public class UserValidator {
	
	private AdminDataAccessor adminDAObj=new AdminDataAccessor();
	private Administrator admObj=new Administrator();
	
	public String adminValidation()
	{
		
		String username=admObj.getUsername();
		String password=admObj.getPassword();
		
		/*boolean result = adminDAObj.userValidation(username, password);
		
		String resultStatus;
		
		if(result == true)
		{
			resultStatus="SUCCESSFUL !";
		} else {
			resultStatus="UNSUCCESSFUL !";
		}
		
		return resultStatus;*/
		
		String resultStatus= "USERNAME: " + username + "PASSWORD: "+password;
	
		return resultStatus;
	} 

}
