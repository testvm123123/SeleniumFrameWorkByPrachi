package PageObjectClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class addresPageObjects {	
	WebDriver driver;
	
	public addresPageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	
	
	@FindBy(css="[id='firstname']")
    WebElement firstname;
	
	@FindBy(css="[id='lastname']")
    WebElement lastname;
	@FindBy(css="[id='company']")
    WebElement companyname;
	
	@FindBy(css="[id='address1']")
    WebElement address1;
	
	@FindBy(css="[id='city']")
    WebElement city;
	
	@FindBy(css="[name='id_state'][id='id_state']")
    WebElement id_state;
	
	
	@FindBy(css="[id='postcode']")
    WebElement postcode;
	
	@FindBy(css="[id='id_country']")
    WebElement id_country;
	@FindBy(css="[id='phone']")
    WebElement phoneNumberr;
	@FindBy(css="[id='alias']")
    WebElement alias;
	@FindBy(css="[id='submitAddress']")
    WebElement submitAddress;
	
	@FindBy(xpath="//*[@name='processAddress']")
	WebElement prcdnextt;
	
	@FindBy(css="[name='processCarrier']")
	WebElement processCarrier;
	
	@FindBy(css="[id='uniform-cgv']")
	WebElement cbox;
	
	@FindBy(css="[class='cheque']")
	WebElement scheck;
	
	@FindBy(css="[type=\"submit\"][class=\"button btn btn-default button-medium\"]")
	WebElement confirm;
	
	@FindBy(css="[class=\"alert alert-success\"]")
	WebElement stext;
	
	@FindBy(css="[class='logout']")
	WebElement signout;
	
	
	public void firstName(String fName) {
		firstname.clear();
		firstname.sendKeys(fName);
	}
	public void lastName(String lName) {
		firstname.clear();
		firstname.sendKeys(lName);
	}
	public void companyName(String cName) {
		companyname.sendKeys(cName);
	}
	public void address1(String adr) {
		address1.sendKeys(adr);
	}
	public void citytName(String ctName) {
		city.sendKeys(ctName);
	}
	public void stateName() {
		Select select=new Select(id_state);
		select.selectByValue("2");;
	}
	public void postalcode(String pCode) {
		postcode.sendKeys(pCode);
	}
	public void phoneNumber(String phone) {
		phoneNumberr.sendKeys(phone);
	}
	public void addressTitle(String aliass) {
		alias.sendKeys(aliass);
	}
	public void submitButton() {
		submitAddress.click();
	}
	
	public void nextproceed() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		prcdnextt.click();
	}
	
	public void processCarrierr() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		cbox.click();
		processCarrier.click();
	}
	
	public void selectcheque() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		scheck.click();
	}
		
	public void confirmed() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		confirm.click();
	}
	
	public String successMessage() {
		String Text=stext.getText();
		return Text;
	}
	
	public void clickSignout() {
		signout.click();
	}
	
}
