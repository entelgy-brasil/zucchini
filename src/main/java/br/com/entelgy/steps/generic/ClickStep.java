package br.com.entelgy.steps.generic;

import br.com.entelgy.selenium.TypeEnum;
import br.com.entelgy.steps.GenericStep;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ClickStep extends GenericStep {

	@When("^I click on element having (id|name|class|xpath|css) \"([^\"]*)\"$")
	public void clickElement(String type, String element) {

		WebElement webElement = getWebElement(type, element);

		click(webElement);

	}

	@When("^I click on link having text \"([^\"]*)\"$")
	public void clickLink(String text) {

		By by = TypeEnum.LINK_TEXT.by(text);

		WebElement webElement = getWebDriver().findElement(by);

		click(webElement);

	}

	@When("^I double click on element having (id|name|class|xpath|css) \"([^\"]*)\"$")
	public void doubleClickElement(String type, String element) {

		WebElement webElement = getWebElement(type, element);

		doubleClick(webElement);

	}

	@When("^I click on element having (id|name|class|xpath|css) \"([^\"]*)\" and text \"([^\"]*)\"$")
	public void clickElementHaving(String type, String element, String text) {
		List<WebElement> webElements = getWebElements(type, element);
        for (WebElement el : webElements)
            if (text.trim().equals(el.getText().trim()))
                click(el);
    }

    @When("^I click on element having (id|name|class|xpath|css) \"([^\"]*)\" on row containing \"([^\"]*)\" at table with (id|name|class|xpath|css) \"([^\"]*)\"$")
    public void clickElementHavingOnRow(String type, String element, String text, String tableType, String tableElement) {
        WebElement table = getWebElement(tableType, tableElement);
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        WebElement row = findTextAtRow(text, rows);
        if(row != null){
            WebElement el = row.findElement(TypeEnum.getBy(type, element));
            el.click();
        }else {
            Assert.fail(String.format("Didn't found %s on row",text));
        }
    }

    private WebElement findTextAtRow(String text, List<WebElement> rows) {
        for (WebElement r : rows) {
            List<WebElement> cells = r.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                if(text.trim().equals(cell.getText().trim())){
                    return r;
                }
            }
        }
        return null;
    }

}
