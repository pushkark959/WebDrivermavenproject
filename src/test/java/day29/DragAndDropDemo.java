package day29;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		WebElement Rome = driver.findElement(By.xpath("//div[@id='box6']"));
		WebElement Italy = driver.findElement(By.xpath("//div[@id='box106']"));
		act.dragAndDrop(Rome, Italy).perform(); // Rome will drag to italy
		
		WebElement washington = driver.findElement(By.xpath("//div[@id='box3']"));
		WebElement United_styaes = driver.findElement(By.xpath("//div[@id='box103']"));
		act.dragAndDrop(washington, United_styaes).perform(); // wasington will drag to united_staes
			
		
		Thread.sleep(5000);
		driver.close();
	}

}
