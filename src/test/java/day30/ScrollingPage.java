package day30;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {

	public static void main(String[] args) throws InterruptedException {
		//WebDriver driver = new ChromeDriver();
	    ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		JavascriptExecutor js = driver;
		
		//1) scroll down page by pixel
		js.executeScript("window.scrollBy(0,3000)", "");
		//System.out.println(js.executeScript("return window.pageYOffset;"));  //3000	
		
		//2) scroll down the page till the element is present
//		WebElement flag = driver.findElement(By.xpath("//img[@alt='Flag of India']"));
//	    js.executeScript("arguments[0].scrollIntoView();", flag);
//		System.out.println(js.executeScript("return window.pageYOffset;"));  //7688.5
		
		//3) scroll down till end of the page/document
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
				
		Thread.sleep(3000);
				
		// go back to initial position
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		
		Thread.sleep(5000);
		driver.quit();
		

	}

}
