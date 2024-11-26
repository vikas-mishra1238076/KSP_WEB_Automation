package com.objectRepo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.genericmethods.BasePage;

public class LoginPage1 extends BasePage {

    protected LoginPage1(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// WebElements for login interaction
    @FindBy(xpath = "(//button[@type='button' and @aria-haspopup='true'])[1]") 
    public WebElement profileIcon;
    
//    @FindBy(xpath = "//p[text()='SIGN UP']")
//    public WebElement signUpLink;

    
    
    
  

    @FindBy(xpath = "//input[@name='email']") 
    public WebElement usernameInput; 

    @FindBy(xpath = "//input[@id='pass']") 
    public WebElement passwordInput; 

    @FindBy(xpath = "//span[text()='SIGN IN']") 
    public WebElement loginButton;
    
//    @FindBy(xpath = "//h3[contains(text(),'ij')]") 
    
//  @FindBy(xpath = "//p[contains(text(), 'vikas')]")
//  public WebElement selectProfile;
    
    
   // @FindBy(xpath = "(//div[contains(@style, 'background-image: url(\"https://horizon-plus.d1538gwiw68ik8.amplifyapp.com/259ba81bf82fb8ad9f27becc1905fe71.png\")')])")

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[1]")
   public WebElement selectProfile;
    
    
    
    
    
    

    
    
  
   
    
    @FindBy(xpath = "//p[text()='Please enter valid email']")
    public WebElement validEmailErrorMessage;
    
    @FindBy(xpath = "//p[text()='Email is required']")
    public WebElement emailRequiredErrorMessage;
    
    @FindBy(xpath = "//p[text()='Password is required']")
    public WebElement passwordRequiredErrorMessage;
    
    @FindBy(xpath = "//p[text()='Please enter valid email']")
    private WebElement emailErrorMessage;

    
    
    
  
    
    @FindBy(xpath = "//p[contains(text(), 'Please click the “Forgot Password” button.')]")
    public WebElement errorMessage; // Uncommented for use in negative test cases

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver); 
        PageFactory.initElements(driver, this); 
    }

    // Navigate to the home page
    public void navigateToHomePage() {
        driver.get("https://horizon-plus.d1538gwiw68ik8.amplifyapp.com/home");
    }

    public void initiateLogin() throws InterruptedException {
        Thread.sleep(4000); 
        clickElement(profileIcon);
    }

    
// // Method to click on the Sign Up link
//    public void clickSignUpLink() {
//        signUpLink.click();
//    }
    
    // Enter username
    public void enterUsername(String userName) {
        usernameInput.clear(); 
        usernameInput.sendKeys(userName); 
    }

    // Enter password
    public void enterPassword(String password) {
        passwordInput.clear(); 
        passwordInput.sendKeys(password); 
    }
    
    // Click the login button
    public void clickLoginButton() {
        clickElement(loginButton); 
    }
    
    // Select profile
    public void selectProfile() {
        clickElement(selectProfile); 
    }

    // Utility method to click an element and measure time taken
    private void clickElement(WebElement element) {
        long startTime = System.nanoTime(); 
        wait.until(ExpectedConditions.elementToBeClickable(element)).click(); 
        long endTime = System.nanoTime(); 

        long duration = endTime - startTime; 
        System.out.println("Time taken to click " + element + ": " + duration + " nanoseconds");
    }

    // Negative Test Case Methods

    // Login with invalid email and valid password
    public String loginWithInvalidEmail(String invalidEmail, String validPassword) {
        enterUsername(invalidEmail);
        enterPassword(validPassword);
        clickLoginButton();
        wait.until(ExpectedConditions.visibilityOf(validEmailErrorMessage)); 
        return validEmailErrorMessage.getText(); 
    }

    // Login with valid email and invalid password
    public String loginWithInvalidPassword(String validEmail, String invalidPassword) {
        enterUsername(validEmail);
        enterPassword(invalidPassword);
        clickLoginButton();
        wait.until(ExpectedConditions.visibilityOf(errorMessage)); 
        return errorMessage.getText(); 
    }

    public List<String> loginWithEmptyCredentials() {
        // Enter empty values in both fields
        enterUsername("");
        enterPassword("");
        clickLoginButton();

        // Create a list to store error messages
        List<String> errorMessages = new ArrayList<>();

        // Wait for both error messages to be visible and add them to the list
        wait.until(ExpectedConditions.visibilityOf(emailRequiredErrorMessage));
        errorMessages.add(emailRequiredErrorMessage.getText());

        wait.until(ExpectedConditions.visibilityOf(passwordRequiredErrorMessage));
        errorMessages.add(passwordRequiredErrorMessage.getText());

        // Return the list of error messages
        return errorMessages;
    }


    // Login with invalid username and password
    public String loginWithInvalidCredentials(String invalidUsername, String invalidPassword) {
        enterUsername(invalidUsername);
        enterPassword(invalidPassword);
        clickLoginButton();
        wait.until(ExpectedConditions.visibilityOf(emailErrorMessage)); 
        return emailErrorMessage.getText(); 
    }

    // Simulate account lock after 3 invalid attempts
    public String simulateAccountLock(String validUsername, String invalidPassword) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            enterUsername(validUsername);
            enterPassword(invalidPassword);
            clickLoginButton();
            wait.until(ExpectedConditions.visibilityOf(errorMessage)); 
            Thread.sleep(1000); 
        }
        return errorMessage.getText(); 
    }
}


