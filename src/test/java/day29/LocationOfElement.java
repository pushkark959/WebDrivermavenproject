package day29;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocationOfElement {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebElement logo = driver.findElement(By.xpath("//img[@alt='company-branding']"));
		System.out.println("Before maximizing window : "+logo.getLocation());
		
		driver.manage().window().maximize();
		System.out.println("After maximizing window: "+logo.getLocation());
		
		driver.manage().window().minimize();
		System.out.println("After minimizing window: "+logo.getLocation());
		
		driver.manage().window().fullscreen();
		System.out.println("After full Screen window: "+logo.getLocation());
		
		Point p = new Point(100, 100);
		driver.manage().window().setPosition(p);
		System.out.println("After setting window 100 * 100: "+logo.getLocation());
		
		Point p2 = new Point (50,50);
		driver.manage().window().setPosition(p2);
		System.out.println("After setting window 50 * 50: "+logo.getLocation());
		
		Thread.sleep(5000);
		driver.close();
		

	}

}
