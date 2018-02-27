import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class LinkedinLoginTest {
    WebDriver driver;
   /* @BeforeClass
    public void beforeClass () {
        driver=new FirefoxDriver();
        WebDriver driver = new FirefoxDriver();
    }
    @AfterClass
    public void afterClass() {
        driver.close();
    }
    */
   @BeforeMethod
    public void beforeTest () {
        driver=new FirefoxDriver();
        WebDriver driver = new FirefoxDriver();
    }
    @AfterMethod
    public void afterTest () {
          driver.close();
    }

    @Test
    public void asuccessfulllogintest () {
            LinkedInLoginPage loginPage = new LinkedInLoginPage (driver);

        // WebDriver driver = new FirefoxDriver(); -драйвер создан выше
        //driver.get("https://www.linkedin.com/");
        String initialPageTitle= loginPage.getPageTitle();
        String initialPageUrl= loginPage.getPageUrl();
        Assert.assertEquals(initialPageTitle,
                "Крупнейшая в мире сеть профессиональных контактов | LinkedIn",   "Login in page title is wrong");
        LinkedinBasePage homepage = loginPage.loginAs("TanyaQA07@gmail.com", "0635663551");

        //LinkedinBasePage homepage = new LinkedinBasePage(driver); перенесли

        /*
        WebElement emailfield=driver.findElement(By.xpath("//*[@id='login-email']"));
              // или можно использовать WebElement emailfield=driver.findElement(By.id("login-email"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id='login-password']"));
        WebElement singInButton = driver.findElement(By.xpath("//*[@id='login-submit']"));
              singInButton.click(); */

       // WebElement usericon = driver.findElement(By.xpath("//*[@id='profile-nav-item']"));
        assertTrue(homepage.isSignedIn(), "User icon was not displayed");
        assertNotEquals(homepage.getPageTitle(), initialPageTitle, "Page tiile did not change after login");
        assertNotEquals(homepage.getPageUrl (),initialPageUrl, "Page title did not change after login");
        // driver.close();
        /* Assert.assertTrue(driver.getTitle(). equals(initialPageTitle), "Page title did not change after login");
         */
            }

    @Test
    public void negativlogintest () {
        // WebDriver driver = new FirefoxDriver();
        driver.get("https://www.linkedin.com/");
        WebElement emailfield = driver.findElement(By.xpath("//*[@id='login-email']"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id='login-password']"));
        WebElement singInButton = driver.findElement(By.xpath("//*[@id='login-submit']"));
        emailfield.sendKeys("test@gmail.com");
        passwordField.sendKeys("123456");
        singInButton.click();
        WebElement alertMessage = driver.findElement(By.xpath("//div[@id='global-alert-queue']//strong[not(text()='')]"));
        assertTrue(alertMessage.isDisplayed(), "Alert message is not displayed");
    }

        }
