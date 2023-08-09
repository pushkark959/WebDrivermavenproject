package day39;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage2 {
	
	public WebDriver driver;
	
	//Constructor
	LoginPage2(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locators
	
	@FindBy(xpath = "//img[@alt='company-branding']")
	WebElement img_logo;
	
	@FindBy (name="username")
	WebElement txt_username;
	
	@FindBy(name="password")
	WebElement txt_password;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement txt_submit;
	
	//@FindBy(tagName="a")
	//List<WebElement> links;
	
	//Action Method
	public void setUserName()
	{
		txt_username.sendKeys("Admin");
	}
	
	public void setPassword()
	{
		txt_password.sendKeys("Admin123");
	}
	
	public void clickSubmit()
	{
		txt_submit.click();
	}
	
	public boolean checkLogoPresence()
	{
		boolean status = img_logo.isDisplayed();
		return status;
	}

}
