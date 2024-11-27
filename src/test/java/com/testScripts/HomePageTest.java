package com.testScripts;

import java.awt.AWTException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericmethods.Base;
import com.objectRepo.HomePage;

public class HomePageTest extends Base {

    @Test(priority = 1)
    public void homeScreenManagement() throws InterruptedException, AWTException {
        loadPropertiesFile();
        if (prop == null) {
            throw new NullPointerException("Properties file not loaded successfully.");
        }

        // Initialize HomePage object with WebDriver
        HomePage homePage = new HomePage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement premiumRailTitle = homePage.getPremiumRailTitle();
        wait.until(ExpectedConditions.visibilityOf(premiumRailTitle));

        // Check if Premium rail title is displayed
        boolean isPremiumRailDisplayed = premiumRailTitle.isDisplayed();
        Assert.assertTrue(isPremiumRailDisplayed, "Premium rail title is not displayed.");

        if (isPremiumRailDisplayed) {
            System.out.println("Premium rail title is displayed.");
        } else {
            System.out.println("Premium rail title is not displayed.");
        }

        WebElement sliderLeft = homePage.getSliderLeft();
        wait.until(ExpectedConditions.elementToBeClickable(sliderLeft));

        // Click the left slider
        sliderLeft.click();
        System.out.println("Left slider clicked.");

        // Check if the Trending Rail is visible after clicking
        WebElement trendingRail = homePage.getTrendingRailTitle();
        Assert.assertNotNull(trendingRail, "Trending rail title did not appear after clicking left slider.");

        System.out.println("Trending rail title is displayed.");

        // Check if the "View All" buttons are present on the homepage
        int viewAllButtonCount = homePage.getViewAllButtons().size();
        Assert.assertTrue(viewAllButtonCount > 0, "No 'View All' buttons found.");

        System.out.println("Found " + viewAllButtonCount + " 'View All' buttons.");

//        // Get all the bottom links
//        java.util.List<WebElement> bottomLinks = homePage.getBottomLinks();
//
//        // Get the current window handle (the main window)
//        String mainWindowHandle = driver.getWindowHandle();
//
//        // Iterate over each bottom link and perform the necessary actions
//        for (WebElement link : bottomLinks) {
//            // Click on the bottom link to open in a new window/tab
//            link.click();
//            System.out.println("Clicked on link: " + link.getText());
//
//            // Wait for the new window to appear
//            WebDriverWait waitForNewWindow = new WebDriverWait(driver, Duration.ofSeconds(10));
//            waitForNewWindow.until(ExpectedConditions.numberOfWindowsToBe(2));
//
//            // Get all window handles and switch to the new window
//            Set<String> allWindowHandles = driver.getWindowHandles();
//            for (String handle : allWindowHandles) {
//                if (!handle.equals(mainWindowHandle)) {
//                    driver.switchTo().window(handle);  // Switch to the new window
//                    break;
//                }
//            }
//
//            // Close the new window
//            driver.close();
//            System.out.println("Closed the new window.");
//
//            // Switch back to the main window
//            driver.switchTo().window(mainWindowHandle);
//            System.out.println("Switched back to the main window.");
//
//            // Optional: Add a small delay between actions if needed
//            Thread.sleep(1000);
//        }
//        
        // Slow scroll down to the bottom using JavaScript execution
        for (int i = 0; i < 50; i++) {
            js.executeScript("window.scrollBy(0, 100);");  // Scroll down by 100 pixels
            Thread.sleep(500);  // Slow down with a 0.5-second delay between each scroll
        }
        System.out.println("Scrolled down to the bottom.");

        // Slow scroll up to the top using JavaScript execution
        for (int i = 0; i < 50; i++) {
            js.executeScript("window.scrollBy(0, -100);");  // Scroll up by 100 pixels
            Thread.sleep(500);  // Slow down with a 0.5-second delay between each scroll
        }
        System.out.println("Scrolled back to the top.");

        // Uncomment and complete the following actions if needed for other parts of the test
//      WebElement daredevilDiv = homePage.getDaredevilDiv();
//      boolean isDaredevilDivDisplayed = daredevilDiv.isDisplayed();
//      Assert.assertTrue(isDaredevilDivDisplayed, "'Daredevil' div is not displayed.");
//
//      if (isDaredevilDivDisplayed) {
//          System.out.println("'Daredevil' div is displayed.");
//      } else {
//          System.out.println("'Daredevil' div is not displayed.");
//      }
//
//      WebElement closeButton = homePage.getCloseButton();
//      wait.until(ExpectedConditions.elementToBeClickable(closeButton));
//
//      // Click the Close button
//      closeButton.click();
//      System.out.println("Close button clicked.");
//
//      // Check if close button is no longer displayed after clicking
//      Assert.assertFalse(closeButton.isDisplayed(), "Close button is still visible after clicking.");
//
//      WebElement profileIcon = homePage.getProfileIcon();
//      wait.until(ExpectedConditions.elementToBeClickable(profileIcon));
//
//      // Click the profile icon
//      profileIcon.click();
//      System.out.println("Profile icon clicked.");
//
//      // Check if the profile icon is displayed (this can be adjusted based on the profile icon's behavior)
//      Assert.assertTrue(profileIcon.isDisplayed(), "Profile icon was not clicked successfully.");
//
//      boolean isAddMyListEnabled = homePage.getAddMyList().isEnabled();
//      Assert.assertTrue(isAddMyListEnabled, "'Add MyList' button is not enabled.");
//
//      if (isAddMyListEnabled) {
//          System.out.println("'Add MyList' button is enabled and clickable.");
//      } else {
//          System.out.println("'Add MyList' button is not enabled.");
//      }
    }
}
