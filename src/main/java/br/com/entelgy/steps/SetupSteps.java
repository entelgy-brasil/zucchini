package br.com.entelgy.steps;

import br.com.entelgy.GenericDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SetupSteps {

	@Given("^setup url \"([^\"]*)\"$")
	public void setup_url(String serverUrl) throws Exception {
		GenericDriver.getApplicationContext().setServerUrl(serverUrl);
	}

	@Then("^setup cleaning$")
	public void setup_cleaning() throws Exception {

	}

}
