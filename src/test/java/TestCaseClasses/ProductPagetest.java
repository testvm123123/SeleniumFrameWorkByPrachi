package TestCaseClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjectClasses.SearchResultsPage;
import PageObjectClasses.SummaryPage;
import PageObjectClasses.addresPageObjects;
import PageObjectClasses.index;
import PageObjectClasses.loginPage;
import PageObjectClasses.productPage;
import PageObjectClasses.registrationDetails;

public class ProductPagetest extends BaseClass{
	
	@Test
public void checkProductText() throws InterruptedException, IOException {
	
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
	
	/*SearchResultsPage srp=new SearchResultsPage(driver);
	srp.searchBox("T-shirts");
	srp.searchButton();
	
	String txtx=srp.tshirttext();
	System.out.println("ddddddddddddddddddd"+txtx);
	
	if(txtx.contains("T-shirts")) {
		logger.info("if ****************************");
		Assert.assertTrue(true);
	}
	else {
		capturesScreenshots(driver, "checkProductText");
		logger.info("else ****************************");
		Assert.assertTrue(false);
		lp.signoutlink();
	}*/
	//srp.mousehover();
   //srp.moreClick();
	productPage prpage = new productPage(driver);
	prpage.searchproduct("printed summer dress");
	
	SummaryPage sp=new SummaryPage(driver);
	sp.proceedtoCheckout();
	sp.proceedd();
    
	
	addresPageObjects adrpg=new addresPageObjects(driver);
	
//	adrpg.firstName("Thiru");
//	adrpg.lastName("A");
//	adrpg.companyName("SB");
//	adrpg.address1("Alaska");
//	adrpg.citytName("Sweden");
//	adrpg.stateName();
//	adrpg.postalcode("50421");
//	adrpg.phoneNumber("9678767876");
//	adrpg.addressTitle("hiii");
//	adrpg.submitButton();
	
	
	adrpg.nextproceed();
	adrpg.processCarrierr();
	adrpg.selectcheque();
	adrpg.confirmed();
	
	String textmessage=adrpg.successMessage();
	Assert.assertEquals(textmessage, "Your order on My Shop is complete.");
	
	adrpg.clickSignout();
	
	
}
	
}
