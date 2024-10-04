package tests;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import pageObjects.RegistrationOpenCart;
import utilities.DataGenerator;

@Listeners(utilities.ExtentReportManager.class)
public class TC101_RegistrationTest extends DriverClass{

	@Test(priority = 1, groups = {"Smoke", "Regression"})
	public void TC_101_Registration() throws InterruptedException {
		RegistrationOpenCart registration = new RegistrationOpenCart(driver);
//		String email = DataGenerator.randomString().toLowerCase()+"@gmail.com";
//		String password = DataGenerator.randomAlphaNumeric();
//		System.out.println("E-mail : "+ email);
//		System.out.println("Password :"+ password);
//		registration.useRegistration(DataGenerator.randomString(), DataGenerator.randomString(), email, password);
		System.out.println("Register");
	}
}