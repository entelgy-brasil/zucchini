package br.com.entelgy;

import br.com.entelgy.selenium.ApplicationContext;
import br.com.entelgy.selenium.SeleniumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;

public class GenericDriver {

	protected static ApplicationContext applicationContext = new ApplicationContext();

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static void goToURL(String url) {
		getWebDriver().get(applicationContext.getServerUrl() + url);
	}

	public static WebDriver getWebDriver() {
		return SeleniumDriver.getInstance();
	}

	public static JavascriptExecutor getJavascriptExecutor() {
		return (JavascriptExecutor) getWebDriver();
	}

	public static Navigation getNavigate() {
		return getWebDriver().navigate();
	}

}
