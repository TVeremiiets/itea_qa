import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class LinkedinSearchTest {


        WebDriver driver;

        @BeforeMethod
        public void beforeTest () {
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://www.linkedin.com/");
        }
        @AfterMethod
        public void afterTest () {
            driver.close();
        }

        @Test
        public void basicSearchTest() throws InterruptedException {
            LinkedInLoginPage loginPage = new LinkedInLoginPage (driver);
            loginPage.loginAs("TanyaQA07@gmail.com", "0635663551");

            // search
            String searchTerm = "hr";

            driver.findElement(By.xpath("//input[@placeholder='Поиск']")).sendKeys( searchTerm);
            driver.findElement(By.xpath ("//*[@type='search-icon']")).click();
            sleep(5000);
            // driver.findElement(By.xpath ("//div[contains(@class, 'search-results-person')]"));

            List<WebElement> results =driver.findElements(By.xpath("//li[contains(@class,'search-result__occluded-item')]"));
            int currentResultNumber=results.size();
            Assert.assertEquals(currentResultNumber, 10,"Number of results is wrong");
            //sleep(5000);

            // скролим  --- HomeTask пофиксить цикл
           /* for (int i=1; i < results.size(); i++) {
                Object executeScript = ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", results.get(i));
                String cardTitle = driver.findElement(
                        By.xpath("//li[contains(@class,'search-result__occluded-item')]["+1+"]//span[contains(@class, 'actor-name')]")).getText();
                System.out.println(cardTitle);
                Assert.assertTrue(cardTitle.contains(searchTerm.toLowerCase()),
                        "Searchterm " +searchTerm+ "not found in card number"+ Integer.toString(i));
                //System.out.println(cardTitle);
            }
            */
            // скролим 2 v


                for (WebElement result : results) {
                    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", result);
                    String cardTitle = result.getText();
                    System.out.println("XXXX");
                    System.out.println(cardTitle);
                    Assert.assertTrue(cardTitle.toLowerCase().contains(searchTerm),
                            "Searchterm " +searchTerm+ "not found in cart");

                }

            }


            /* пример: WebElement webElement= driver.findElement(By.xpath("Bla-bla-bla"));
            ( (JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoViev();", webElement); */

        }



