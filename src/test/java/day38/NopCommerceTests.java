package day38;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NopCommerceTests {
	WebDriver driver;
	
	@BeforeClass
	void setup()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
	}
	
	//@Test(priority=1)
	void testlog()
	{
		try
		{
			boolean status = driver.findElement(By.xpath("//input[@id='small-searchterms']")).isDisplayed();
			Assert.assertEquals(status, true);			
		}
		catch(NoSuchElementException e)
		{
			Assert.assertTrue(false);
		}
	}
	
	
	@Test(priority=2)
	void testlogin() throws InterruptedException
	{
		try
		{
		driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click(); //login link
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("polard@yopmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("test123");
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
		Thread.sleep(3000);
		
		//Validation
		boolean status = driver.findElement(By.xpath("//a[@class='ico-account']")).isDisplayed();
		Assert.assertEquals(status, true);
	    }
		catch (Exception e)
		{
			Assert.fail(); // Assert.assertTrue(false)
		}
	}
	
	@Test(priority=3,dependsOnMethods= {"testlogin"})
	void testlogout() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[normalize-space()='Log out']")).click();
		Thread.sleep(3000);
		boolean status=driver.findElement(By.xpath("//a[normalize-space()='Register']")).isDisplayed();
		System.out.println(status);
		Assert.assertEquals(status,true);
	}
	
	@AfterClass
	void teardown()
	{
		driver.quit();
	}
	
	

}
