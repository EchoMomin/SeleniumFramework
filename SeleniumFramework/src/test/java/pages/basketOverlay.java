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


public class basketOverlay {
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


	//click on basket and remove and Item
	@Test(priority=1)
	public void removeItem() {
		//click on My Basket
		driver.findElement(By.xpath("//*[@id=\"header-basket\"]")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		//		click on the remove button from the overlay and remove product
		driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div[3]/div/div/div[2]/ul/li[1]/div/form/button")).click();
		String Title = driver.getTitle();
		Assert.assertEquals(Title,"Basket | eSpares");


	}


	//go to Basket page by clicking the link and verify
	@Test(priority=2)
	public void basketPage() {
		//click on the My Basket menu
		driver.findElement(By.xpath("//*[@id=\"header-basket\"]")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div[3]/div/div/div[2]/ul/li[1]/div/form/button")).click();
		String Title = driver.getTitle();
		Assert.assertEquals(Title,"Basket | eSpares");
	}
	//from the overlay click on the product name and go to the product details page
	@Test(priority=3)
	public void productPage() {
		//click on the My Basket menu
		driver.findElement(By.xpath("//*[@id=\"header-basket\"]")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div[3]/div/div/div[2]/ul/li[1]/div/form/button")).click();
		String Title = driver.getTitle();
		Assert.assertEquals(Title,"Basket | eSpares");
	}

	//from the overlay click on the checkOut Securely and verify the link
	@Test(priority=4)
	public void checkOutSecurely() {
		//click on the My Basket menu
		driver.findElement(By.xpath("//*[@id=\"header-basket\"]")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div[3]/div/div/div[2]/ul/li[1]/div/form/button")).click();
		String Title = driver.getTitle();
		Assert.assertEquals(Title,"Basket | eSpares");
	}

	//from the overlay click on the product image and go to the product details page
	@Test(priority=5)
	public void productImage() {
		//click on the My Basket menu
		driver.findElement(By.xpath("//*[@id=\"header-basket\"]")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div[3]/div/div/div[2]/ul/li[1]/div/form/button")).click();
		String Title = driver.getTitle();
		Assert.assertEquals(Title,"Basket | eSpares");
	}

	//from the overlay click on the viewBasket and go to the basket page and verify functionality
	@Test(priority=6)
	public void viewBasket() {
		//click on the My Basket menu
		driver.findElement(By.xpath("//*[@id=\"header-basket\"]")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div[3]/div/div/div[2]/ul/li[1]/div/form/button")).click();
		String Title = driver.getTitle();
		Assert.assertEquals(Title,"Basket | eSpares");
	}


	@AfterMethod
	public void tearDown() {
		//		driver.quit();
	}
}
