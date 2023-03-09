package com.inetbanking.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	
	@Test
	public void setLogin() throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(UserId);
		logger.info("entered userID");
		lp.setPassword(Password);
		logger.info("entered password");
		lp.clickLoginButton();
		logger.info("click on submitbutton");
		
		if(driver.getCurrentUrl().contains("Managerhomepage"))
		{
			Assert.assertTrue(true);
			logger.info("Login successful");
		}
		
		else
		{
			captureScreenshot(driver,"setLogin");
			Assert.assertTrue(false);
			logger.info("Login fail");
		}
	}
	
}
