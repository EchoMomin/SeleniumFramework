package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class plpPage {
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
	
	
	
	
	@Test(priority=1)
	public void plpURL() throws InterruptedException {
		//Click on All Brands tab
		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a")).click();
		driver.findElement(By.id("btn-allow-all")).click();
		WebElement firstResult=  driver.findElement(By.cssSelector("ul.a-z-index-keys"));
		List<WebElement> elements = firstResult.findElements(By.tagName("li"));
		System.out.println(elements.size());
		
//		
//		 for (int i=0; i<elements.size(); i++) {
//			 	
//			 elements.get(i).findElement(By.tagName("a")).click();
//			 Thread.sleep(7000);
			 
			 
			 //WebElement r2 =  driver.findElement(By.cssSelector("ul.split-list>li>a"));
			 
			 
//			 String URL = driver.getCurrentUrl();
//			 System.out.println("LOL = "+URL);
		
//		  WebElement homePageQuery = driver.findElement(By.cssSelector(".primary-navigation>li:nth-child(2)>a"));
//          homePageQuery.click();
//          System.out.println();(webDriver.Title + " ~ loaded!");
//          WebElement brandPageQuery = driver.findElement(By.className("a-z-index-keys"));
//          readOnlyCollection<WebElement> aTozLinks = brandPageQuery.findElements(By.cssSelector("li>a"));


		 }

	

	@AfterMethod
	public void tearDown() {
		//				driver.quit();
	}
}
