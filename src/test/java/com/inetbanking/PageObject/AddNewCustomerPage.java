package com.inetbanking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage 
{
   WebDriver driver;
   
    public AddNewCustomerPage(WebDriver d)
    {
    	driver=d;
    	PageFactory.initElements(d, this);
    }
    
    @FindBy(linkText="New Customer")
    WebElement addcustomerlink;
    
    @FindBy(xpath="//input[@name='name']")
    WebElement Customername;
    
    @FindBy(xpath="//tbody/tr[5]/td")
    WebElement gender;	
    
    @FindBy(xpath="//input[@id='dob']")
    WebElement DoBtxtbox;
    
    @FindBy(xpath="//textarea[@name='addr']")
    WebElement address;
    
    @FindBy(xpath="//input[@name='city']")
    WebElement city;
    
    @FindBy(xpath="//input[@name='state']")
    WebElement state;
    
    @FindBy(xpath="//input[@name='pinno']")
    WebElement pin;
    
    @FindBy(xpath="//input[@name='telephoneno']")
    WebElement mobNo;
    
    @FindBy(xpath="//input[@name='emailid']")
    WebElement email;
    
    @FindBy(xpath="//input[@name='password']")
    WebElement password;
    
    @FindBy(xpath="//input[@name='sub']")
    WebElement submitbutton;
    
    public void clickAddCustomerLink()
    {
    	addcustomerlink.click();
    }
    
    public void setCustomerName(String cname)
    {
    	 Customername.sendKeys(cname);
    }
    
    public void setGender(String cgender)
    {
    	 gender.click();
    }
    
    public void setCustomerDoB(String dd, String mm, String yyyy)
    {
    	DoBtxtbox.sendKeys(dd);
    	DoBtxtbox.sendKeys(mm);
    	DoBtxtbox.sendKeys(yyyy);
    	
    }
    
    public void setCustomerAddres(String add)
    {
    	address.sendKeys(add);
    }
    
    public void setCustomerCity(String ccity)
    {
    	city.sendKeys(ccity);
    }
    
    public void setCustomerState(String cstate)
    {
    	state.sendKeys(cstate);
    }
    
    public void setCustomerpinno(String cpin)
    {
    	pin.sendKeys(cpin);
    }
    
    public void setCustomerMobno(String cmobno)
    {
    	mobNo.sendKeys(cmobno);
    }
    
    public void setCustomerEmail(String cemail)
    {
        email.sendKeys(cemail);
    }
    
    public void setCustomerPassword(String cpwd)
    {
    	password.sendKeys(cpwd);
    }
    
    public void clickSubmitButton()
    {
    	submitbutton.click();
    }
    
    
    
  }
