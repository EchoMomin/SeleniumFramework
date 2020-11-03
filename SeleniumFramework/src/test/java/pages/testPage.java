package pages;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class testPage {
	WebDriver driver;

	@BeforeMethod
	public void setUpTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.espares.co.uk");
		driver.findElement(By.id("btn-allow-all")).click();

	}


	//	aboutDelivery link verification
	@Test(priority=1)
	public void aboutDelivery() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(By.xpath("//a[contains(text(),'About Delivery')]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/aboutdelivery" );
	}



	@AfterMethod
	public void tearDown() {
		//				driver.quit();
	}
}
