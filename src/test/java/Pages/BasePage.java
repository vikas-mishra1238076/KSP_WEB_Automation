package Pages;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
 
public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
 
    // User credentials
    public String websiteUrl = "https://horizon-plus.d1538gwiw68ik8.amplifyapp.com/home";
    public String username = "ibc.jobst@gmail.com";
    public String password = "ibc2024$";
 
    // Constructor
    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        PageFactory.initElements(driver, this); // Initialize elements
    }
 
    // Navigate to the home page
    public void navigateToHomePage() {
        driver.get(websiteUrl);
    }
 
    // Screenshot method
    public void takeScreenshot(String testName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(screenshot, new File("screenshots/" + testName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }}