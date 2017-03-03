package br.com.entelgy.steps.generic;

import br.com.entelgy.steps.GenericStep;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class InputStep extends GenericStep {

	private static final String CLASS = "class";
	private static final String CLASS_ERROR_FIELD = "error-field";

	@Then("^I enter \"([^\"]*)\" into input field having (id|name|class|xpath|css) \"([^\"]*)\"$")
	public void sendKeys(String value, String type, String element) {

		WebElement webElement = waitWebElement(type, element, 10);

		sendKeys(webElement, value);

	}

	@Then("^I clear input field having (id|name|class|xpath|css) \"([^\"]*)\"$")
	public void clear(String type, String element) {

		WebElement webElement = getWebElement(type, element);

		clear(webElement);

	}

	@Then("^I input field having (id|name|class|xpath|css) \"([^\"]*)\" contains error$")
	public void error(String type, String element) {

		WebElement webElement = getWebElement(type, element);

		assertThat(webElement.getAttribute(CLASS), containsString(CLASS_ERROR_FIELD));

	}

	@Then("^I input field having (id|name|class|xpath|css) \"([^\"]*)\" is required$")
	public void required(String type, String element) {

		WebElement webElement = getWebElement(type, element);

		click(webElement);

		assertThat(webElement.getAttribute(CLASS), containsString(CLASS_ERROR_FIELD));

	}

}
