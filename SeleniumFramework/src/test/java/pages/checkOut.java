package pages;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class checkOut {
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
	//search product
	@Test(priority=1)
	public void searchProduct() throws InterruptedException {
		driver.findElement(By.id("searchTermDesktop")).sendKeys("Bosch Cooker Hood Chimney");
		Thread.sleep(8000);
		driver.findElement(By.id("search")).submit();
		Thread.sleep(8000);
		//click on the product name
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section/ul/li[1]/div[1]/div[2]/h2/a")).click();
		Thread.sleep(8000);
		// click on plus button to add product number
		driver.findElement(By.xpath("//*[@id=\"all-basket\"]/div[1]/div[2]/form/div/button[2]")).click();
		Thread.sleep(8000);
		//Click on buy now
		driver.findElement(By.xpath("//*[@id=\"all-basket\"]/div[1]/div[2]/form/input")).click();
		Thread.sleep(8000);
		//Click to checkout Securely
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[1]/div[2]/form/button")).click();
		Thread.sleep(8000);
		//Guest CheckOut email Address
		driver.findElement(By.xpath("//*[@id=\"EmailAddress\"]")).sendKeys("John@sh.com");
		Thread.sleep(8000);
		//Press continue button
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/section/form/div[3]/button[2]")).click();
		Thread.sleep(8000);
		//Select Mr from dropdown
		new Select (driver.findElement(By.id("Honorific_Predefined"))).selectByVisibleText("Mr");
		Thread.sleep(8000);
		//Fill up first name
		driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).sendKeys("Jonh");
		//Fill up last name
		driver.findElement(By.xpath("//*[@id=\"LastName\"]")).sendKeys("Jonh");
		//Fill up Phone number
		driver.findElement(By.xpath("//*[@id=\"PhoneNumber\"]")).sendKeys("001230412442");
		//Select country from dropdown
		//new Select (driver.findElement(By.id("Honorific_Predefined"))).selectByVisibleText("Mr");
		//House number
		driver.findElement(By.id("HouseNumber")).sendKeys("99  Main St");
		//postcode
		driver.findElement(By.id("Postcode")).sendKeys("B10 0HJ");
		Thread.sleep(8000);
		//Click on find your address
		driver.findElement(By.xpath("//*[@id=\"DeliveryPostCodeLookup\"]/div[10]/div[1]/input[2]")).click();
		Thread.sleep(8000);
		//Delivery to this address
		driver.findElement(By.xpath("//*[@id=\"DeliveryPostCodeLookup\"]/div[9]/div[7]/div/button")).click();


	}



	@AfterMethod
	public void tearDown() {
		//				driver.quit();
	}
}
