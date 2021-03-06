package pages;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class homePage {
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


	//	verify allBrand URL
	@Test(priority=2)
	public void allBrand() {
		driver.findElement(By.xpath("//header/div[4]/nav[1]/div[1]/ul[1]/li[2]/a[1]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/brands" );
	}
	//	verify kitchenAppliances URL
	@Test(priority=3)
	public void kitchenAppliances(){
		driver.findElement(By.xpath("//header/div[4]/nav[1]/div[1]/ul[1]/li[3]/a[1]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/browse/ca1/kitchen-appliances" );
	}

	//Verify tron washersDryers link
	@Test(priority=4)
	public void washersDryers() {

		driver.findElement(By.xpath("//header/div[4]/nav[1]/div[1]/ul[1]/li[4]/a[1]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/browse/ca1236/washers-and-dryers" );

	}


	//Verify  vacuumsFloorcare link
	@Test(priority=5)
	public void vacuumsFloorcare() {

		driver.findElement(By.xpath("//header/div[4]/nav[1]/div[1]/ul[1]/li[5]/a[1]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/browse/ca1237/vacuums-and-floorcare" );

	}
	//Verify  Garden link
	@Test(priority=6)
	public void garden() {

		driver.findElement(By.xpath("//header/div[4]/nav[1]/div[1]/ul[1]/li[6]/a[1]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/browse/ca7/garden-and-outdoor" );

	}
	//Verify  cleaningProducts link
	@Test(priority=7)
	public void cleaningProducts() {

		driver.findElement(By.xpath("//header/div[4]/nav[1]/div[1]/ul[1]/li[7]/a[1]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/browse/ca1421/cleaning-products" );

	}
	//Verify  soundVision link
	@Test(priority=8)
	public void soundVision() {

		driver.findElement(By.xpath("//header/div[4]/nav[1]/div[1]/ul[1]/li[8]/a[1]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/browse/ca1474/sound-and-vision" );
	}

	//Verify  homeOffice link
	@Test(priority=9)
	public void homeOffice() {

		driver.findElement(By.xpath("//header/div[4]/nav[1]/div[1]/ul[1]/li[9]/a[1]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/browse/ca1480/home-and-office" );
	}

	//Verify  Offers link
	@Test(priority=10)
	public void Offers() {

		driver.findElement(By.xpath("//header/div[4]/nav[1]/div[1]/ul[1]/li[10]/a[1]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/browse/ca1794/espares-offers" );
	}

	//Verify  adviceCentre link
	@Test(priority=11)
	public void adviceCentre() {

		driver.findElement(By.xpath("//header/div[4]/nav[1]/div[1]/ul[1]/li[11]/a[1]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/advice" );
	}




	//		Verify aboutUs URL
	@Test(priority=13)
	public void aboutUs(){
		driver.findElement(By.xpath("//a[contains(text(),'About Us')]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/aboutus" );
	}

	//		verify Contact Us URL
	@Test(priority=14)
	public void contactUs(){
		driver.findElement(By.xpath("//a[contains(text(),'Contact Us')]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/contact" );
	}


	//		verify Currency Dropdown
	@Test(priority=15)
	public void currency(){
		driver.findElement(By.id("nationality-trigger")).click();
	}

	//		verify basket page
	@Test(priority=16)
	public void basket(){
		driver.findElement(By.id("header-basket")).click();
		driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/a[1]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/basket" );
	}



	//		verify myAccount URL
	@Test(priority=17)
	public void myAccount(){
		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/account/logon?ReturnUrl=%2faccount" );
	}

	//	Footer part check
	//	contact link verification
	@Test(priority=18)
	public void contact() {
		driver.findElement(By.linkText("Contact Us")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/contact" );
	}

	//	aboutDelivery link verification
	@Test(priority=19)
	public void aboutDelivery() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[@id=\"footer-collapse-1\"]/ul/li[2]/a")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/aboutdelivery" );
	}

	//	returnsRefunds link verification
	@Test(priority=20)
	public void returnsRefunds() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(By.linkText("Returns & Refunds")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/returns" );
	}

	//adviceCentre link verification
	@Test(priority=21)
	public void advice() {
		driver.findElement(By.linkText("Advice Centre")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/advice" );
	}


	//userManuals link verification
	@Test(priority=22)
	public void userManuals() {
		driver.findElement(By.linkText("User Manuals")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/usermanuals" );
	}


	//modelNumberFinder link verification
	@Test(priority=23)
	public void modelNumberFinder() {
		driver.findElement(By.xpath("//*[@id=\"footer-collapse-2\"]/ul/li[3]/a")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/findingmodelnumbers" );
	}


	//	helpMeFindMyPart link verification
	@Test(priority=24)
	public void helpMeFindMyPart() {
		driver.findElement(By.linkText("Help Me Find My Part")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/contact/sales" );
	}



	//	cookieSettings link verification
	@Test(priority=25)
	public void cookieSettings() {
		driver.findElement(By.linkText("Cookie Settings")).click();

	}


	//	privacyPolicy link verification
	@Test(priority=26)
	public void privacyPolicy() {
		driver.findElement(By.linkText("Privacy Policy")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/privacy" );
	}



	//	termsConditions link verification
	@Test(priority=27)
	public void termsConditions() {
		driver.findElement(By.xpath("//*[@id=\"footer-collapse-3\"]/ul/li[3]/a")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/terms" );
	}


	//	siteMap link verification
	@Test(priority=28)
	public void siteMap() {
		driver.findElement(By.linkText("Site Map")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/sitemap" );
	}


	//	everythingYouEver link verification
	@Test(priority=29)
	public void everythingYouEver() {
		driver.findElement(By.xpath("//*[@id=\"footer-collapse-4\"]/p/a")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/aboutus" );
	}

	//	FB link verification
	@Test(priority=30)
	public void fb() {
		driver.findElement(By.xpath("/html/body/div[4]/footer/div[1]/div[1]/div/div/ul/li[1]/a")).click();
		//		String URL = driver.getCurrentUrl();
		//		Assert.assertEquals(URL, "https://www.facebook.com/fixityourself" );
	}


	//	twitter link verification
	@Test(priority=31)
	public void twitter() {
		driver.findElement(By.xpath("/html/body/div[4]/footer/div[1]/div[1]/div/div/ul/li[2]/a")).click();
		//		String URL = driver.getCurrentUrl();
		//		Assert.assertEquals(URL, "https://twitter.com/espares" );
	}

	//	youTube link verification
	@Test(priority=32)
	public void youTube() {
		driver.findElement(By.xpath("/html/body/div[4]/footer/div[1]/div[1]/div/div/ul/li[3]/a")).click();
		//		String URL = driver.getCurrentUrl();
		//		Assert.assertEquals(URL, "https://www.youtube.com/user/eSparesVideo" );
	}

	//	blog link verification
	@Test(priority=33)
	public void blog() {
		driver.findElement(By.xpath("/html/body/div[4]/footer/div[1]/div[1]/div/div/ul/li[4]/a")).click();
		//		String URL = driver.getCurrentUrl();
		//		Assert.assertEquals(URL, "https://blog.espares.co.uk/" );
	}
	//	Ireland's site link verification
	@Test(priority=34)
	public void ireland() {
		driver.findElement(By.xpath("/html/body/div[4]/footer/div[2]/div[2]/div/a[1]/img")).click();
	}
	//	Austria's Site link verification
	@Test(priority=35)
	public void austria() {
		driver.findElement(By.xpath("/html/body/div[4]/footer/div[2]/div[2]/div/a[2]/img")).click();
	}

	//	France's Site link verification
	@Test(priority=36)
	public void france() {
		driver.findElement(By.xpath("/html/body/div[4]/footer/div[2]/div[2]/div/a[3]/img")).click();
	}

	//	Germany's Site link verification
	@Test(priority=37)
	public void germany() {
		driver.findElement(By.xpath("/html/body/div[4]/footer/div[2]/div[2]/div/a[4]/img")).click();
	}

	//	Italy's Site link verification
	@Test(priority=38)
	public void italy() {
		driver.findElement(By.xpath("/html/body/div[4]/footer/div[2]/div[2]/div/a[5]/img")).click();
	}

	//	Spain's Site link verification
	@Test(priority=39)
	public void spain() {
		driver.findElement(By.xpath("/html/body/div[4]/footer/div[2]/div[2]/div/a[6]/img")).click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
