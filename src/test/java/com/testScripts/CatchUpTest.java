package com.testScripts;

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
import com.objectRepo.CatchUpPage;

public class CatchUpTest extends Base {
	
@Test(priority = 1)
	
	public void newKidsmanagement() throws InterruptedException {
			loadPropertiesFile();
		if (prop == null) {
			throw new NullPointerException("Properties file not loaded successfully.");
		}	
		
		CatchUpPage catchup = new CatchUpPage(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 catchup.getCatchupscreen().click();
		 
		 /*WebElement next = catchup.getBannernextslide();
		 int nextslide = 5;
		  for(int i=0; i<=nextslide; i++) {
			  next.click();
			  Thread.sleep(2000);
		  }
		  
		  WebElement prev = catchup.getBannernPrevslide();
			 int prevslide = 5;
			  for(int i=0; i<=prevslide; i++) {
				  prev.click();
				  Thread.sleep(2000);
			  }
			  
			  Thread.sleep(2000);
			  js.executeScript("window.scrollBy(0, 400);");
			  js.executeScript("arguments[0].click();", catchup.getFirstNextSlide());
			  Thread.sleep(2000);
			  catchup.getFirstpreviousslide().click();
			  Thread.sleep(2000);
			  
			  js.executeScript("window.scrollBy(0, 400);");
			  js.executeScript("arguments[0].click();", catchup.getSecondNextSlide());
			  Thread.sleep(3000);
			 // wait.until(ExpectedConditions.visibilityOf(catchup.getSecondpreviousslide()));
			  catchup.getSecondpreviousslide().click();
			  Thread.sleep(2000);
			  
			  js.executeScript("window.scrollBy(0, 400);");
			  js.executeScript("arguments[0].click();", catchup.getThirdNextSlide());
			  Thread.sleep(3000);
			  catchup.getThirdpreviousslide().click();
			  Thread.sleep(2000);
			  
			  js.executeScript("window.scrollBy(0, 200);");
			  js.executeScript("arguments[0].click();", catchup.getFourthslide());
			  Thread.sleep(3000);
			  catchup.getFourthpreviousslide().click();
			  Thread.sleep(2000);
			  
			  js.executeScript("window.scrollBy(0, 200);");
			  js.executeScript("arguments[0].click();", catchup.getFifthslide());
			  Thread.sleep(3000);
			  catchup.getFifthpreviousslide().click();
			  Thread.sleep(2000);
			  
			  js.executeScript("window.scrollBy(0, 200);");
			  js.executeScript("arguments[0].click();", catchup.getSixthslide());
			  Thread.sleep(3000);
			  catchup.getSixthpreviousslide().click();
			  Thread.sleep(2000);*/
		 
		     catchup.getCatchupasset().click();
		     System.out.println("The asset is clicked successfully");
		     Thread.sleep(2000);
		     catchup.getAddmyList().click();
		     Thread.sleep(2000);
		     js.executeScript("arguments[0].click();", catchup.getAddmyList());
		     Thread.sleep(2000);
		     js.executeScript("arguments[0].click();", catchup.getShare());
		    // catchup.getShare().click();
		     Thread.sleep(2000);
		     catchup.getClosesharebtn().click();
		     Thread.sleep(2000);
			 catchup.getPlay().click();	
			 
			 Thread.sleep(3000);
			 WebElement doubleclick = catchup.getPlayerdoubleclick();
				
				Actions act = new Actions(driver);
				
				Thread.sleep(3000);
				act.doubleClick(doubleclick).perform();
				Thread.sleep(2000);
				
				 int hours = 1;
			     int minutes = 5;
				 int seconds = 30;
				 
				// Convert minutes and seconds to total seconds
			        int jumpToTime = (minutes * 60) + seconds;

				 JavascriptExecutor je = (JavascriptExecutor) driver;
				 je.executeScript("var video = document.querySelector('video'); video.currentTime = " + jumpToTime + ";");
				System.out.println("skipped successfully");
				Thread.sleep(3000);
				
				catchup.getForward().click();
				 Thread.sleep(3000); 
//				 kids.getForward().click();
//				 Thread.sleep(3000); 
				 catchup.getBackward().click();
				 Thread.sleep(3000);
				 catchup.getBackward().click();
				 Thread.sleep(2000);
				 catchup.getBackward().click();
				 Thread.sleep(4000);
				 act.click().perform();
				 Thread.sleep(3000);
				 act.click().perform();
				 
				 WebElement mute = catchup.getMuteUnmute();
				 Thread.sleep(2000);
		          act.doubleClick(mute).perform();
		          
		          Thread.sleep(3000);
		          catchup.getPictureinPicture().click();
		          
		          //to disable PIP mode
		          Thread.sleep(4000);
		          WebElement pipstop = catchup.getPipstop();
		          act.moveToElement(pipstop).click().perform();
		                    
		          catchup.getMaximize().click();
		          Thread.sleep(3000);
		          act.doubleClick(doubleclick).perform();
		          catchup.getBackbtnplayerscreen().click();
		          Thread.sleep(3000);
		          
		          driver.navigate().back();
		          
		         // catchup.getBackbtnplayerscreen().click();
		          
		          Thread.sleep(3000);
		          js.executeScript("window.scrollTo(0, 0);"); 
		          Thread.sleep(2000);
		          catchup.getHomeScreen().click();
		          By continueWatchingRailLocator = By.xpath("//*[contains(text(),'Continue Watching')]");
		          
		          try {
		        	  WebElement continueWatchingRail = wait.until(ExpectedConditions.visibilityOfElementLocated(continueWatchingRailLocator));
			            Assert.assertTrue(continueWatchingRail.isDisplayed(), "'Continue Watching' rail is not displayed.");

			            // Scroll into view if necessary
			            js.executeScript("arguments[0].scrollIntoView(true);", continueWatchingRail);

			            // Check for the asset in "Continue Watching"
			            String playedAssetTitle = "AFLHigh3 - Mini-Match _ Brisbane v Western Bulldogs _ Semi Final, 2021 _ AFL"; // The title of the asset
			            By assetLocator = By.xpath("//img[@alt='" + playedAssetTitle + "']"); // Updated XPath for the played asset
			            
			            WebElement assetElement = wait.until(ExpectedConditions.visibilityOfElementLocated(assetLocator));
			            Assert.assertTrue(assetElement.isDisplayed(), "The played asset is not present in 'Continue Watching' rail.");
			            System.out.println("The played asset is present in 'Continue Watching' rail.");
			            
			        } 
				    catch (org.openqa.selenium.NoSuchElementException e) {
			            System.out.println("The 'Continue Watching' rail or the played asset is not found.");
			            Assert.fail("The 'Continue Watching' rail or the played asset is not found.");
			        } 
				    catch (org.openqa.selenium.TimeoutException e) {
			            System.out.println("The 'Continue Watching' rail did not load within the timeout period.");
			            Assert.fail("The 'Continue Watching' rail did not load within the timeout period.");
			        }
		        	  
		          }
											
}

