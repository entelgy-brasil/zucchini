package br.com.entelgy.steps;

import br.com.entelgy.GenericDriver;
import br.com.entelgy.selenium.TypeEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class GenericStep {

	protected void goToURL(String url) {
		GenericDriver.goToURL(url);
	}

	protected Navigation getNavigate() {
		return GenericDriver.getNavigate();
	}

	protected WebDriver getWebDriver() {
		return GenericDriver.getWebDriver();
	}

	protected JavascriptExecutor getJavascriptExecutor() {
		return GenericDriver.getJavascriptExecutor();
	}

	protected WebElement getWebElement(String type, String element){

		By by = TypeEnum.getBy(type, element);

		return getWebDriver().findElement(by);
	}

	protected List<WebElement> getWebElements(String type, String element){

		By by = TypeEnum.getBy(type, element);

		return getWebDriver().findElements(by);
	}

	protected void click(WebElement webElement) {
		webElement.click();
	}

	protected void doubleClick(WebElement webElement) {
		Actions actions = new Actions(getWebDriver());
		actions.moveToElement(webElement).doubleClick().build().perform();
	}

	protected void scroll(WebElement webElement) {
		Actions actions = new Actions(getWebDriver());
		actions.moveToElement(webElement);
	}

	protected void hover(WebElement webElement) {
		Actions actions = new Actions(getWebDriver());
		actions.moveToElement(webElement).perform();
	}

	protected void sendKeys(WebElement webElement, String value) {
		clear(webElement);
		webElement.sendKeys(value);
	}

	protected void clear(WebElement webElement) {
		webElement.clear();
	}

	protected WebElement waitWebElement(String type, String element, int timeout) {
		By by = TypeEnum.getBy(type, element);
		return new WebDriverWait(getWebDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(by));
	}

}
