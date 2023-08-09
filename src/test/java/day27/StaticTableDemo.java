package day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTableDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
		// 1) Find total number of rows 
		
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr")).size();
		System.out.println("Number of rows : "+rows); // 7
		
		//2) Find total number of columns
		
		int cols = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/th")).size();
		System.out.println("No of Cols : "+ cols);  // 4
		
		//3) Read specific row & column data
		//String Value = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr[7]/td[1]")).getText();
		//String value=driver.findElement(By.xpath("//table[@name='BookTable']//tr[7]//td[1]")).getText();
		//System.out.println("Values : "+ Value); // Master in Js
		
		
		/*	
		//4) Read data from all the rows & columns
		for(int r=2;r<=rows;r++)
		{
			for(int c=1;c<=cols;c++)
			{
				String Value = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+r+"]/td["+c+"]")).getText();
				System.out.print( Value+"     "); 
		    }
		System.out.println();
		}
		
		
		//5) Print book names whose author is Amit
		for (int r=2;r<=rows;r++)
		{
			String author = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+r+"]/td[2]")).getText();
			if (author.equals("Amit"))
			{
				String Bookname = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+r+"]/td[1]")).getText();
				System.out.println(Bookname);
			}
		}
		*/
		
		//6)Find sum of prices for all the books
		int sum =0;
		for (int r =2;r<=rows;r++)
		{
			String price = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+r+"]/td[4]")).getText();
	        sum=sum+Integer.parseInt(price); // It changes string value into integer
		}
		System.out.println("Total price of books : "+ sum);
		
		
		
		
		Thread.sleep(5000);
		driver.close();
		
	}

}
	
