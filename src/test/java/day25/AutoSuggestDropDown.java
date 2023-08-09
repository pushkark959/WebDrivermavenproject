package day25;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Selenium");
		Thread.sleep(5000);
		List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class,'wM6W7d')]//span"));
		System.out.println("List of suggestion : "+list.size());
		
		
		//Select an option from the list
		for(int i=0; i<=list.size();i++)
		{
			String text = list.get(i).getText();
			System.out.println("List of suggestion : "+text);
			if (text.equals("selenium tutorial"))
			{
				list.get(i).click();
				break;
			}
		}
		
		Thread.sleep(30000);
		driver.close();
		

	}

}
