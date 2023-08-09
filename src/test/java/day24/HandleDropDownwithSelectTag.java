package day24;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropDownwithSelectTag {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().window().maximize();
		
//		WebElement drpCountryEle = driver.findElement(By.xpath("//select[@id='country-list']"));
//		Select drpCountry = new Select (drpCountryEle);
//		
		WebElement drpCountryEle=driver.findElement(By.xpath("//select[@id='country-list']")); 
		Select drpCountry=new Select(drpCountryEle);
		
		//Selecting an option from the dropdown
		//drpCountry.selectByVisibleText("USA");
		//drpCountry.selectByIndex(4);//use this only if value attribute is present for option tag (India)
		
		//Find total option in dropdown
		List<WebElement> Options = drpCountry.getOptions();
		System.out.println("Total Number of options : "+Options.size());
		
		//Print option in console window
		for(int i=0; i<Options.size(); i++)
		{
			System.out.println(Options.get(i).getText());
		}
		
		
		//Using enhance loop
		for(WebElement op:Options)
		{
			System.out.println(op.getText());
		}

		Thread.sleep(5000);
		driver.close();

	}

}
