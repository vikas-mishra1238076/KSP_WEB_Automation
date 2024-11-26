package com.testScripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.genericmethods.Base;
import com.objectRepo.LoginPage;


public class LoginTest extends Base {
	private WebDriver driver;

	@BeforeMethod
	public void browsersetup() throws InterruptedException {
		loadPropertiesFile();
		driver = initializeAndOpenBrowser(prop.getProperty("browser"));
	}
	
	
	@AfterMethod
	public void quitt() throws InterruptedException {
		Thread.sleep(3000);
		// driver.quit();

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority = 1)
	public void validPasswordloginpage() throws InterruptedException {
	    try {
	        LoginPage login = new LoginPage(driver);
	        Thread.sleep(2000);
	        login.getSignincta().click();
	        Thread.sleep(2000);
	        //verify if email & password field is enabled or not
	        boolean isEmailEnabled = login.getValidEmail().isEnabled();
	        Assert.assertTrue(isEmailEnabled, "Email field is not enabled.");
	        
	        boolean isPaswordEnabled = login.getValidPassword().isDisplayed();
	        Assert.assertTrue(isPaswordEnabled, "Password field is not enabled");
	        
	        login.getValidEmail().sendKeys(prop.getProperty("validemail"));
	        Thread.sleep(2000);
	        login.getValidPassword().sendKeys(prop.getProperty("validpassword"));
	        Thread.sleep(4000);
	        
	        boolean isLoginbtnEnabled = login.getLogin().isEnabled();
	        Assert.assertTrue(isLoginbtnEnabled, "Login button is not enabled");
	        
	        login.getLogin().click();
	        Thread.sleep(5000);

	        // Capture total time from the login to home page
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        Long loadTime = (Long) js.executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;");
	        System.out.println("Page load time from login to home: " + loadTime + " milliseconds");

	        Assert.assertTrue(login.getLoginProfile().isDisplayed(), "Login profile is not displayed after login");
	        
	        login.getLoginProfile().click();
	        Thread.sleep(3000);
	        login.getVivreSkip().click();
	        
	        System.out.println("User logged in successfully");
	        
	       // Increment passed tests count
	       incrementPassedTests(); 
	             
	    } catch (Exception e) {
	       System.out.println("Test failed: " + e.getMessage());
	       incrementFailedTests(); // Increment failed tests count
	       Assert.fail("Login test failed", e);
	    }
	}
}
