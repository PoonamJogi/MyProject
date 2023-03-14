package com.inetbanking.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObject.AddNewCustomerPage;
import com.inetbanking.PageObject.LoginPage;

public class TC_AddNewCustomerTest_003 extends BaseClass
{
	
	@Test
	public void addnewCustomer() throws InterruptedException, IOException
	{
	
	LoginPage lp=new LoginPage(driver);
    
	lp.setUsername(UserId);
	logger.info("entered userID");
	lp.setPassword(Password);
	logger.info("entered password");
	lp.clickLoginButton();
	logger.info("click on submit button");
	
	AddNewCustomerPage addcust=new AddNewCustomerPage(driver);

	logger.info("click on New Customer link");
	addcust.clickAddCustomerLink();
	
	logger.info("customer detail provided");
	addcust.setCustomerName("poonam");
	addcust.setGender("female");
	addcust.setCustomerDoB("10","07","1989");
	addcust.setCustomerAddres("mahalunge");
	addcust.setCustomerCity("pune");
	addcust.setCustomerState("maharashtra");
	addcust.setCustomerpinno("410567");
	addcust.setCustomerMobno("5673458921");
    String email=randomString()+"@gmail.com";
    addcust.setCustomerEmail(email);
	addcust.setCustomerPassword("abcd");
	addcust.clickSubmitButton();
	
	logger.info("validation started..");
    boolean status= driver.getPageSource().contains("Customer Registered Successfully!!!");
    if(status==true)
    {   
    	logger.info("Added customer detail Successfully");
    	Assert.assertTrue(true);
    	
    	
    }
    else
    {   
    	logger.info("Failed to add customer detail");
    	captureScreenshot(driver,"addCustomer");
    	Assert.assertTrue(false);
    	
    }
	
   
	}
	
}

