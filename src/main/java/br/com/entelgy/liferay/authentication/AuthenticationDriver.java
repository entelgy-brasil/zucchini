package br.com.entelgy.liferay.authentication;

import br.com.entelgy.GenericDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthenticationDriver extends GenericDriver {

	private static final Logger LOG = LoggerFactory.getLogger(AuthenticationDriver.class);

	protected static final String PORTAL_URL = "c/portal/";
	protected static final String LOGOUT_URL = PORTAL_URL + "logout";
	protected static final String LOGIN_URL = PORTAL_URL + "login";
	private static final String CONTROL_PANEL_URL = "group/control_panel";


	public static WebElement login(String username, String password) {
		try {

			getWebDriver().get(applicationContext.getServerUrl() + LOGIN_URL);

			if (!applicationContext.getUsername().isEmpty()) {
				if (!applicationContext.getUsername().equals(username)) {
					logout();
				}
			}

			if (applicationContext.getUsername().isEmpty()) {

				getWebDriver().get(applicationContext.getServerUrl() + LOGIN_URL);

				LoginPage page = PageFactory.initElements(getWebDriver(), LoginPage.class);
				page.setDriver(getWebDriver());

				page.login(username, password);

				applicationContext.setUsername(username);
			}

			return getWebDriver().findElement(By.className("sign-out"));

		} catch (NoSuchElementException ex) {
			LOG.error("Logout element is not found.");
			return null;
		}
	}

	public static void logout() {
		getWebDriver().get(applicationContext.getServerUrl() + LOGOUT_URL);
		applicationContext.setUsername("");

	}

	public static void goToControlPanel() {
		getWebDriver().get(applicationContext.getServerUrl() + CONTROL_PANEL_URL);
	}

}
