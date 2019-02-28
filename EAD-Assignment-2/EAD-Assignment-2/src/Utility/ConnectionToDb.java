package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * creates connection with database
 * @author Akshat
 *
 */
public class ConnectionToDb {

	public static Connection getConnection()
	{
		Connection con=null;
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			con=DriverManager.getConnection(  
			UtilityDB.dbURL+UtilityDB.dbName,UtilityDB.dbUser,UtilityDB.dbPassword);  
			
    		}
 
		
		    catch(Exception e)
		    {
		    	System.out.println(e);
		    	
		    }  
		 
		return con;
			  
	}
}
