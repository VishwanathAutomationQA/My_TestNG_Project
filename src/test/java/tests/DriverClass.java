package tests;

import java.io.IOException;
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

import utilities.ReadTestData;

public class DriverClass {

	public WebDriver driver;

	@BeforeClass
	public void setDriver() throws IOException {
		
		String browser = System.getProperty("browser", ReadTestData.readPropFile("browserName"));
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

		String env = System.getProperty("env", ReadTestData.readPropFile("qa1URL"));
		switch (env) {
		case "qa1" : driver.get(ReadTestData.readPropFile("qa1URL"));
		      break;
		case "qa2" : driver.get(ReadTestData.readPropFile("qa2URL"));
		      break;
		default:
			throw new UnexpectedException(env);
		}
	}

	@AfterClass
	public void quitDriver() {
		driver.quit();
	}
}
