package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinHomePage extends LinkedinBasePage  {
    @FindBy(id ="profile-nav-item")
    WebElement userIcon;

    @FindBy(xpath ="//input[@placeholder='Поиск']")
    WebElement searchFild;

    @FindBy(xpath ="//*[@type='search-icon']")
    WebElement seachIcon;


    public  LinkedinHomePage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public boolean isSignedIn()  {
        waitUnitElementIsCliskable(userIcon);
        return userIcon.isDisplayed () ;
    }

    public LinkedinSearchPage searchByTerm(String searchTerm) {
searchFild.sendKeys(searchTerm);
///waitUnitElementIsCliskable(seachIcon);
seachIcon.click();
    }
}
