package day29;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

	public static void main(String[] args) throws InterruptedException   {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		WebElement min_slider = driver.findElement(By.xpath("//span[1]"));
		System.out.println(min_slider.getLocation());
		act.dragAndDropBy(min_slider, 250, 250).perform();
		System.out.println(min_slider.getLocation());
		
		WebElement max_slider = driver.findElement(By.xpath("//span[2]"));
		System.out.println(max_slider.getLocation());
		act.dragAndDropBy(max_slider, -150, 250).perform();
		System.out.println(max_slider.getLocation());

		
		Thread.sleep(5000);
		driver.close();
		
		
		
		


	}

}
