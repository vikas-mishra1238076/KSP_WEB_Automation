package com.objectRepo;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.genericmethods.Base;

public class SignIn extends Base {

    @FindBy(xpath = "(//button[@type='button' and @aria-haspopup='true'])[1]")
    public WebElement profileIcon;

//    @FindBy(xpath = "(//p[contains(@class, 'MuiTypography-root') and contains(@class, 'MuiTypography-body1')])[2]")
//    public WebElement signInOption;

    @FindBy(xpath = "//p[text()='SIGN UP']")
    public WebElement signUpOption;

    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "pass")
    public WebElement passwordInput;

    @FindBy(xpath = "//span[text()='SIGN UP']")
    public WebElement signUpButton;

    @FindBy(xpath = "//p[contains(@class, 'MuiFormHelperText-root') and contains(@class, 'Mui-error') and text()[normalize-space() = 'FirstName is required']]")
    private WebElement firstNameErrorMessage;

    @FindBy(xpath = "//p[contains(@class, 'MuiFormHelperText-root') and contains(@class, 'Mui-error') and text()[normalize-space() = 'LastName is required']]")
    private WebElement lastNameErrorMessage;

    @FindBy(xpath = "//p[contains(@class, 'MuiFormHelperText-root') and contains(@class, 'Mui-error') and text()[normalize-space() = 'Email is required']]")
    private WebElement emailErrorMessage;

    @FindBy(xpath = "//p[contains(@class, 'MuiFormHelperText-root') and text() = ' Use 8 or more characters which contains alphanumeric characters.']")
    private WebElement passwordErrorMessage;

    public SignIn(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomePage() {
        driver.get("https://horizon-plus.d1538gwiw68ik8.amplifyapp.com/home");
    }

    
    public void initiateLogin() {
        // Call the method to click the profile icon
       // clickProfileIcon();
        // Additional logic for logging in can be added here if needed
    }
    
    public void clickProfileIcon() {
        clickElement(profileIcon);
    }

//    public void clickSignInOption() {
//        clickElement(signInOption);
//    }

    public void clickSignUpOption() {
        clickElement(signUpOption);
    }

    public void enterFirstName(String firstName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickSignUpButton() {
        clickElement(signUpButton);
    }

    public String getFirstNameErrorMessage() {
        return firstNameErrorMessage.getText();
    }

    public String getLastNameErrorMessage() {
        return lastNameErrorMessage.getText();
    }

    public String getEmailErrorMessage() {
        return emailErrorMessage.getText();
    }

    public String getPasswordErrorMessage() {
        return passwordErrorMessage.getText();
    }

   private void clickElement(WebElement element) {
        for (int i = 0; i < 3; i++) {
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); // Scroll to the element
                wait.until(ExpectedConditions.visibilityOf(element));
                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                break; // Exit loop if click is successful
            } catch (ElementClickInterceptedException e) {
                System.out.println("Click intercepted, retrying... " + e.getMessage());
            }
        }
    }

}





