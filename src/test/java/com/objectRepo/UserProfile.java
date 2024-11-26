package com.objectRepo;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

public class UserProfile {

    private WebDriver driver;

    // Profile Icon (Existing)
    @FindBy(xpath = "(//button[@type='button' and @aria-haspopup='true'])[1]") 
    public WebElement profileIcon;

    // Profile Name (Existing)
    @FindBy(xpath = "//h6[@class='MuiTypography-root MuiTypography-h6' and contains(text(), 'vikass2121@gmail.com')]")
    private WebElement profileName;

    // Switch Profile Button
    @FindBy(xpath = "//span[@class='MuiButton-label' and text()='Switch Profile']")
    private WebElement switchProfileButton;

    // Add Profile Text (5 different Add Profile Text elements for multiple profile creation)
    @FindBy(xpath = "(//div[@style='display: flex; flex-direction: column; align-items: center; max-width: max-content;'])[2]")
    private WebElement addProfileText;
    
    @FindBy(xpath = "(//div[@style='display: flex; flex-direction: column; align-items: center; max-width: max-content;'])[3]")
    private WebElement addProfileText2;
    
    @FindBy(xpath = "(//div[@style='display: flex; flex-direction: column; align-items: center; max-width: max-content;'])[4]")
    private WebElement addProfileText3;
    
    @FindBy(xpath = "(//div[@style='display: flex; flex-direction: column; align-items: center; max-width: max-content;'])[5]")
    private WebElement addProfileText4;
    
    @FindBy(xpath = "(//div[@style='display: flex; flex-direction: column; align-items: center; max-width: max-content;'])[6]")
    private WebElement addProfileText5;

    // First Name Input Field
    @FindBy(xpath = "(//input[@type='text' and @maxlength='25' and contains(@class, 'MuiFilledInput-input')])[1]")
    private WebElement firstNameInput;

    // Last Name Input Field
    @FindBy(xpath = "(//input[@type='text' and @maxlength='25' and contains(@class, 'MuiFilledInput-input')])[2]")
    private WebElement lastNameInput;

    // Checkbox
    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    private WebElement checkbox;

    // Continue Button
    @FindBy(xpath = "//span[@class='MuiButton-label' and text()='Continue']")
    private WebElement continueButton;
    
 // Using FindBy annotation to locate the second div element with the specified style
    @FindBy(xpath = "(//div[@style='position: absolute; width: 5rem; padding-top: 1.6rem; padding-left: 0.8rem;'])[2]")
    private WebElement secondDivElement;
    
 // Button with class 'custom_button' (Delete Profile button)
    @FindBy(xpath = "//button[@class='custom_button' and contains(text(), 'Delete Profile')]")
    private WebElement deleteProfileButton;

    // Div elements with absolute positioning
    @FindBy(xpath = "(//div[@style='position: absolute; width: 5rem; padding-top: 1.6rem; padding-left: 0.8rem;'])[2]")
    private WebElement divElement2;
    
    @FindBy(xpath = "(//div[@style='position: absolute; width: 5rem; padding-top: 1.6rem; padding-left: 0.8rem;'])[3]")
    private WebElement divElement3;
    
    @FindBy(xpath = "(//div[@style='position: absolute; width: 5rem; padding-top: 1.6rem; padding-left: 0.8rem;'])[4]")
    private WebElement divElement4;
    
    @FindBy(xpath = "(//div[@style='position: absolute; width: 5rem; padding-top: 1.6rem; padding-left: 0.8rem;'])[5]")
    private WebElement divElement5;
    
 // Locate the button with the class 'custom_button' using FindBy annotation
 
    @FindBy(xpath = "//button[@class='custom_button']")
    private WebElement manageProfileButton;
    
  //button[@class='custom_button']


    // Constructor to initialize elements
    public UserProfile(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to click on Profile Icon
    public void clickProfileIcon() {
        profileIcon.click();
    }

    // Method to get Profile Name
    public String getProfileName() {
        return profileName.getText();
    }

    // Method to click on Switch Profile button
    public void clickSwitchProfileButton() {
        switchProfileButton.click();
    }

    // Method to click on Add Profile (optional step before interacting with fields)
    public void clickAddProfile() {
        addProfileText.click();
    }
    
    // Methods for different "Add Profile" buttons
    public void clickAddProfile2() {
        addProfileText2.click();
    }
    
    
    // Method to click on Manage Profile Button
    public void clickManageProfileButton() {
        manageProfileButton.click();
    }
    
    public void clickAddProfile3() {
        addProfileText3.click();
    }

    
 // Method to click on the second div element
    public void clickSecondDivElement() {
        secondDivElement.click();
    }
    
    public void clickAddProfile4() {
        addProfileText4.click();
    }
    
    public void clickAddProfile5() {
        addProfileText5.click();
    }

    // Method to enter First Name
    public void enterFirstName(String firstName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    // Method to enter Last Name
    public void enterLastName(String lastName) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    // Method to wait for the checkbox and click it
    public void waitForCheckboxAndClick() {
        checkbox.click();
    }

    // Method to click on Continue Button
    public void clickContinueButton() {
        continueButton.click();
    }
    
    
 // Method to click the Delete Profile button
    public void clickDeleteProfileButton() {
        deleteProfileButton.click();
    }

    // Method to click on the second div element
    public void clickDivElement2() {
        divElement2.click();
    }

//    // Method to click on the third div element
//    public void clickDivElement3() {
//        divElement3.click();
//    }
//
//    // Method to click on the fourth div element
//    public void clickDivElement4() {
//        divElement4.click();
//    }
//
//    // Method to click on the fifth div element
//    public void clickDivElement5() {
//        divElement5.click();
//    }


    // Method to wait for Add Profile Text and click it
    public void waitForAndClickAddProfile() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Wait for up to 10 seconds
            wait.until(ExpectedConditions.elementToBeClickable(addProfileText));  // Wait until Add Profile is clickable

            // Click on Add Profile
            addProfileText.click();
        } catch (TimeoutException e) {
            System.out.println("Add Profile text not clickable within the timeout period.");
        }
    }
}


