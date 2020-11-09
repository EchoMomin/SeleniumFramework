package pages;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
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
	public void searchProduct() throws InterruptedException {
		//Search Product
		driver.findElement(By.id("searchTermDesktop")).sendKeys("Bosch Cooker Hood Chimney");
		//Click on search Button
		driver.findElement(By.id("search")).submit();
		String Title = driver.getTitle();
		Assert.assertEquals(Title,"Bosch Cooker Hood Chimney | eSpares");
		Thread.sleep(8000);
		//click on the product name
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section/ul/li[1]/div[1]/div[2]/h2/a")).click();

		String ProductTitle = driver.getTitle();
		Assert.assertEquals(ProductTitle,"Bosch Cooker Hood Interference Capacitor | eSpares");
		// click on plus button to add product number
		driver.findElement(By.cssSelector("div.easy-number-wrapper>button:last-of-type")).click();
		//Click on buy now button
		driver.findElement(By.cssSelector("input.btn.btn-primary.shoppingCartTrack")).click();
		String baskettTitle = driver.getTitle();
		Assert.assertEquals(baskettTitle,"Basket | eSpares");

		//Click to checkout Securely
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[1]/div[2]/form/button")).click();
		String checkoutTitle = driver.getTitle();
		Assert.assertEquals(checkoutTitle,"Checkout | eSpares");

		//Guest CheckOut email Address
		driver.findElement(By.xpath("//*[@id=\"EmailAddress\"]")).sendKeys("John@sh.com");
		//Press continue button
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/section/form/div[3]/button[2]")).click();
		String DATitle = driver.getTitle();
		Assert.assertEquals(DATitle,"Delivery Address | eSpares");

		//Select Mr from dropdown
		new Select (driver.findElement(By.id("Honorific_Predefined"))).selectByVisibleText("Mr");
		//Fill up first name
		driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).sendKeys("Jonh");
		//Fill up last name
		driver.findElement(By.xpath("//*[@id=\"LastName\"]")).sendKeys("Jonh");
		//Fill up Phone number
		driver.findElement(By.xpath("//*[@id=\"PhoneNumber\"]")).sendKeys("001230412442");
		//Select country from dropdown
		//		new Select (driver.findElement(By.id("Country"))).selectByVisibleText("Albania");
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
		String PDTitle = driver.getTitle();
		Assert.assertEquals(PDTitle,"Payment Details | eSpares");
		//		Thread.sleep(8000);
		//		//Card number
		//		driver.findElement(By.id("CardNumber")).sendKeys("4008180000113823");
		//		// select EndDateYear
		//		new Select (driver.findElement(By.id("EndDateYear"))).selectByVisibleText("2022");
		//		//Security Code
		//		driver.findElement(By.id("SecurityCode")).sendKeys("123");
		//		//TermsAndConditionsAgreed 
		//		driver.findElement(By.id("TermsAndConditionsAgreed")).click();
		//		//Place order
		//		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div[1]/section[2]/form/div[6]/div/button[2]")).click();



	}



	@AfterMethod
	public void tearDown() {
		//				driver.quit();
	}
}
