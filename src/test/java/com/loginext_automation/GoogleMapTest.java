package com.loginext_automation;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleMapTest 
{
	public static void main(String[] args) throws Throwable 
	{
		
//Setting up and launching the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//Entering the Url of the application
		driver.get("https://www.google.com/maps");
		
//Clicking on Directions button
		driver.findElement(By.xpath("//button[@aria-label='Directions']")).click();
		
//Entering the source loaction
		driver.findElement(By.xpath("//input[@tooltip=\"Choose starting point, or click on the map...\"]")).sendKeys("Jyothi Bakery, 2936, Mahakavi Kuvempu Rd, D-Block, Gayatrinagar, Rajajinagar, Bengaluru, Karnataka 560010");
		
//Entering the destination location		
		driver.findElement(By.xpath("//input[@tooltip='Choose destination, or click on the map...']")).sendKeys("91springboard,vikhroli");
		
//Clicking on enter button using robot class		
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
				
//Selecting the first route
		driver.findElement(By.xpath("//div[@id='section-directions-trip-0']")).click();
		
//Storing the driving instructions in a list
		List<WebElement> list = driver.findElements(By.xpath("//h2[@class='JoXhkf fontBodyMedium']"));
		int count = list.size();
		System.out.println(count);
	
//Copying the instructions to Excel file
		FileInputStream fis=new FileInputStream("./src/test/resources/Excel.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet=book.getSheet("Sheet1");
		
		for (int i = 0; i < count; i++) 
		{
			Row row=sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(list.get(i).getText());
			System.out.println(list.get(i).getText());
			System.out.println();
		}
	
		FileOutputStream fout=new FileOutputStream("./src/test/resources/Excel.xlsx");
		book.write(fout);
		Random ran=new Random();
		int rand = ran.nextInt(1000);
		
//Taking the screenshot			
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/maps"+rand+".png");
		FileUtils.copyFile(src, dest);
		
//closing the browser		
		driver.quit();
}
}