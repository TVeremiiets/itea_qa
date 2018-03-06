package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.LinkedInLandingPage;
import page.LinkedinBasePage;
import page.LinkedinHomePage;

import static org.testng.Assert.*;

public class LinkedinLoginTest {
    WebDriver driver;
    LinkedInLandingPage landingPage;
    String initialPageTitle;
    String initialPageUrl;



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
        driver.get("https://www.linkedin.com/");
        //WebDriver driver = new FirefoxDriver();
       landingPage = new LinkedInLandingPage(driver);
       initialPageTitle= landingPage.getPageTitle();
       initialPageUrl= landingPage.getPageUrl();
    }
    @AfterMethod
    public void afterTest () {
         driver.close();
    }

    @Test
    public void asuccessfulllogintest () {

        // WebDriver driver = new FirefoxDriver(); -драйвер создан выше
        //driver.get("https://www.linkedin.com/");
       Assert.assertEquals (initialPageTitle,
                "LinkedIn: Войти или зарегистрироваться",   "Login in page title is wrong");
        LinkedinHomePage homepage =  landingPage.loginAs("TanyaQA07@gmail.com", "0635663551");

        assertTrue(homepage.isSignedIn(), "User icon was not displayed");
        Assert.assertNotEquals(homepage.getPageTitle(), initialPageTitle, "Page tiile did not change after login");
        Assert.assertNotEquals(homepage.getPageUrl (),initialPageUrl, "Page title did not change after login");

        //LinkedinBasePage homepage = new LinkedinBasePage(driver); перенесли
        /*
        WebElement emailfield=driver.findElement(By.xpath("//*[@id='login-email']"));
              // или можно использовать WebElement emailfield=driver.findElement(By.id("login-email"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id='login-password']"));
        WebElement singInButton = driver.findElement(By.xpath("//*[@id='login-submit']"));
              singInButton.click(); */

       // WebElement usericon = driver.findElement(By.xpath("//*[@id='profile-nav-item']"));

        // driver.close();
        /* Assert.assertTrue(driver.getTitle(). equals(initialPageTitle), "Page title did not change after login");
         */
            }


    @Test
    public void negativlogintest () {
        Assert.assertEquals (initialPageTitle,
                "LinkedIn: Войти или зарегистрироваться",   "Login in page title is wrong");
        LinkedinHomePage homepage = landingPage.loginAs("test@gmail.com", "067A3551");

        Assert.assertTrue(homepage.isSignedIn(), "Alert message is not displayed");
    }
        }
