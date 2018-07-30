package dbOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private Connection conn;
	
    private static String dbSource="jdbc:mysql://localhost/clientmgtdb";
    private static String username="root";
    private static String password="";
	
	public Connection dbConnection()
	{
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn=DriverManager.getConnection(dbSource, username, password);
	
		}
		
		catch(ClassNotFoundException ex)
		{
			System.out.println("Class Not Found !");
		}
		
		catch(SQLException ex){
			System.out.println("Problem Occured !");
		}
		
		return conn;
	}
}
