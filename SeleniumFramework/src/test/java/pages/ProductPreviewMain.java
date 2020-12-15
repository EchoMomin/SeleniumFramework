package pages;

import org.openqa.selenium.chrome.ChromeDriver;

public class ProductPreviewMain {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		ProductPreview productPreview= new ProductPreview(driver);
		productPreview.run();
		System.out.println("run");
		
	}

}
