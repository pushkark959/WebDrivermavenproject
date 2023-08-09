package day39;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
	
	
	WebDriver driver;
	LoginPage lp;
	
	@BeforeClass
	void setup()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	
	@Test (priority=1)
	void testlogo()
	{
		lp = new LoginPage(driver);
		 
		//Assert.assertEquals(lp.checkLogoPresence(), true);
		Assert.assertEquals(lp.checkLogoPresence(), true);
		
	}
	
	@Test (priority=2)
	void testlogin()
	{
		lp.setUserName("Admin");
		lp.setPassword("Admin123");
		lp.clickSubmit();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@AfterClass
	void teardown()
	{
		driver.close();
	}

}
