package webdriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.lang.System.Logger;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ClassToInstanceMap;

import okio.Timeout;

public class Topic_07_WebElement_Browser {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	//xpath
	By linkMyAccount = By.xpath("//div[@class='footer']//a[@title='My Account']");
	By buttonCreateAnAccount = By.xpath("//div[@class='col-1 new-users']//a[@class='button']");
	By textLoginOrCreate = By.xpath("//div[@class='page-title']/h1[text()]");
	By textCreateAccount = By.xpath("//div[@class='account-create']//h1[text()]");
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}
 
		driver = new ChromeDriver();
//		ChromeOptions opt = new ChromeOptions();
//		opt.setHeadless(true);
//		opt.addArguments("--headless");
//		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
	}

	@Test
	public void TC_01_Verify_URL() {
		driver.get("http://live.techpanda.org/");
		sleepInSecond(2);
		driver.findElement(linkMyAccount).click();
		assertTrue(driver.getCurrentUrl().contains("http://live.techpanda.org/index.php/customer/account/login/"));
		driver.findElement(buttonCreateAnAccount).click();
		assertTrue(driver.getCurrentUrl().contains("http://live.techpanda.org/index.php/customer/account/create/"));
	}
//
	@Test
	public void TC_02_Verify_Title() {
		driver.get("http://live.techpanda.org/");
		sleepInSecond(2);
		driver.findElement(linkMyAccount).click();
		assertEquals(driver.getTitle(),"Customer Login");
		driver.findElement(buttonCreateAnAccount).click();
		assertEquals(driver.getTitle(),"Create New Customer Account");
	}

	@Test
	public void TC_03_Navigate_Function() {
		driver.get("http://live.techpanda.org/");
		sleepInSecond(2);
		driver.findElement(linkMyAccount).click();
		driver.findElement(buttonCreateAnAccount).click();
		assertTrue(driver.getCurrentUrl().contains("http://live.techpanda.org/index.php/customer/account/create/"));
		driver.navigate().back();
		assertTrue(driver.getCurrentUrl().contains("http://live.techpanda.org/index.php/customer/account/login/"));
		driver.navigate().forward();
		assertTrue(driver.getTitle().contains("Create New Customer Account"));
	}
	@Test
	public void TC_04_Ge_Page_Source_Code() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(linkMyAccount).click();
//		System.out.println(driver.findElement(textLoginOrCreate).getText());
		
		assertEquals(driver.findElement(textLoginOrCreate).getText(),"LOGIN OR CREATE AN ACCOUNT");
		driver.findElement(buttonCreateAnAccount).click();
//		System.out.println(driver.findElement(textCreateAccount).getText());
		assertEquals(driver.findElement(textCreateAccount).getText(),"CREATE AN ACCOUNT");
		
	}
	
	public void sleepInSecond (long timeInSecond) {
		try {
			Thread.sleep(timeInSecond*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}