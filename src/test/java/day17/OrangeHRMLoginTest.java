package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMLoginTest {

	public static void main(String[] args) throws InterruptedException {
		
		// 1) Launch browser
		//ChromeDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver();
		
		// 2) Open URL on browser
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize(); // To maximize the chrome window
		Thread.sleep(5000); //  Delay to excute next line in mili second
		
		// 3) Provide username - Admin
		//WebElement txrUsername = driver.findElement(By.name("username"));
		//txrUsername.sendKeys("Admin");
		driver.findElement(By.name("username")).sendKeys("Admin");
		
		// 4) Provide Password - admin123
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		// 5) Click on login button
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		Thread.sleep(5000);
		
		// 6) Verify  title of Dashboard Page
		
	/*	String act_title = driver.getTitle();
		String exp_title = "Dashboard";
		if(act_title.equals(act_title));
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}  */
		
		
		//Label Validation after successful login
		String act_label = "";
		try
		{
			act_label = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
		}
		catch(NoSuchElementException e) {
		}
		String exp_label = "Dashboard";
		if (act_label.equals(exp_label))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}  
		
		// 7) Close broser
		driver.close();  // To close the opened browser
		//driver.quit();  
	}

}
