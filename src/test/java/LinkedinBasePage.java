import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class LinkedinBasePage {
    WebDriver driver;
    WebElement userIcon;

    public LinkedinBasePage (WebDriver driver) {
        this.driver = driver;
    }

    private void initElements () {
        userIcon = driver.findElement(By.id("profile-nav-item"));
    }

    public boolean isSignedIn()  {
        initElements ();
                   //sleep (3000);
        waitUnitElementIsCliskable(userIcon);
        return userIcon.isDisplayed () ;
        }


    public String getPageTitle () {
            return driver.getTitle();
        }
        public String getPageUrl () {
            return driver.getCurrentUrl();
        }

    public void waitUnitElementIsCliskable (WebElement webElement ) {
        //WebDriverWait wait = new WebDriverWait((WebDriver) driver, 10);
       // wait.until(ExpectedConditions.elementToBeClickable(webElement));
        // elementToBeClickable -только этот webElement, остальные локаторы
        waitUnitElementIsCliskable(webElement, 10);

    }
    public void waitUnitElementIsCliskable (WebElement webElement, int timeOutInSecond) {
        WebDriverWait wait = new WebDriverWait((WebDriver) driver, timeOutInSecond);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    }

