package com.loginext.GenericLibrary;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class will read data from property file and return to user 
 * @author Dhananjaya MK
 *
 */
public class PropertyFileUtility {

	/**
	 * This class will read data from property file for the key given to user and return value to user
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pLib=new Properties();
		pLib.load(fis);
		
		String value = pLib.getProperty(key);
		return value;
	}
}
