package br.com.entelgy.steps.generic;

import br.com.entelgy.selenium.hook.ScreenshotHook;
import br.com.entelgy.steps.GenericStep;
import cucumber.api.java.en.Then;

import java.util.Date;

public class ScreenshotStep extends GenericStep {

	private static final String SCREENSHOT = "screenshot";
	private static final String SCREENSHOT_FORMAT = SCREENSHOT + "_%s";

	@Then("^I take screenshot")
	public void screenshot() {
		final String name = String.format(SCREENSHOT_FORMAT, new Date());
		ScreenshotHook.createScreenshot(name);
	}

	@Then("^I take screenshot with name \"([^\"]*)\"$")
	public void screenshotName(String name) {
		ScreenshotHook.createScreenshot(name);
	}

}
