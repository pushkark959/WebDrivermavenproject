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

public class BrokenLinks {

	private static String hrefAttValue;

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		List<WebElement> Linkss = driver.findElements(By.tagName("a"));
		System.out.println("No of available links : " + Linkss.size());

		// pre-requisite for checking broken link
		int brokenlinks = 0;
		for (WebElement linkEle : Linkss) {

			if (linkEle.getAttribute("href") == null || linkEle.getAttribute("href").isEmpty()) {
				System.out.println("herf link is empty  ");
				continue;
			}

			// Checking link is broken or not
			URL linkurl = new URL(hrefAttValue); // convert String --> URL format
			if (linkurl.toString().contains("=")) {
				System.out.println("link url start: " + linkurl);
				String error_code = linkurl.toString().split("=")[1];
				if (!error_code.equals("408")) {

				} else {
					System.out.println("Skipping 408... moving on");
				}
			} else {
				HttpURLConnection conn = (HttpURLConnection) linkurl.openConnection(); //// send request to server -
																						//// open , connect
				conn.connect();
				System.out.println("link url: " + linkurl + " Response code : " + conn.getResponseCode());
				if (conn.getResponseCode() >= 400) {
//				System.out.println("Broken Link : "+hrefAttValue);
					brokenlinks++;
				} else {
//				System.out.println("Not Broken Link : "+hrefAttValue);
				}
			System.out.println("Total Number of Broken Links : "+brokenlinks);
			}

		}
		Thread.sleep(5000);
		driver.close();

	}

}
