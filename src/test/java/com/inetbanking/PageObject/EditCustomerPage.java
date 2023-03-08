package com.inetbanking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage 
{
	WebDriver driver;
    public EditCustomerPage(WebDriver d)
    {
    	driver=d;
    	PageFactory.initElements(d,this);
    }
    
    @FindBy(xpath="//a[normalize-space()='Edit Customer']")
    WebElement editcustomerlink;
    
    @FindBy(xpath="//input[@name='cusid']")
    WebElement customerid;
    
    @FindBy(xpath="//input[@name='AccSubmit']")
    WebElement edidcustsubmitbutton;
    
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
    WebElement submit;
    
    @FindBy(xpath="//input[@name='res']")
    WebElement resetbutton;
    
    public void clickEditCustomerLink()
    {
    	editcustomerlink.click();
    }
    public void enterCustomerId(String custid)
    {
    	customerid.sendKeys(custid);
    }
    
    public void clickEditSubmitButton()
    {
    	edidcustsubmitbutton.click();
    }
    
    
    public void updateCustomerAddres(String add)
    {
    	address.clear();
    	address.sendKeys(add);
    }
    
    public void updateCustomerCity(String ccity)
    {
    	city.clear();
    	city.sendKeys(ccity);
    }
    
    public void updateCustomerState(String cstate)
    {
    	state.clear();
    	state.sendKeys(cstate);
    }
    
    public void updateCustomerpinno(String cpin)
    {
    	pin.clear();
    	pin.sendKeys(cpin);
    }
    
    public void updateCustomerMobno(String cmobno)
    {
    	mobNo.clear();
    	mobNo.sendKeys(cmobno);
    }
    
    public void updateCustomerEmail(String cemail)
    {
    	email.clear();
        email.sendKeys(cemail);
    }
    
    public void clickSubmitButton()
    {   
    	submit.click();
    }
    
    public void clickResetButton()
    {   
    	
    	resetbutton.click();
    }
}
