package test;



import org.testng.Assert;
import org.testng.annotations.*;
import page.LinkedinLoginPage;
import page.LinkedinHomePage;

public class LinkedinLoginTest extends LinkedinBaseTest1 {

    @Test
    public void successfullogintest() {
        String initialPageTitle = landingPage.getPageTitle();
        String initialPageUrl = landingPage.getPageUrl();

        Assert.assertEquals(initialPageTitle,
                "LinkedIn: Войти или зарегистрироваться", "Login in page title is wrong");
        LinkedinHomePage homepage = landingPage.loginAs("TanyaQA07@gmail.com", "0635663551");

        Assert.assertTrue(homepage.isSignedIn(), "User icon was not displayed");
        Assert.assertNotEquals(homepage.getPageTitle(), initialPageTitle, "Page tiile did not change after login");
        Assert.assertNotEquals(homepage.getPageUrl(), initialPageUrl, "Page title did not change after login");

    }

    @DataProvider
    public Object[][] negativeTestCredentialsReturnedToLanding() {
        return new Object[][]{
                {"", ""}};
    }

    @Test (dataProvider = "negativeTestCredentialsReturnedToLanding")
    public void negativeLoginTestCredentialReturnedToLanding (String email, String password) {
        String initialPageTitle=landingPage.getPageTitle();
        String initialPageUrl = landingPage.getPageUrl();
        Assert.assertEquals (initialPageTitle,
                "LinkedIn: Войти или зарегистрироваться",   "Login in page title is wrong");
        LinkedinHomePage homepage = landingPage.loginAs("test@gmail.com", "067A3551");
        Assert.assertEquals(landingPage.getPageUrl(), initialPageUrl, "Different page URL is loaded");
        //Assert.assertTrue(homepage.isSignedIn(), "Alert message is not displayed");
    }
    @DataProvider
    public Object[][] negativeTestCredentialsReturnedToLanding () {
    return new Object[][] {
            {"xyz", "xyz", "Please enter a valid email adress", "The password you provited must have at least 6 characters."}
    }};

    @Test(dataProvider="negativeTestCredentialsReturnedToLogin")
    public void negativeLoginTestReturnedToLogin(String email, String password, String emailMessage, String passwordMessage) {
        String initialPageTitle = landingPage.getPageTitle();
        String initialPageUrl = landingPage.getPageUrl();
        Assert.assertEquals(initialPageTitle, "LinkedIn: Log In or Sign Up",
                "Login page title is wrong");

        LinkedinLoginPage loginPage = landingPage.loginAs(email, password);
        Assert.assertNotEquals(loginPage.getPageUrl(), initialPageUrl,
                "Not redirected to login page");

        String actualEmailMessage = loginPage.getEmailMessage();
        String actualPasswordMessage = loginPage.getPasswordMessage();

        Assert.assertEquals(emailMessage, actualEmailMessage, "Actual and Expected Email messages do not match");
        Assert.assertEquals(emailMessage, actualEmailMessage, "Actual and Expected Password messages do not match");

    }

