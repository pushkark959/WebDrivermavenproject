package day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionCommands {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		System.out.println("Display Status of Logo : "+logo.isDisplayed());
		
		boolean status = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		System.out.println(status);
		
		WebElement searchbox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		System.out.println("Display Status : "+searchbox.isDisplayed());
		System.out.println("Enabled Status : "+searchbox.isEnabled());
		
		WebElement male_rd = driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female_rd = driver.findElement(By.xpath("//input[@id='gender-female']"));
		
		System.out.println("Before Selection radio button..");
		System.out.println(male_rd.isSelected()); //false
		System.out.println(female_rd.isSelected()); //false
		
		System.out.println("After Selection male radio button..");
		male_rd.click();
		System.out.println(male_rd.isSelected()); //true
		System.out.println(female_rd.isSelected()); //false
		
		System.out.println("After Selection female radio button..");
		female_rd.click();
		System.out.println(male_rd.isSelected()); //false
		System.out.println(female_rd.isSelected()); //true
				
		
		driver.close();

	}

}
