package br.com.entelgy.selenium;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.PhantomJsDriverManager;
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
	private static final long TIMEOUT = 20;
	private static final long TIMEOUT_PAGE_LOAD = 60;

	@Deprecated
	public static WebDriver getInstance() {
		return getInstance(DriverEnum.FIREFOX, null);
	}

	/**
	 * Use getDriver(DriverEnum driverEnum) for automatically resolves binary driver path
	 * @param driverEnum
	 * @param driverPath
	 * @return
	 */
	@Deprecated
	public static WebDriver getInstance(DriverEnum driverEnum, String driverPath) {

		if (driver == null) {

			switch (driverEnum) {

			case CHROME:
				driver = createChromeDriver(driverPath);
				break;

			case FIREFOX:
				driver = createFireFoxDriver();
				break;

			case PHANTOMJS:
			default:
				driver = createPhantomJSDriver(driverPath);
				break;
			}

			driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(TIMEOUT_PAGE_LOAD, TimeUnit.SECONDS);
			driver.manage().window().setSize(new Dimension(1200, 800));
		}

		return driver;
	}

	/**
	 * Automatically resolves binary driver path with WebDriverManager
	 * @see [https://github.com/bonigarcia/webdrivermanager]
	 * @param driverEnum
	 * @return
	 */
	public static WebDriver getDriver(DriverEnum driverEnum) {

		if (driver == null) {

			switch (driverEnum) {

				case CHROME:
					ChromeDriverManager.getInstance().setup();
					driver = new ChromeDriver();
					break;

				case FIREFOX:
					driver = new FirefoxDriver();
					break;

				case PHANTOMJS:
				default:
					PhantomJsDriverManager.getInstance().setup();
					driver = new PhantomJSDriver();
					break;
			}

			driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(TIMEOUT_PAGE_LOAD, TimeUnit.SECONDS);
			driver.manage().window().setSize(new Dimension(1200, 800));
		}

		return driver;
	}


	private static WebDriver createChromeDriver(String driverPath) {
		System.setProperty("webdriver.chrome.driver", driverPath);
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

	private static WebDriver createPhantomJSDriver(String driverPath) {

		DesiredCapabilities desiredCapabilities = DesiredCapabilities.phantomjs();
		desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, driverPath);
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
