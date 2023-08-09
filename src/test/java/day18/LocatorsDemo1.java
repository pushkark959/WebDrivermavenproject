package day18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		//Open app
		driver.get("http://automationpractice.pl/index.php");
		driver.manage().window().maximize();
		
		
		//Search Box
		driver.findElement(By.id("search_query_top")).sendKeys("T-SHIRTS");
		
		//Search Button
		driver.findElement(By.name("submit_search")).click();
		
		//Link text and partial link text
		driver.findElement(By.linkText("Printed Chiffon Dress")).click();
		
		//driver.close();

	}

}
