package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {

    WebDriver driver;

    public MyAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "email_create")
    WebElement emailID;

    @FindBy(id = "SubmitCreate")
    WebElement createSubmitButton;

    public void enterEmailID(String email) {
        emailID.sendKeys(email);
    }

    public void clickSubmit() {
        createSubmitButton.click();
    }
}
