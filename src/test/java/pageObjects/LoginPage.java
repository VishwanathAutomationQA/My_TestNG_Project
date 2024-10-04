package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "[name='username']") private WebElement usernameElement;

	@FindBy(css = "[name='password']") private WebElement passwordElement;

	@FindBy(css = "[type='submit']") private WebElement loginBtn;

	public void loginWithCredentials(String username, String password) {
		action.enterText(usernameElement, username);
		action.enterText(passwordElement, password);
		action.clickOnElement(loginBtn);
	}
}