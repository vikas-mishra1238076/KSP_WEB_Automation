package com.testScripts;

import Pages.LoginPage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest1 {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        // Set up the WebDriver for Firefox
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        
        // Initialize the LoginPage object
        loginPage = new LoginPage(driver);
        
        // Navigate to the login page
        driver.get("https://horizon-plus.d1538gwiw68ik8.amplifyapp.com/home");
    }

    @Test
    public void testValidLogin() throws InterruptedException {
        // Initiate login process
        loginPage.initiateLogin();
        
        // Wait for a moment to allow the sign-in button to be available
        Thread.sleep(2000); 

        // Enter valid username and password
        loginPage.enterUsername("vikass2121@gmail.com"); // Replace with a valid email
        loginPage.enterPassword("Test@123"); // Replace with a valid password
        
        // Click the login button
        loginPage.clickLoginButton();
        
        // Select profile after clicking sign-in
        loginPage.selectProfile();
        
        // Assert successful login
        //Assert.assertTrue(driver.getCurrentUrl().contains("expectedUrlAfterLogin"), "Login was not successful");
    }

//    @Test
//    public void testLoginWithInvalidEmail() throws InterruptedException {
//        loginPage.initiateLogin();
//        String validEmailErrorMessage = loginPage.loginWithInvalidEmail("in@validEmail@test.com", "validPassword");
//        Assert.assertEquals(validEmailErrorMessage, "Please enter valid email");
//    }
//
//
//    @Test
//    public void testLoginWithInvalidPassword() {
//        String errorMessage = loginPage.loginWithInvalidPassword("ibc.jobst@gmail.com", "invalidPassword");
//        Assert.assertEquals(errorMessage, "Please click the “Forgot Password” button. If you are still unable to login please contact us at customerservice@aptnlumi.ca");
//    }

//    @Test
//    public void testLoginWithEmptyCredentials() throws InterruptedException {
//        loginPage.initiateLogin();
//
//        List<String> errorMessages = loginPage.loginWithEmptyCredentials();
//
//        Assert.assertEquals(errorMessages.size(), 2, "Expected 2 error messages for empty email and password fields.");
//
//        // Using assertTrue with contains
//        Assert.assertTrue(errorMessages.get(0).contains("Email is required"), "Incorrect error message for empty email field.");
//        Assert.assertTrue(errorMessages.get(1).contains("Password is required"), "Incorrect error message for empty password field.");
//    }

//
//    @Test
//    public void testLoginWithInvalidCredentials() throws InterruptedException {
//        loginPage.initiateLogin(); // Initiate the login process
//
//        // Perform login with invalid credentials
//        String emailErrorMessage = loginPage.loginWithInvalidCredentials("invalidUsername", "invalidPassword");
//        
//        // Click the login button (you may not need this if the button click is already handled in the login method)
//        loginPage.clickLoginButton(); // This line can be removed if clicking the button is part of the login method
//
//        // Define the expected error message
//        String expectedMessage = "Please enter valid email"; // Adjusted to match the exact expected message
//
//        // Assert that the actual error message matches the expected message
//        Assert.assertEquals(emailErrorMessage, expectedMessage, "Error message did not match for invalid credentials.");
//    }


//
//    @Test
//    public void testAccountLockAfterInvalidAttempts() throws InterruptedException {
//        String errorMessage = loginPage.simulateAccountLock("ibc.jobst@gmail.com", "invalidPassword");
//        Assert.assertEquals(errorMessage, "Your account has been locked after multiple invalid attempts."); // Update with the actual message from your application
//    }

    @AfterClass
    public void tearDown() {
        // Close the browser after the test is complete
        if (driver != null) {
           // driver.quit();
        }
    }
}


