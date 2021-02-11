package pages;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class review {
	WebDriver driver;

	@BeforeMethod
	public void setUpTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.espares.co.uk/product/es690491/cooker-hood-onoff-light-slider-button?vwo_opt_out=1");
		//		Alert alert = driver.switchTo().alert();
		//		alert.accept();
		driver.findElement(By.id("btn-allow-all")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	

	}

//Review form
	@Test
	public review() {
		//Review Field
		driver.findElement(By.id("Details")).sendKeys("This is a test review");
	}
		
	

	@AfterMethod
	public void tearDown() {
		//						driver.quit();
	}
}


			
			
