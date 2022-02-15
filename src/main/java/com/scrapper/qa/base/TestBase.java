package com.scrapper.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		try {

			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"./src/main/resources/com/scrapper/" + "qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			Reporter.log("Unable to load the property file");

		} catch (IOException e) {
			e.printStackTrace();
			Reporter.log("Unable to load the property file");
		}
	}

	public static void initialization() {

		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("ChromeDriverPath"));
			ChromeOptions options = new ChromeOptions();
			// options.addArguments("window-size=1400,800");
			 options.addArguments("--headless"); ;
			// ChromeDriver is just AWFUL because every version or two it breaks unless you
			// pass cryptic arguments
			// AGRESSIVE: options.setPageLoadStrategy(PageLoadStrategy.NONE); //
			// https://www.skptricks.com/2018/08/timed-out-receiving-message-from-renderer-selenium.html
//			options.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
//			options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
//			options.addArguments("--no-sandbox"); // https://stackoverflow.com/a/50725918/1689770
//			options.addArguments("--disable-infobars"); // https://stackoverflow.com/a/43840128/1689770
//			options.addArguments("--disable-dev-shm-usage"); // https://stackoverflow.com/a/50725918/1689770
//			options.addArguments("--disable-browser-side-navigation"); // https://stackoverflow.com/a/49123152/1689770
//			options.addArguments("--disable-gpu"); // https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
//			driver = new ChromeDriver(options);

			driver = new ChromeDriver(options);
//			driver=new ChromeDriver();
		} else if (browserName.equals("ff")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("FirefoxDriverPath"));
			FirefoxBinary firefoxBinary = new FirefoxBinary();
			firefoxBinary.addCommandLineOptions("--headless");
			FirefoxOptions options = new FirefoxOptions();
			driver = new FirefoxDriver(options);
			options.setBinary(firefoxBinary);
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
//		 getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//		 getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//		getDriver().manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
//		getDriver().manage().timeouts().setScriptTimeout(3L, TimeUnit.SECONDS);

		getDriver().get(prop.getProperty("URL"));

	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		TestBase.driver = driver;
	}

}
