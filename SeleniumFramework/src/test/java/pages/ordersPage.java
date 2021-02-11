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

public class ordersPage {
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


	// verify  My account URL
	@Test(priority=1)
	public void myAccountUrl() throws InterruptedException {
		//Click on My Account
		driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div[2]/a")).click();
		Thread.sleep(8000);
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/account/logon?ReturnUrl=%2faccount" );
	}

	//Sign in to your account
	@Test(priority=2)
	public void signIn() throws InterruptedException {
		//Click on My Account
		driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div[2]/a")).click();
		Thread.sleep(8000);
		//put email address
		driver.findElement(By.name("EmailAddress")).sendKeys("imran@echologyx.com");
		//put password
		driver.findElement(By.name("Password")).sendKeys("Echo123!");
		//click on sign in button
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section/form/div[5]/div/input[1]")).click();
		String title = driver.getCurrentUrl();
		Assert.assertEquals(title, "Your Orders | eSpares" );

	}
	//Send me an email to setup a new password
	@Test(priority=3)
	public void newPassword() throws InterruptedException {
		//Click on My Account
		driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div[2]/a")).click();
		Thread.sleep(8000);
		//Click on Send me an email to setup a new password
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section/form/div[3]/div/a")).click();
		//put email address
		driver.findElement(By.name("EmailAddress")).sendKeys(" ");
		//click on submit button
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/section/form/div/div[2]/input[2]")).click();
		//String title = driver.getCurrentUrl();
		//Assert.assertEquals(title, "Your Orders | eSpares" );
	}
	// verify View Order URL
	@Test(priority=4)
	public void viewOrder() throws InterruptedException {
		//Click on My Account
		driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div[2]/a")).click();
		driver.findElement(By.name("EmailAddress")).sendKeys("imran@echologyx.com");
		//put password
		driver.findElement(By.name("Password")).sendKeys("Echo123!");
		//click on sign in button
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section/form/div[5]/div/input[1]")).click();
		//click on my View order
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section/div[2]/article/div[4]/span/a")).click();
		//Assert title with order number
		String title = driver.getCurrentUrl();
		Assert.assertEquals(title, "Order #8727908 | eSpares" );


	}
	//contact details
	@Test(priority=5)
	public void contactDetails() throws InterruptedException {
		//Click on My Account
		driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div[2]/a")).click();
		//put email address
		driver.findElement(By.name("EmailAddress")).sendKeys("imran@echologyx.com");
		//put password
		driver.findElement(By.name("Password")).sendKeys("Echo123!");
		//click on sign in button
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section/form/div[5]/div/input[1]")).click();
		//click on contact details
		driver.findElement(By.xpath("//*[@id=\"collapse-your-details\"]/ul/li[1]/a")).click();
		//	change mobile number
		driver.findElement(By.id("MobilePhone")).clear();
		driver.findElement(By.id("MobilePhone")).sendKeys("1111111111");
		//click on save my details
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section/form/div[9]/div/input[1]")).click();
		//Assert title with order number
		String title = driver.getCurrentUrl();
		Assert.assertEquals(title, "Thank you | eSpares" );


	}
	//Address book edit and save
	@Test(priority=6)
	public void addressBook() throws InterruptedException {
		//Click on My Account
		driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div[2]/a")).click();
		//put email address
		driver.findElement(By.name("EmailAddress")).sendKeys("imran@echologyx.com");
		//put password
		driver.findElement(By.name("Password")).sendKeys("Echo123!");
		//click on sign in button
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section/form/div[5]/div/input[1]")).click();
		//click on address book
		driver.findElement(By.xpath("//*[@id=\"collapse-your-details\"]/ul/li[2]/a")).click();
		//	click on the edit button
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section[1]/article[1]/form/ul/li[1]/input")).click();
		//edit the name filed
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section[1]/article[1]/form/ul/li[1]/input")).sendKeys("1");
		//click on save this address
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section/form/div[2]/div/input")).click();
		//Assert title with order number
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/account/addressbook" );
	}
	//Address book edit and save
	@Test(priority=7)
	public void addressBookEditCancel() throws InterruptedException {
		//Click on My Account
		driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div[2]/a")).click();
		//put email address
		driver.findElement(By.name("EmailAddress")).sendKeys("imran@echologyx.com");
		//put password
		driver.findElement(By.name("Password")).sendKeys("Echo123!");
		//click on sign in button
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section/form/div[5]/div/input[1]")).click();
		//click on address book
		driver.findElement(By.xpath("//*[@id=\"collapse-your-details\"]/ul/li[2]/a")).click();
		//	click on the edit button
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section[1]/article[1]/form/ul/li[1]/input")).click();
		//edit the name filed
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section[1]/article[1]/form/ul/li[1]/input")).sendKeys("1");
		//click on cancel button
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section/form/div[2]/div/a")).click();
		//Assert title with order number
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/account/addressbook" );
	}

	//Sign out from the myAccount
	@Test(priority=8)
	public void signOut() throws InterruptedException {
		//Click on My Account
		driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div[2]/a")).click();
		//put email address
		driver.findElement(By.name("EmailAddress")).sendKeys("imran@echologyx.com");
		//put password
		driver.findElement(By.name("Password")).sendKeys("Echo123!");
		//click on sign in button
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section/form/div[5]/div/input[1]")).click();
		//click on signOut 
		driver.findElement(By.xpath("//*[@id=\"nav-blocks\"]/div[2]/a")).click();
		//Assert title with order number
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/account/logon" );
	}
	//	Change password
	@Test(priority=8)
	public void changePassword() throws InterruptedException {
		//Click on My Account
		driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div[2]/a")).click();
		//put email address
		driver.findElement(By.name("EmailAddress")).sendKeys("imran@echologyx.com");
		//put password
		driver.findElement(By.name("Password")).sendKeys("Echo123!");
		//click on sign in button
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section/form/div[5]/div/input[1]")).click();
		//click on change password 
		driver.findElement(By.xpath("//*[@id=\"collapse-your-details\"]/ul/li[3]/a")).click();
		//put current password
		driver.findElement(By.id("CurrentPassword")).sendKeys("");
		//put new password
		driver.findElement(By.id("NewPassword")).sendKeys("");
		//Repeat new password
		driver.findElement(By.id("NewPasswordConfirm")).sendKeys("");
		//save my password
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section/form/div[4]/div/button")).click();
		//Assert title with order number
		//		String URL = driver.getCurrentUrl();
		//		Assert.assertEquals(URL, "https://www.espares.co.uk/account/logon" );
	}
	//View your orders
	@Test(priority=9)
	public void viewOrders() throws InterruptedException {
		//Click on My Account
		driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div[2]/a")).click();
		//put email address
		driver.findElement(By.name("EmailAddress")).sendKeys("imran@echologyx.com");
		//put password
		driver.findElement(By.name("Password")).sendKeys("Echo123!");
		//click on sign in button
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section/form/div[5]/div/input[1]")).click();
		//click on change password 
		driver.findElement(By.xpath("//*[@id=\"collapse-your-details\"]/ul/li[3]/a")).click();
		//put current password
		driver.findElement(By.id("CurrentPassword")).sendKeys("");
		//put new password
		driver.findElement(By.id("NewPassword")).sendKeys("");
		//Repeat new password
		driver.findElement(By.id("NewPasswordConfirm")).sendKeys("");
		//save my password
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/section/form/div[4]/div/button")).click();
		//Assert title with order number
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.espares.co.uk/account/logon" );
	}
	//Your ratings & reviews
	//Your questions & answers

	@AfterMethod
	public void tearDown() {
		//				driver.quit();
	}
}
