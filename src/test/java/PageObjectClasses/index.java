package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class index {

    WebDriver driver;

    public index(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Sign in")
    WebElement signInButton;
    @FindBy(xpath="(//a[@title='T-shirts'])[2]")
    WebElement Ts;
    

    public void clickSignInButton() {
        signInButton.click();
    }
    
    public void clickOnTshirts() {
    	Ts.click();
    }
}

