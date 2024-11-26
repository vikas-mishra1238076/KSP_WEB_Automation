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
import com.objectRepo.KidsPage;

public class KidsTest extends Base {
	 
	@Test(priority = 1)
	
	public void newKidsmanagement() throws InterruptedException {
		loadPropertiesFile();
		if (prop == null) {
			throw new NullPointerException("Properties file not loaded successfully.");
		}
		KidsPage kids = new KidsPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		kids.getKids().click();
//		Thread.sleep(3000);
//		kids.getSearch().click();
//		Thread.sleep(2000);
//		kids.getSearch().sendKeys(prop.getProperty("KidsSearch"));
		
//		Thread.sleep(3000);
//		kids.getAssetclick().click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		/*String[] rails = { "Summer Camp for Kids",
		           "Cute Movies", 
		           "Gems For You", 
		           "Funny movies",
		           "Crowd Pleasers",
		           "Animated Movies",
		           "Silly",
		           "Kids Exclusive"};
		
		
		for (String rail : rails) {
			By railLocator = By.xpath("//*[contains(text(), '" + rail + "')]");

			try {
				WebElement railElement = wait.until(ExpectedConditions.visibilityOfElementLocated(railLocator));
				Thread.sleep(2000);

				js.executeScript("arguments[0].scrollIntoView();", railElement);
				Thread.sleep(3000);
		
				Assert.assertTrue(railElement.isDisplayed(), rail + " rail is not displayed.");
				System.out.println(rail + " rail is displayed.");
			} catch (org.openqa.selenium.NoSuchElementException e) {
				System.out.println(rail + " rail is not found.");
			} catch (org.openqa.selenium.TimeoutException e) {
				System.out.println(rail + " rail is not visible within the timeout period.");
			}
		}  */
		
		
		Thread.sleep(4000);
		//to click on the asset
		js.executeScript("arguments[0].click();", kids.getAssetclick());
		Thread.sleep(3000);
		//js.executeScript("window.scrollBy(0, 6000);");
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(2000);
		kids.getAddmyList().click();
		Thread.sleep(4000);
		js.executeScript("arguments[0].click();", kids.getAddmyList());
		Thread.sleep(2000);
//		kids.getAddmyList().click();
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", kids.getShare());
		//kids.getShare().click();
		Thread.sleep(2000);
		kids.getClosesharebtn().click();
		Thread.sleep(2000);
		kids.getPlay().click();
		Thread.sleep(3000);
		WebElement doubleclick = kids.getPlayerdoubleclick();
		
		Actions act = new Actions(driver);
		
		Thread.sleep(3000);
		act.doubleClick(doubleclick).perform();
		Thread.sleep(2000);
		
		kids.getForward().click();
		 Thread.sleep(3000); 
//		 kids.getForward().click();
//		 Thread.sleep(3000); 
		 kids.getBackward().click();
		 Thread.sleep(3000);
		 kids.getBackward().click();
		 Thread.sleep(2000);
		 kids.getBackward().click();
		 Thread.sleep(4000);
		 act.click().perform();
		 Thread.sleep(3000);
		 act.click().perform();
		 //Thread.sleep(2000);
		 
		 //to handle mute/unmute volume
		WebElement mute = kids.getMuteUnmute();
		 Thread.sleep(2000);
          act.doubleClick(mute).perform();
          
          
//         WebElement settings = kids.getSettings();
//          Thread.sleep(3000);
//          act.moveToElement(settings).click().perform();
//          Thread.sleep(4000);
          
         Thread.sleep(3000);
          kids.getPictureinPicture().click();
          
          //to disable PIP mode
          Thread.sleep(4000);
          WebElement pipstop = kids.getPipstop();
          act.moveToElement(pipstop).click().perform();
                    
          kids.getMaximize().click();
          Thread.sleep(3000);
          act.doubleClick(doubleclick).perform();
          kids.getBackbtnplayerscreen().click();
          Thread.sleep(3000);
          
          driver.navigate().back();
         
         // kids.getBackbtnplayerscreen().click();
          Thread.sleep(3000);
          
          js.executeScript("window.scrollTo(0, 0);"); 
          Thread.sleep(3000);
		
		js.executeScript("window.scrollBy(0, 100);");
		Thread.sleep(3000);
          WebElement firstslides = kids.getFirstslide();
          int maxclick = 4;
          for (int i=0; i<maxclick; i++) {
        	  firstslides.click();
        	  Thread.sleep(2000);
          }
          
          js.executeScript("window.scrollBy(0, 100);");
  	      Thread.sleep(3000);
          WebElement secondslides = kids.getSecondslide();
          int maxclick2 = 4;
          for (int i=0; i<maxclick2; i++) {
        	  secondslides.click();
        	  Thread.sleep(2000);
          }
          
         // js.executeScript("window.scrollBy(0, 500);");
  	      Thread.sleep(3000);
  	    WebElement banner = kids.getBannerslide();
        int banner1 = 4;
        for (int i=0; i<banner1; i++) {
        	banner.click();
      	  Thread.sleep(2000);
        }
        
        js.executeScript("window.scrollBy(0, 700);");
	      Thread.sleep(3000);
	    WebElement thirdslides = kids.getThirdslide();
      int third = 4;
      for (int i=0; i<third; i++) {
    	  thirdslides.click();
    	  Thread.sleep(2000);
      }
      
      js.executeScript("window.scrollBy(0, 200);");
	      Thread.sleep(3000);
	    WebElement fourthslides = kids.getFourthslide();
    int fourth = 4;
    for (int i=0; i<fourth; i++) {
    	fourthslides.click();
  	  Thread.sleep(2000);
    }
    
    js.executeScript("window.scrollBy(0, 200);");
	      Thread.sleep(3000);
	    WebElement fifthslides = kids.getFifthslide();
	    int fifth = 4;
	    for (int i=0; i<fifth; i++) {
	  fifthslides.click();
	  Thread.sleep(2000);
  }
	    
	    js.executeScript("window.scrollBy(0, 200);");
		      Thread.sleep(3000);
		    WebElement sixthslides = kids.getSixthslide();
		    int sixth = 4;
		    for (int i=0; i<sixth; i++) {
		    	sixthslides.click();
		  Thread.sleep(2000);
	  }  
		    
		    js.executeScript("window.scrollBy(0, 200);");
			      Thread.sleep(3000);
			    WebElement seventhslides = kids.getSeventhslide();
			    int seventh = 4;
			    for (int i=0; i<seventh; i++) {
			    	seventhslides.click();
			  Thread.sleep(2000);
		  }	 
			    
			    js.executeScript("window.scrollBy(0, 200);");
				      Thread.sleep(2000);
				    WebElement eightslides = kids.getEightslide();
				    int eight = 4;
				    for (int i=0; i<eight; i++) {
				    	eightslides.click();
				  Thread.sleep(2000);
			  }   
			    
//			    js.executeScript("window.scrollBy(0, 200);");
//				      Thread.sleep(2000);
//				    WebElement ninthslides = kids.getNinthslide();
//				    int ninth = 4;
//				    for (int i=0; i<ninth; i++) {
//				    	ninthslides.click();
//				  Thread.sleep(2000);
//			  }	
				    
			    js.executeScript("window.scrollTo(0, 0);");    
			    kids.getHomeScreen().click();
			    By continueWatchingRailLocator = By.xpath("//*[contains(text(),'Continue Watching')]");
			    
			    try {
		            WebElement continueWatchingRail = wait.until(ExpectedConditions.visibilityOfElementLocated(continueWatchingRailLocator));
		            Assert.assertTrue(continueWatchingRail.isDisplayed(), "'Continue Watching' rail is not displayed.");

		            // Scroll into view if necessary
		            js.executeScript("arguments[0].scrollIntoView(true);", continueWatchingRail);

		            // Check for the asset in "Continue Watching"
		            String playedAssetTitle = "GOOSEBUMPS - Official Trailer (HD)"; // The title of the asset
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
		            Assert.fail("The cntinue watching rail dis not load within the timeout period");
		        }
			    
			   
	}

}
