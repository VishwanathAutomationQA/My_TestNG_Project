package utilities;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WebActions {
	WebDriver driver;
	Wait<WebDriver> wait;

	public WebActions(WebDriver driver) {
		this.driver = driver;
		// this.wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
		wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(NoSuchElementException.class);

	}

	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}

	public void clickByJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}

	public void clickOnElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	public void enterText(WebElement element, String value) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

	public boolean isDisplayed(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return element.isDisplayed();
		}catch(NoSuchElementException | TimeoutException e) {
			return false;
		}
	}

	public String getElementAttribute(WebElement element, String attribute) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getAttribute(attribute);
	}
}
