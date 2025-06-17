package TestCaseClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import PageObjectClasses.MyAccount;
import PageObjectClasses.index;
import PageObjectClasses.loginPage;
import PageObjectClasses.registrationDetails;

public class VerifyRegistrationadnLogin extends BaseClass {

	@Test(priority=1)
	public void registerandlogin() throws InterruptedException, IOException {

		index in = new index(driver);
		in.clickSignInButton();

		MyAccount macc = new MyAccount(driver);
		macc.enterEmailID("viska@gmail.com");
		macc.clickSubmit();

		registrationDetails acdetails = new registrationDetails(driver);
		acdetails.selectMrRadio();
		acdetails.enterFirstName("varu");
		acdetails.enterLastName("a");
		acdetails.enterEmailF("viska@gmail.com");
		acdetails.enterpasswordField("Thirupathi123");
		acdetails.selectDayByIndex(2);
		acdetails.selectMonthByValue("5");
		acdetails.selectYrByValue("2022");
		acdetails.clickOnRegister();

		String namee = acdetails.successMessage();
		if(namee.contains("created.")) {
			//Assert.assertEquals("Your account has been created.", namee);
			logger.info("Registration done successfully");
			Assert.assertTrue(true);
		}
		else {
			capturesScreenshots(driver,"registerandlogin");
			Assert.assertTrue(false);
		}
		
	}
	
	@Test(priority=2)
	public void myLogin() throws InterruptedException {
		
		index in = new index(driver);
		in.clickSignInButton();
		registrationDetails data = new registrationDetails(driver);
		loginPage lp=new loginPage(driver);
		lp.getEmail("viska@gmail.com");
		lp.getPassword("Thirupathi123");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		String validText=lp.linktextt();
		Assert.assertEquals(validText, "Varu a");
		logger.info("Lodggedin successfully");
		
		
	}
}
