package br.com.entelgy.steps.generic;

import br.com.entelgy.selenium.TypeEnum;
import br.com.entelgy.steps.GenericStep;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by andre on 24/03/17.
 */
public class WaitStep extends GenericStep {

    @Then("^I wait \"([^\"]*)\" seconds an element having (id|name|class|xpath|css) \"([^\"]*)\" to be clickable$")
    public void iNavigateToPreferencesOfPortlet(String seconds, String type, String element) throws Throwable {
        By by = TypeEnum.getBy(type, element);
        new WebDriverWait(getWebDriver(), Integer.valueOf(seconds)).until(ExpectedConditions.elementToBeClickable(by));
    }
}
