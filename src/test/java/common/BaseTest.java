package common;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import testCases.DemoTest;
import testCases.MyDataObject;
import testCases.ReadJsonFile;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;
	public WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	public static DemoTest demoTest = new DemoTest();
	public static MyDataObject data = new ReadJsonFile().getData();

	@BeforeTest
	public static void setupTest() throws IOException {

		if (driver == null) {
			FileReader fr = new FileReader(System.getProperty("user.dir") + "/src/test/resources/configFiles/config.properties");
			prop.load(fr);
		}
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (prop.getProperty("browser").equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}
		driver.get(prop.getProperty("url"));
	}

	@AfterTest
	public static void teardown() {
		driver.quit();
	}

}
