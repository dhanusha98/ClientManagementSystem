package dbOperations;

import java.sql.*;

public class ClientDataAccessor {
	
	private static DatabaseConnection connObj=new DatabaseConnection();
	private Connection conn=connObj.dbConnection();

	public void searchProfile(int customerID)
	{
		
		String sql;
		
		try {
			
			Statement selectStmt=conn.createStatement();
			sql="SELECT * FROM customer WHERE CustomerID="+customerID+"";
			
			ResultSet rs=selectStmt.executeQuery(sql);
			
			if(rs.next()){
				System.out.println("CUSTOMER ID: "+rs.getString(1));
				System.out.println("CUSTOMER FULL NAME: "+rs.getString(2));
				System.out.println("USERNAME: "+rs.getString(3));
				System.out.println("PASSWORD: "+rs.getString(4));
				System.out.println("OTHER DETAILS: "+rs.getString(5));
				
			} else {
				System.out.println("NOT FOUND !");
			}
		}
		
		catch(Exception ex){
			 System.out.println("PROBLEM OCCURED !");
		}
	}
	
	public boolean insertProfile(String customerFullName, String username, String password, String otherDetails)
	{
		boolean isValid=false;
		String sql;
		
        try {
			
        	Statement insertStmt=conn.createStatement();
        	sql="INSERT INTO customer (CustomerFullName, Username, Password, OtherDetails) VALUES ('"+customerFullName+"', '"+username+"', '"+password+"', '"+otherDetails+"')";
        	int result=insertStmt.executeUpdate(sql);
        	
        	if(result > 0)
        	{
        		isValid=true;
        	} else {
        		isValid=false;
        	}
		}
		
		catch(Exception ex){
			System.out.println("PROBLEM OCCURED !");
		}
		
		return isValid;
	}
	
	public boolean updateProfile(int customerID, String customerFullName, String username, String password, String otherDetails)
	{
		
		boolean isValid=false;
		String sql;
		
        try {
			
        	Statement updateStmt=conn.createStatement();
        	sql="UPDATE customer SET CustomerFullName='"+customerFullName+"', Username='"+username+"', Password='"+password+"', OtherDetails='"+otherDetails+"' WHERE CustomerID="+customerID+"";
        	
        	int result =  updateStmt.executeUpdate(sql);
        	
        	if(result > 0)
        	{
        		isValid=true;
        	} else {
        		
        		isValid=false;
        	}
		}
		
		catch(Exception ex){
			System.out.println("PROBLEM OCCURED !");
		}
		
		return isValid;
	}
	
	public boolean deleteProfile(int customerID)
	{
		boolean isValid=false;
		String sql;
		
        try {
        	
        	Statement deleteStmt=conn.createStatement();
        	sql="DELETE FROM customer WHERE CustomerID="+customerID+"";
        	
        	int result=deleteStmt.executeUpdate(sql);
        	
        	if(result > 0)
        	{
        		isValid=true;
        	} else {
        		isValid=false;
        	}
			
		}
		
		catch(Exception ex){
			System.out.println("PROBLEM OCCURED !");
		}
		
		return isValid;
	}
	
	public static void main(String[] args) {
		
		Connection conn=connObj.dbConnection();

		ClientDataAccessor clientObj=new ClientDataAccessor();
		
		clientObj.searchProfile(5000);
		//boolean isValid=clientObj.insertProfile("DHANUSHA SIRIWARDANE", "DPS2813280", "2813280D", "FULL PRIVILEDGES");
		//boolean isValid=clientObj.updateProfile(5003,"PIUMAL", "DPS2813280", "2813280D", "FULL PRIVILEDGES");

		
		/*boolean isValid=clientObj.deleteProfile(5003);
		
		if(isValid == true)
		{
			
			System.out.println("RECORD DELETION SUCCESSFUL !");
			
		} else {
			
			System.out.println("RECORD DELETION FAILED !");
		}
*/	
		
	}
}
