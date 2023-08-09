package day25;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlerts_cancel {

	
		public static void main(String[] args) throws InterruptedException {
			WebDriver driver = new ChromeDriver();
			//WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://the-internet.herokuapp.com/javascript_alerts");
			driver.manage().window().maximize();
			
			driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
			Alert alertwindow = driver.switchTo().alert();
			//Alert alertwindow=mywait.until(ExpectedConditions.alertIsPresent());
			System.out.println(alertwindow.getText());
			//alertwindow.accept();
			alertwindow.dismiss();
			
			Thread.sleep(5000);
			driver.close();

	}

}
