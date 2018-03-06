package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinHomePage extends LinkedinBasePage  {
    @FindBy(id ="profile-nav-item")
    WebElement userIcon;

    public  LinkedinHomePage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public boolean isSignedIn()  {
        waitUnitElementIsCliskable(userIcon);
        return userIcon.isDisplayed () ;
    }

}
