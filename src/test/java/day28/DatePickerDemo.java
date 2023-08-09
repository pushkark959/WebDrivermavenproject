package day28;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
//		driver.findElement(By.xpath("//input[@type='text']")).click();
//		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("10/15/2022"); // mm/dd//yy
		
		
		//select month & year
		
		String year="2024";
		String month="July";
		String date="22";
				
		driver.findElement(By.xpath("//input[@id='datepicker']")).click(); // will open the date picker
	
		
		
	
		while(true)
		{
			String mon=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yr=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(mon.equals(month) && yr.equals(year))
			{
				break;
			}
			
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();  // Future date
			//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();   //Past date
					
		}
		 //Select date
		List<WebElement> allDates =  driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		/*
		for(WebElement dt:allDates)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
				break;
			}
		}
		*/
		
		for(int i=1;i<=allDates.size();i++)
		{
			if(allDates.get(i).getText().equals(date))
			{
				allDates.get(i).click();
				break;
			}
		}
		
		
 		
		Thread.sleep(5000);
		driver.close();
			
	}

}
