package tests;
import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.annotations.Listeners;
import pageObjects.Homepage;
import pageObjects.LoginPage;
import utilities.ReadTestData;

@Listeners(utilities.ExtentReportManager.class)
public class TC100_LoginTest extends DriverClass{

	@Test(priority = 1,groups = {"Smooke"})
	public void TC_100_Login() throws IOException {
		LoginPage page = new LoginPage(driver);
		String username = ReadTestData.readPropFile("username");
		String password = ReadTestData.readPropFile("password");
		page.loginWithCredentials(username, password);
		System.out.println("Login");
	}
	
	@Test(dependsOnMethods = {"TC_100_Login"})
	public void HomePageVarification() {
		Homepage homepage = new Homepage(driver);
//		homepage.verifyMainMenuElements();
		homepage.verifySidePanelStatus(false);
		homepage.clickSlidePanelCloseBtn();
		homepage.verifySidePanelStatus(true);
		System.out.println("Home");
	}
}