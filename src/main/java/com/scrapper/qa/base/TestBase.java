package com.scrapper.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
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
					"./src/test/resources/Properties/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			Reporter.log("Unable to load the property file");

		} catch (IOException e) {
//			e.printStackTrace();
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
			 options.addArguments("--headless"); 
			 options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			options.addArguments("--disable-infobars"); 
			options.addArguments("--disable-dev-shm-usage"); 
			options.addArguments("--disable-gpu");
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
		getDriver().get(prop.getProperty("URL"));

	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		TestBase.driver = driver;
	}

}
