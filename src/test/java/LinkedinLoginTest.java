import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedinLoginTest {

    @Test
    public void successfulllogintest () {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.linkedin.com/");
        WebElement emailfield=driver.findElement(By.xpath("//*[@id='login-email']"));
              /* или можно использовать WebElement emailfield=driver.findElement(By.id("login-email")); */
        WebElement passwordField = driver.findElement(By.xpath("//*[@id='login-password']"));
        WebElement singInButton = driver.findElement(By.xpath("//*[@id='login-submit']"));
        emailfield.sendKeys("TanyaQA07@gmail.com");
        passwordField.sendKeys( "0635663551");
        singInButton.click();

    }

    @Test
    public void negativlogintest (){
        WebDriver driver=new FirefoxDriver();
        driver.get ("https://www.linkedin.com/");
        WebElement emailfield=driver.findElement(By.xpath("//*[@id='login-email']"));
        /* или можно использовать WebElement emailfield=driver.findElement(By.id("login-email")); */
        WebElement passwordField=driver.findElement(By.xpath("//*[@id='login-password']"));
        WebElement singInButton=driver.findElement(By.xpath("//*[@id='login-submit']"));
        emailfield.sendKeys( "test@gmail.com");
        passwordField.sendKeys( "123456");
        singInButton.click();
        WebElement alertMessage=driver.findElement(By.xpath("//div[@id='global-alert-queue']//strong[not(text()='')]"));
        Assert.assertTrue(alertMessage.isDisplayed(), "Alert message is not displayed");


    }
