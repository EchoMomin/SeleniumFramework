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


public class basketPage {
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


	//Get the eSpares eNews on the footer
	@Test(priority=1)
	public void eSparesNews() {
		//click on my basket
		driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div[2]")).click();
		//click on view basket
		driver.findElement(By.className("tablet-desktop")).click();
		//click on email input box
		driver.findElement(By.id("subscribe-email")).sendKeys("john@es.com");
		//put the first name
		driver.findElement(By.id("subscribe-name")).sendKeys("john");
		String text= driver.findElement(By.xpath("//*[@id=\"EmailSignupForm\"]/p")).getText();
		Assert.assertEquals(text,"Thanks for signing up, you will be the first to hear about our exclusive offers");
	}

	//delivery to drop down



	@AfterMethod
	public void tearDown() {
		//		driver.quit();
	}
}

//delivery to drop down
@Test(priority=1)
public void eSparesNews() {
	//click on my basket
	driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div[2]")).click();
	//click on view basket
	driver.findElement(By.className("tablet-desktop")).click();
	//click on email input box
	driver.findElement(By.id("subscribe-email")).sendKeys("john@es.com");
	//put the first name
	driver.findElement(By.id("subscribe-name")).sendKeys("john");
	String text= driver.findElement(By.xpath("//*[@id=\"EmailSignupForm\"]/p")).getText();
	Assert.assertEquals(text,"Thanks for signing up, you will be the first to hear about our exclusive offers");
}
//UK Next Day Delivery radio button check
@Test(priority=1)
public void eSparesNews() {
	//click on my basket
	driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div[2]")).click();
	//click on view basket
	driver.findElement(By.className("tablet-desktop")).click();
	//click on email input box
	driver.findElement(By.id("subscribe-email")).sendKeys("john@es.com");
	//put the first name
	driver.findElement(By.id("subscribe-name")).sendKeys("john");
	String text= driver.findElement(By.xpath("//*[@id=\"EmailSignupForm\"]/p")).getText();
	Assert.assertEquals(text,"Thanks for signing up, you will be the first to hear about our exclusive offers");
}
//Got a discount and apply code
@Test(priority=1)
public void eSparesNews() {
	//click on my basket
	driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div[2]")).click();
	//click on view basket
	driver.findElement(By.className("tablet-desktop")).click();
	//click on email input box
	driver.findElement(By.id("subscribe-email")).sendKeys("john@es.com");
	//put the first name
	driver.findElement(By.id("subscribe-name")).sendKeys("john");
	String text= driver.findElement(By.xpath("//*[@id=\"EmailSignupForm\"]/p")).getText();
	Assert.assertEquals(text,"Thanks for signing up, you will be the first to hear about our exclusive offers");
}
//update quantity
@Test(priority=1)
public void eSparesNews() {
	//click on my basket
	driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div[2]")).click();
	//click on view basket
	driver.findElement(By.className("tablet-desktop")).click();
	//click on email input box
	driver.findElement(By.id("subscribe-email")).sendKeys("john@es.com");
	//put the first name
	driver.findElement(By.id("subscribe-name")).sendKeys("john");
	String text= driver.findElement(By.xpath("//*[@id=\"EmailSignupForm\"]/p")).getText();
	Assert.assertEquals(text,"Thanks for signing up, you will be the first to hear about our exclusive offers");
}
//remove product
@Test(priority=1)
public void eSparesNews() {
	//click on my basket
	driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div[2]")).click();
	//click on view basket
	driver.findElement(By.className("tablet-desktop")).click();
	//click on email input box
	driver.findElement(By.id("subscribe-email")).sendKeys("john@es.com");
	//put the first name
	driver.findElement(By.id("subscribe-name")).sendKeys("john");
	String text= driver.findElement(By.xpath("//*[@id=\"EmailSignupForm\"]/p")).getText();
	Assert.assertEquals(text,"Thanks for signing up, you will be the first to hear about our exclusive offers");
}
//Get the eSpares eNews
//more info
//product details on clicking the product name
//product image click on