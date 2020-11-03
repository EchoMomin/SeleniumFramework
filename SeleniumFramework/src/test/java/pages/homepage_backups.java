package pages;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class homepage_backups {
	WebDriver driver;

	@BeforeMethod
	public void setUpTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.tron.espares.co.uk");

	}

	//	Verify tron site title 
	@Test(priority=1)
	public void tronTitleVerification() {
		String Title = driver.getTitle();
		//System.out.println("Page title is: + Title");
		Assert.assertEquals(Title,"eSpares - Spare Parts & Accessories for Electrical Appliances | eSpares");
	}



	//		Verify aboutUs URL
	@Test(priority=3)
	public void aboutUs(){
		driver.findElement(By.xpath("//a[contains(text(),'About Us')]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.tron.espares.co.uk/aboutus" );
	}

	//		verify Contact Us URL
	@Test(priority=4)
	public void contactUs(){
		driver.findElement(By.xpath("//a[contains(text(),'About Us')]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.tron.espares.co.uk/contact" );
	}


	//		verify Currency Dropdown
	@Test(priority=5)
	public void currency(){
		driver.findElement(By.id("nationality-trigger")).click();
	}

	//		verify basket page
	@Test(priority=5)
	public void basket(){
		driver.findElement(By.id("header-basket")).click();
		driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/a[1]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.tron.espares.co.uk/basket" );
	}



	//		verify myAccount URL
	@Test(priority=5)
	public void myAccount(){
		driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/button[1]/span[1]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.tron.espares.co.uk/account/logon?ReturnUrl=%2faccount" );
	}


	//		verify allBrand URL
	//	@Test(priority=2)
	//	public void allBrand() {
	//		driver.findElement(By.xpath("//header/div[4]/nav[1]/div[1]/ul[1]/li[2]/a[1]")).click();
	//		String URL = driver.getCurrentUrl();
	//		Assert.assertEquals(URL, "https://www.tron.espares.co.uk/brands" );
	//	}


	//Verify tron Product Search
	@Test(priority=2)
	public void searchProduct() {
		driver.findElement(By.name("SearchTerm")).sendKeys("Bosch Cooker Hood Chimney");
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.findElement(By.id("search")).submit();
	}

	/*
	fail
		Verify tron hoverMenu
	@Test(priority=3)
		public void hoverMenu() {

			Actions actions = new Actions(driver);
			WebElement menuOption = driver.findElement(By.xpath("//header/div[4]/nav[1]/div[1]/ul[1]/li[3]/a[1]"));
			actions.moveToElement(menuOption).perform();
			driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
			System.out.println("Done Mouse hover on 'Kitchen Appliances' from Menu");
			WebElement subMenuOption = driver.findElement(By.xpath("/html[1]/body[1]/header[1]/div[4]/nav[1]/div[1]/ul[1]/li[3]/ul[1]/li[1]/div[1]/ul[1]/li[1]/div[2]/section[2]/div[1]/ul[1]/li[1]/a[1]")); 
			driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
			actions.moveToElement(subMenuOption).perform();
		}
	 */
	
	//	Verify kitchenAppliances URL
	@Test(priority=2)
	public void kitchenAppliances(){
		driver.findElement(By.xpath("//header/div[4]/nav[1]/div[1]/ul[1]/li[3]/a[1]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.tron.espares.co.uk/browse/ca1/kitchen-appliances" );
	}


	//Verify tron washersDryers link
	@Test(priority=3)
	public void washersDryers() {

		driver.findElement(By.xpath("//header/div[4]/nav[1]/div[1]/ul[1]/li[4]/a[1]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.tron.espares.co.uk/browse/ca1236/washers-and-dryers" );

	}

	//Verify tron vacuumsFloorcare link
	@Test(priority=3)
	public void vacuumsFloorcare() {

		driver.findElement(By.xpath("//header/div[4]/nav[1]/div[1]/ul[1]/li[5]/a[1]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.tron.espares.co.uk/browse/ca1237/vacuums-and-floorcare" );

	}
	//Verify  Garden link
	@Test(priority=3)
	public void garden() {

		driver.findElement(By.xpath("//header/div[4]/nav[1]/div[1]/ul[1]/li[6]/a[1]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.tron.espares.co.uk/browse/ca7/garden-and-outdoor" );

	}
	//Verify  cleaningProducts link
	@Test(priority=3)
	public void cleaningProducts() {

		driver.findElement(By.xpath("//header/div[4]/nav[1]/div[1]/ul[1]/li[7]/a[1]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.tron.espares.co.uk/search/ca1421/cleaning-products" );

	}
	//Verify  soundVision link
	@Test(priority=3)
	public void soundVision() {

		driver.findElement(By.xpath("//header/div[4]/nav[1]/div[1]/ul[1]/li[8]/a[1]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.tron.espares.co.uk/browse/ca1474/sound-and-vision" );
	}
	
	//Verify  homeOffice link
	@Test(priority=3)
	public void homeOffice() {

		driver.findElement(By.xpath("//header/div[4]/nav[1]/div[1]/ul[1]/li[9]/a[1]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.tron.espares.co.uk/browse/ca1480/home-and-office" );
	}
	
	//Verify  Offers link
	@Test(priority=3)
	public void Offers() {

		driver.findElement(By.xpath("//header/div[4]/nav[1]/div[1]/ul[1]/li[10]/a[1]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.tron.espares.co.uk/browse/ca1770" );
	}
	
	//Verify  adviceCentre link
	@Test(priority=3)
	public void adviceCentre() {

		driver.findElement(By.xpath("//header/div[4]/nav[1]/div[1]/ul[1]/li[11]/a[1]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.tron.espares.co.uk/advice" );
	}
	
	
	
	// Verify text of "Major Brand"
	@Test(priority=4)
	public void verifyText() {
		String bodyText = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/main[1]/section[2]/div[1]/h2[1]")).getText();
		String ActualText="Major Brands";
		Assert.assertEquals(bodyText,ActualText);
	}


	//validation of Get the eSpares eNews form
	@Test(priority=5)
	public void eNews() {
		driver.findElement(By.id("subscribe-email")).sendKeys("abd@gh.hg");
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.findElement(By.id("subscribe-name")).sendKeys("Abd");
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/form[1]/div[2]/span[1]/input[1]")).submit();
	}


	//	Varify next and previous button
//		@Test(priority=6)
//		public void nextBtn() {
//			WebElement next =driver.findElement(By.className("owl-next"));
//			//		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
//			next.click();
//		}


	//		verify Contact Us URL in the footer
	@Test(priority=2)
	public void contact() {
		driver.findElement(By.linkText("Contact Us")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.tron.espares.co.uk/contact" );
	}



	//	aboutDelivery link verification
	//	@Test(priority=2)
	//	public void aboutDelivery() {
	//		driver.findElement(By.linkText("About Delivery")).click();
	//	String URL = driver.getCurrentUrl();
	//	Assert.assertEquals(URL, "https://www.tron.espares.co.uk/aboutdelivery" );
	//	}

	//	returnsRefunds link verification
	//	@Test(priority=10)
	//	public void returnsRefunds() {
	//		driver.findElement(By.linkText("Returns & Refunds")).click();
	//	}

	//	adviceCentre link verification
	//	@Test(priority=11)
	//	public void adviceCentre() {
	//		driver.findElement(By.linkText("Advice Centre")).click();
	//	}


	//	userManuals link verification
	//	@Test(priority=12)
	//	public void userManuals() {
	//		driver.findElement(By.linkText("User Manuals")).click();
	//	}


	//	modelNumberFinder link verification
	//	@Test(priority=13)
	//	public void modelNumberFinder() {
	//		driver.findElement(By.linkText("Model Number Finder")).click();
	//	}


	//	helpMeFindMyPart link verification
	//	@Test(priority=14)
	//	public void helpMeFindMyPart() {
	//		driver.findElement(By.linkText("Help Me Find My Part")).click();
	//	}
	//


	//	cookieSettings link verification
	//	@Test(priority=15)
	//	public void cookieSettings() {
	//		driver.findElement(By.linkText("Cookie Settings")).click();
	//	}


	//	privacyPolicy link verification
	//	@Test(priority=16)
	//	public void privacyPolicy() {
	//		driver.findElement(By.linkText("Privacy Policy")).click();
	//	}



	//	termsConditions link verification
	//	@Test(priority=17)
	//	public void termsConditions() {
	//		driver.findElement(By.linkText("Terms & Conditions")).click();
	//	}


	//	siteMap link verification
	//	@Test(priority=18)
	//	public void siteMap() {
	//		driver.findElement(By.linkText("Site Map")).click();
	//	}


	//	everythingYouEver link verification
	//	@Test(priority=19)
	//	public void everythingYouEver() {
	//		driver.findElement(By.linkText("Everything you ever")).click();
	//	}
	
	//	FB link verification
	@Test(priority=3)
	public void fb() {
		driver.findElement(By.xpath("//body/div[4]/footer[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/span[1]/i[1]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.facebook.com/fixityourself" );
	}

	
	//	twitter link verification
	@Test(priority=3)
	public void twitter() {
		driver.findElement(By.xpath("//body/div[6]/footer[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]/i[1]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://twitter.com/espares" );
	}

	//	youTube link verification
	@Test(priority=3)
	public void youTube() {
		driver.findElement(By.xpath("//body/div[6]/footer[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]/span[1]/i[1]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.youtube.com/user/eSparesVideo" );
	}

	//	blog link verification
	@Test(priority=3)
	public void blog() {
		driver.findElement(By.xpath("//body/div[6]/footer[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]/span[1]/i[1]")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://blog.espares.co.uk/" );
	}



	@AfterMethod
	public void tearDown() {
		//				driver.quit();
	}
}
