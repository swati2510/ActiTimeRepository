package com.actiTime.genericLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.actiTime.genericLib.FileLib;
import com.actiTime.objectRepoLib.Home;
import com.actiTime.objectRepoLib.Login;

//import com.google.common.base.Throwables;

//import GenericLibraries_Listener.FileLib;
 //** test for commit 


public class BaseClass  {
	/*GLOBAL OBJECT*/
	
	public static WebDriver driver;
	
	public FileLib flib=new FileLib();
	
	@BeforeTest
	public void configBt()
	{
	
	}
		
	@BeforeClass
	public void configBC() throws Throwable
	{
	
		
	System.out.println("======LAUNCH THE BROWSER========");
	/*Read the browser name from properties file*/
	
	
	String browsername = flib.getPropertyKeyValue("browser");

	if(browsername.equals("firefox")){
		driver = new FirefoxDriver();
	}else if(browsername.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
	    driver = new ChromeDriver();
	}else if(browsername.equals("ie")){
	    driver = new InternetExplorerDriver();
	}
	    driver.manage().window().maximize();
}
	
	@BeforeMethod
	public void configBM() throws Throwable
	{
		System.out.println("<<<<<LOGIN>>>>>");
		String URL=flib.getPropertyKeyValue("url");
		String USER=flib.getPropertyKeyValue("username");
		String PASSWORD=flib.getPropertyKeyValue("password");
		driver.manage().window().maximize();
		driver.get(URL);
		
		Login lp = PageFactory.initElements(driver, Login.class);
	       lp.loginToApp(USER, PASSWORD);
	       Thread.sleep(2000);	
	  }
	
	@AfterMethod
	public void configAM() throws InterruptedException
	{
		Thread.sleep(2000);
		System.out.println("<<<<LOGOUT>>>>");
		
		Home hp= PageFactory.initElements(driver,Home.class);
		hp.logout();
	}
	
	@AfterClass
	public void configAC()
	{
		System.out.println("=======CLOSE THE BROWSER========");
		driver.close();
	}
	
	
	@AfterTest
	public void configAt()
	{
		
		
	}
	
}

