package com.inetbanking.Testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
   ReadConfig read=new ReadConfig();
   public String url=read.getUrl();
   public String UserId=read.getUserId();
   public String Password=read.getPassword();
   
   public static WebDriver driver;
   public static  Logger logger;
  
   @Parameters("browser")
   @BeforeClass
   public void setup(String br)
   {
	   logger=Logger.getLogger("MyProject");
	   PropertyConfigurator.configure("Log4j.properties");
		  
	 if(br.equalsIgnoreCase("chrome"))
	 {
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	 }
	 
	 else if(br.equalsIgnoreCase("edge"))
	 {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	 }
	 
	 else if(br.equalsIgnoreCase("firefox")) 
	 {
		 WebDriverManager.firefoxdriver().setup();
		 driver=new FirefoxDriver();
	 }
	 
	 else if(br.equalsIgnoreCase("ie"))
	 {
		 WebDriverManager.iedriver().setup();
		 driver=new InternetExplorerDriver();
	 }
	 
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get(url);
	  driver.manage().window().maximize();
	 
	  }
   
   @AfterClass
   public void tearDown()
   {
	   driver.quit();
   }
   
   public void captureScreenshot(WebDriver driver, String tname) throws IOException
   {
	   TakesScreenshot ts=(TakesScreenshot) driver;
	   File src=ts.getScreenshotAs(OutputType.FILE);
	   File target=new File(System.getProperty("user.dir")+"/Screenshots/" +tname +".png");
	   FileUtils.copyFile(src, target);
	   System.out.println("Screenshot Taken");
   }
   
   public String randomString()
	{
		String generatestring=RandomStringUtils.randomAlphabetic(7);
		return generatestring;
	}
   
   public String randomAlphanumeric()
   {
	   String generatealphanemeric=RandomStringUtils.randomAlphanumeric(6);
	   return generatealphanemeric;
   }
  
   public boolean isAlertPresent()
   {
	 try
	 {
		 driver.switchTo().alert();
		 return true;
	 } catch(NoAlertPresentException e)
	 {
		 return false;
	 }
	  
  }
}
