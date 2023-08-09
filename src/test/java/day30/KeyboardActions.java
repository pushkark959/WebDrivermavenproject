package day30;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("Welcome to automation");
		
		Actions  act = new Actions(driver);
		//ctrl +a
		act.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform();
		
		//ctrl + c
		act.keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND).perform();
	
		//tab
		//act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		act.sendKeys(Keys.TAB).perform();
		
		Thread.sleep(5000);

		//ctrl + v
		act.keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).perform();
		
		
		Thread.sleep(5000);
		driver.close();

	}

}
