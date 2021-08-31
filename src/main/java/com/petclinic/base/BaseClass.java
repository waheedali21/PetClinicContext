
package com.petclinic.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.petclinic.utils.ExcelDataConfig;
import com.petclinic.utils.TestUtilities;

/**
 * @author WA
 *
 */
public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	public static JavascriptExecutor js;
	public static WebDriverWait wait;

	public static ExcelDataConfig excelDataConfigObj = null;
	
	public static Logger log = Logger.getLogger(BaseClass.class); 

	// Current class constructor in order to load property file
	public BaseClass() throws Exception {

		prop = new Properties();
		log.info("Properties file object got create");
		fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\petclinic\\config\\configuration.properties");
		log.info("FileInputStream path is setup");
		prop.load(fis);
		log.info("FileInputStream got loaded");
		// Excel sheet
		excelDataConfigObj = new ExcelDataConfig(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\petclinic\\testdata\\petClinicContextExcelData.xlsx");

	}

	// launch the browser
	public static void initializeBrowser() {

		String broswerName = prop.getProperty("broswer");
		log.info("Broswer name fetched from property file");

		if (broswerName.contentEquals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\drivers\\chromedriver.exe");

			DesiredCapabilities caps = new DesiredCapabilities();
			ChromeOptions options = new ChromeOptions();
			// caps.setAcceptInsecureCerts(true);
			options.addArguments("--start-maximized");
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			options.merge(caps);

			driver = new ChromeDriver(options);
			log.info("Chrome launched");

			driver.manage().deleteAllCookies();
			log.info("Coookies got got deleted");
			driver.manage().timeouts().pageLoadTimeout(TestUtilities.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		}

		else if (broswerName.contentEquals("firefox")) {
			System.setProperty("webdriver.geck.odriver",
					System.getProperty("user.dir") + "\\src\\test\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		}

		else if (broswerName.contentEquals("internet explorer")) {
			System.setProperty("webdriver.geck.odriver",
					System.getProperty("user.dir") + "\\src\\test\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		}

		driver.get(prop.getProperty("url"));

	}

	// click element method
	public static void clickElement(WebElement element) {
		element.click();

	}

	// send-key generic method
	public static void enterValue(WebElement element, String value) {
		if (!element.getText().isEmpty()) {
			element.clear();
		}

		element.sendKeys(value);

	}

	// drop-down field value selection
	public static void selectElement(WebElement element, String value) {
		Select selectObj = new Select(element);
		selectObj.selectByValue(value);

	}

	//@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
