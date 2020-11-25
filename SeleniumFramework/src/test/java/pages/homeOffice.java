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

public class homeOffice {
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
	
	
	
	@Test(priority=1)
	public void gardenUrl() throws InterruptedException {
		//Click on garden tab
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[6]/a")).click();
		Thread.sleep(8000);
		driver.findElement(By.id("btn-allow-all")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/browse/ca7/garden-and-outdoor" );	

	}
	@Test(priority=2)
	public void gardenCategroyTitle() throws InterruptedException {
		//Click on garden tab
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[6]/a")).click();
		Thread.sleep(8000);
		driver.findElement(By.id("btn-allow-all")).click();
		//Click on one of Garden and Outdoor Appliances product photo
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section[1]/section[1]/div[2]/ul/li[1]/a/img")).click();
		String title=driver.getTitle();
		Assert.assertEquals(title, "Lawnmower Spare Part & Accessories | blades, bolts, power cables and more | eSpares | eSpares");
	}
	@Test(priority=3)
	public void priceCompare() throws InterruptedException {
		//Click on garden tab
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[6]/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("btn-allow-all")).click();
		Thread.sleep(5000);
		//Click on one of Garden and Outdoor Appliances product photo
		driver.findElement(By.xpath("//*[@id=\\\"main-content\\\"]/div[2]/div/section[1]/section[1]/div[2]/ul/li[1]/a/img")).click();
		// click on Lawnmower Spares and Accessories 1st logo
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section[1]/div/ul/li[1]/a")).click();
		//compare price
		String price=driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section/ul/li[1]/div[1]/div[3]/div/span")).getText();
		Assert.assertEquals(price,"£4.49");
	}
	@AfterMethod
	public void tearDown() {
		//				driver.quit();
	}
}
