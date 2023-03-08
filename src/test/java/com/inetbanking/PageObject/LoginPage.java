package com.inetbanking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	
     @FindBy(xpath="//input[@name='uid']")
     WebElement username;
     
     @FindBy(xpath="//input[@name='password']")
     WebElement password;
     
     @FindBy(xpath="//input[@name='btnLogin']")
     WebElement loginbutton;
     
     @FindBy(xpath="//a[text()='Log out']")
     WebElement logoutlink;
     
    public LoginPage(WebDriver d)
     {
    	 driver=d;
    	 PageFactory.initElements(d,this);
     }
     
    public void setUsername(String uname)
    {
    	username.sendKeys(uname);
    }
    
    public void setPassword(String pswd)
    {
    	password.sendKeys(pswd);
    }
    
    public void clickLoginButton()
    {
    	loginbutton.click();
    }
    
    public void clickLogoutLink()
    {
    	logoutlink.click();
    }
}
