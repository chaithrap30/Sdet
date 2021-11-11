package com.genericutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DataBaseUtils {
	static Connection con=null;
	static ResultSet result=null;
	public void connectToDB() throws SQLException
	{
		Driver driverRef;
		driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");
	}
    public void closeDB() throws SQLException 
    {
    	con.close();
    }
  //get data from DB method to retrive data from database as key value pairs
   public static ResultSet execyteQuesry(String query) throws Throwable
   {
	   result=con.createStatement().executeQuery(query);
	   return result;
   }
   
   public static String executeQueryAndGetData(String query, int columnName, String expectedData) throws Throwable 
   {
	   boolean flag=false;
	   result=con.createStatement().executeQuery(query);
	   
	   while(result.next())
	   {
		   if(result.getString(columnName).equals(expectedData))
		   {
			   flag=true;
			   break;
		   }
	   }
	   if(flag)
	   {
		 System.out.println(expectedData+"===> data verified in database table");
		 return expectedData;
	   }
	   else
	   {
		   System.out.println(columnName+"===> data not verified in database table");
		   return expectedData;
	   }
	   
   }
}
