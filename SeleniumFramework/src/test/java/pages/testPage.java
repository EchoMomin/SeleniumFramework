package pages;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;
public class testPage {


	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.espares.co.uk?vwo_opt_out=1");
		Thread.sleep(8000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.findElement(By.id("btn-allow-all")).click();

		driver.findElement(By.xpath("/html/body/header/div[4]/nav/div/ul/li[2]/a")).click();

		//list
		WebElement body= driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/ul"));
		System.out.println(body);
		List<WebElement> tags=body.findElements(By.cssSelector("li>a"));
		List<String> a=new ArrayList<String>();
		//a to z
		for (int i=0; i<tags.size(); i++) {
			a.add(tags.get(i).getText());
			System.out.println(tags.get(i).getText()+" it works");

		}
		//all in one
		for (int i=0; i<a.size(); i++) {
			driver.navigate().to("https://www.espares.co.uk/brands?facetstartswith="+a.get(i));
			System.out.println(driver.getCurrentUrl()+" loaded");
			List<WebElement> allBrandsByText = driver.findElements(By.cssSelector(".split-list>li>a"));
			List<String> all = new ArrayList<String>();
			//all in one href
			for(int j=0;j<allBrandsByText.size(); j++) {
				System.out.println(allBrandsByText.get(j).getAttribute("href")+" workssss");
				all.add(allBrandsByText.get(j).getAttribute("href"));

			}
			for(int j=0;j<all.size(); j++) {
				driver.navigate().to(all.get(j));
				System.out.println(driver.getCurrentUrl()+" loaded");
				
				List<WebElement> productElmList = driver.findElements(By.cssSelector(".product-listing>li>div.product-desktop>div.thumb.product-image-container-table>a"));
				List<String> productLinkList = new ArrayList<String>();
				
				for(int k=0;k<productElmList.size(); k++) {
					System.out.println(productElmList.get(k).getAttribute("href") + " ~ product href");
					productLinkList.add(productElmList.get(k).getAttribute("href"));
				}

				for(int k=0;k<productLinkList.size(); k++) {
					driver.navigate().to(productLinkList.get(k));
					System.out.println(driver.getCurrentUrl() + " ~ loaded!");
				}
				
			}
			
			
		}




		//close browser
		driver.close();

	}

}