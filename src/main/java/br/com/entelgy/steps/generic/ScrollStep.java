package br.com.entelgy.steps.generic;

import br.com.entelgy.steps.GenericStep;
import cucumber.api.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;

/**
 * Created by andre on 24/03/17.
 */
public class ScrollStep extends GenericStep {

    @Then("^I scroll up$")
    public void iScrollUp() throws Throwable {
        JavascriptExecutor jse = (JavascriptExecutor)getWebDriver();
        jse.executeScript("window.scrollBy(0,-250)");
    }
}
