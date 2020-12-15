package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductPreview {


	public ChromeDriver chromeDriver;
	public ProductPreview(ChromeDriver chromeDriver) {
		this.chromeDriver= chromeDriver;
	}
	public void run() {
		chromeDriver.navigate().to("http://espares.co.uk/");
		System.out.println(chromeDriver.getTitle() + " ~ loaded!");
		List<WebElement> megaMenuPanelElmLinks = chromeDriver
				.findElements(By.cssSelector(".mobile-megamenu-panel>ul>li>a"));
		List<String> megaMenuPanelLinks = new ArrayList<String>();
		for (WebElement webElement : megaMenuPanelElmLinks) {
			if (webElement.getAttribute("href").contains("search"))
			{
				megaMenuPanelLinks.add(webElement.getAttribute("href"));   
			}
		}

		for (String url : megaMenuPanelLinks) {
			System.out.println(url+ " ~ mega men link");
			search(url);
		}
	}


	public void search(String url) {
		chromeDriver.navigate().to(url);
		System.out.println(chromeDriver.getTitle() + " ~ loaded!");
		preview();
		chromeDriver.navigate().to(url);
		System.out.println(chromeDriver.getTitle() + " ~ back!");
		WebElement paginationLi = chromeDriver.findElement(By.cssSelector(".pagination>li:last-child"));
		if (paginationLi.getAttribute("class").equals("disabled"))
		{
			System.out.println("last page!");
		}
		else
		{
			WebElement paginationLiLink = chromeDriver.findElement(By.cssSelector(".pagination>li:last-child>a"));
			search(paginationLiLink.getAttribute("href"));
		}
	}


	public  void preview()
	{
		List<WebElement> productElmList = chromeDriver.findElements(By.cssSelector(".product-listing>li>div.product-desktop>div.thumb.product-image-container-table>a"));
		List<String> productLinkList = new ArrayList<String>();

		for(int k=0;k<productElmList.size(); k++) {
			System.out.println(productElmList.get(k).getAttribute("href") + " ~ product href");
			productLinkList.add(productElmList.get(k).getAttribute("href"));
		}

		for(int k=0;k<productLinkList.size(); k++) {
			chromeDriver.navigate().to(productLinkList.get(k));
			System.out.println(chromeDriver.getCurrentUrl() + " ~ loaded!");
		} 

	}
}
