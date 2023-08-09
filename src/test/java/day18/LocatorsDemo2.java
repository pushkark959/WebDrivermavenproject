package day18;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		//Open App
		driver.get("http://automationpractice.pl/index.php");
		driver.manage().window().maximize();
		
		//Find Number of slider on homepage
	    List<WebElement> sliders = driver.findElements(By.className("homeslider-container"));
	    System.out.println("Number of Sliders : " + sliders.size());
	    
	    //Find total number of images on homepage
	    List <WebElement> images = driver.findElements(By.tagName("img"));
	    System.out.println("Total Number of images " + images.size());
	    
	    //Find total number of links
	    List<WebElement> Links = driver.findElements(By.tagName("a"));
	    System.out.println("Total number of links : "+ Links.size());
	    
	    driver.close();
		

	}

}
