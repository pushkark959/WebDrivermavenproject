package day31;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Brokenlinks_2 {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.get("http://www.deadlinkcity.com/");
		driver.get("https://harappa.education/");
		driver.manage().window().maximize();
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println("No of available links : " + Links.size());

		int brokenlinks = 0;
		for (WebElement LinkEle : Links) {
			String hrefAttValue = LinkEle.getAttribute("href");
			if (hrefAttValue == null || hrefAttValue.isEmpty()) {
				System.out.println("href link is empty");
				continue;
			}

			// Checking link is broken or not
			URL Linkurl = new URL(hrefAttValue); // Convert link into url
			HttpURLConnection conn = (HttpURLConnection) Linkurl.openConnection(); //// send request to server - open ,
																					//// connect
			conn.connect();

			if (conn.getResponseCode() >= 400) {
				System.out.println("Broken Links : " + hrefAttValue);
				continue;
			} else {
				System.out.println("Not Broken Links : " + hrefAttValue);
			}
			System.out.println("Total number of Broken Links : " + brokenlinks);

			Thread.sleep(5000);
			driver.close();
		}

	}

}
