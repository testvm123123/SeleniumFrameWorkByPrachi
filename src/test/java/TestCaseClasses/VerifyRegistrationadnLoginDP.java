package TestCaseClasses;

import java.io.IOException;

import javax.swing.text.Utilities;

import org.testng.Assert;
import org.testng.annotations.Test;


import PageObjectClasses.MyAccount;
import PageObjectClasses.index;
import PageObjectClasses.loginPage;
import PageObjectClasses.registrationDetails;
import Utilities.dpClause;

public class VerifyRegistrationadnLoginDP extends BaseClass {

	@Test(enabled=false)
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
	
	
	@Test(dataProvider="login", dataProviderClass=dpClause.class)
	public void myLogin(String email,String pwd, String expctd) throws InterruptedException, IOException {
		
		index in = new index(driver);
		in.clickSignInButton();
		registrationDetails data = new registrationDetails(driver);
		loginPage lp=new loginPage(driver);
		lp.getEmail(email);
		lp.getPassword(pwd);
		lp.clickSubmit();
		Thread.sleep(3000);
		
		String validText=lp.linktextt();
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&"+validText);
		
		if(validText.equals(expctd)) {
			logger.info("Lodggedin successfully");
			lp.signoutlink();
			logger.info("Lodgged out successfully");
		}
		else {
			System.out.println("+++++++++++++++++++++++++++++");
			capturesScreenshots(driver,"myLogin");
			Assert.assertTrue(false);		
			
		}
	}
}
