package page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LinkedinBasePage {
    WebDriver driver;


    public LinkedinBasePage (WebDriver driver) {
        this.driver = driver;
        }

       public String getPageTitle () {
            return driver.getTitle();
        }
        public String getPageUrl () {
            return driver.getCurrentUrl();
        }

    public void waitUnitElementIsCliskable (WebElement webElement ) {
        waitUnitElementIsCliskable(webElement, 10);

    }
    public void waitUnitElementIsCliskable (WebElement webElement, int timeOutInSecond) {
        WebDriverWait wait = new WebDriverWait((WebDriver) driver, timeOutInSecond);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
    public void waitUnitElementIsVisible (WebElement webElement, int timeOutInSecond) {
        WebDriverWait wait = new WebDriverWait((WebDriver) driver, timeOutInSecond);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

}

