package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Homepage extends BasePage{


	public Homepage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//ul//a[contains(@class,'oxd-main-menu-item')]") private List<WebElement> mainMenuItemsElements;
	
	@FindBy(xpath = "//aside[contains(@class,'oxd-sidepanel')]") private WebElement sidePanelElement;
	
	@FindBy(xpath = "//div[@class='orangehrm-admin-access-button-container']/button[@type='button']") private WebElement administratorAccessCancelBtnElement;
	
	@FindBy(css = "[aria-label='Sidepanel'] [type='button']") private WebElement slidePanelCloseBtn;


	public void clickAdimistratorAccessCancelBtn() {
		action.clickOnElement(administratorAccessCancelBtnElement);
	}

	public void verifyMainMenuElements() {
		int noOfMainMenu= mainMenuItemsElements.size();
		System.out.println(noOfMainMenu);
		for(int i=0; i<noOfMainMenu; i++ ) {	 
			action.isDisplayed(mainMenuItemsElements.get(i));
			action.clickOnElement(mainMenuItemsElements.get(i));

			boolean value = action.isDisplayed(administratorAccessCancelBtnElement);
			if(value){
				this.clickAdimistratorAccessCancelBtn();
			}
			boolean attributeValue = action.getElementAttribute(mainMenuItemsElements.get(i), "class").contains("active");
			Assert.assertEquals(true, attributeValue);
		}
	}

	public void verifySidePanelStatus(boolean value) {
		boolean result = action.getElementAttribute(sidePanelElement, "class").contains("toggled");
		Assert.assertEquals(value, result);
	}

	public void clickSlidePanelCloseBtn() {
		action.clickOnElement(slidePanelCloseBtn);
	}
}