package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
	WebDriver driver;
	
	public SearchResultsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="search_query_top")
	WebElement Searchboxx;
	
	@FindBy(xpath="//button[@name='submit_search']")
	WebElement searchButtonn;
	
	@FindBy(xpath="//h5[@itemprop='name']//a[@title='Faded Short Sleeve T-shirts']")
	WebElement tshirtText;
	
	//class="button-container"
	//class="replace-2x img-responsive"
	@FindBy(css="span.out-of-stock")
	WebElement mouse;
	
	@FindBy(xpath="//*[text()='More']")
	WebElement more;
	
	
	public void searchBox(String text) {
		Searchboxx.sendKeys(text);
	}
	
	public void searchButton() {
		searchButtonn.click();
	}
	public String tshirttext() {
		return tshirtText.getText();
	}
	public void mousehover() {
		Actions act=new Actions(driver);
		act.moveToElement(mouse).build().perform();
	}
	
	
	public void moreClick() {
		more.click();
	}
	
	
	
	
}
