package com.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.utils.Utils;


public class Base {
	
	public static WebDriver driver;
	public static Properties prop;

	public Base()
	{
		FileInputStream fis;
		try 
		{
			fis = new FileInputStream(".\\src\\main\\java\\com\\crm\\config\\config.properties");
			prop=new Properties();
			prop.load(fis);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
			driver=new ChromeDriver();	
		}
		else if(browserName.equals("firefox"))
		{
			  System.setProperty("webdriver.firefox.marionette", ".\\src\\main\\resources\\geckodriver.exe");
			  driver=new FirefoxDriver();
		}
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Utils.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Utils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
	}
}
