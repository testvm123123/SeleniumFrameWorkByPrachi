package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class registrationDetails {	
	WebDriver driver;
	
	public registrationDetails(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='id_gender'][@id='id_gender1']")
	WebElement mrRadio;
	
	@FindBy(css="[id=customer_firstname]")
	WebElement firstName;
	
	@FindBy(css="[id='customer_lastname']")
	WebElement lastName;
	
	@FindBy(id="email")
	WebElement emailField;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement passwordField;
	
	@FindBy(xpath="//div[@id='uniform-days']//select[@id='days']")
	WebElement dayDropdown;
	
	@FindBy(xpath="//div[@id='uniform-months']//select[@id='months']")
	WebElement monthDropdown;
	
	@FindBy(xpath="//div[@id='uniform-years']//select[@id='years']")
	WebElement yrDrpdwn;
	
	@FindBy(css="[id='submitAccount']")	
	WebElement submitButton;
	
	@FindBy(xpath="//p[contains(text(),'created.')]")
	WebElement successMessages;
	
	@FindBy(xpath="[class='account']")
	WebElement usernaam;
	
	
	
	public void selectMrRadio() {
		mrRadio.click();
	}
	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	
	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	
	public void enterEmailF(String email) {
		emailField.clear();
		emailField.sendKeys(email);
	}
	
	public void enterpasswordField(String pwd) {
		passwordField.sendKeys(pwd);
	}
	
	 public void selectDayByIndex(int index) {
	        Select select = new Select(dayDropdown);
	        select.selectByIndex(index); 
	    }
	 public void selectMonthByValue(String month) {
		    Select select = new Select(monthDropdown);
		    select.selectByValue(month);
		}

	 public void selectYrByValue(String value) {
	        Select select = new Select(yrDrpdwn);
	        select.selectByValue(value);
	    }
	 

		public void clickOnRegister() {
			submitButton.click();
		}
		
		public String getUserName() {
			String text=usernaam.getText();
			return text;
		}
		
		public String successMessage() {
			String msg=successMessages.getText();
			return msg;
		}
		
	

}
