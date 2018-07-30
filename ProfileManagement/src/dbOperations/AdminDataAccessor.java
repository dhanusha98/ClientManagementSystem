package dbOperations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import presentationLayer.Administrator;

public class AdminDataAccessor {
	
	private static DatabaseConnection connObj=new DatabaseConnection();
	private Connection conn=connObj.dbConnection();
	
	private Administrator adminObj=new Administrator();
	
	public boolean userValidation(String username, String password)
	{
		boolean result=false;
		try {
			
			
			Statement selectStmt=conn.createStatement();
		    String sql="SELECT * FROM admin WHERE Username='"+username+"' AND Password='"+password+"'";
			
		    ResultSet rs=selectStmt.executeQuery(sql);
		    
		    if(rs.next())
		    {
		    	result=true;
		    } else {
		    	
		    	result=false;
		    }
		}
		
		catch(Exception ex) {
			System.out.println("PROBLEM OCCURED !"+ex.getMessage());
		}
		
		return result;
	}
	
	public void viewProfile(String username, String password)
	{
		
		try {
			
			Statement selectStmt=conn.createStatement();
		    String sql="SELECT * FROM admin WHERE Username='"+username+"' AND Password='"+password+"'";
			
		    ResultSet rs=selectStmt.executeQuery(sql);
		    
		    if(rs.next())
		    {
		    	  System.out.println("ADMIN ID: "+rs.getString(1));
	    		  System.out.println("ADMIN FULL NAME: "+rs.getString(2));
	    		  System.out.println("USERNAME: "+rs.getString(3));
	    		  System.out.println("PASSWORD: "+rs.getString(4));
	    		  System.out.println("OTHER DETAILS: "+rs.getString(5));
	    		   
		    } else {
		    	
		    	System.out.println("PROFILE DETAILS NOT FOUND !");
		    }
		}
		
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void searchProfile(int adminID)
	{
				
       try {
			
    	   
    	   Statement selectStmt=conn.createStatement();
    	   String sql="SELECT* FROM admin WHERE AdminID="+adminID+"";
    	   
    	   ResultSet rs=selectStmt.executeQuery(sql);
    	   
    	   if(rs.next())
    	   {
    		   
    		   System.out.println("ADMIN ID: "+rs.getString(1));
    		   System.out.println("ADMIN FULL NAME: "+rs.getString(2));
    		   System.out.println("USERNAME: "+rs.getString(3));
    		   System.out.println("PASSWORD: "+rs.getString(4));
    		   System.out.println("OTHER DETAILS: "+rs.getString(5));
    		   
    	   } else {
    		   
    		   System.out.println("NOT FOUND !");
    	   }
			
		}
		
		catch(Exception ex) {
			System.out.println("PROBLEM OCCURED !");
		}
		
	}
	
	public boolean insertProfile(String adminName, String username, String password, String otherDetails)
	{
		
		boolean isValid=false;
		
        try {
			
        	Statement insertStmt=conn.createStatement();
        	String sql="INSERT INTO admin (AdminName, Username, Password, OtherDetails) VALUES ('"+adminName+"', '"+username+"', '"+password+"', '"+otherDetails+"')";
			
        	int result = insertStmt.executeUpdate(sql);
        	
        	if(result > 0)
        	{
        		isValid=true;
        	} else {
        		isValid=false;
        	}
        	
		}
		
		catch(Exception ex) {
			System.out.println("PROBLEM OCCURED !");
		}
		
		return isValid;
	}
	
	public boolean updateProfile(int adminID, String adminName, String username, String password, String otherDetails)
	{
		
		boolean isValid=false;
		
        try {
			
        	Statement updateStmt=conn.createStatement();
			String sql="UPDATE admin SET AdminName='"+adminName+"', Username='"+username+"', Password='"+password+"', OtherDetails='"+otherDetails+"' WHERE AdminID="+adminID+"";
			int result = updateStmt.executeUpdate(sql);
        	
        	if(result > 0)
        	{
        		isValid=true;
        	} else {
        		isValid=false;
        	}
        	
		}
		
		catch(Exception ex) {
			System.out.println("PROBLEM OCCURED !");
		}
		
        return isValid;
		
	}
	
	public boolean deleteProfile(int adminID)
	{
		
		boolean isValid=false;
		
        try {
			
        	Statement deleteStmt=conn.createStatement();
     	    String sql="DELETE FROM admin WHERE AdminID="+adminID+"";
     	    
     	    int result=deleteStmt.executeUpdate(sql);
     	    
     	    if(result > 0)
     	    {
     	    	isValid=true;
     	    	
     	    } else {
     	    	
     	    	isValid=false;
     	    }
			
		}
		
		catch(Exception ex) {
			System.out.println("PROBLEM OCCURED !");
		}
		
        return isValid;
	}
	
	/*public static void main(String[] args) {
		
		AdminDataAccessor adminDAObj=new AdminDataAccessor();
		
		boolean result = adminDAObj.userValidation("DhanushaPS", "2813280PS");
		//boolean result = adminDAObj.insertProfile("PIUMAL", "PIUMALPS", "2813280PS", "FULL PRIVILEDGES");
		
		//boolean result = adminDAObj.updateProfile(1002, "PIUMAL SIRIWARDANE", "PIUMALDAS", "2813280DPSPIUMAL", "FULL PRIVILEDGES");
		
		
		//boolean result=adminDAObj.deleteProfile(1002);
		
		if(result == true)
		{
			
			System.out.println("SUCCESSFUL !");
			
		} else {
			
			System.out.println("UNSUCCESSFUL !");
		}
		
	
	}*/
}
