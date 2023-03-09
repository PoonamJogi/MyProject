package com.inetbanking.Testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetbanking.PageObject.EditCustomerPage;
import com.inetbanking.PageObject.LoginPage;

import junit.framework.Assert;

public class TC_EditCustomerTest_004 extends BaseClass
{
	@Test
    public void editCustomer() throws InterruptedException, IOException
    {
	  LoginPage lp=new LoginPage(driver);
	  lp.setUsername(UserId);
	  logger.info("user Id entered");
	  lp.setPassword(Password);
	  logger.info("password entered");
	  lp.clickLoginButton();
	
	  EditCustomerPage editcust=new EditCustomerPage(driver);
	  editcust.clickEditCustomerLink();
	  logger.info("click on Edit Customer link");
	  
	  editcust.enterCustomerId("6913");
	  logger.info("Customer Id provided");
	  editcust.clickEditSubmitButton();
	  
	  
		  logger.info("Customer detail update started..");
		  editcust.updateCustomerCity(randomString());
	      editcust.updateCustomerEmail(randomString()+"@gmail.com");
		  editcust.clickSubmitButton();
		  
    
		  if(isAlertPresent()==true)
		  {
			  driver.switchTo().alert().accept();
			  driver.switchTo().defaultContent();
			  Assert.assertTrue(true);
			  logger.info("customer detail updated successfully ");
		  }
		  else 
		  {  
			  logger.info("customer detail updation failed");
			  captureScreenshot(driver,"editcuatomer");
			  Assert.assertTrue(false);
		  }
		  
    }
	
}


