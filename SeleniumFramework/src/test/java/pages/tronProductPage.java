package pages;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class tronProductPage {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.espares.co.uk?vwo_opt_out=1");
		driver.findElement(By.id("btn-allow-all")).click();

	}
	//search product
	@Test(priority=1)
	public void checkProductPage() throws InterruptedException {
		
		driver.findElement(By.id("searchTermDesktop")).sendKeys("Bosch Cooker Hood Chimney");
		Thread.sleep(2000);
		driver.findElement(By.id("search")).click();
		Thread.sleep(5000);
		//click on the product name
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section/ul/li[1]/div[1]/div[2]/h2/a")).click();					
//		String URL = driver.getCurrentUrl();
//		Assert.assertEquals(URL, "https://www.tron.espares.co.uk/product/es723937/cooker-hood-inner-chimney-vent-hose" );
		//change product quantity
		Thread.sleep(5000);
		WebElement quant= driver.findElement(By.id("quantity"));
		quant.clear();
		quant.sendKeys("5");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"all-basket\"]/div[1]/div[2]/form/input")).click();	
		//Check Just added to your basket URL
//		String justAddedUrl = driver.getCurrentUrl();
//		Assert.assertEquals(justAddedUrl, "https://www.tron.espares.co.uk/product/es723937/cooker-hood-inner-chimney-vent-hose" );
		}


	@AfterMethod
	public void tearDown() {
		//				driver.quit();
	}
}
