package day24;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDropDownWithoutSelectTag {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		
		//Clicking on the dropdown
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		  
		
		List<WebElement> Options = driver.findElements(By.xpath("//ul[contains(@class,multiselect)]//label"));
		
		//Find total Number of options
		System.out.println("Total Number of size : "+Options.size());
		
		//Print all the option of the dropdown
		for(int i=0; i<Options.size(); i++)
		{
			System.out.println(Options.get(i).getText());
		}
		
		//Select option from dropdown
		for(int i=0; i<Options.size(); i++)
		{
			String option = Options.get(i).getText();
			if(option.equals("Java") || option.equals("Python"))
			{
			   Options.get(i).click();
			}
		}
		
		
		//Select option from dropdown using enhanced for loop
		for(WebElement option:Options)
		{
			String text=option.getText();
			if(text.equals("Java") || text.equals("Python"))
			{
				option.click();
			}
		}
		
		
		
		
		Thread.sleep(5000);
		driver.close();
		

	}

}
