package com.testScripts;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericmethods.Base;
import com.objectRepo.HomePage;

public class HomePageTest extends Base {
	

	@Test(priority = 1)
    public void homeScreenManagement()throws InterruptedException, AWTException {
    	loadPropertiesFile();
    	if (prop == null) {
			throw new NullPointerException("Properties file not loaded successfully.");
		}

   // Initialize HomePage object with WebDriver
      HomePage  homePage = new HomePage(driver);
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
 
   // Wait for the Play button to be clickable
      WebElement playButton = homePage.getPlayButton();
      wait.until(ExpectedConditions.elementToBeClickable(playButton));

      //need to check xpath error!
      // Click the Play button
      playButton.click();
      System.out.println("Play button clicked.");

      // Check if the play button is still displayed after clicking (this is a placeholder check)
      Assert.assertTrue(playButton.isDisplayed(), "Play button is not displayed after clicking.");
      Thread.sleep(3000);
      
      WebElement shareButton = homePage.getShareButton();
      wait.until(ExpectedConditions.elementToBeClickable(shareButton));

      // Click the Share button
      shareButton.click();
      System.out.println("Share button clicked.");

      // Check if Share button is still displayed (you may add more checks based on the actual behavior)
      Assert.assertTrue(shareButton.isDisplayed(), "Share button is not displayed after clicking.");
      
      int bottomLinksCount = homePage.getBottomLinks().size();
      Assert.assertTrue(bottomLinksCount > 0, "No bottom links found.");

      System.out.println("Found " + bottomLinksCount + " bottom links.");
      
      WebElement daredevilDiv = homePage.getDaredevilDiv();
      boolean isDaredevilDivDisplayed = daredevilDiv.isDisplayed();
      Assert.assertTrue(isDaredevilDivDisplayed, "'Daredevil' div is not displayed.");

      if (isDaredevilDivDisplayed) {
          System.out.println("'Daredevil' div is displayed.");
      } else {
          System.out.println("'Daredevil' div is not displayed.");
      }
      
      WebElement closeButton = homePage.getCloseButton();
      wait.until(ExpectedConditions.elementToBeClickable(closeButton));

      // Click the Close button
      closeButton.click();
      System.out.println("Close button clicked.");

      // Check if close button is no longer displayed after clicking
      Assert.assertFalse(closeButton.isDisplayed(), "Close button is still visible after clicking.");
 
      WebElement profileIcon = homePage.getProfileIcon();
      wait.until(ExpectedConditions.elementToBeClickable(profileIcon));

      // Click the profile icon
      profileIcon.click();
      System.out.println("Profile icon clicked.");

      // Check if the profile icon is displayed (this can be adjusted based on the profile icon's behavior)
      Assert.assertTrue(profileIcon.isDisplayed(), "Profile icon was not clicked successfully.");
  
      boolean isAddMyListEnabled = homePage.getAddMyList().isEnabled();
      Assert.assertTrue(isAddMyListEnabled, "'Add MyList' button is not enabled.");

      if (isAddMyListEnabled) {
          System.out.println("'Add MyList' button is enabled and clickable.");
      } else {
          System.out.println("'Add MyList' button is not enabled.");
      }
	
	
	}
	
	}
      

      
	
      
      
  

	
  
  
      
    

 

    

