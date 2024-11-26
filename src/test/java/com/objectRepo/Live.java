package com.objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.genericmethods.BasePage;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Live extends BasePage {

    private WebDriverWait wait;

    @FindBy(xpath = "//button[contains(text(), 'SKIP')]")
    private WebElement skipButton;

    @FindBy(xpath = "//button[text()='Live']")
    private WebElement liveScreenButton;

    @FindBy(xpath = "//button[contains(text(), 'View All')]")
    private List<WebElement> viewAllButtons;

    @FindBy(xpath = "//p[contains(text(), 'Horizon') or contains(text(), 'Kaltura') or contains(text(), 'Terms Of Use') or contains(text(), 'Privacy Policy')]")
    private List<WebElement> bottomLinks;

    @FindBy(xpath = "//img[@alt='Image']")
    private List<WebElement> imageLinks;

    // Locate the image element with alt="CNN" using @FindBy annotation
    @FindBy(xpath = "//span[@class='lazy-load-image-background blur lazy-load-image-loaded']//img[@alt='CNN']")
    private WebElement cnnImageWrapper;

    // Constructor to initialize the page elements
    public Live(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Method to click the skip button
    public void clickSkipButton() {
        try {
            System.out.println("Attempting to click the skip button...");
            wait.until(ExpectedConditions.elementToBeClickable(skipButton)).click();
            Thread.sleep(2000); // Wait for 2 seconds to observe the action
            System.out.println("Skip button clicked successfully.");
        } catch (Exception e) {
            System.err.println("Error clicking skip button: " + e.getMessage());
        }
    }

    // Method to click the "Live" button (ensure we are on the Live page)
    public void clickLiveScreen() {
        try {
            System.out.println("Attempting to click the 'Live' button...");
            wait.until(ExpectedConditions.elementToBeClickable(liveScreenButton)).click();
            Thread.sleep(2000); // 2-second delay to observe the action
            System.out.println("'Live' button clicked successfully.");
        } catch (Exception e) {
            System.err.println("Error clicking 'Live' button: " + e.getMessage());
        }
    }

    // Method to click the CNN image (or its wrapper)
    public void clickCNNImage() {
        try {
            // Wait for the CNN image wrapper (span) to be clickable
            wait.until(ExpectedConditions.elementToBeClickable(cnnImageWrapper));

            // Use JavaScriptExecutor if the element still isn't clickable directly due to pointer-events issues
            if (!cnnImageWrapper.isEnabled()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cnnImageWrapper);
                System.out.println("CNN image clicked using JavaScript.");
            } else {
                cnnImageWrapper.click();
                System.out.println("CNN image wrapper clicked successfully.");
            }
        } catch (Exception e) {
            System.err.println("Error clicking CNN image: " + e.getMessage());
        }
    }

    // Scroll down the page and click all "View All" buttons
    public void clickAllViewAllButtons() {
        System.out.println("Attempting to click all 'View All' buttons...");
        wait.until(ExpectedConditions.visibilityOfAllElements(viewAllButtons));

        for (int i = 0; i < viewAllButtons.size(); i++) {
            try {
                WebElement viewAllButton = viewAllButtons.get(i);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewAllButton);
                wait.until(ExpectedConditions.elementToBeClickable(viewAllButton));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewAllButton);
                Thread.sleep(2000); // Wait for 2 seconds after each click to observe the transition
                System.out.println("Clicked 'View All' button: " + viewAllButton.getText());

                // Simulate waiting and navigating back
                Thread.sleep(2000); // Pause to see the back navigation action
                driver.navigate().back();
                wait.until(ExpectedConditions.visibilityOfAllElements(viewAllButtons));
            } catch (Exception e) {
                System.err.println("Error clicking 'View All' button: " + e.getMessage());
            }
        }
    }

    // Scroll down the page and click all bottom links (text and image links)
    public void clickAllBottomLinksAndNavigate() {
        System.out.println("Attempting to click all bottom links...");

        String mainWindowHandle = driver.getWindowHandle();
        wait.until(ExpectedConditions.visibilityOfAllElements(bottomLinks));

        for (WebElement link : bottomLinks) {
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
                link.click();
                Thread.sleep(2000); // Pause to see the transition before switching windows
                waitForNewWindow(mainWindowHandle);
                switchToNewWindow(mainWindowHandle);
                driver.close();
                driver.switchTo().window(mainWindowHandle);
            } catch (Exception e) {
                System.err.println("Error while processing text link: " + link.getText());
            }
        }

        // Now handle the image-based links
        for (WebElement imageLink : imageLinks) {
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", imageLink);
                imageLink.click();
                Thread.sleep(2000); // Pause to see the action before switching windows
                waitForNewWindow(mainWindowHandle);
                switchToNewWindow(mainWindowHandle);
                driver.close();
                driver.switchTo().window(mainWindowHandle);
            } catch (Exception e) {
                System.err.println("Error while processing image link: " + imageLink.getAttribute("alt"));
            }
        }
    }

    // Helper method to wait for a new window to open
    private void waitForNewWindow(String mainWindowHandle) {
        wait.until((driver) -> driver.getWindowHandles().size() > 1);
    }

    // Helper method to switch to the newly opened window
    private void switchToNewWindow(String mainWindowHandle) {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }
}


