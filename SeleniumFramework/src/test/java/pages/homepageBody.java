package pages;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
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


public class homepageBody {
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



	//validation of Get the eSpares eNews form
	@Test(priority=2)
	public void eNews() {
		driver.findElement(By.id("subscribe-email")).sendKeys("abddd@gh.hg");
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.findElement(By.id("subscribe-name")).sendKeys("Abdel");
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"EmailSignupForm\"]/div[2]/span[1]/input")).click();
	}


	// View All Brands
	@Test(priority=3)

	public void viewAllBrands() {
		driver.findElement(By.cssSelector("div.view-all-brands")).click();
		String title=driver.getTitle();
		Assert.assertEquals(title, "Brands | eSpares");
	}


	// Featured Spares
	@Test(priority=4)
	public void featured() {
		driver.findElement(By.xpath("//*[@id=\"featured-spares-carousel\"]/div[1]/div/div[4]/article/footer/a")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		String title=driver.getTitle();
		Assert.assertEquals(title, "Cooker & Hob Knobs | eSpares");
	}

	// Featured Spares Next button click 5times
	@Test(priority=5)
	public void featuredNext() {
		int i=0;
		while (i < 5) {
			driver.findElement(By.cssSelector("section.featured-spares-teasers>div.section-heading>div.owl-nav>span.owl-next")).click();
			driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);

			i++;
		}

		System.out.println("This loop runs 5 times");
	}



	// ADVICE CENTRE URL
	@Test(priority=6)
	public void adviceCenter() {
		driver.findElement(By.className("get-advice")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		String title=driver.getTitle();
		Assert.assertEquals(title, "Appliance Repair Help & Advice Centre | eSpares");
	}

	// find-model
	@Test(priority=7)
	public void findModel() {
		driver.findElement(By.className("find-model")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		String title=driver.getTitle();
		Assert.assertEquals(title, "Finding Model Numbers | eSpares");
	}
	// find-part
	@Test(priority=8)
	public void findPart() {
		driver.findElement(By.className("find-part")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		String title=driver.getTitle();
		Assert.assertEquals(title, "Help me find the part I need | eSpares");
	}
	//manuals
	@Test(priority=9)
	public void manuals() {
		driver.findElement(By.className("manuals")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		String title=driver.getTitle();
		Assert.assertEquals(title, "Download User Manuals | eSpares");
	}

	//Advice center articles
	@Test(priority=10)
	public void adiceCenterArticle() {
		driver.findElement(By.xpath("//*[@id=\"advice-centre-carousel\"]/div[1]/div/div[4]/article/a/div/img")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		String title=driver.getTitle();
		Assert.assertEquals(title, "How to Diagnose Tumble Dryer Drying and Heating Problems | eSpares");
	}

	//Major Brands> beko
	@Test(priority=11)
	public void beko() {
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[2]/div[2]/div/div/div[1]/ul/li[1]/a/div/img")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.espares.co.uk/browse/ma927/beko");
	}
	//Major Brands> bosch
	@Test(priority=12)
	public void bosch() {
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[2]/div[2]/div/div/div[1]/ul/li[2]/a/div/img")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.espares.co.uk/browse/ma856/bosch");
	}
	//Major Brands> beko
	@Test(priority=13)
	public void dyson() {
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[2]/div[2]/div/div/div[1]/ul/li[3]/a/div/img")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.espares.co.uk/browse/ma716/dyson");
	}
	//Major Brands> hotPoint
	@Test(priority=14)
	public void hotPoint() {
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[2]/div[2]/div/div/div[1]/ul/li[4]/a/div/img")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.espares.co.uk/browse/ma808/hotpoint");
	}
	//Major Brands> indesit
	@Test(priority=15)
	public void indesit() {
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[2]/div[2]/div/div/div[1]/ul/li[5]/a/div/img")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.espares.co.uk/browse/ma805/indesit");
	}
	//Major Brands> karcher
	@Test(priority=16)
	public void karcher() {
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[2]/div[2]/div/div/div[1]/ul/li[6]/a/div/img")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.espares.co.uk/browse/ma877/karcher");
	}

	//Major Brands> kenwood
	@Test(priority=17)
	public void kenwood() {
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[2]/div[2]/div/div/div[1]/ul/li[7]/a/div/img")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.espares.co.uk/browse/ma435/kenwood");
	}
	//Major Brands> lamona
	@Test(priority=18)
	public void lamona() {
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[2]/div[2]/div/div/div[1]/ul/li[8]/a/div/img")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.espares.co.uk/browse/ma2361/lamona");
	}
	//Major Brands> miele
	@Test(priority=19)
	public void miele() {
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[2]/div[2]/div/div/div[1]/ul/li[9]/a/div/img")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.espares.co.uk/browse/ma254/miele");
	}
	//Major Brands> neff
	@Test(priority=20)
	public void neff() {
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[2]/div[2]/div/div/div[1]/ul/li[10]/a/div/img")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.espares.co.uk/browse/ma1126/neff");
	}
	//Major Brands> numatic-henry
	@Test(priority=21)
	public void numaticHenry() {
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[2]/div[2]/div/div/div[1]/ul/li[11]/a/div/img")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.espares.co.uk/browse/at1086ma531/vacuum-cleaners/numatic-henry");
	}
	//Major Brands> samsung
	@Test(priority=22)
	public void samsung() {
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[2]/div[2]/div/div/div[1]/ul/li[12]/a/div/img")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.espares.co.uk/browse/ma596/samsung");
	}

	//Major Brands> vax
	@Test(priority=23)
	public void vax() {
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[2]/div[2]/div/div/div[1]/ul/li[13]/a/div/img")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.espares.co.uk/browse/ma694/vax");
	}

	//Major Brands> zanussi
	@Test(priority=24)
	public void zanussi() {
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[2]/div[2]/div/div/div[1]/ul/li[14]/a/div/img")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.espares.co.uk/browse/ma332/zanussi");
	}
	@Test
	public void linkCount() throws InterruptedException, IOException {
		//Count total links in the homepage
		System.out.println(driver.findElements(By.tagName("a")).size());
		List<WebElement> links= driver.findElements(By.tagName("a"));
		  SoftAssert a =new SoftAssert();

		for(WebElement link : links){
			String url= link.getAttribute("href");
			HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			a.assertTrue(respCode<400, "The link with Text"+link.getText()+" is broken with code" +respCode);
}
		   a.assertAll();


	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
