package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.*;

public class AgodaMainPage
{
    // Locators for elements on the Agoda Main Page
    private By signInButton = By.cssSelector("a[data-element-name='sign-in']");
    private By continueWithEmailButton = By.xpath("//button[contains(.,'Continue with Email')]");
    private By emailAddressField = By.id("email");
    private By passwordField = By.id("password");
    private By signInSubmitButton = By.xpath("//button[contains(.,'Sign in') and @type='submit']");
    private By closePopupButton = By.cssSelector("button[aria-label='Close']");

    private WebDriver driver;

    public AgodaMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getSignInButton() {
        return signInButton;
    }

    public By getContinueWithEmailButton() {
        return continueWithEmailButton;
    }

    public By getEmailAddressField() {
        return emailAddressField;
    }

    public By getPasswordField() {
        return passwordField;
    }

    public By getSignInSubmitButton() {
        return signInSubmitButton;
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void clickContinueWithEmailButton() {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(continueWithEmailButton)).click();
    }

    public void enterEmailAddress(String email) {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddressField));
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));
        WebElement passwordFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordFieldElement.sendKeys(password);
    }

    public void clickSignInSubmitButton() {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(signInSubmitButton)).click();
    }

}
