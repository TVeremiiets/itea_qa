import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkedinSearchTest {

    public class LinkedinLoginTest {
        WebDriver driver;

        @BeforeMethod
        public void beforeTest () {
            driver = new FirefoxDriver();
            driver.get("https://www.linkedin.com/");
        }
        @AfterMethod
        public void afterTest () {
            driver.close();
        }

        @Test
        public void basicSearchTest(){
            LinkedInLoginPage loginPage=new LinkedInLoginPage (driver);
            loginPage.loginAs("TanyaQA07@gmail.com", "0635663551");

            // search
            //input [@placeholder='Search']
            //*[@type='search-icon']
            //div[contains(@class, 'search-results-person')]
        }
    }


    }
