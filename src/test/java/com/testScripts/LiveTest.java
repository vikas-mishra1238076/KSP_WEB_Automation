package com.testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.objectRepo.LoginPage;
import com.objectRepo.LoginPage1;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LiveTest<Live> {
    private WebDriver driver;
    private LoginPage1 loginPage;
    private Live livePage;

    @BeforeMethod
    public void setup() throws InterruptedException {
        System.out.println("Setting up the test environment...");

        // Setup Firefox driver using WebDriverManager
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // Initialize page objects
        loginPage = new LoginPage(driver);
        livePage = new Live(driver);

        // Navigate to login page and perform login
        loginPage.navigateToHomePage();
        loginPage.initiateLogin();

        // Wait for the sign-in button to be available
        Thread.sleep(2000);

        // Enter valid username and password
        loginPage.enterUsername("ibc.jobst@gmail.com"); // Replace with valid email
        loginPage.enterPassword("ibc2024$"); // Replace with valid password

        // Click login button
        loginPage.clickLoginButton();

        // Select profile after clicking sign-in
        loginPage.selectProfile();

        // Wait for profile to load and skip any introductory screens
        Thread.sleep(3000);

        // Skip any onboarding screens on the Live page (if applicable)
        livePage.clickSkipButton();

        System.out.println("Test environment set up complete.");
    }

    @Test
    public void testLiveScreen() throws InterruptedException {
        System.out.println("Testing 'Live' screen...");
        
        // Clicking the 'Live' button from Live page
        livePage.clickLiveScreen();
        
        // Wait for 2 seconds to see the action
        Thread.sleep(2000); 
        
//        // Scroll down and click all "View All" buttons
//        livePage.clickAllViewAllButtons();
        
        // Wait for 3 seconds to observe the action
        Thread.sleep(3000);

//        // Clicking all the bottom links and navigating through them
//        livePage.clickAllBottomLinksAndNavigate();
        
        // Wait for 3 seconds after clicking bottom links to observe the page transition
        Thread.sleep(3000);
        
        livePage.clickCNNImage(); 
    }
     
        
//        System.out.println("'Live' screen tested successfully.");
//    }
    
//    @Test
//    public void testClickCNNImage() throws InterruptedException {
//        System.out.println("Testing CNN image click...");
//
//        
//       // livePage.clickLiveScreen();
//        // Click the CNN image on the Live page
//        livePage.clickCNNImage(); 
//        
//        // Wait for a few seconds to observe the action (you can add validation here)
//        Thread.sleep(2000);
//
//        System.out.println("CNN image clicked successfully.");
//    }
    

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            System.out.println("Closing the browser...");
           // driver.quit(); // Close the browser after each test
        }
    }
}


