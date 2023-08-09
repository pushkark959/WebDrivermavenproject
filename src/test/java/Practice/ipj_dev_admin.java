package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ipj_dev_admin {

	public static void main(String[] args) throws InterruptedException {
		
		// 1) Launch Browser
		WebDriver driver = new ChromeDriver();
		
		// 2) Open URL in browser
		driver.get("https://ipj-auth-frn-dev.harappa.education/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		// 3) Provide email address -  kumar@gmail.com
		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("kumar@gmail.com");
		
		// 4) Provide Password - 888ps@KS
		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("888ps@KS");
		
		// 5) Click on Login button
		driver.findElement(By.xpath("/html/body/app-root/nb-auth/nb-layout/div/div/div/div/div/nb-layout-column/nb-card/nb-card-body/nb-auth-block/app-login/form/button")).click();
		Thread.sleep(10000);
		
		// 6) Label Validation after successful login
		String actual_label = "";
		try
		{
			actual_label = driver.findElement(By.xpath("/html/body/app-root/app-dashboard/nb-layout/div[1]/div/div/div/div/nb-layout-column/app-ipj-dashboard/nb-card/nb-card-body/nb-tabset/ul/li[1]/a/span")).getText();
		}
		catch (NoSuchElementException e) {
			;	
		}
		String expected_label = "PROGRAMS";
		if (actual_label.equals(expected_label))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
		// 7) Close Browser
		driver.close();
		


	}

}
