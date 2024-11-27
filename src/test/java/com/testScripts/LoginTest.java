package com.testScripts;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        Thread.sleep(2000);
	        login.getSignincta().click();
	        Thread.sleep(2000);
	        //login.getLogin().click();
	        
	        
	        login.getValidEmail().sendKeys(prop.getProperty("invalidEmail"));
	        Thread.sleep(2000);
	        login.getValidPassword().sendKeys(prop.getProperty("validpassword"));
	        Thread.sleep(2000);
	        login.getLogin().click();
	        Thread.sleep(2000);
	        String errormessage = login.getEmailErrorMessage().getText();
	        Thread.sleep(2000);
	        Assert.assertEquals(errormessage, "Please enter valid email");
	        System.out.println(errormessage);
	        
	        Thread.sleep(3000);
	       
	        WebElement emailField = login.getValidEmail();
	        Thread.sleep(2000);
	        emailField.click(); // Focus on the input field

	        // Clear the field by sending backspace key multiple times
	        int length = emailField.getAttribute("value").length(); // Get the current length of the value
	        for (int i = 0; i < length; i++) {
	            emailField.sendKeys(Keys.BACK_SPACE);
	        }
	        
	        Thread.sleep(2000);
	       login.getValidEmail().sendKeys(prop.getProperty("validemail"));
	       
	       
	       WebElement passfield = login.getValidPassword();
	        Thread.sleep(2000);
	        passfield.click(); // Focus on the input field

	        // Clear the field by sending backspace key multiple times
	        int lengthpass = passfield.getAttribute("value").length(); // Get the current length of the value
	        for (int i = 0; i < lengthpass; i++) {
	        	passfield.sendKeys(Keys.BACK_SPACE);
	        }
	       
	      
	        Thread.sleep(2000);
	        login.getValidPassword().sendKeys(prop.getProperty("invalidPassword"));
	        Thread.sleep(2000);
	        login.getLogin().click();
	        Thread.sleep(2000);
	        String errorpassmessage = login.getPasswordErrorMessage().getText();
	        Thread.sleep(2000);
	        Assert.assertEquals(errorpassmessage, "Please click the “Forgot Password” button. If you are still unable to login please contact us at customerservice@aptnlumi.ca");
	        System.out.println(errorpassmessage);
	        
	        
	        
	        WebElement emailField1 = login.getValidEmail();
	        Thread.sleep(2000);
	        emailField1.click(); // Focus on the input field
	        Thread.sleep(2000);
	        emailField1.sendKeys(Keys.CONTROL, "a");
	        emailField1.sendKeys(Keys.BACK_SPACE);
	        	Thread.sleep(2000);
	            String ema = login.getEmailRequiredErrorMessage().getText();
	            System.out.println(ema);
	            
	            
	            
	            WebElement passfield1 = login.getValidPassword();
		        Thread.sleep(2000);
		        passfield1.click(); // Focus on the input field
		        Thread.sleep(2000);
		        passfield1.sendKeys(Keys.CONTROL, "a");
		        passfield1.sendKeys(Keys.BACK_SPACE);
		        	Thread.sleep(2000);
		        	 String pass = login.getPasswordRequiredErrorMessage().getText();
			            System.out.println(pass);
		      
	        
	        Thread.sleep(5000);
	       
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
