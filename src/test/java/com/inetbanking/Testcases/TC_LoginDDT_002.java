package com.inetbanking.Testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.PageObject.LoginPage;
import com.inetbanking.Utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
  @Test(dataProvider="LoginData")
  public void LoginDDT(String un,String psw) throws IOException, InterruptedException
  {
	  LoginPage lp=new LoginPage(driver);
	  lp.setUsername(un);
	  logger.info("username entered");
	  lp.setPassword(psw);
	  logger.info("password entered");
	  lp.clickLoginButton();
	  
	  Thread.sleep(3000);
	  if(isAlertPresent()==true)
	  {
		  driver.switchTo().alert().accept();
		  driver.switchTo().defaultContent();
		  Assert.assertTrue(false);
		  logger.warn("login failed");
	 }
	  
	  else
	  {
		  Assert.assertTrue(true);
		  logger.info("login success");
		  lp.clickLogoutLink();
		  Thread.sleep(3000);
		  driver.switchTo().alert().accept();
		  driver.switchTo().defaultContent();
	  }
	  
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
    
  @DataProvider(name="LoginData")
  String[][] getData() throws IOException 
  {
	  String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/TestData/LoginData.xlsx";
	  
	  int rowcount=XLUtils.getRowCount(path,"Sheet1");
	  int cellcount=XLUtils.getCellCount(path,"Sheet1",1);
	  
	  String logindata[][]=new String[rowcount][cellcount];
	  
	  for(int i=1;i<=rowcount;i++)
	  {
		  for(int j=0;j<cellcount;j++)
		  {
			  logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
		  }
	  }
	  return logindata;
  }
}
