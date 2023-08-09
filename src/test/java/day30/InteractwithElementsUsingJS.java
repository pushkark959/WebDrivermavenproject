package day30;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InteractwithElementsUsingJS {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
	    //ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//driver.findElement(By.xpath("//input[@id='name']")).sendKeys("sadf");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//JavascriptExecutor js =  driver;
	    
		//First name - inputbox
		WebElement inputbox = driver.findElement(By.xpath("//input[@id='name']"));
		js.executeScript("arguments[0].setAttribute('value','john')", inputbox);
		
		//Radio button
		WebElement male_Rd = driver.findElement(By.xpath("//input[@id='male']"));
		//male_Rd.click(); //ClickInterceptedException
		js.executeScript("arguments[0].click();",male_Rd);
		
		//Checkbox button
		WebElement chkbox = driver.findElement(By.xpath("//input[@id='monday']"));
		js.executeScript("arguments[0].click();",chkbox);
		
		//button
//		
//		WebElement button = driver.findElement(By.id("FSsubmit"));
//		System.out.println(button);
//		js.executeScript("arguments[0].click();",button);
//		
		//link
		WebElement link = driver.findElement(By.xpath("//a[normalize-space()='2']"));
     	js.executeScript("arguments[0].click();",link);
		
		Thread.sleep(10000);
		driver.quit();
		
		

	}

}
