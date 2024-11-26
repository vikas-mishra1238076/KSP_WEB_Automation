package Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.genericmethods.Base;
import com.objectRepo.SignIn;

import Pages.BasePage;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SignInTest extends Base {
    public SignIn signInPage;

    // Constructor for SignInTest
    public SignInTest() {
        super(null); // Call BasePage constructor with null for now
    }

    @BeforeMethod
    public void setup() {
        // Initialize WebDriver
        WebDriverManager.firefoxdriver().setup();
        this.driver = new FirefoxDriver(); // Initialize WebDriver
        driver.manage().window().maximize();
        signInPage = new SignIn(driver); // Pass the driver to SignIn
        signInPage.navigateToHomePage(); // Navigate to the home page
    }
//
//    @Test(priority = 1) // Positive test case for successful sign-up
//    public void testSuccessfulSignUp() throws InterruptedException {
//        signInPage.initiateLogin(); // Click profile icon to reveal sign-in option
//        
//        Thread.sleep(4000);
//        
//        
//        signInPage.clickProfileIcon();
//        
//        Thread.sleep(4000);
//        
//        signInPage.clickSignUpOption();
//
//        // Enter valid data for all fields
//        signInPage.enterFirstName("Vikas"); // Valid first name
//        signInPage.enterLastName("Mishra"); // Valid last name
//        signInPage.enterEmail("vikas.misrrrrhra@example.com"); // Valid email
//        signInPage.enterPassword("Test@123"); // Valid password
//
//        // Click the sign-up button
//        signInPage.clickSignUpButton();
//
//        // Assert successful sign-up; modify based on expected behavior after sign-up
//        String expectedUrl = "https://horizon-plus.d1538gwiw68ik8.amplifyapp.com/dashboard"; // Example URL after successful sign-up
//        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Sign-up failed; URL did not change as expected.");
//        
//        // Optionally, you could check for a welcome message or confirmation
//        // Assert.assertTrue(signInPage.isSuccessMessageDisplayed(), "Success message not displayed after sign-up.");
//    }
//
//    @Test(priority = 2) // Test for First Name required
//    public void testFirstNameRequired() throws InterruptedException {
//signInPage.initiateLogin(); // Click profile icon to reveal sign-in option
//        
//        Thread.sleep(4000);
//        
//        
//        signInPage.clickProfileIcon();
//        
//        Thread.sleep(4000);
//        
//        signInPage.clickSignUpOption();
//
//        // Enter valid data for all fields
//        signInPage.enterFirstName(""); // Valid first name
//        signInPage.enterLastName("Mishra"); // Valid last name
//        signInPage.enterEmail("vikas.misrrrrhra@example.com"); // Valid email
//        signInPage.enterPassword("Test@123"); // Valid password
//
//        // Click the sign-up button
//        signInPage.clickSignUpButton(); 
//        
//        Assert.assertEquals(signInPage.getFirstNameErrorMessage(), "FirstName is required", "Error message for first name not displayed as expected.");
//    }
//
//    @Test(priority = 3) // Test for Last Name required
//    public void testLastNameRequired() throws InterruptedException {
//signInPage.initiateLogin(); // Click profile icon to reveal sign-in option
//        
//        Thread.sleep(4000);
//        
//        
//        signInPage.clickProfileIcon();
//        
//        Thread.sleep(4000);
//        
//        signInPage.clickSignUpOption();
//
//        // Enter valid data for all fields
//        signInPage.enterFirstName("Vikas"); // Valid first name
//        signInPage.enterLastName(""); // Valid last name
//        signInPage.enterEmail("vikas.misrrrrhra@example.com"); // Valid email
//        signInPage.enterPassword("Test@123"); // Valid password
//
//        // Click the sign-up button
//        signInPage.clickSignUpButton();
//        Assert.assertEquals(signInPage.getLastNameErrorMessage(), "LastName is required", "Error message for last name not displayed as expected.");
//    }

    @Test(priority = 4) // Test for Email required
    public void testEmailRequired() throws InterruptedException {
signInPage.initiateLogin(); // Click profile icon to reveal sign-in option
        
        Thread.sleep(4000);
        
        
        signInPage.clickProfileIcon();
        
        Thread.sleep(4000);
        
        signInPage.clickSignUpOption();

        // Enter valid data for all fields
        signInPage.enterFirstName("Vikas"); // Valid first name
        signInPage.enterLastName("Mishra"); // Valid last name
        signInPage.enterEmail(""); // Valid email
        signInPage.enterPassword("Test@123"); // Valid password

        // Click the sign-up button
        signInPage.clickSignUpButton();
        Assert.assertEquals(signInPage.getEmailErrorMessage(), "Email is required", "Error message for email not displayed as expected.");
    }
//
//    @Test(priority = 5) // Test for Password length
//    public void testPasswordLength() throws InterruptedException {
//        signInPage.initiateLogin(); // Click profile icon to reveal sign-in option
//        signInPage.clickSignUpOption(); // Click sign-up option
//        signInPage.enterFirstName("YourFirstName"); // Enter first name
//        signInPage.enterLastName("YourLastName"); // Enter last name
//        signInPage.enterEmail("vikas@980000009889@gmail.com"); // Enter email
//        signInPage.enterPassword("short"); // Enter a short password
//        signInPage.clickSignUpButton(); // Click sign-up button
//        Assert.assertEquals(signInPage.getPasswordErrorMessage(), "Use 8 or more characters which contains alphanumeric characters.", "Error message for password length not displayed as expected.");
//    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
          driver.quit(); // Close the browser after each test
        }
    }
}


