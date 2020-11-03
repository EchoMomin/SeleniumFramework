import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTest {
	public static void main(String[] args) {
		//System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.tron.espares.co.uk/");
		driver.manage().window().maximize();
		driver.findElement(By.name("SearchTerm")).sendKeys("Bosch Cooker Hood Chimney");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("search")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

}
