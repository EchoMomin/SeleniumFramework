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


public class sound {
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

	//Verify Sound page title
	@Test(priority=1)
	public void washersUrl() throws InterruptedException {
		//Click on Washers & Dryers tab
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[8]/a")).click();
		Thread.sleep(8000);
		driver.findElement(By.id("btn-allow-all")).click();
		String title = driver.getTitle();
		Assert.assertEquals(title, "Sound &amp; Vision Spare Parts &amp; Accessories | eSpares" );	

	}
	
	////Verify Sound catecogry page title
	@Test(priority=2)
	public void soundCategroyTitle() throws InterruptedException {
		//Click on Washers & Dryers tab
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[4]/a")).click();
		Thread.sleep(8000);
		driver.findElement(By.id("btn-allow-all")).click();
		//Click on Tumble Dryers Categories
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section[1]/div[2]/ul/li[1]/a/div[1]/img")).click();
		String title=driver.getTitle();
		Assert.assertEquals(title, "Buy Tumble Dryer Spares, Parts & Accessories | Belts, Thermostats and More | eSpares | eSpares");
	}
	@Test(priority=3)
	public void priceCompare() throws InterruptedException {
		//Click on Washers & Dryers tab
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[4]/a")).click();
		Thread.sleep(8000);
		driver.findElement(By.id("btn-allow-all")).click();
		//Click on Tumble Dryers Categories
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section[1]/div[2]/ul/li[1]/a/div[1]/img")).click();
		//compare price
		String price=driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section[3]/div[2]/article[1]/div[2]/footer/p")).getText();
		Assert.assertEquals(price,"£6.99");
	}
	@AfterMethod
	public void tearDown() {
		//				driver.quit();
	}
}