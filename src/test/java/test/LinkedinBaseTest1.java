package test;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.LinkedInLandingPage;
import page.LinkedinHomePage;


public class LinkedinBaseTest1 {
    WebDriver driver;
    LinkedInLandingPage landingPage;

    @Parameters ({"browserType"})

    @BeforeMethod
    public void beforeTest (@Optional("firefox") String browserType) {
        if (browserType.toLowerCase().equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        if (browserType.toLowerCase().equals("chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else {
            System.out.println("Unsupported browser");
        }
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