package day36;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	
	WebDriver driver;
	@BeforeClass
	void setup()
	{
		driver = new ChromeDriver();
	}
	
	@Test (dataProvider ="dp")
	void testlogin(String email, String pwd)
	{
		driver.get("https://demo.nopcommerce.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
		
		String exp_title = "nopCommerce demo store";
		String act_title = driver.getTitle();
		
		Assert.assertEquals(exp_title, act_title);
	}
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}
	
	@DataProvider (name = "dp")
	String [][] loginData()
	{
		String data [][]= {
				{"polard@yopmail.com","test123"},
				{ "abc@gmail.com", "test123" }, 
				{ "pavanol@gmail.com", "test@123" },
				{ "pavanoltraining@gmail.com", "test3" },
				{ "pavanoltraining@gmail.com", "test@123" },
				{ "pavanoltraining@gmail.com", "test@123" } 
			};
		return data;
		}
	}

