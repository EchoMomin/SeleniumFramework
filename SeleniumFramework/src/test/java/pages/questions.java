package pages;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class questions {
	WebDriver driver;
//before
	@BeforeMethod
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.espares.co.uk/question/es731397?vwo_opt_out=1");
		Thread.sleep(8000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.findElement(By.id("btn-allow-all")).click();

	}
	//Ask a question
	@Test
	public void askQuestion() throws InterruptedException {
		//Search a product by name
		driver.findElement(By.id("Title")).sendKeys("Does this product has any warranty");
		driver.findElement(By.id("Details")).sendKeys("Product name: Cooker Hood Interference Capacitor");
		driver.findElement(By.id("Name")).sendKeys("Zenifer");
		driver.findElement(By.id("EmailAddress")).sendKeys("Zenifer@zen.com");
		driver.findElement(By.id("Location")).sendKeys("33  Park End St,BROOK STREET");
		WebElement radio1 = driver.findElement(By.id("SubscribeToNewsletter_Yes"));
		radio1.click();	
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div[1]/section[3]/form/div[9]/div/input[2]")).click();
		String title=driver.getTitle();
		Assert.assertEquals(title, "Ask a Question | eSpares");
		driver.findElement(By.name("action")).click();
		String submitTitle=driver.getTitle();
		Assert.assertEquals(submitTitle, "Thank you | eSpares");
	}


	@AfterMethod
	public void tearDown() {
		//				driver.quit();
	}
}

