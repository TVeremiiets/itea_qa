package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.LinkedInLandingPage;
import page.LinkedinHomePage;

public abstract class LinkedinBaseTest1 {
    WebDriver driver;
    LinkedInLandingPage landingPage;

    @BeforeMethod
    public void beforeTest() {
        driver = new FirefoxDriver();
        driver.get("https://www.linkedin.com/");
        //WebDriver driver = new FirefoxDriver();
        landingPage = new LinkedInLandingPage(driver);
        //initialPageTitle = landingPage.getPageTitle();
        /// initialPageUrl = landingPage.getPageUrl();
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
    }

}