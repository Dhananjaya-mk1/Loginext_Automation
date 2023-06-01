package com.loginext.GenericLibrary;

import java.util.Random;

/**
 * This class consists of generic methods wrt to Java
 * @Dhananjaya MK
 */

public class JavaUtility {

	/**
	 * This method will generate random number and return it to user
	 * @return 
	 */
	public int getRandomnumber()
	{
		Random ran=new Random();
		int rand = ran.nextInt();
		return rand;
	}

}
