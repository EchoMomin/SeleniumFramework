package pages;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class productPage {
	WebDriver driver;

	@BeforeMethod
	public void setUp() throws InterruptedException {
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
	public void searchProduct() throws InterruptedException {
		//Search a product by name
		driver.findElement(By.id("searchTermDesktop")).sendKeys("Bosch Cooker Hood Chimney");
		driver.findElement(By.id("search")).click();
		//verify title
		String Title = driver.getTitle();
		Assert.assertEquals(Title,"Bosch Cooker Hood Chimney | eSpares");
		Thread.sleep(5000);
		//click on the product name
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section/ul/li[1]/div[1]/div[2]/h2/a")).click();
		String ProductTitle = driver.getTitle();
		Assert.assertEquals(ProductTitle,"Bosch Cooker Hood Interference Capacitor | eSpares");
		//Click on the input field of product number to change number of product
//		WebElement webElement =driver.findElement(By.id("quantity"));
//		webElement.click();
//		Actions act=new Actions(driver);
//		act.sendKeys(Keys.DELETE).perform();
//		webElement.sendKeys("5");
		
		// click on plus button to add product number
//		driver.findElement(By.cssSelector("div.easy-number-wrapper>button:last-of-type")).click();	
		//Click on Read more
		//		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div[1]/section[1]/div[1]/div[2]/div/p[2]/a")).click();
		Thread.sleep(2000);
		//enlarge image
//		driver.findElement(By.xpath("//*[@id=\"enlarge-image\"]")).click();
//		Thread.sleep(2000);
		//	Close Modal
//		driver.findElement(By.cssSelector("div.modal-header>button.close")).click();
		//	click on check now
		//	driver.findElement(By.cssSelector(".zoom-toggle")).click();
		//	Thread.sleep(1000);
		//Select Will this part fit my Appliance?
			new Select (driver.findElement(By.id("dif-brand-selector"))).selectByVisibleText("Bosch Cooker Hoods");
		//	enter your Bosch Cooker Hoods model number
			driver.findElement(By.id("dif-model-number")).sendKeys("11");
			Thread.sleep(1000);
//			Actions act=new Actions(driver);
//			act.sendKeys(Keys.ARROW_DOWN).perform();
			driver.findElement(By.cssSelector(".typeahead.typeahead.dropdown-menu>li:nth-of-type(3)")).click();
		//	Thread.sleep(3000);
		//	click on This is Bosch Spares reference: 162532
		//	driver.findElement(By.xpath("//*[@id=\"product-info-panel\"]/div/span/p[4]/a")).click();
		//	Click on ask Question
		//	driver.findElement(By.xpath("//*[@id=\"qa-panel\"]/div/div[1]/a")).click();


	}


	@AfterMethod
	public void tearDown() {
		//				driver.quit();
	}
}
