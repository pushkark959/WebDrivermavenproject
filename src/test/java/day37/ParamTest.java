package day37;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.AssertJUnit;
import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParamTest {

	WebDriver driver;

	@BeforeClass
	@Parameters({"browser"})
	void setup(String br) {
		if (br.equals("chrome"))
		{
		driver = new ChromeDriver();
		}
		else
		{
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ipj-lrn-dev.harappa.education/login");
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	void testLogo() {
		try {
			boolean status = driver.findElement(By.xpath("//img[@alt='Logo']")).isDisplayed();
			Assert.assertEquals(status, true);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test(priority = 2)
	void testHomePageTitle() {
		AssertJUnit.assertEquals(driver.getTitle(), "Harappa", "Titles are not matched");

	}

	@AfterClass
	void close() {
		driver.close();

	}

}
