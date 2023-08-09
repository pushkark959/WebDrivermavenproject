package day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginationTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/admin/index.php?route=common/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("demo");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("demo");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		if(driver.findElement(By.xpath("//div[@class='modal-content']")).isDisplayed());
		{
			driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		}
		
		//Customers--->customers
		driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
		driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();
		
		String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
		System.out.println("Number of pages text  : " +text); // Number of pages : Showing 1 to 10 of 13634 (1364 Pages)
		
		//int total_pages = Integer.parseInt(text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1));
		int total_pages = Integer.parseInt(text.substring(text.indexOf("(")+1,text.indexOf("P")-1));
		System.out.println("Number of pages   : " +total_pages); //Number of pages   : 1364
		
		/*
		for(int p=1;p<=total_pages;p++)
		{
			if (total_pages>1)
			{
			    WebElement active_Page = driver.findElement(By.xpath("//ul[@class='pagination']//li//*[text()="+p+"]"));
				//WebElement active_page = driver.findElement(By.xpath("//a[normalize-space()="+p+"]"));
				System.out.println("Active Pages"+active_Page.getText());
				active_Page.click();
				Thread.sleep(5000);
	
		}
		int NoOfrows = driver.findElements(By.xpath("//div[@class='table-responsive']/tbody/tr")).size();
		//int noOfrows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
		System.out.println(" Total No Of Rows in active Page : "+NoOfrows);	
			*/
		
		for(int p=1;p<=10;p++)   //for(int p=1;p<=total_pages;p++)
		{
			if(total_pages>1)
			{
				WebElement active_Page=driver.findElement(By.xpath("//ul[@class='pagination']//li//*[text()="+p+"]"));	
				System.out.println(" Active Page : "+active_Page.getText());
				active_Page.click();
				Thread.sleep(2000);
			}
			
			int noOfrows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			System.out.println(" Total No Of Rows in active Page : "+noOfrows);
			
			for(int r=1;r<=noOfrows;r++)
			{
				String customerName=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[2]")).getText();
				String customerEmail=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[3]")).getText();
				String status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[5]")).getText();
				
				System.out.println(customerName+"      "+customerEmail+"          "+status);
			}
			
		Thread.sleep(5000);
		driver.close();

	}

}}
