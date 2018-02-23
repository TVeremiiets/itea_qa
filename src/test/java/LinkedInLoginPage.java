import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinkedInLoginPage {
    WebDriver driver;
    public LinkedInLoginPage(WebDriver driver) {
        this.driver=driver;
    }
    private WebElement emailfield;
    private WebElement passwordField;
    private WebElement singInButton;

    private  void initelements () {
        emailfield = driver.findElement(By.xpath("//*[@id='login-email']"));
        waitUnitElementIsCliskable(emailfield);
        passwordField = driver.findElement(By.xpath("//*[@id='login-password']"));
        singInButton = driver.findElement(By.xpath("//*[@id='login-submit']"));
    }

    public void loginAs (String email, String password) {
        initelements();
        emailfield.sendKeys("TanyaQA07@gmail.com");
        passwordField.sendKeys("0635663551");
        singInButton.click();
    }
    public void waitUnitElementIsCliskable (WebElement webElement ) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        // elementToBeClickable -только этот webElement, остальные локаторы

    }
    public void waitUnitElementIsCliskable2 (WebElement webElement, int timeOutInSecond) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
