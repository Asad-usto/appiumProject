package Tests;

import baseTest.AppFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.loginPage;

import java.net.MalformedURLException;
import java.util.Random;

public class loginTests {

    loginPage login;
    AppFactory factory;
    @BeforeTest
    public void setup() throws MalformedURLException {

        factory = new AppFactory();
        factory.initializer();
        login = new loginPage();
    }

    @Test
    public void createAccount() throws InterruptedException {

        login.clickOnCreateAccount();
        login.enterEmail();
        login.clickContinueBtn();
        Thread.sleep(5000);
        login.enterPassword();
        //Assert.assertTrue(login.tittle_header.isDisplayed());
        login.enterConfirmPassword();
        login.createAccountBtn();

    }

    public int rand(){
        Random r = new Random();
        int x = r.nextInt(900) + 100;
        return x;

    }
}
