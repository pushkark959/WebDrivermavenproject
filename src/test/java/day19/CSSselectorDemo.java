package day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSselectorDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		//Thread.sleep(10000);
		
		//CSS selector with tag and id of search box
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("MacBook");
		driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("MacBook");
		
		//CSS selector with tag & class
		//driver.findElement(By.cssSelector("input.search-box-text ui-autocomplete-input")).sendKeys("MackBook");
		//driver.findElement(By.cssSelector(".search-box-text ui-autocomplete-input")).sendKeys("MackBook");
		
		//CSS selector with tag & attribute
		//driver.findElement(By.cssSelector("input[name='q']")).sendKeys("MackBook");
		//driver.findElement(By.cssSelector("[name='q']")).sendKeys("MackBook");
		
		//CSS selector with tag, class & attribute
		//driver.findElement(By.cssSelector("input.search-box-text ui-autocomplete-input[[name='q']]")).sendKeys("MackBook");
		
		Thread.sleep(5000);
		driver.close();
		

	}

}
