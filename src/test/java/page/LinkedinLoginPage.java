package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


    public class LinkedinLoginPage extends LinkedinBasePage {

        @FindBy(id="session_key-login")
        private WebElement emailfield;

        @FindBy (id="session_password-login")
        private WebElement passwordField;

        @FindBy (id="btn-primary")
        private WebElement singInButton;


        public LinkedinLoginPage (WebDriver driver) {
            super(driver);

            PageFactory.initElements(driver, this);
        }

    }
