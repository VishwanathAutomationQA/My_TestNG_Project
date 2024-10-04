package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationOpenCart extends BasePage{

	public RegistrationOpenCart(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "input-firstname") private WebElement firstNameInput;
	
	@FindBy(id = "input-lastname") private WebElement lastNameInput;
	
	@FindBy(id = "input-email") private WebElement emailInput;
	
	@FindBy(id = "input-password") private WebElement passwordInput;
	
	@FindBy(xpath = "//input[@name='agree']") private WebElement privacyPolicyBtn;
	
	@FindBy(xpath = "//button[@type='submit']") private WebElement continueBtn;


	public void enterFirstName(String firstName) {
		action.enterText(firstNameInput, firstName);
	}
	public void enterLastName(String lastName) {
		action.enterText(lastNameInput, lastName);
	}
	public void enterEmail(String email) {
		action.enterText(emailInput, email);
	}
	public void enterPassword(String password) {
		action.enterText(passwordInput, password);
	}
	public void selectPrivacyPolicy() throws InterruptedException {
		action.clickByJS(privacyPolicyBtn);
	}
	public void clickContinueBtn() throws InterruptedException {
		action.clickByJS(continueBtn);
	}

	public void useRegistration(String firstName, String lastName, String email, String password) throws InterruptedException {
		this.enterFirstName(firstName);
		this.enterLastName(lastName);
		this.enterEmail(email);
		this.enterPassword(password);
		action.scrollToElement(privacyPolicyBtn);
		this.selectPrivacyPolicy();
		this.clickContinueBtn();
	}
}
