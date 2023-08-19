package webdriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
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

public class Topic_07_WebElement_Element {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String url = "https://automationfc.github.io/basic-form/index.html";

	By textBoxEmail = By.xpath("//div[@class='container']//input[@id='mail']");
	By radioButtonUnder18 = By.xpath("//input[@type='radio' and @id='under_18']");
	By textUser5 = By.xpath("//div[@class='figcaption']/h5[.='Name: User5']");
	By textBoxEducation = By.xpath("//div[@class='container']//textarea[@id='edu']");
	By dropDownUserDrop1 = By.xpath("//div[@class='container']//select[@name='user_job1']");
	By checkBoxDevelopment = By.xpath("//input[@type='checkbox' and @id='development']");
	By slider1 = By.xpath("//div[@class='container']//input[@id='slider-1']");
	By textBoxPassword = By.xpath("//div[@class='container']//input[@type='password' and @disabled='disabled']");
	By radioDisbaledButton = By.xpath("//div[@class='container']//input[@type='radio' and @disabled='disabled']");
	By textBoxBio = By.xpath("//div[@class='container']//textarea[@id='bio' and @disabled='disabled']");
	By dropDownUserDrop3 = By.xpath("//div[@class='container']//select[@id='job3' and @disabled='disabled']");
	By checkBoxInteresDiabled = By.xpath("//label[@class='light' and @for='check-disbaled']");
	By slider2 = By.xpath("//input[@id='slider-2' and @disabled='disabled']");
	By checkBoxJava = By.xpath("//input[@type='checkbox' and @id='java']");
	// xpath TC 4

	By textboxBMail = By.xpath("//fieldset[@class=\"!margin-bottom--lv2\"]//input[@type='email']");
	By textboxPass = By.xpath("//fieldset[@class=\"!margin-bottom--lv2\"]//input[@type='password']");

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
	public void TC_01_Elements_IsDisplayed() {
		driver.get(url);
		sleepInSecond(2);
		if (driver.findElement(textBoxEmail).isDisplayed()) {
			driver.findElement(textBoxEmail).sendKeys("lcdanh.testing@gmail.com");
			System.out.println("Email textbox is displayed");
		} else {
			System.out.println("Email textbox is not displayed");

		}
		if (driver.findElement(radioButtonUnder18).isDisplayed()) {
			driver.findElement(radioButtonUnder18).click();
			System.out.println("Under 18 radio button is displayed");

		} else {
			System.out.println("Under 18 radio button is not displayed");
		}
		if (driver.findElement(textBoxEducation).isDisplayed()) {
			driver.findElement(textBoxEducation).sendKeys("Testing");
			System.out.println("Education textbox is displayed");

		} else {
			System.out.println("Education textbox is not displayed");

		}
	}

//
	@Test
	public void TC_02_Elements_isEnabled() {
		driver.get(url);
		if (driver.findElement(textBoxEmail).isDisplayed()) {
			System.out.println("Email textbox is displayed");
		} else {
			System.out.println("Email textbox is not displayed");
		}
		if (driver.findElement(radioButtonUnder18).isDisplayed()) {
			System.out.println("Under 18 radio button is displayed");
		} else {
			System.out.println("Under 18 radio button is not displayed");
		}
		if (driver.findElement(textBoxEducation).isDisplayed()) {
			System.out.println("Education textbox is displayed");
		} else {
			System.out.println("Education textbox is not displayed");
		}
		if (driver.findElement(dropDownUserDrop1).isDisplayed()) {
			System.out.println("Job role 1 dropdown list is displayed");
		} else {
			System.out.println("Job role 1 dropdown is not displayed");
		}
		if (driver.findElement(slider1).isEnabled()) {
			System.out.println("Slider 1 is enabled");

		} else {
			System.out.println("Slider 1 is disabled");
		}
		if (driver.findElement(textBoxPassword).isEnabled()) {
			System.out.println("Password textbox is enabled");
		} else {
			System.out.println("Password textbox is disabled");
		}
		if (driver.findElement(radioDisbaledButton).isEnabled()) {
			System.out.println("Radio disbaled button is enabled");
		} else {
			System.out.println("Radio button is disabled");
		}
		if (driver.findElement(textBoxBio).isEnabled()) {
			System.out.println("Biography textbox is enabled");
		} else {
			System.out.println("Biography textbox is disabled");
		}
		if (driver.findElement(dropDownUserDrop3).isEnabled()) {
			System.out.println("Job role 3 dropdown list is enabled");

		} else {
			System.out.println("Job role 3 dropdown list is disabled");
		}
		if (driver.findElement(checkBoxInteresDiabled).isEnabled()) {
			System.out.println("Interest checkbox is enabled");

		} else {
			System.out.println("Interest checkbox is disabled");
		}
		if (driver.findElement(slider2).isEnabled()) {
			System.out.println("Slider 2 is enabled");

		} else {
			System.out.println("Slider 2 is disabled");
		}
	}

	@Test
	public void TC_03_Elements_IsSelected() {
		driver.get(url);
		driver.findElement(radioButtonUnder18).click();
		driver.findElement(checkBoxJava).click();
		assertTrue(driver.findElement(radioButtonUnder18).isSelected());
		assertTrue(driver.findElement(checkBoxJava).isSelected());
		driver.findElement(checkBoxJava).click();
		assertFalse(driver.findElement(checkBoxJava).isSelected());
	}

	@Test
	public void TC_04_Register_Function() {
		driver.get("https://login.mailchimp.com/signup/");
		driver.findElement(textboxBMail).sendKeys("lcdanh.testing@gmail.com");
		sleepInSecond(0);
		// input lower char
		driver.findElement(textboxPass).sendKeys("a");
//		driver.findElement(By.xpath("//html")).click();
		assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		driver.findElement(textboxPass).clear();
		sleepInSecond(0);
//		// input upper char
		driver.findElement(textboxPass).sendKeys("A");
		assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		driver.findElement(textboxPass).clear();
//		sleepInSecond(2);
//		// input one number
		driver.findElement(textboxPass).sendKeys("3");
		assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		driver.findElement(textboxPass).clear();
//		sleepInSecond(2);
//		// input special character
		driver.findElement(textboxPass).sendKeys("?");
		assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		driver.findElement(textboxPass).clear();
//		sleepInSecond(2);
//		// input more than 8 chars
		driver.findElement(textboxPass).sendKeys("123456789");
		assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		driver.findElement(textboxPass).clear();
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
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