package day24;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckboxes {

	
	
	
	public static void main(String[] args) throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://itera-qa.azurewebsites.net/home/automation");
    driver.manage().window().maximize();
    
    //Select Specific one checkbox
   // driver.findElement(By.xpath("//label[normalize-space()='Monday']")).click();
    
    //Select the number of checkboxes
    List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
    System.out.println("Number of checkboxes : "+checkboxes.size());
    //System.out.println("Number of checkboxes : "+((WebElement) checkboxes.getText());
//     Iterator<WebElement> it= checkboxes.iterator();
//     while(it.hasNext()) {
//     System.out.println(it.next().getText());
//      }
    
    
    // Select all the checkboxes for normal for loop
   
 /*    for(int i=0;i<=checkboxes.size();i++)
    {
    	checkboxes.get(i).click();
    }
    
    // Select all the checkboxes with enhanced for loop
    for(WebElement chkbox:checkboxes)
	{
		chkbox.click();    
	} */
    
    //Select last 3 checkboxes
	// total Number of checkboxes-how many checkboxes to be selected= startign index
	//7-3= 4 ( startign index)
    
   /* for(int i=0;i<= 3;i++)
    {
    	//int check=checkboxes.size();s
    	WebElement checkbox = checkboxes.get(i);
    	String value=checkbox.getText();
    	System.out.println(value);
    	String text = checkbox.getAttribute("type");
    	System.out.println(text + " <- Text ");
    	
    	checkboxes.get(i).click();
    	
    	Thread.sleep(5000); 
    	
    } */
    
    // Select all the checkboxes
    for(int i=0;i<=checkboxes.size();i++)
    {
    	if(i<7)
    	checkboxes.get(i).click();	
    	checkboxes.get(i).getText();
    }
    
    
    
    Thread.sleep(5000); 
    driver.close();

   

	}

}
