package br.com.entelgy.liferay.authentication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;

	@FindBy(how = How.ID, using = "_58_login")
	private WebElement username;

	@FindBy(how = How.ID, using = "_58_password")
	private WebElement password;

	@FindBy(how = How.CLASS_NAME, using = "btn-primary")
	private WebElement btn;

	public void login(String username, String password) {
		WebElement usernameElement = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(this.username));
		usernameElement.clear();
		usernameElement.sendKeys(username);
		this.password.sendKeys(password);
		this.btn.click();
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getBtn() {
		return btn;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
