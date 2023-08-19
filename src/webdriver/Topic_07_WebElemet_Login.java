package webdriver;

import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_WebElemet_Login {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String url = "http://live.techpanda.org/";
	By linkMyAccount = By.xpath("//li[@class='first']/a[@title='My Account'][2]");
	By txtboxEmail = By.xpath("//input[@id='email']");
	By txtboxPassword = By.xpath("//input[@id='pass']");
	
	By buttonLogin = By.xpath("//button[@type='submit' and @title='Login']");
	By validateEmail = By.xpath("//label[@for=\"email\"]//following-sibling::div//div[.='This is a required field.']");
	By validatePass = By.xpath("//label[@for=\"pass\"]//following-sibling::div//div[.='This is a required field.']");
	By validateInvalidEmail = By.xpath("//div[.='Please enter a valid email address. For example johndoe@domain.com.']");
	By validateLessThan6Pass = By.xpath("//div[.='Please enter 6 or more characters without leading or trailing spaces.']");
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}
 
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	//

	@Test
	public void TC_01_Login_EmptyEmail_EmptyPass() {
		driver.get(url);
		driver.findElement(linkMyAccount).click();
		driver.findElement(buttonLogin).click();
		assertTrue(driver.findElement(validateEmail).isDisplayed());
		assertTrue(driver.findElement(validatePass).isDisplayed());
		
	}

	@Test
	public void TC_02_Login_InvalidEmail() {
		driver.get(url);
		driver.findElement(linkMyAccount).click();
		driver.findElement(txtboxEmail).sendKeys("123@1235.123/");
		driver.findElement(txtboxPassword).sendKeys("123456");
		driver.findElement(buttonLogin).click();
		assertTrue(driver.findElement(validateInvalidEmail).isDisplayed());
	}

	@Test
	public void TC_03_Login_LessThan6CharsPass() {
		driver.get(url);
		driver.findElement(linkMyAccount).click();
		driver.findElement(txtboxEmail).sendKeys("automation@gmail.com");
		driver.findElement(txtboxPassword).sendKeys("123");
		driver.findElement(buttonLogin).click();
		assertTrue(driver.findElement(validateLessThan6Pass).isDisplayed());
		

	}
	public void sleepInSecond (long time) {
		try {
			Thread.sleep(time*1000);
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