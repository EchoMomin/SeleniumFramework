package pages;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class homepageBody {
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
		driver.findElement(By.id("btn-allow-all")).click();

	}


	//	Verify site title 
	@Test(priority=1)
	public void tronTitleVerification() {
		String Title = driver.getTitle();
		//System.out.println("Page title is: + Title");
		Assert.assertEquals(Title,"eSpares - Spare Parts & Accessories for Electrical Appliances | eSpares");
	}

	//validation of Get the eSpares eNews form
	@Test(priority=2)
	public void eNews() {
		driver.findElement(By.id("subscribe-email")).sendKeys("abddd@gh.hg");
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.findElement(By.id("subscribe-name")).sendKeys("Abdel");
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"EmailSignupForm\"]/div[2]/span[1]/input")).click();
	}



	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
