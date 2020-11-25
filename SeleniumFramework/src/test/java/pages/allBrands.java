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


public class allBrands {
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


	//Verify Url
	@Test(priority=1)
	public void verifyUrl() {
		//		click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/brands");
	}

	//	Appliance Recalls
	@Test(priority=2)
	public void applianceRecalls() {
		//		click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("//*[@id=\"collapse-category-filter\"]/ul/li[1]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/search/ca2192/appliance-recalls");
	}
	//	Cleaning Products
	@Test(priority=3)
	public void cleaningProducts() {
		//		click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("//*[@id=\"collapse-category-filter\"]/ul/li[2]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/browse/ca1421/cleaning-products");
	}
	//	COVID-19
	@Test(priority=4)
	public void covid19() {
		//		click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		String title= driver.getTitle();
		Assert.assertEquals(title,"Brands | eSpares");
		driver.findElement(By.xpath("//*[@id=\"collapse-category-filter\"]/ul/li[3]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/search/ca2185/covid-19");
	}
	//	eSpares Heroes
	@Test(priority=5)
	public void heroes() {
		//		click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		String title= driver.getTitle();
		Assert.assertEquals(title,"Brands | eSpares");
		driver.findElement(By.xpath("//*[@id=\"collapse-category-filter\"]/ul/li[4]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/browse/ca2163/espares-heroes");
	}
	//	eSpares Offers
	@Test(priority=6)
	public void offers() {
		//		click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		String title= driver.getTitle();
		Assert.assertEquals(title,"Brands | eSpares");
		driver.findElement(By.xpath("//*[@id=\"collapse-category-filter\"]/ul/li[5]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/browse/ca1794/espares-offers");
	}
	//	Fitting Tools
	@Test(priority=7)
	public void fittingTools() {
		//		click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		String title= driver.getTitle();
		Assert.assertEquals(title,"Brands | eSpares");
		driver.findElement(By.xpath("//*[@id=\"collapse-category-filter\"]/ul/li[6]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/browse/ca1477/fitting-tools");
	}
	//	Fix First
	@Test(priority=8)
	public void fixFirst() {
		//		click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		String title= driver.getTitle();
		Assert.assertEquals(title,"Brands | eSpares");
		driver.findElement(By.xpath("//*[@id=\"collapse-category-filter\"]/ul/li[7]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/browse/ca2166/fix-first");
	}
	//	Garden & Outdoor
	@Test(priority=9)
	public void garden() {
		//		click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		String title= driver.getTitle();
		Assert.assertEquals(title,"Brands | eSpares");
		driver.findElement(By.xpath("//*[@id=\"collapse-category-filter\"]/ul/li[8]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/browse/ca7/garden-and-outdoor");
	}
	//	Home & Office
	@Test(priority=10)
	public void homeOffice()  {
		//		click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		String title= driver.getTitle();
		Assert.assertEquals(title,"Brands | eSpares");
		driver.findElement(By.xpath("//*[@id=\"collapse-category-filter\"]/ul/li[9]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/browse/ca1480/home-and-office");
	}
	//	Kitchen Appliances
	@Test(priority=11)
	public void kitchenAppliances() {
		//		click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		String title= driver.getTitle();
		Assert.assertEquals(title,"Brands | eSpares");
		driver.findElement(By.xpath("//*[@id=\"collapse-category-filter\"]/ul/li[10]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/browse/ca1/kitchen-appliances");
	}
	//	Sound & Vision
	@Test(priority=12)
	public void sound() {
		//		click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		String title= driver.getTitle();
		Assert.assertEquals(title,"Brands | eSpares");
		driver.findElement(By.xpath("//*[@id=\"collapse-category-filter\"]/ul/li[11]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/browse/ca1474/sound-and-vision");
	}
	//	Vacuums & Floorcare
	@Test(priority=13)
	public void vacuums() {
		//		click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		String title= driver.getTitle();
		Assert.assertEquals(title,"Brands | eSpares");
		driver.findElement(By.xpath("//*[@id=\"collapse-category-filter\"]/ul/li[12]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/browse/ca1237/vacuums-and-floorcare");
	}
	//	Washers & Dryers
	@Test(priority=14)
	public void washers() {
		//		click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		String title= driver.getTitle();
		Assert.assertEquals(title,"Brands | eSpares");
		driver.findElement(By.xpath("//*[@id=\"collapse-category-filter\"]/ul/li[13]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/browse/ca1236/washers-and-dryers");
	}

	//	Click on 3
	@Test(priority=15)
	public void click3() {
		//		click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		String title= driver.getTitle();
		Assert.assertEquals(title,"Brands | eSpares");
		//click on 3
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/ul/li[1]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/brands?facetstartswith=3");
	}
	//	Click on A
	@Test(priority=16)
	public void clickA() {
		//click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		String title= driver.getTitle();
		Assert.assertEquals(title,"Brands | eSpares");
		//click on A
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/ul/li[2]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/brands?facetstartswith=A");
	}
	//	Click on B
	@Test(priority=17)
	public void clickB() {
		//click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		String title= driver.getTitle();
		Assert.assertEquals(title,"Brands | eSpares");
		//click on B
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/ul/li[3]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/brands?facetstartswith=B");
	}

	//	Click on C
	@Test(priority=18)
	public void clickC() {
		//click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		String title= driver.getTitle();
		Assert.assertEquals(title,"Brands | eSpares");
		//click on C
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/ul/li[4]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/brands?facetstartswith=C");
	}

	//	Click on D
	@Test(priority=19)
	public void clickD() {
		//click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		String title= driver.getTitle();
		Assert.assertEquals(title,"Brands | eSpares");
		//click on D
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/ul/li[5]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/brands?facetstartswith=D");
	}


	//	Click on E
	@Test(priority=20)
	public void clickE() {
		//click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		String title= driver.getTitle();
		Assert.assertEquals(title,"Brands | eSpares");
		//click on E
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/ul/li[6]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/brands?facetstartswith=E");
	}

	//	Click on F
	@Test(priority=21)
	public void clickF(){
		//click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		String title= driver.getTitle();
		Assert.assertEquals(title,"Brands | eSpares");
		//click on F
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/ul/li[7]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/brands?facetstartswith=F");
	}

	//	Click on G
	@Test(priority=22)
	public void clickG(){
		//click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		String title= driver.getTitle();
		Assert.assertEquals(title,"Brands | eSpares");
		//click on G
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/ul/li[8]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/brands?facetstartswith=G");
	}

	//	Click on H
	@Test(priority=23)
	public void clickH() {
		//click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		String title= driver.getTitle();
		Assert.assertEquals(title,"Brands | eSpares");
		//click on H
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/ul/li[9]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/brands?facetstartswith=H");
	}

	//	Click on I
	@Test(priority=24)
	public void clickI() {
		//click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		String title= driver.getTitle();
		Assert.assertEquals(title,"Brands | eSpares");
		//click on I
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/ul/li[10]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/brands?facetstartswith=I");
	}

	//	Click on J
	@Test(priority=25)
	public void clickJ(){
		//click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		String title= driver.getTitle();
		Assert.assertEquals(title,"Brands | eSpares");
		//click on J
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/ul/li[11]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/brands?facetstartswith=J");
	}

	//	Click on K
	@Test(priority=26)
	public void clickK() {
		//click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		String title= driver.getTitle();
		Assert.assertEquals(title,"Brands | eSpares");
		//click on K
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/ul/li[12]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/brands?facetstartswith=K");
	}

	//	Click on L
	@Test(priority=27)
	public void clickL(){
		//click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		String title= driver.getTitle();
		Assert.assertEquals(title,"Brands | eSpares");
		//click on L
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/ul/li[13]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/brands?facetstartswith=L");
	}

	//	Click on M
	@Test(priority=28)
	public void clickM(){
		//click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		String title= driver.getTitle();
		Assert.assertEquals(title,"Brands | eSpares");
		//click on M
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/ul/li[14]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/brands?facetstartswith=M");
	}

	//	Click on N
	@Test(priority=29)
	public void clickN() {
		//click on All Brands
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a/span")).click();
		String title= driver.getTitle();
		Assert.assertEquals(title,"Brands | eSpares");
		//click on N
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/ul/li[15]/a")).click();
		String Url= driver.getCurrentUrl();
		Assert.assertEquals(Url,"https://www.espares.co.uk/brands?facetstartswith=N");
	}

	@AfterMethod
	public void tearDown() {
				driver.quit();
	}
}

