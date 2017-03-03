package br.com.entelgy.liferay;

import br.com.entelgy.GenericDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.seleniumemulation.JavascriptLibrary;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserManagementDriver extends GenericDriver {

	private static final Logger LOG = LoggerFactory.getLogger(UserManagementDriver.class);

	private static final String FIND_USER_URL = "group/control_panel/manage?p_p_id=125&125_struts_action=%2Fusers_admin%2Fview_users&_125_usersListView=flat-users&_125_keywords=";

	public static void removeUser(String emailAddress) throws InterruptedException {
		modifyUserStatus(emailAddress, CommandEnum.DELETE);
	}

	public static WebElement findUser(String emailAddress, String status) {
		try {
			getWebDriver().get(applicationContext.getServerUrl() + FIND_USER_URL + emailAddress + "&_125_status=" + status);
			return getWebDriver().findElement((By.xpath("//a[contains(@id, '_125_usersSearchContainer_')]")));
		} catch (NoSuchElementException ex) {
			LOG.error("Couldn't find " + emailAddress + " with status " + status);
			return null;
		}
	}

	public static void deactivateUser(String emailAddress) throws InterruptedException {
		modifyUserStatus(emailAddress, CommandEnum.DEACTIVATE);

	}

	private static void modifyUserStatus(String emailAddress, CommandEnum command) throws InterruptedException {
		WebElement webElement = getWebDriver().findElement(By.xpath("//a/img[contains(@src, 'html/themes/control_panel/images/common/" + command.getValue() + ".png')]"));

		WebElement parentElement = webElement.findElement(By.xpath(".."));
		String action = parentElement.getAttribute("href");
		action = action.substring(action.indexOf("submitForm"), action.indexOf(");") + 2);
		getJavascriptExecutor().executeScript("document.getElementById('"+ parentElement.getAttribute("id") + "').href=\"javascript:" + action + "\"", parentElement);

		JavascriptLibrary javascriptLibrary = new JavascriptLibrary();
		javascriptLibrary.callEmbeddedSelenium(getWebDriver(), "triggerMouseEventAt", parentElement, "click", "0,0");

		if (getWebDriver() instanceof PhantomJSDriver) {
			try {
				parentElement.click();
			} catch (ElementNotVisibleException e) {
				;
			}
		}
	}

	public static void activateUser(String emailAddress) {
		getWebDriver().findElement((By.xpath("//a[contains(@id, '_125_usersSearchContainer_')]"))).click();
		WebElement webElement = getWebDriver().findElement(By.xpath("//a/img[contains(@src, 'html/themes/control_panel/images/common/activate.png')]"));
		webElement.findElement(By.xpath("..")).click();
	}

}
