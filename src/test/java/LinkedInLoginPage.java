import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        passwordField = driver.findElement(By.xpath("//*[@id='login-password']"));
        singInButton = driver.findElement(By.xpath("//*[@id='login-submit']"));
    }

    public void loginAs (String email, String password) {
        initelements();
        emailfield.sendKeys("TanyaQA07@gmail.com");
        passwordField.sendKeys("0635663551");
        singInButton.click();
    }
}