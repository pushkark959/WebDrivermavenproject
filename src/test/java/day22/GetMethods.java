package day22;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		System.out.println("Title of the page : "+driver.getTitle());
		System.out.println("Current URL : "+driver.getCurrentUrl());
		
		System.out.println("Page Source......");
		String ps = driver.getPageSource();
		System.out.println(ps);
		System.out.println(ps.contains("html"));  
		
		System.out.println(driver.getWindowHandle()); //return current unique window id
		
		
		Thread.sleep(5000);
		System.out.println();
		driver.findElement(By.linkText("OrangeHRM, Inc")).click(); // open  new browser
		Set <String> windowids = driver.getWindowHandles(); //return  unique window id of all active browser
		
		for(String winid : windowids)
		{
			System.out.println(winid);
		}
		
		driver.quit();
		

	}

}
