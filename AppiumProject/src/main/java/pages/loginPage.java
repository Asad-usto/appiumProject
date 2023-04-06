package pages;

import baseTest.AppDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class loginPage {

    public loginPage(){

        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }

    @FindBy(id = "com.booking:id/identity_landing_social_button")
    public WebElement signIn_btn;

    @FindBy(id = "com.booking:id/identity_account_start")
    public WebElement signIn_withEmail;

    @FindBy(id = "com.booking:id/identity_text_input_edit_text")
    public WebElement userName_txtField;

    @FindBy(id = "com.booking:id/identity_landing_social_button_text")
    public WebElement continue_btn;

    @FindBy(id = "com.booking:id/identity_text_input_edit_text")
    public List<WebElement> password_txtField;

    @FindBy(id = "com.booking:id/identity_header_title")
    public List<WebElement> tittle_header;

    @FindBy(id = "com.booking:id/identity_landing_social_button_text")
    public WebElement createAccount_btn;

    public void waitForElement(WebDriver d, WebElement elem){

        WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOf(elem));
    }

    public void waitForElements(WebDriver d, List<WebElement> elem){

        WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOfAllElements(elem));
    }
    public void clickOnCreateAccount(){

        waitForElement(AppDriver.getDriver(), signIn_withEmail);
        signIn_withEmail.click();
    }

    public void enterEmail(){

        waitForElement(AppDriver.getDriver(), userName_txtField);
        userName_txtField.sendKeys("asad@yahhoo.com");
    }
    public void enterPassword(){

        waitForElements(AppDriver.getDriver(), password_txtField);
        password_txtField.get(0).sendKeys("Test@1234567");
    }
    public void enterConfirmPassword(){

        waitForElements(AppDriver.getDriver(), password_txtField);
        password_txtField.get(1).sendKeys("Test@1234567");
    }
    public void clickContinueBtn(){

        waitForElement(AppDriver.getDriver(), continue_btn);
        continue_btn.click();
    }
    public void createAccountBtn(){

        waitForElement(AppDriver.getDriver(), createAccount_btn);
        createAccount_btn.click();
    }


}
