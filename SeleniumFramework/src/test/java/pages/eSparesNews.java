package pages;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class eSparesNews{
	WebDriver driver;

	@BeforeMethod
	public void setUpTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.tron.espares.co.uk?vwo_opt_out=1");
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
		driver.findElement(By.id("btn-allow-all")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	

	}

	//eSparesNews submit
	@Test
	public void newsForm()  {

		
		driver.findElement(By.id("subscribe-email")).sendKeys("email@espare.com");
		driver.findElement(By.id("subscribe-name")).sendKeys("Test");
		JavascriptExecutor js = null;
		if (driver instanceof JavascriptExecutor) {
		    js = (JavascriptExecutor) driver;
		}
		js.executeScript("return document.querySelectorAll('.captcha').forEach(el => el.remove());");
		driver.findElement(By.xpath("//*[@id=\"EmailSignupForm\"]/div[2]/span[1]")).click();
		
		
	}
	


	@AfterMethod
	public void tearDown() {
//		driver.quit();
	}
}














