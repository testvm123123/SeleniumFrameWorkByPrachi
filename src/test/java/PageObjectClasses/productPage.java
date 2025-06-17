package PageObjectClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestCaseClasses.BaseClass;




public class productPage extends BaseClass {
	
	
	WebDriver ldriver;
	   // WebDriverWait wait;
	 
	    public productPage(WebDriver rdriver){
	        ldriver = rdriver;
	        PageFactory.initElements(rdriver, this);
	    }
	 
	    @FindBy(css="input#search_query_top")
	    WebElement searchBar;
	 
	 
	    @FindBy(xpath="//button[@name='submit_search']")
	    WebElement searchButtonn;
	 
	    @FindBy(xpath="//h5[@itemprop='name']//a[@title='Faded Short Sleeve T-shirts']")
	    WebElement tshirtText;
	 
	    @FindBy(css="[title='Printed Summer Dress']")
	    WebElement mouse;
	 
	    @FindBy(xpath="//*[text()='More']")
	    WebElement more;
	 
	    @FindBy(css="[name='group_1']")
	    WebElement size;
	 
	    @FindBy(className="icon-plus")
	    WebElement plus;
	 
	    @FindBy(id="add_to_cart")
	    WebElement addtoCart;
	 
	    @FindBy(id = "attributes")
	    WebElement attributes;
	 
	    @FindBy(css= "[alt='Printed Summer Dress']")
	    WebElement printeddress;
	 
	    @FindBy(css = "[title='Proceed to checkout']")
	    WebElement ProccedToCheckout;
	 
	 
	    public void searchproduct(String txt)  {
	        searchBar.sendKeys(txt);
	        searchButtonn.click();	 
	        JavascriptExecutor js = (JavascriptExecutor)driver;
	        js.executeScript("arguments[0].scrollIntoView(true);",printeddress );
	 
	        Actions act=new Actions(driver);
	        act.moveToElement(mouse).build().perform();
	        more.click();
	 
	        js.executeScript("arguments[0].scrollIntoView(true);",size );
	 
	        Select select=new Select(size);
	        select.selectByValue("2");
	        select.selectByValue("1");
	        select.selectByValue("2");
	        plus.click();
	 
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add_to_cart")));
	        addtoCart.click();
	 
	        ProccedToCheckout.click();
	 
	 
	 
	 
	 
	 
	 
	 
	    }
	 
	 
	}