package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	WebDriver driver;
	
	public loginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	
	@FindBy(css="[id='email']")
	WebElement emailF;
	
	@FindBy(css="[id='passwd'][name='passwd']")
	WebElement password;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement submit;
	
	@FindBy(css="[title='View my customer account']")
	WebElement linktext;
	
	@FindBy(linkText="Sign out")
	WebElement signoutlinkk;
	
	public void getEmail(String email) {
		emailF.sendKeys(email);
	}
	public void getPassword(String pwd) {
		password.sendKeys(pwd);
	}
	public void clickSubmit() {
		submit.click();
	}
	
	public String linktextt() {
		String text=linktext.getText();
		return text;
	}
	
	public void signoutlink() {
		signoutlinkk.click();
	}
	

}
