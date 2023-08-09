package day24;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckboxes1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().window().maximize();
		
		//select specific one checkbox
		//driver.findElement(By.xpath("//input[@id='monday']")).click();
				
	    //Select the number of checkboxes
	    List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
	    System.out.println("Number of checkboxes : "+checkboxes.size());
	    
	    // Select all the checkboxes
	    for(int i=0;i<=checkboxes.size();i++)
	    {
	    	if(i<7)
	    	checkboxes.get(i).click();
	    }
	    
	    for(int i=0;i<checkboxes.size();i++)
		{
			if(checkboxes.get(i).isSelected())
			{
			checkboxes.get(i).click();
			}
		}
	    
	    
	  
//	    //for selecting first two checkboxes using if 
//	    for(int i=0;i<=checkboxes.size();i++)
//	    {
//	    	if(i<2)
//	    	checkboxes.get(i).click();
//	    }
//	    
//	   
//	    //for un-selecting first two checkboxes using if
//	    for(int i=0;i<=checkboxes.size();i++)
//	    {
//	    	if(i<2)
//	    	checkboxes.get(i).click();
//	    }
	    
	    
	    
	    
	    Thread.sleep(10000);
	    
	    driver.close();
	}

	}
