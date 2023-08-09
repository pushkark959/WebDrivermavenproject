package day26;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeDemo_assign {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://the-internet.herokuapp.com/iframe");
		driver.manage().window().maximize();
		
		//WebElement frm = driver.findElement(By.xpath("//iframe[@title='Rich Text Area']")).click();
		//WebElement frm = driver.findElement(By.xpath("//iframe[@title='Rich Text Area']")).click();
		WebElement fr = driver.findElement(By.xpath("//iframe[@title='Rich Text Area']"));
		driver.switchTo().frame(fr);
		
		driver.findElement(By.xpath("//p[normalize-space()='Your content goes here.']")).clear();
		driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Welcome To Selenium");
		
		Thread.sleep(5000);
		driver.quit();
		
		

	}

}
