package webdriver;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Browser {
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
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void TC_01_() {
		// Đóng 1 tab
		driver.close();
		// Đóng cả trình duyệt
		driver.quit();
		// Tìm 1 element
		WebElement emailTextbox = driver.findElement(By.xpath(""));
		emailTextbox.clear();
		emailTextbox.sendKeys("");
		//Tìm nhiều elements
		List <WebElement> checkboxes =  driver.findElements(By.xpath(""));
		// Mở ra 1 URL
		driver.get("");
		// Trả về url
		driver.getCurrentUrl();
		// Kiểm tra xem đúng không
		Assert.assertEquals(driver.getCurrentUrl(), "");
		
		// Trả về source code HTML của page hiện tại
		driver.getPageSource();
		
		// Verify tương đối
		Assert.assertTrue(driver.getPageSource().contains(""));
		// Trả về title hiện tại
		driver.getTitle();
		// Lấy ra ID của Window/Tab
		String loginWindow = driver.getWindowHandle();
		// Lấy ra tất cả ID của Windows/Tabs
		Set <String> allIDs = driver.getWindowHandles();
		
		Options opt = driver.manage();
		
		// Login thành công, lưu cookies lại
		opt.getCookies();
		// Testcase khác -> set cookies vào lại -> không cần login nữa
		
		Timeouts time = opt.timeouts();
		
		// Implicitly wait and depend on: findElement/ findElements
		// Khoảng thời gian chờ element xuất hiện trong vòng x giây
		time.implicitlyWait(15, TimeUnit.MINUTES);
		
		// Khoảng thời gian chờ page load xong trong vòng
		time.pageLoadTimeout(15, TimeUnit.MILLISECONDS);
		
		// WebDriver API - Javascript Executor (JavvascriptExecutor libary)
		// Khoảng thời gian chờ script được thực thi
		time.setScriptTimeout(5, TimeUnit.SECONDS);
		
		Window win = opt.window();
		win.fullscreen();
		win.maximize();
		
		// Test GUI: Front/Size/ Color/ Position/ Local
		win.getPosition();
		win.getSize();
		
		Navigation nav = driver.navigate();
		
		nav.back();
		nav.forward();
		nav.refresh();
		nav.to("");
		
		TargetLocator tar = driver.switchTo();
		tar.alert();
		tar.frame(0);
		tar.window("");
		WebElement element = driver.findElement(By.className(""));
		
		// Dùng cho các textbox/ textarea/ dropdown (Editable)
		// Xoá dữ liệu đi trước khi nhập text
		element.clear();
		// Dùng cho các textbox/ textarea/ dropdown (Editable)
		// Nhập dữ liệu
		element.sendKeys("");
		
		// Click vào button/ link/ checkbox/ radio/ image...
		element.click();
		
		String searchAttribute = element.getAttribute("");
		// Lấy value trong email textbox
		String emailTextboxAttribute = element.getAttribute("value");
		// Lấy background color
		element.getCssValue("background-color");
		// Vị trí của element so với web
		element.getLocation();
		
		// Kích thước của element
		element.getSize();
		
		
		
		
	}
//
//	@Test
//	public void TC_02_() {
//
//	}
//
//	@Test
//	public void TC_03_() {
//
//	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}