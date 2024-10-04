package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utilities.WebActions;

public class BasePage {

	WebDriver driver;
	WebActions action;
	public BasePage(WebDriver driver) {
		this.driver= driver;
		action = new WebActions(driver);
		PageFactory.initElements(driver, this);
	}
}