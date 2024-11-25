package Pages;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
 
public class SignIn extends BasePage {
 
    // WebElements for sign-in interaction
    @FindBy(xpath = "(//button[@type='button' and @aria-haspopup='true'])[1]") 
    public WebElement profileIcon;
 
    @FindBy(xpath = "(//p[contains(@class, 'MuiTypography-root') and contains(@class, 'MuiTypography-body1')])[2]") 
    public WebElement signInOption;
    @FindBy(xpath = "//p[text()='SIGN UP']") 
    public WebElement signUpOption; // WebElement for SIGN UP option
    @FindBy(id = "firstName") // For First Name input field
    public WebElement firstNameInput;
 
    @FindBy(id = "lastName") // For Last Name input field
    public WebElement lastNameInput;
 
    @FindBy(id = "email") // For Email input field
    public WebElement emailInput;
 
    @FindBy(id = "pass") // For Password input field
    public WebElement passwordInput;
 
    @FindBy(xpath = "//span[text()='SIGN UP']") // For SIGN UP button
    public WebElement signUpButton;
    // Locate the error messages
    @FindBy(xpath = "//p[contains(@class, 'MuiFormHelperText-root') and contains(@class, 'Mui-error') and text()[normalize-space() = 'FirstName is required']]")
    private WebElement firstNameErrorMessage;
    @FindBy(xpath = "//p[contains(@class, 'MuiFormHelperText-root') and contains(@class, 'Mui-error') and text()[normalize-space() = 'LastName is required']]")
    private WebElement lastNameErrorMessage;
 
    @FindBy(xpath = "//p[contains(@class, 'MuiFormHelperText-root') and contains(@class, 'Mui-error') and text()[normalize-space() = 'Email is required']]")
    private WebElement emailErrorMessage;
 
    @FindBy(xpath = "//p[contains(@class, 'MuiFormHelperText-root') and text() = ' Use 8 or more characters which contains alphanumeric characters.']")
    private WebElement passwordErrorMessage;
 
    // Constructor
    public SignIn(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    // Navigate to the home page
    public void navigateToHomePage() {
        driver.get("https://horizon-plus.d1538gwiw68ik8.amplifyapp.com/home");
    }
 
    public void initiateLogin() throws InterruptedException {
        Thread.sleep(4000); // Wait for animation to complete
        clickProfileIcon(); // Click profile icon
        clickSignInOption(); // Click sign-in option
    }
 
    // Click profile icon
    public void clickProfileIcon() {
        clickElement(profileIcon);
    }
 
    // Click sign-in option
    public void clickSignInOption() {
        clickElement(signInOption);
    }
    // Click sign-up option
    public void clickSignUpOption() {
        clickElement(signUpOption); // Click on SIGN UP option
    }
 
    // Method to enter first name
    public void enterFirstName(String firstName) {
        firstNameInput.clear(); // Clear existing text, if any
        firstNameInput.sendKeys(firstName); // Enter first name
    }
 
    // Method to enter last name
    public void enterLastName(String lastName) {
        lastNameInput.clear(); // Clear existing text, if any
        lastNameInput.sendKeys(lastName); // Enter last name
    }
 
    // Method to enter email
    public void enterEmail(String email) {
        emailInput.clear(); // Clear existing text, if any
        emailInput.sendKeys(email); // Enter email
    }
 
    // Method to enter password
    public void enterPassword(String password) {
        passwordInput.clear(); // Clear existing text, if any
        passwordInput.sendKeys(password); // Enter password
    }
 
    // Click sign-up button
    public void clickSignUpButton() {
        clickElement(signUpButton); // Click on SIGN UP button
    }
 
    // Get error message for first name
    public String getFirstNameErrorMessage() {
        return firstNameErrorMessage.getText();
    }
 
    // Get error message for last name
    public String getLastNameErrorMessage() {
        return lastNameErrorMessage.getText();
    }
 
    // Get error message for email
    public String getEmailErrorMessage() {
        return emailErrorMessage.getText();
    }
 
    // Get error message for password
    public String getPasswordErrorMessage() {
        return passwordErrorMessage.getText();
    }
 
    // Utility method to click an element
    private void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}