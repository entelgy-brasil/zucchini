package br.com.entelgy.steps.liferay;

import br.com.entelgy.liferay.authentication.AuthenticationDriver;
import br.com.entelgy.selenium.hook.ScreenshotHook;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertNotNull;

public class AuthenticationSteps {

	public static final String DEFAULT_PASSWORD = "test";

	@Given("^user \"(.+)\" is logged in liferay$")
	@Then("^login as \"([^\"]*)\"$ in liferay")
	public void loginUser(String username) {
		WebElement logoutElement = AuthenticationDriver.login(username, DEFAULT_PASSWORD);
		assertNotNull("Logout element is not found.", logoutElement);
	}

	@Then("^go to control panel$")
	public void controlPanel() throws Throwable {
		AuthenticationDriver.goToControlPanel();
		ScreenshotHook.createScreenshot("LNLUG");
	}

	@Then("^logout in liferay$")
	public void logout() {
		AuthenticationDriver.logout();
	}

}
