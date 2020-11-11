
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


public class kitchenAppliances {
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

	//search product
	@Test(priority=1)
	public void testKitchenAppliances() throws InterruptedException {
		//Click on kitchen appliance tab
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[3]/a")).click();
		Thread.sleep(8000);
		driver.findElement(By.id("btn-allow-all")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/browse/ca1/kitchen-appliances" );
		//Click on Blenders - Mixers - Juicers Categories
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section[1]/div[2]/ul/li[1]/a/span")).click();
		String title=driver.getTitle();
		Assert.assertEquals(title, "Buy Spare Parts for your Blender, Mixer or Juicer | eSpares | eSpares");
		//Click on 
//		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section[1]/div/ul/li[1]/a/div/img")).click();
//		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section/ul/li[1]/div[1]/div[3]/div/form/button")).click();
		
		
	}


	@AfterMethod
	public void tearDown() {
		//				driver.quit();
	}
}