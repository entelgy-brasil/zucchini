package br.com.entelgy.selenium.hook;

import br.com.entelgy.selenium.SeleniumDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class ScreenshotHook {

	private static final Logger LOG = LoggerFactory.getLogger(ScreenshotHook.class);

	private static final String IMAGE_PNG = "image/png";
	private static final String SCREENSHOTS_PATH = "target/cucumber-screenshots/";
	private static final String SCREENSHOTS_FORMAT = SCREENSHOTS_PATH + "%s.png";

	@After
	public void takeScreenshot(Scenario result) throws IOException {
		if (result.isFailed()) {
			result.embed(createScreenshot(), IMAGE_PNG);
		}
	}

	public byte[] createScreenshot() {
		if (SeleniumDriver.getInstance() instanceof TakesScreenshot) {
			return ((TakesScreenshot) SeleniumDriver.getInstance()).getScreenshotAs(OutputType.BYTES);
		}

		return new byte[] {};
	}

	public static void createScreenshot(String fileName) {

		if (SeleniumDriver.getInstance() instanceof TakesScreenshot) {

			File fileSrc = ((TakesScreenshot) SeleniumDriver.getInstance()).getScreenshotAs(OutputType.FILE);

			try {
				File destFile = new File(String.format(SCREENSHOTS_FORMAT, fileName));
				FileUtils.copyFile(fileSrc, destFile);
				LOG.info("[Screenshot] " + destFile.getAbsolutePath());
			} catch (IOException e) {
				;
			}
		}

	}
}
