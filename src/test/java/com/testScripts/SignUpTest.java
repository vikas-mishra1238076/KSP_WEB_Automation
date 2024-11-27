package com.testScripts;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.genericmethods.Base;
import com.objectRepo.SignUpPage;

public class SignUpTest extends Base {
    private WebDriver driver;
    private SignUpPage signup;

    @BeforeMethod
    public void browserSetup() throws InterruptedException {
        loadPropertiesFile();
        driver = initializeAndOpenBrowser(prop.getProperty("browser"));
        signup = new SignUpPage(driver);
    }

    @Test // Run this test method
    public void newSignUp() throws InterruptedException {
        if (prop == null) {
            throw new NullPointerException("Properties file not loaded successfully.");
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        signup.getSignincta().click();
        Thread.sleep(2000);
        // Navigate to sign-up option
        signup.getSignUpOption().click();

      /*  
        
        // Test for empty first name
        signup.getFirstNameInput().sendKeys(""); // Empty first name
        Thread.sleep(2000); // Replace with explicit waits if possible
        signup.getLastNameInput().sendKeys(prop.getProperty("lastname"));
        Thread.sleep(2000);
        signup.getEmailInput().sendKeys(prop.getProperty("email"));
        Thread.sleep(2000);
        signup.getPasswordInput().sendKeys(prop.getProperty("pass"));
        Thread.sleep(2000);  
        signup.getSignUpButton().click(); 
        Thread.sleep(4000); 
        
        String firstnameerrormessage = signup.getFirstNameErrorMessage().getText();
      System.out.println(firstnameerrormessage);

        // Test for empty last name
        signup.getFirstNameInput().sendKeys(prop.getProperty("firstname"));
        Thread.sleep(2000);
        
        signup.getLastNameInput().click();
        signup.getLastNameInput().sendKeys(Keys.CONTROL, "a");
        
        
        Thread.sleep(2000);
        
        signup.getEmailInput().sendKeys(prop.getProperty("email"));
        Thread.sleep(2000);
        signup.getPasswordInput().sendKeys(prop.getProperty("pass"));
        Thread.sleep(2000);  
        
        signup.getSignUpButton().click();
        
        Assert.assertEquals(signup.getLastNameErrorMessage(), "LastName is required", "Error message for last name not displayed as expected.");

        
        
        // Test for empty email
        signup.getFirstNameInput().clear();
        signup.getFirstNameInput().sendKeys(prop.getProperty("firstname"));
        
        Thread.sleep(2000);
        
        signup.getLastNameInput().sendKeys(prop.getProperty("lastname"));
        
        Thread.sleep(2000);
        
        signup.getEmailInput().clear(); // Clear email field
        Thread.sleep(2000);
        
        signup.getPasswordInput().sendKeys(prop.getProperty("pass"));
        
        Thread.sleep(2000);  
        
        signup.getSignUpButton().click();
        
        Assert.assertEquals(signup.getEmailErrorMessage(), "Email is required", "Error message for email not displayed as expected.");

        // Test for empty password
        signup.getFirstNameInput().clear();
        signup.getFirstNameInput().sendKeys(prop.getProperty("firstname"));
        
      	Thread.sleep(2000);
      	
      	signup.getLastNameInput().sendKeys(prop.getProperty("lastname"));
      	
      	Thread.sleep(2000);
      	
      	signup.getEmailInput().sendKeys(prop.getProperty("email"));
      	
      	Thread.sleep(2000);
      	
      	signup.getPasswordInput().clear(); // Clear password field
       
      	Thread.sleep(2000);
       
      	signup.getSignUpButton().click();
       
      	Assert.assertEquals(signup.getPasswordErrorMessage(), "Password is required", "Error message for password not displayed as expected.");

      	
      	
      	// Test for password length
      	signup.getFirstNameInput().clear();
      	
      	
      	
      	signup.getFirstNameInput().sendKeys(prop.getProperty("firstname"));
      	
      	Thread.sleep(2000);
      	
      	signup.getLastNameInput().sendKeys(prop.getProperty("lastname"));
      	
      	Thread.sleep(2000);
      	
      	signup.getEmailInput().sendKeys(prop.getProperty("email"));
      	
      	Thread.sleep(2000);
      	
      	signup.getPasswordInput().sendKeys(prop.getProperty("shortPWD")); // Short password
      	
      	Thread.sleep(2000);
      	
      	signup.getSignUpButton().click();
      	
      	Assert.assertEquals(signup.getPasswordErrorMessage(), "Use 8 or more characters which contains alphanumeric characters.", "Error message for password length not displayed as expected.");
   
      */	
      	
signup.getFirstNameInput().sendKeys(prop.getProperty("firstname"));
      	
      	Thread.sleep(2000);
      	
      	signup.getLastNameInput().sendKeys(prop.getProperty("lastname"));
      	
      	Thread.sleep(2000);
      	
      	signup.getEmailInput().sendKeys(prop.getProperty("email"));
      	
      	Thread.sleep(2000);
      	
      	signup.getPasswordInput().sendKeys(prop.getProperty("pass")); // Short password
      	
      	Thread.sleep(2000);
      	
      	signup.getSignUpButton().click();
      	
      //	Assert.assertEquals(signup.getPasswordErrorMessage(), "Use 8 or more characters which contains alphanumeric characters.", "Error message for password length not displayed as expected.");
   
      	
      	
      	
    }
}