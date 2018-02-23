import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

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
        // WebDriver driver = new FirefoxDriver(); -драйвер создан выше
        driver.get("https://www.linkedin.com/");
        String initialPageTitle= driver.getTitle();
        String initialPageUrl= driver.getCurrentUrl();
        Assert.assertEquals(driver.getTitle(),  "Крупнейшая в мире сеть профессиональных контактов | LinkedIn",   "Login in page title is wrong");
        WebElement emailfield=driver.findElement(By.xpath("//*[@id='login-email']"));
              /* или можно использовать WebElement emailfield=driver.findElement(By.id("login-email")); */
        WebElement passwordField = driver.findElement(By.xpath("//*[@id='login-password']"));
        WebElement singInButton = driver.findElement(By.xpath("//*[@id='login-submit']"));
        emailfield.sendKeys("TanyaQA07@gmail.com");
        passwordField.sendKeys( "0635663551");
        singInButton.click();
        WebElement usericon = driver.findElement(By.xpath("//*[@id='profile-nav-item']"));
        Assert.assertTrue(usericon.isDisplayed(), "User icon was not displayed");
        Assert.assertNotEquals(driver.getTitle(), initialPageTitle, "Page tiile did not change after login");
        Assert.assertNotEquals(driver.getCurrentUrl(),initialPageUrl, "Page title did not change after login");
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
        Assert.assertTrue(alertMessage.isDisplayed(), "Alert message is not displayed");
    }

        }
