package br.com.entelgy.steps.generic;

import br.com.entelgy.steps.GenericStep;
import cucumber.api.java.en.Then;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

public class NavigationStep extends GenericStep {

	@Then("^I navigate to \"([^\"]*)\"$")
	public void to(String url) {
		goToURL(url);
	}

	@Then("^I navigate back")
	public void back() {
		getNavigate().back();
	}

	@Then("^I navigate forward$")
	public void forward() {
		getNavigate().forward();
	}

	@Then("^I refresh page$")
	public void refresh() {
		getNavigate().refresh();
	}

	@Then("^go to \"([^\"]*)\"$")
	public void goTo(String uri) throws Throwable {
		goToURL(uri);
	}

	@Then("^I maximize browser window$")
	public void maximize() {
		getWebDriver().manage().window().maximize();
	}

	@Then("^I scroll to element having (id|name|class|xpath|css) \"([^\"]*)\"$")
	public void scroll(String type, String element) {
		WebElement webElement = getWebElement(type, element);

		scroll(webElement);
	}

	@Then("^I hover over element having (id|name|class|xpath|css) \"([^\"]*)\"$")
	public void hover(String type, String element) {
		WebElement webElement = getWebElement(type, element);

		hover(webElement);
	}

	@Then("^I confirm alert message$")
	public void iConfirmAlertMessage() throws Throwable {
		Alert alert = getWebDriver().switchTo().alert();
		alert.accept();
	}

	@Then("^I decline alert message$")
	public void iDeclineAlertMessage() throws Throwable {
		Alert alert = getWebDriver().switchTo().alert();
		alert.dismiss();
	}
}
