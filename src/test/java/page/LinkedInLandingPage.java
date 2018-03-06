package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInLandingPage extends LinkedinBasePage {

    @FindBy (id="login-email")
    private WebElement  emailfield;

    @FindBy (id="login-password")
    private WebElement passwordField;

    @FindBy (id="login-submit")
    private WebElement singInButton;


    public LinkedInLandingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public LinkedinHomePage loginAs (String email, String password) {
        waitUnitElementIsCliskable(emailfield,5);
        emailfield.sendKeys("TanyaQA07@gmail.com");
        passwordField.sendKeys("0635663551");
        singInButton.click();
        return PageFactory.initElements(driver, LinkedinHomePage.class);
       /// return new LinkedinHomePage(driver);
    }
    public <T> T loginAs (String email, String password) {
        waitUnitElementIsCliskable(emailfield,5);
        emailfield.sendKeys("TanyaQA07@gmail.com");
        passwordField.sendKeys("0635663551");
        singInButton.click();
        if (singInButton.isDisplayed()) {
            return (T) this;
        }
        else {
            return (T) PageFactory.initElements(driver, LinkedinHomePage.class);
        }
        }
    }


