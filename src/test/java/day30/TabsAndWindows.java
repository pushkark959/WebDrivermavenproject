package day30;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabsAndWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.opencart.com/");
		
		
	    driver.switchTo().newWindow(WindowType.TAB); // open tew tab in same active window
	    driver.get("https://www.google.com/");
	    
	    driver.switchTo().newWindow(WindowType.WINDOW); // open new window with a tab
	    driver.get("https://www.facebook.com/");
		
		
		
		
		Thread.sleep(5000);
		driver.quit();
		
		

	}

}
