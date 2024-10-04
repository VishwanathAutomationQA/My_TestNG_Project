package tests;

import java.rmi.UnexpectedException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class DriverClass {

	public WebDriver driver;

	@BeforeClass
	public void setDriver() throws UnexpectedException {

		String browser = System.getProperty("browser", "chrome");
		switch(browser) {
		case "chrome" : driver = new ChromeDriver();
		
		break;
		case "edge" : driver = new EdgeDriver(); 
		break;
		case "safari" : driver = new SafariDriver(); 
		break;
		default : throw new UnexpectedException(browser);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/auth/login");
//		driver.get("https://demo.opencart.com/en-gb?route=account/register");
	}

	@AfterClass
	public void quitDriver() {
		driver.quit();
	}
}
