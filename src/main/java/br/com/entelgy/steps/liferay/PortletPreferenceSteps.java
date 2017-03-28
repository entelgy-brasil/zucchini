package br.com.entelgy.steps.liferay;

import br.com.entelgy.steps.GenericStep;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by andre on 08/03/17.
 */
public class PortletPreferenceSteps extends GenericStep {
    @Then("^I navigate to preferences of portlet \"([^\"]*)\"$")
    public void iNavigateToPreferencesOfPortlet(String id) throws Throwable {
        String expression = String.format("//*[contains(@id, '%s') and @class='portlet-topper-toolbar']",id);
        WebElement options = waitWebElement("xpath", expression, 10);
        options.click();

        WebElement preferences = waitWebElement("linkText","Preferences",10);
        preferences.click();
    }

    @Then("^I come back to portlet$")
    public void iComeBackToPortlet() throws Throwable {
        WebElement backToPortlet = getWebDriver().findElement(By.className("portlet-icon-back"));
        backToPortlet.click();
    }
}
