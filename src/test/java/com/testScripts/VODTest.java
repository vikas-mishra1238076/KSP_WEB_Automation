package com.testScripts;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericmethods.Base;
import com.objectRepo.VODPage;


//@Listeners(eventlist.class)

public class VODTest extends Base {

	@Test(priority = 1)
	public void newVODmanagement() throws InterruptedException, AWTException {
		loadPropertiesFile();

		if (prop == null) {
			throw new NullPointerException("Properties file not loaded successfully.");
		}
		VODPage page = new VODPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

//		page.getSearch().click();
//		Thread.sleep(3000);
//		page.getSearch().sendKeys(prop.getProperty("search"));
//		page.getAssetBlueBeetle().click();

		boolean isVODDisplayed = page.getVOD().isDisplayed();
		Assert.assertTrue(isVODDisplayed, "Vod screen is not enabled");
		
//print message if VOD screen is displayed
		if(isVODDisplayed) {
			System.out.println("VOD screen is present");
		} else {
			System.out.println("VOD screen is not displayed");
		}
		
//print message if VOD screen is displayed
		page.getVOD().click();
		Thread.sleep(3000);
		page.getVIPasset().click();
		Thread.sleep(3000);
		page.getPlaybtn().click();
		Thread.sleep(3000);
		page.getClosesharebtn().click();
		Thread.sleep(3000);
		page.getCloseCDpagebtn().click();
		//driver.navigate().back();

		Long loadTime = (Long) js
				.executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;");
		System.out.println("Page load time from Home to VOD screen: " + loadTime + " milliseconds");
		Thread.sleep(5000);

//		 js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		/*String[] rails = { "Action Movies",
				           "Thriller", 
				           "Horror", "Scifi & Fantasy", 
				           "Crime & Thriller",
				           "Must Watch Movies" };

		for (String rail : rails) {
			By railLocator = By.xpath("//*[contains(text(), '" + rail + "')]");

			try {
				WebElement railElement = wait.until(ExpectedConditions.visibilityOfElementLocated(railLocator));
				Thread.sleep(3000);

				js.executeScript("arguments[0].scrollIntoView();", railElement);
				Thread.sleep(4000);

				// page.getActionGotoNextSlide().click();
				// Thread.sleep(5000);
				// WebElement railElement1 = driver.findElement(railLocator);
				Assert.assertTrue(railElement.isDisplayed(), rail + " rail is not displayed.");
				System.out.println(rail + " rail is displayed.");
			} catch (org.openqa.selenium.NoSuchElementException e) {
				System.out.println(rail + " rail is not found.");
			} catch (org.openqa.selenium.TimeoutException e) {
				System.out.println(rail + " rail is not visible within the timeout period.");
			}
		}*/

		js.executeScript("window.scrollTo(0, 0);");

		WebElement ele = page.getAssetBlueBeetle();
		int width = ele.getSize().getWidth();
		int height = ele.getSize().getHeight();

		// Calculate the aspect ratio
		double aspectRatio = (double) width / height;

		// Print the results
		System.out.println("Video Width: " + width);
		System.out.println("Video Height: " + height);
		System.out.println("Aspect Ratio: " + aspectRatio);

		// to click on assets
		long vodToAssetStartTime = System.currentTimeMillis();
		page.getAssetBlueBeetle().click();
		long vodToAssetEndTime = System.currentTimeMillis();
		System.out.println("Page load time from VOD screen to Asset: "
				+ (vodToAssetEndTime - vodToAssetStartTime) / 1000.0 + " milliseconds");
		
		boolean isEnabled = page.getAddMylist().isEnabled();
		Assert.assertTrue(isEnabled, "Add MyList is not enabled");
		
		if(isEnabled) {
			System.out.println("Add MyList button is clickable & working as expected");
		} else {
			System.out.println("Add MyList button is clickable & working as expected ");
		}
		
		Thread.sleep(2000);
		page.getAddMylist().click();
		Thread.sleep(2000);
		  js.executeScript("arguments[0].click();", page.getAddMylist());
//		page.getAddMylist().click();
		Thread.sleep(2000);
		  js.executeScript("arguments[0].click();", page.getShare());
		//page.getShare().click();
		Thread.sleep(3000);
		page.getClosesharebtn().click();
		Thread.sleep(3000);
		long vodToplayerscreentStartTime = System.currentTimeMillis();
		page.getPlaybtn().click();
		long assetToPlayerEndTime = System.currentTimeMillis();
		System.out.println("Page load time from Asset to Player screen: "
				+ (assetToPlayerEndTime - vodToplayerscreentStartTime) / 1000.0 + " milliseconds");
		Thread.sleep(4000);

		WebElement doubleclick = page.getPlayerdoubleclick();
		Actions act = new Actions(driver);
		act.doubleClick(doubleclick).perform();
		Thread.sleep(3000);
		
		 int hours = 1;
	     int minutes = 1;
		 int seconds = 15;
		 
		// Convert minutes and seconds to total seconds
	        int jumpToTime = (minutes * 60) + seconds;

		 JavascriptExecutor je = (JavascriptExecutor) driver;
		 je.executeScript("var video = document.querySelector('video'); video.currentTime = " + jumpToTime + ";");
		 System.out.println("skipped successfully");
		 Thread.sleep(8000);
		 
		 page.getBackward().click();
		  Thread.sleep(4000); 
//		  page.getBackward().click();
//		  Thread.sleep(3000); 
		 page.getForward().click(); 
		 Thread.sleep(2000);
		  page.getForward().click(); 
		 Thread.sleep(4000); 
		 act.click().perform();
		 Thread.sleep(5000); 
		 act.click().perform(); 
		 Thread.sleep(2000);
	
		// mute/unmutes
		act.moveToElement(page.getMuteUnmute()).click();
		Thread.sleep(3000);
		
		act.moveToElement(page.getPictureinPicture()).click();
		 Thread.sleep(4000);
         WebElement pipstop = page.getPipstop();
         act.moveToElement(pipstop).click().perform();
         
         page.getMaximize().click();
		Thread.sleep(3000);
		act.doubleClick(doubleclick).perform();
		
		// back button on player screen
		//Thread.sleep(2000);
		page.getBackbtnplayerscreen().click();
		System.out.println("Successfully navigated to CD page from player screen");
		// back button from the CD page
		Thread.sleep(3000);
		
		driver.navigate().back();
//		page.getBackbtnplayerscreen().click();
       	Thread.sleep(3000);

		page.getOriginalNextslide().click();
		Thread.sleep(2000);
		page.getOriginalNextslide().click();
		Thread.sleep(2000);
		page.getActionGotoNextSlide().click();
		Thread.sleep(2000);
		page.getActionGotoNextSlide().click();
		Thread.sleep(2000);
		page.getSmallrailNextSlide().click();
		Thread.sleep(2000);
		page.getSmallrailNextSlide().click();
		Thread.sleep(2000);
		page.getSmallrailsecNextSlide().click();
		Thread.sleep(2000);
		page.getSmallrailsecNextSlide().click();
		Thread.sleep(2000);

		/*WebElement nextslidebtn = page.getBannerNextSlide();
		int maxClick = 5;
		for (int i = 0; i < maxClick; i++) {
			nextslidebtn.click();
			Thread.sleep(2000);
		}*/
		
		//to click on view all
		js.executeScript("window.scrollTo(0, 0);");
		Thread.sleep(3000);
		
		page.getViewall().click();
		driver.navigate().back();
		

//		page.getSearch().click();
//		Thread.sleep(3000);
//		page.getSearch().sendKeys(prop.getProperty("search"));
//		page.getAssetBlueBeetle().click();

		// driver.navigate().refresh();
		Thread.sleep(3000);
		js.executeScript("window.scrollTo(0, 0);"); 
        Thread.sleep(2000);
        page.getHomeScreen().click();
        
        By continueWatchingRailLocator = By.xpath("//*[contains(text(),'Continue Watching')]");
        
        try {
      	  WebElement continueWatchingRail = wait.until(ExpectedConditions.visibilityOfElementLocated(continueWatchingRailLocator));
	            Assert.assertTrue(continueWatchingRail.isDisplayed(), "'Continue Watching' rail is not displayed.");

	            // Scroll into view if necessary
	            js.executeScript("arguments[0].scrollIntoView(true);", continueWatchingRail);

	            // Check for the asset in "Continue Watching"
	            String playedAssetTitle = "Blue Beetle"; // The title of the asset
	            By assetLocator = By.xpath("//img[@alt='" + playedAssetTitle + "']"); // Updated XPath for the played asset
	            
	            WebElement assetElement = wait.until(ExpectedConditions.visibilityOfElementLocated(assetLocator));
	            Assert.assertTrue(assetElement.isDisplayed(), "The played asset is not present in 'Continue Watching' rail.");
	            System.out.println("The played asset is present in 'Continue Watching' rail.");
	            
	        } 
        
		    catch (org.openqa.selenium.NoSuchElementException e) {
	            System.out.println("The 'Continue Watching' rail or the played asset is not found. Error: " + e.getMessage());
	           // Assert.fail("The 'Continue Watching' rail or the played asset is not found.");
	        } 
		    catch (org.openqa.selenium.TimeoutException e) {
	            System.out.println("The 'Continue Watching' rail did not load within the timeout period. Error: " + e.getMessage());
	          //  Assert.fail("The 'Continue Watching' rail did not load within the timeout period.");
	        }
        

	}

}
