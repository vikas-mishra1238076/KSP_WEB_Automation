package com.testScripts;

import Pages.LoginPage;
import Pages.UserProfile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.objectRepo.LoginPage1;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserProfileTest {

    private WebDriver driver;
    private LoginPage1 loginPage;
    private UserProfile userProfilePage;

    @BeforeClass
    public void setUp() {
        // Set up WebDriver for Firefox
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // Initialize LoginPage object
        loginPage = new LoginPage(driver);

        // Initialize UserProfilePage object
        userProfilePage = new UserProfile(driver);

        // Navigate to the login page
        driver.get("https://horizon-plus.d1538gwiw68ik8.amplifyapp.com/home");
    }

    @Test
    public void testValidLoginAndProfileActions() throws InterruptedException {
        // Initiate login process
        loginPage.initiateLogin();

        // Wait for a moment to allow the sign-in button to be available
        Thread.sleep(2000);

        // Enter valid username and password
        loginPage.enterUsername("vikass2121@gmail.com"); // Replace with a valid email
        loginPage.enterPassword("Test@123"); // Replace with a valid password

        // Click the login button
        loginPage.clickLoginButton();

        Thread.sleep(3000);

        // After login, navigate to the user profile section
        loginPage.selectProfile();
        userProfilePage.clickProfileIcon(); // Click the profile icon to switch profiles

        // Verify the profile information (example: check the profile name)
        String profileName = userProfilePage.getProfileName();
        System.out.println("Profile Name: " + profileName);
        Assert.assertNotNull(profileName, "Profile name should not be null");

        // Switch profile and add first and last names
        userProfilePage.clickSwitchProfileButton();
        
        Thread.sleep(3000);        

        // Create first profile
        userProfilePage.clickAddProfile();
        userProfilePage.enterFirstName("Sonu");
        userProfilePage.enterLastName("Sood");
        Thread.sleep(3000);  
        userProfilePage.waitForCheckboxAndClick();
        userProfilePage.clickContinueButton();
        
        Thread.sleep(3000);  
        
        userProfilePage.clickManageProfileButton(); 
        
        Thread.sleep(3000); 
        
       userProfilePage.clickSecondDivElement();
        
        // Click on Delete Profile button (example)
       // userProfilePage.clickDeleteProfileButton();  // Click Delete Profile button
        
//        // Create second profile
//        userProfilePage.clickAddProfile2();
//        userProfilePage.enterFirstName("Akash");
//        userProfilePage.enterLastName("Mishra");
//        Thread.sleep(3000);  
//        userProfilePage.waitForCheckboxAndClick();
//        userProfilePage.clickContinueButton();
//        
//        Thread.sleep(3000);  
//
//        // Create third profile
//        userProfilePage.clickAddProfile3();
//        userProfilePage.enterFirstName("Aman");
//        userProfilePage.enterLastName("Singh");
//        Thread.sleep(3000);  
//        userProfilePage.waitForCheckboxAndClick();
//        userProfilePage.clickContinueButton();
//        
//        Thread.sleep(3000);  
//        
//        // Create fourth profile
//        userProfilePage.clickAddProfile4();
//        userProfilePage.enterFirstName("Rahul");
//        userProfilePage.enterLastName("Gupta");
//        Thread.sleep(3000);  
//        userProfilePage.waitForCheckboxAndClick();
//        userProfilePage.clickContinueButton();
        
        Thread.sleep(3000);  

        
        
    }
    
    
     
//    
//    @Test
//    public void  clickManageProfileButton() throws InterruptedException {
//    
//    	Thread.sleep(2000);
// // Ensure Manage Profile Button is clicked after profile creation
//    userProfilePage.clickManageProfileButton();  // Click the Manage Profile button
//    
//
//    // Click on Delete Profile button (example)
//    userProfilePage.clickDeleteProfileButton();  // Click Delete Profile button
//    Thread.sleep(2000);
//    }
    
    
    
 

//    @Test
//    public void testProfileActions() throws InterruptedException {
//        // Example of clicking the Delete Profile button
//        userProfilePage.clickDeleteProfileButton(); // Click the Delete Profile button
//        
//        Thread.sleep(2000);
//        
//        // Example of clicking on a specific div element
//        userProfilePage.clickDivElement2(); // Click on the second div
//        
//        // Add other interactions as needed
//
//        // Wait and assert as necessary
//        Thread.sleep(2000);  // Example wait
//    }

    @AfterClass
    public void tearDown() {
        // Close the browser after the test
        if (driver != null) {
           // driver.quit(); // Uncomment this line to close the browser after tests
        }
    }
}


