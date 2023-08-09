package day20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		String ProductName = driver.findElement(By.xpath("//a[text()='MacBook']")).getText();
		String productname = driver.findElement(By.xpath("/html/body/main/div[2]/div/div/div[2]/div[1]/form/div/div[2]/div[1]/h4/a")).getText();
		System.out.println("Name of the Product : "+ProductName);
		System.out.println("Name of the Product : "+productname);
		
		driver.close();
		
		

	}

}
