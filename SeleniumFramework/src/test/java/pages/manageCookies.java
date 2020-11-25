package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class manageCookies {
	WebDriver driver;

	@BeforeMethod
	public void setUpTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.espares.co.uk?vwo_opt_out=1");
		Thread.sleep(8000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		//		driver.findElement(By.id("btn-allow-all")).click();

	}


	//click on Manage cookies
	@Test(priority=1)
	public void gardenUrl() throws InterruptedException {
		//Click on Manage cookies tab
		driver.findElement(By.xpath("/html/body/div[6]/div/div/a[1]")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[@id=\"cookie-control-form\"]/div[2]/label/span[2]")).click();

	}


	@AfterMethod
	public void tearDown() {
		//				driver.quit();
	}
}
