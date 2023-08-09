package day33;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FixedDepositCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();

		 String file=System.getProperty("user.dir")+"/testdata/caldata.xlsx";
//		File filee = new File("/Users/pushkar/eclipse-workspace/WebDrivermavenproject/testdata/caldata.xlsx");
//		// Files.readString() ;
//		String file = filee.toString();

		int rows = ExcelUtils.getRowCount(file, "Sheet1");
		System.out.println(rows + "rows count");
		for (int i = 1; i <= rows; i++) {
			// Read data from excel
			String prince = ExcelUtils.getCellData(file, "Sheet1", i, 0);
			String rateofint = ExcelUtils.getCellData(file, "Sheet1", i, 1);
			String per1 = ExcelUtils.getCellData(file, "Sheet1", i, 2);
			String per2 = ExcelUtils.getCellData(file, "Sheet1", i, 3);
			String frequency = ExcelUtils.getCellData(file, "Sheet1", i, 4);
			String exp_mat_val = ExcelUtils.getCellData(file, "Sheet1", i, 5);
			
			

			// Pass data to the app
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(prince);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateofint);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(per1);

			Select perdrp = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			perdrp.selectByVisibleText(per2);

			Select fre = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			fre.selectByVisibleText(frequency);

			// driver.findElement(By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']")).click();
			// After getting the error "
			// org.openqa.selenium.ElementClickInterceptedException" we use below code of
			// JavascriptExecutor to click button calculate
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement calculate_btn = driver.findElement(By.xpath("//div[@class='cal_div']//a[1]"));
			js.executeScript("arguments[0].click();", calculate_btn); // clicking on calculate button

			// validation & update results in excel
			String act_mat = driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();
			if (Double.parseDouble(exp_mat_val) == Double.parseDouble(act_mat)) {
				System.out.println("Test Passed");
				ExcelUtils.setCellData(file, "Sheet1", i, 7, "Passed");
				ExcelUtils.fillGreenColor(file, "Sheet1", i, 7);
			} else {
				System.out.println("Test Failed");
				ExcelUtils.setCellData(file, "Sheet1", i, 7, "Failed");
				ExcelUtils.fillRedColor(file, "Sheet1", i, 7);
			}

			// driver.findElement(By.xpath("//img[@class='PL5']")).click();

			// After getting an error "org.openqa.selenium.ElementClickInterceptedException"
			// on executing line no 70 we use JavascriptExecutor
			//Thread.sleep(3000);
			WebElement clear_btn = driver.findElement(By.xpath("//img[@class='PL5']"));
			js.executeScript("arguments[0].click();", clear_btn); // clicking on clear button
			
			

			

		}
		Thread.sleep(5000);
		driver.quit();

	}

}
