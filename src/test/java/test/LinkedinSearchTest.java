package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinSearchPage;

import java.util.List;


public class LinkedinSearchTest extends LinkedinBaseTest1 {

    @Test
    public void basicSearchTest() {
        String searchTerm = "hr";
        //LinkedInLandingPage loginPage = new LinkedInLandingPage(driver);
        LinkedinHomePage homePage =landingPage.loginAs("TanyaQA07@gmail.com", "0635663551");
        LinkedinSearchPage searchPage = homePage.searchByTerm (searchTerm);
        List<String> results = searchPage.getResults();

        Assert.assertEquals(results.size(), 10,"Number of results is wrong");

        for (String result : results) {
            Assert.assertTrue(result.toLowerCase().contains(searchTerm),
                    "Searchterm " +searchTerm+ "not found in cart");
        }
        }

           }







