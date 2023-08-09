package day29;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		WebElement destop = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		WebElement Macs = driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(destop).moveToElement(Macs).click().perform();
		
		Thread.sleep(5000);
		driver.close();
		
		
	}

}
