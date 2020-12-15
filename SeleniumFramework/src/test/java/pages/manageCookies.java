package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class manageCookies {
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
		//		driver.findElement(By.id("btn-allow-all")).click();

	}


	//click on Manage cookies
	@Test(priority=1)
	public void allOn() throws InterruptedException {
		//Click on Manage cookies tab
		driver.findElement(By.xpath("/html/body/div[6]/div/div/a[1]")).click();
		Thread.sleep(8000);
		//Performance/Analytics toggle on
		driver.findElement(By.xpath("//*[@id=\"cookie-control-form\"]/div[2]/label/span[2]")).click();
		//Functional toggle on
		driver.findElement(By.xpath("//*[@id=\"cookie-control-form\"]/div[3]/label/span[2]")).click();
		//Marketing/Targeting toggle on
		driver.findElement(By.xpath("//*[@id=\"cookie-control-form\"]/div[4]/label/span[2]")).click();
		//save
		driver.findElement(By.xpath("//*[@id=\"cookie-control-form\"]/div[5]/button")).click();
		//page source
		String	src=driver.getPageSource();
		int cmt=src.indexOf("cookies_marketing_targeting");
		String cookieMarketing=src.substring(cmt,cmt+33);
		cookieMarketing=cookieMarketing.replace("\"", "");
		System.out.println(cookieMarketing +" cmt");
		Assert.assertEquals(cookieMarketing,"cookies_marketing_targeting:true");
		
		int cf=src.indexOf("cookies_functional");
		String cookiesFunctional=src.substring(cf,cf+24);
		cookiesFunctional=cookiesFunctional.replace("\"", "");
		System.out.println(cookiesFunctional +" cf");
		Assert.assertEquals(cookiesFunctional,"cookies_functional:false");
		
		int cpa=src.indexOf("cookies_performance_analytic");
		String cookiesPerformanceAnalytic=src.substring(cpa,cpa+35);
		cookiesPerformanceAnalytic=cookiesPerformanceAnalytic.replace("\"", "");
		System.out.println(cookiesPerformanceAnalytic +" cpa");
		Assert.assertEquals(cookiesPerformanceAnalytic,"cookies_performance_analytics:true");
	}


	@AfterMethod
	public void tearDown() {
		//				driver.quit();
	}
}
