package com.testScripts;

import Pages.HomePage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class HomePageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod
    public void setup() throws InterruptedException {
        System.out.println("Setting up the test environment...");
        
        // Setup Firefox driver using WebDriverManager
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // Initialize pages
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        // Navigate to login page and perform login
        loginPage.navigateToHomePage();
        loginPage.initiateLogin();

        // Wait for the sign-in button to be available
        Thread.sleep(2000);

        // Enter valid username and password
        loginPage.enterUsername("vikass2121@gmail.com"); // Replace with a valid email
        loginPage.enterPassword("Test@123"); // Replace with a valid password

        // Click login button
        loginPage.clickLoginButton();

        // Select profile after clicking sign-in
        loginPage.selectProfile();

        // Wait for profile to load and skip any introductory screens
        Thread.sleep(3000);
        homePage.clickSkipButton();
        System.out.println("Test environment set up complete.");
    }

    @Test
    public void testHomePageRailsAfterLogin() throws InterruptedException {
        System.out.println("Starting test for home page rails...");

        // Ensure user is logged in by checking profile icon visibility
        Assert.assertTrue(homePage.isProfileIconVisible(), "Profile icon is not visible, login failed.");
        
        // Scroll and verify presence of all rails
        homePage.verifyAllRailsPresent();


        
        // Log results
        System.out.println("Test for home page rails completed.");
    }

//    @Test
//   public void testClickAllViewAllButtons() throws InterruptedException {
//       // Ensure you're on the homepage after logging in
//       System.out.println("Testing the 'View All' buttons...");
//
//       // Click all "View All" buttons present on the homepage
//       homePage.clickAllViewAllButtons();
//        
//        // Add any necessary assertions or further actions here
//       System.out.println("View All buttons clicked successfully.");
// 
//
//}
//    
//    @Test
//    public void testClickAllBottomLinksAndNavigate() {
//        // Initialize the HomePage instance
//        HomePage homePage = new HomePage(driver);
//
//        // Call the method to click all the bottom links and handle window switching
//        homePage.clickAllBottomLinksAndNavigate();
//    }
//    
//    @Test
//    public void scrollSlowlyToBottomAndBack() {
//        // Initialize the HomePage instance
//        HomePage homePage = new HomePage(driver);
//
//        // Call the method to click all the bottom links and handle window switching
//        homePage.scrollSlowlyToBottomAndBack();
//    }
//    
//    
//    
//    @Test
//    public void testScrollAndClickContentOption() throws InterruptedException {
//        // Call the scrollAndClickContentOption method from HomePage
//        System.out.println("Testing scroll and click for Daredevil content option...");
//        homePage.scrollAndClickContentOption("daredevil");  // Scroll until Daredevil div is visible, then click
//
//        System.out.println("Testing scroll and click for Add My List content option...");
//        homePage.scrollAndClickContentOption("addmylist");  // No scroll, just click
//        
//        System.out.println("Testing scroll and click for Add My List content option again...");
//        homePage.scrollAndClickContentOption("addmylist");  // No scroll, just click
//
//        System.out.println("Testing scroll and click for Share button content option...");
//        homePage.scrollAndClickContentOption("share");  // No scroll, just click
//        
//        System.out.println("Testing scroll and click for close button content option...");
//        homePage.scrollAndClickContentOption("closeButton");  // No scroll, just click
////        
//        System.out.println("Testing scroll and click for play  button content option...");
//        homePage.scrollAndClickContentOption("play"); } // No scroll, just click  
////        
////        
////        
////        
////    }
//    
//    
//   
//
////
////    @Test
////    public void testClickContentOption() throws InterruptedException {
////        // Call the clickContentOptions method directly (without scroll)
////        System.out.println("Directly clicking the content options...");
////
////        // Click the "Daredevil" div
////        homePage.clickContentOptions("daredevil");
////        
////        // Click the "Add My List" button
////        homePage.clickContentOptions("addmylist");
////        // Click the "Add My List" button
////        
////        homePage.clickContentOptions("addmylist");
////
////        // Click the "Share" button
////        homePage.clickContentOptions("share");
////        homePage.clickContentOptions("closeButton");
////        
////     // Click the "Play" button
////        homePage.clickContentOptions("play");
////        
////        
////    }
//
//    
//    
//   
    
    

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            System.out.println("Closing the browser...");
          // driver.quit(); // Close the browser after each test
        }
    }
}

