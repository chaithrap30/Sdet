package com.genericutils;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	//* author @ chaithra 
  /**
   * *This method is to generate random number to avoid duplicates 
   * * @return 
   */
	public static String getRandomData()
	{
		Random random=new Random();
		int ran = random.nextInt(1000);
		return ""+ran;
	}
	public static String getCurrentDate()  //this method is used to get current date of the system.
	{
		Date date=new Date();
		String currentdate=date.toString();
		return currentdate;
	}

}
