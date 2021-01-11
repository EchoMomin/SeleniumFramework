package pages;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
		driver.get("http://www.espares.co.uk");
		//		Alert alert = driver.switchTo().alert();
		//		alert.accept();
		driver.findElement(By.id("btn-allow-all")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	

	}

	//Footer links Title print
	@Test(priority=1)
	public void linkCount() throws InterruptedException {
		//Count total links in the homepage
		System.out.println(driver.findElements(By.tagName("a")).size());
		//Footer Links
		WebElement footerDriver= driver.findElement(By.cssSelector(".footer-wrapper"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		System.out.println(footerDriver.findElement(By.xpath("//*[@id=\"footer-collapse-3\"]/ul/li[1]/a")).getText());
		String skipTagTitle = "Cookie Settings";
		for (int i=1;i<footerDriver.findElements(By.tagName("a")).size();i++) {
			String tagTitle = footerDriver.findElements(By.tagName("a")).get(i).getText();
			if(!skipTagTitle.equals(tagTitle)) {
				System.out.println(tagTitle + " -- test title from inside");
				String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
				footerDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			}else {
				System.out.println(tagTitle);	
			}
			Thread.sleep(2000L);
		}
		Set<String> abc=driver.getWindowHandles();
		Iterator<String> it=abc.iterator();

		while(it.hasNext())
		{
			System.out.println(driver.getTitle());
			driver.switchTo().window(it.next());
			Thread.sleep(3000L);

		}
	}

	@AfterMethod
	public void tearDown() {
		//						driver.quit();
	}
}
