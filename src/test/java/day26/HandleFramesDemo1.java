package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFramesDemo1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.manage().window().maximize();
		driver.switchTo().frame("packageListFrame");
		//driver.findElement(By.xpath("//a[normalize-space()='org.openqa.selenium']")).click();
		driver.findElement(By.linkText("org.openqa.selenium")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("packageFrame");
		//driver.findElement(By.xpath("//span[normalize-space()='Alert']")).click();
		driver.findElement(By.linkText("WebDriver")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("classFrame");
		driver.findElement(By.linkText("OVERVIEW")).click();
		
		//div[@class='topNav']//a[normalize-space()='Overview']
		
		
		
		Thread.sleep(5000);
		driver.close();

	}

}
