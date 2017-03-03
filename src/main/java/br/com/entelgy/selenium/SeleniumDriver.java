package br.com.entelgy.selenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SeleniumDriver {

	private static WebDriver driver;

	private static final String CHROME_DRIVER = "/home/andre/Downloads/chromedriver";
	private static final String PHANTOMJS_DRIVER = "/home/andre/Downloads/phantomjs";

	private static final long TIMEOUT = 20;
	private static final long TIMEOUT_PAGE_LOAD = 60;

	public static WebDriver getInstance() {
		return getInstance(DriverEnum.CHROME);
	}

	public static WebDriver getInstance(DriverEnum driverEnum) {

		if (driver == null) {

			switch (driverEnum) {

			case CHROME:
				driver = createChromeDriver();
				break;

			case FIREFOX:
				driver = createFireFoxDriver();
				break;

			case PHANTOMJS:
			default:
				driver = createPhantomJSDriver();
				break;
			}

			driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(TIMEOUT_PAGE_LOAD, TimeUnit.SECONDS);
			driver.manage().window().setSize(new Dimension(1200, 800));
		}

		return driver;
	}


	private static WebDriver createChromeDriver() {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
		return new ChromeDriver();
	}

	private static WebDriver createFireFoxDriver() {
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setEnableNativeEvents(false);
		firefoxProfile.setAcceptUntrustedCertificates(true);
		firefoxProfile.setPreference("layers.acceleration.disabled", true);

		DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
		desiredCapabilities.setCapability(FirefoxDriver.PROFILE, firefoxProfile);

		return new FirefoxDriver(desiredCapabilities);
	}

	private static WebDriver createPhantomJSDriver() {

		DesiredCapabilities desiredCapabilities = DesiredCapabilities.phantomjs();
		desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, PHANTOMJS_DRIVER);
		desiredCapabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
		desiredCapabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
		desiredCapabilities.setCapability(CapabilityType.ENABLE_PROFILING_CAPABILITY, true);
		desiredCapabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);

		desiredCapabilities.setJavascriptEnabled(true);

		ArrayList<String> cliArgs = new ArrayList<String>();
		cliArgs.add("--web-security=true");
		cliArgs.add("--ignore-ssl-errors=true");
		desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgs);

		return new PhantomJSDriver(desiredCapabilities);
	}

}
