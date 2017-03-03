package br.com.entelgy.steps.generic;

import br.com.entelgy.selenium.TypeEnum;
import br.com.entelgy.steps.GenericStep;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class AssertionStep extends GenericStep {

	public static final int TIME_OUT_IN_SECONDS = 10;

	@Then("^element having (id|name|class|xpath|css) \"([^\"]*)\" should have text as \"([^\"]*)\"$")
	public void text(String type, String element, String text) {
		WebElement webElement = waitWebElement(type,element, TIME_OUT_IN_SECONDS);

		assertEquals(webElement.getText(), text);

	}

	@Then("^element having (id|name|class|xpath|css) \"([^\"]*)\" should not have text as \"([^\"]*)\"$")
	public void notText(String type, String element, String text) {

		WebElement webElement = getWebElement(type, element);

		assertNotEquals(webElement.getText(), text);

	}

	@Then("^element having (id|name|class|xpath|css) \"([^\"]*)\" should have partial text as \"([^\"]*)\"$")
	public void partialText(String type, String element, String text) {

		WebElement webElement = getWebElement(type, element);

		assertThat(webElement.getText(), containsString(text));

	}

	@Then("^element having (id|name|class|xpath|css) \"([^\"]*)\" should not have partial text as \"([^\"]*)\"$")
	public void notPartialText(String type, String element, String text) {

		WebElement webElement = getWebElement(type, element);

		assertThat(webElement.getText(), not(containsString(text)));

	}

	@Then("^element having (id|name|class|xpath|css) \"([^\"]*)\" should have attribute \"([^\"]*)\" with value \"([^\"]*)\"$")
	public void attributeValue(String type, String element, String attribute, String value) {

		WebElement webElement = getWebElement(type, element);

		assertEquals(webElement.getAttribute(attribute), value);

	}

	@Then("^element having (id|name|class|xpath|css) \"([^\"]*)\" should have attribute \"([^\"]*)\" with partial value \"([^\"]*)\"$")
	public void attributePartialValue(String type, String element, String attribute, String value) {

		WebElement webElement = getWebElement(type, element);

		assertThat(webElement.getAttribute(attribute), containsString(value));

	}

	@Then("^element having (id|name|class|xpath|css) \"([^\"]*)\" should not have attribute \"([^\"]*)\" with value \"([^\"]*)\"$")
	public void notAttributeValue(String type, String element, String attribute, String value) {

		WebElement webElement = getWebElement(type, element);

		assertNotEquals(webElement.getAttribute(attribute), value);

	}

	@Then("^element having (id|name|class|xpath|css) \"([^\"]*)\" should not have attribute \"([^\"]*)\" with partial value \"([^\"]*)\"$")
	public void notAttributePartialValue(String type, String element, String attribute, String value) {

		WebElement webElement = getWebElement(type, element);

		assertThat(webElement.getAttribute(attribute), containsString(value));

	}

	@Then("^element having (id|name|class|xpath|css) \"([^\"]*)\" should be enabled$")
	public void enabled(String type, String element) {

		WebElement webElement = getWebElement(type, element);

		assertTrue(webElement.isEnabled());

	}

	@Then("^element having (id|name|class|xpath|css) \"([^\"]*)\" should be disabled$")
	public void disabled(String type, String element) {

		WebElement webElement = getWebElement(type, element);

		assertFalse(webElement.isEnabled());

	}

	@Then("^element having (id|name|class|xpath|css) \"([^\"]*)\" should be present$")
	public void present(String type, String element) {
		WebElement webElement = waitWebElement(type, element, TIME_OUT_IN_SECONDS);

		assertTrue(webElement.isDisplayed());
	}

	@Then("^element having (id|name|class|xpath|css) \"([^\"]*)\" should not be present$")
	public void notPresent(String type, String element) {

		WebElement webElement = getWebElement(type, element);

		assertFalse(webElement.isDisplayed());

	}

	@Then("^element having (id|name|class|xpath|css) \"([^\"]*)\" should not exist$")
	public void notExist(String type, String element) {

		List<WebElement> webElements = getWebElements(type, element);

		assertTrue(webElements.size() == 0);

	}

	@Then("^element having (id|name|class|xpath|css) \"([^\"]*)\" should be checked$")
	public void checked(String type, String element) {

		WebElement webElement = getWebElement(type, element);

		assertTrue(webElement.isSelected());

	}

	@Then("^element having (id|name|class|xpath|css) \"([^\"]*)\" should be unchecked$")
	public void unchecked(String type, String element) {

		WebElement webElement = getWebElement(type, element);

		assertFalse(webElement.isSelected());

	}

	@Then("^option \"([^\"]*)\" by text from dropdown having (id|name|class|xpath|css) \"([^\"]*)\" should be selected$")
	public void optionSelectedText(String option, String type, String element) {

		WebElement webElement = getWebElement(type, element);

		Select dropdown = new Select(webElement);

		assertEquals(dropdown.getFirstSelectedOption().getText(), option);

	}

	@Then("^option \"([^\"]*)\" by value from dropdown having (id|name|class|xpath|css) \"([^\"]*)\" should be selected$")
	public void optionSelectedValue(String option, String type, String element) {

		WebElement webElement = getWebElement(type, element);

		Select dropdown = new Select(webElement);

		String value = dropdown.getFirstSelectedOption().getAttribute("value");

		assertEquals(value, option);

	}

	@Then("^option \"([^\"]*)\" by text from dropdown having (id|name|class|xpath|css) \"([^\"]*)\" should be unselected$")
	public void optionUnselectedText(String option, String type, String element) {

		WebElement webElement = getWebElement(type, element);

		Select dropdown = new Select(webElement);

		assertNotEquals(dropdown.getFirstSelectedOption().getText(), option);

	}

	@Then("^option \"([^\"]*)\" by value from dropdown having (id|name|class|xpath|css) \"([^\"]*)\" should be unselected$")
	public void optionUnselectedValue(String option, String type, String element) {

		WebElement webElement = getWebElement(type, element);

		Select dropdown = new Select(webElement);

		String value = dropdown.getFirstSelectedOption().getAttribute("value");

		assertNotEquals(value, option);

	}

	@Then("^radio button having (id|name|class|xpath|css) \"([^\"]*)\" should be selected$")
	public void radioSelected(String option, String type, String element) {

		WebElement webElement = getWebElement(type, element);

		assertTrue(webElement.isSelected());

	}

	@Then("^radio button having (id|name|class|xpath|css) \"([^\"]*)\" should be unselected$")
	public void radioUnselected(String option, String type, String element) {

		WebElement webElement = getWebElement(type, element);

		assertFalse(webElement.isSelected());

	}

	// TODO VALIDAR
	@Then("^option \"([^\"]*)\" by text from radio button group having (id|name|class|xpath|css) \"([^\"]*)\" should be selected$")
	public void radioSelectedText(String option, String type, String element) {

		WebElement webElement = getWebElement(type, element);

		assertEquals(webElement.getText(), option);

	}

	// TODO VALIDAR
	@Then("^option \"([^\"]*)\" by value from radio button group having (id|name|class|xpath|css) \"([^\"]*)\" should be selected$")
	public void radioSelectedValue(String option, String type, String element) {

		WebElement webElement = getWebElement(type, element);

		String value = webElement.getAttribute("value");

		assertEquals(value, option);

	}

	@Then("^link having text \"([^\"]*)\" should be present$")
	public void linkTextPresent(String text) {

		By by = TypeEnum.LINK_TEXT.by(text);

		WebElement webElement = getWebDriver().findElement(by);

		assertTrue(webElement.isDisplayed());

	}

	@Then("^link having partial text \"([^\"]*)\" should be present$")
	public void partialLinkTextPresent(String text) {

		By by = TypeEnum.PARTIAL_LINK_TEXT.by(text);

		WebElement webElement = getWebDriver().findElement(by);

		assertTrue(webElement.isDisplayed());

	}

	@Then("^link having text \"([^\"]*)\" should not be present$")
	public void linkTextNotPresent(String text) {

		By by = TypeEnum.LINK_TEXT.by(text);

		WebElement webElement = getWebDriver().findElement(by);

		assertFalse(webElement.isDisplayed());

	}

	@Then("^link having partial text \"([^\"]*)\" should not be present$")
	public void partialLinkTextNotPresent(String text) {

		By by = TypeEnum.PARTIAL_LINK_TEXT.by(text);

		WebElement webElement = getWebDriver().findElement(by);

		assertFalse(webElement.isDisplayed());

	}

	@Then("^I expect to see a table with (id|name|class|xpath|css) \"([^\"]*)\" and row containing \"([^\"]*)\"$")
	public void iExpectToSeeATableWithIdAndRowContaing(String type, String element, String text) throws Throwable {
		WebElement table = waitWebElement(type, element, TIME_OUT_IN_SECONDS);
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		if(!found(text, rows))
			Assert.fail(String.format("Didn't found %s on table",text));
	}

	@Then("^I expect to see \"([^\"]*)\" on page$")
	public void iExpectToSeeOnPage(String text) throws Throwable {
		Assert.assertTrue(getWebDriver().getPageSource().contains(text));
	}

	private boolean found(String text, List<WebElement> rows) {
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				if(text.trim().equals(cell.getText().trim())){
					assertEquals(cell.getText(), text.trim());
					return true;
				}
			}
		}
		return false;
	}
}
