package Practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Wp_admin_ftm {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("testcube4@gmail.com");
		driver.findElement(By.xpath("(//input[@id='input-password'])[1]")).sendKeys("test@123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		
	}
	}


