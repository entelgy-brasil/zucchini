package br.com.entelgy.steps.generic;

import br.com.entelgy.steps.GenericStep;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by andre on 15/02/17.
 */
public class SelectStep extends GenericStep{


    @Then("^I select \"([^\"]*)\" value on element having (id|name|class|xpath|css) \"([^\"]*)\"$")
    public void selectValueOnElement(String value, String type, String element){
        new Select(getWebElement(type, element)).selectByValue(value);
    }

    @Then("^I select \"([^\"]*)\" text on element having (id|name|class|xpath|css) \"([^\"]*)\"$")
    public void selectTextOnElement(String text, String type, String element){
        new Select(getWebElement(type, element)).selectByVisibleText(text);
    }
}
