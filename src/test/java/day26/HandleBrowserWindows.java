package day26;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		Set<String> WindowIDs = driver.getWindowHandles();
		
		
		//Approach1 - using List collection
		
		List<String> WindowIDsList = new ArrayList<String>(WindowIDs); // Change Set into List
		String ParentwindowID = WindowIDsList.get(0);
		String ChildwindowID = WindowIDsList.get(1);
		
		//Swith to child window
		driver.switchTo().window(ChildwindowID);
		driver.findElement(By.linkText("Contact Sales")).click();
		
		//Switch to parent window
		driver.switchTo().window(ParentwindowID);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		
		
		
		
		Thread.sleep(5000);
		driver.quit();
		

	}

}
