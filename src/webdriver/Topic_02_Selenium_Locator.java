package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
 
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// mở trang register
		driver.get("https://demo.nopcommerce.com/register");
	}

	@Test
	public void TC_01_ID() {

	}

	@Test
	public void TC_02_Class() {

	}

	@Test
	public void TC_03_Name () {

	}
	
	@Test
	public void TC_04_TagName () {

	}
	
	@Test
	public void TC_05_LinkText() {

	}
	
	@Test
	public void TC_06_PartialLinkText() {

	}
	
	@Test
	public void TC_07_Css () {

	}
	
	@Test
	public void TC_08_XPath() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}