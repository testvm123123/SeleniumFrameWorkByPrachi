package PageObjectClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage {

	
	WebDriver driver;
	
	public SummaryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class=\"button btn btn-default standard-checkout button-medium\"]")
	WebElement prcdchkt;
	@FindBy(xpath="(//*[@title='Proceed to checkout'])[2]")
	WebElement proceed;
	
	public void proceedtoCheckout() {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", prcdchkt);
		
		//prcdchkt.click();		
	}
	public void proceedd() {
		proceed.click();
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].scrollIntoView(true)", proceed);
	}
	
	
	
	
	
	
	
}
