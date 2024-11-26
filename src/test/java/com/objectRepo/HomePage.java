package com.objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;


public class HomePage extends BasePage {

    private WebDriverWait wait;
    private int scrollCount = 0; 

    // WebElements for general slider actions
    @FindBy(xpath = "//button[contains(@class, 'slick-arrow slick-prev')]")
    public WebElement sliderLeft;

    @FindBy(xpath = "//h5[contains(text(), 'Premium')]")
    public WebElement premiumRailTitle;

    @FindBy(xpath = "//h5[contains(text(), 'Continue Watching for ibc jobst')]")
    public WebElement continueWatchingRailTitle;

    @FindBy(xpath = "//h5[text()='Trending Now']")
    public WebElement trendingRailTitle;

    @FindBy(xpath = "//h5[text()='Scifi & Fantasy']")
    WebElement scifiAndFantasyElement;

    @FindBy(xpath = "//h5[text()='Crime & Thriller']")
    WebElement crimeAndThrillerElement;

    @FindBy(xpath = "//h5[text()='BlockBuster - MultiSubtitle/Audio' and contains(@class, 'MuiTypography-h5')]")
    WebElement blockBusterElement;

    @FindBy(xpath = "//h5[text()='Must Watch Movies']")
    WebElement mustWatchMoviesElement;

    // WebElements for login interaction
    @FindBy(xpath = "(//button[@type='button' and @aria-haspopup='true'])[1]")
    public WebElement profileIcon;

    @FindBy(xpath = "//h5[text()='Watch again']")
    public WebElement watchAgainRailTitle;

    @FindBy(xpath = "//h5[text()='Action & Adventures']")
    public WebElement actionAdventuresRailTitle;

    @FindBy(xpath = "//button[contains(@class, 'slick-arrow slick-next')]")
    public WebElement sliderRight;

    @FindBy(xpath = "//button[contains(text(), 'SKIP')]")
    private WebElement skipButton;

    // Use a single XPath to locate all "View All" buttons
    @FindBy(xpath = "//button[contains(text(), 'View All')]")
    private List<WebElement> viewAllButtons;
    
 // Locating all the links at the bottom by their text (you can also use other attributes if needed)
    @FindBy(xpath = "//p[contains(text(), 'Horizon') or contains(text(), 'Kaltura') or contains(text(), 'Terms Of Use') or contains(text(), 'Privacy Policy')]")
    private List<WebElement> bottomLinks;
    
 // Locate image links by the 'alt' attribute (you can add specific 'alt' text here)
    @FindBy(xpath = "//img[@alt='Image']")
    private List<WebElement> imageLinks;
    
 // XPath for the div that contains the h6 element with text 'Daredevil'
    @FindBy(xpath = "//div[h6[text()='Daredevil']]")
    private WebElement daredevilDiv;

    // XPath for the first button matching the class criteria
    @FindBy(xpath = "(//button[contains(@class, 'MuiButtonBase-root') and contains(@class, 'MuiButton-outlined')])[1]")
    private WebElement addMyList;
    
    

    // XPath for the second button matching the class criteria
    @FindBy(xpath = "(//button[contains(@class, 'MuiButtonBase-root') and contains(@class, 'MuiButton-outlined')])[2]")
    private WebElement playButton;

    // XPath for the third button with a specific background gradient
    @FindBy(xpath = "(//button[contains(@class, 'MuiButtonBase-root') and contains(@class, 'MuiButton-outlined') and contains(@style, 'background-image: linear-gradient')])[3]")
    private WebElement shareButton;
    
  

    @FindBy(xpath = "//button[@aria-label='close']")
    private WebElement closeButton;
    
    
    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Method to click the skip button
    public void clickSkipButton() {
        try {
            System.out.println("Attempting to click the skip button...");
            wait.until(ExpectedConditions.elementToBeClickable(skipButton)).click();
            System.out.println("Skip button clicked successfully.");
        } catch (Exception e) {
            System.err.println("Error clicking skip button: " + e.getMessage());
        }
    }

    
    
    
    public void clickAllViewAllButtons() {
        System.out.println("Attempting to click all 'View All' buttons...");

        // Wait for the "View All" buttons to be present
        wait.until(ExpectedConditions.visibilityOfAllElements(viewAllButtons));

        // Iterate through each "View All" button
        for (int i = 0; i < viewAllButtons.size(); i++) {
            try {
                // Re-locate the "View All" buttons every time before interacting with them
                WebElement viewAllButton = viewAllButtons.get(i);

                // Scroll to the button before clicking, in case it's not in the viewport
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewAllButton);

                // Wait until the button is clickable, with additional timeout handling for dynamic content
                wait.until(ExpectedConditions.elementToBeClickable(viewAllButton));

                // Handle potential overlay elements before clicking
                try {
                    // Wait until any blocking overlays disappear
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[contains(@class, 'MuiButtonBase-root')]")));
                } catch (Exception e) {
                    System.err.println("Overlay still visible: " + e.getMessage());
                }

                // Try to click the "View All" button using JavaScript (in case it's obscured)
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewAllButton);
                System.out.println("Clicked 'View All' button: " + viewAllButton.getText());

                // Wait for 1 minute after clicking the "View All" button to observe the UI change
                System.out.println("Waiting for 1 minute to observe the UI change...");
                Thread.sleep(2000);  // Wait for 1 minute

                // After the click, navigate back to the homepage
                driver.navigate().back();

                // Wait for the page to reload and for the "View All" buttons to be visible again
                wait.until(ExpectedConditions.visibilityOfAllElements(viewAllButtons));

                // Scroll down to the next "View All" button after returning to the homepage
                if (i < viewAllButtons.size() - 1) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewAllButtons.get(i + 1));
                }

                System.out.println("Waiting for the next 'View All' button...");

            } catch (Exception e) {
                System.err.println("Error clicking 'View All' button at index " + (i + 1) + ": " + e.getMessage());
            }
        }

        System.out.println("All 'View All' buttons clicked.");
    }

    
    
    


    
    
 // Method to scroll slowly to the bottom and then back to the top by simulating down and up arrow keys
    public void scrollSlowlyToBottomAndBack() {
        System.out.println("Scrolling slowly to the bottom and then back to the top using down and up arrow keys...");

        // Create Actions instance to simulate key presses
        Actions actions = new Actions(driver);

        // Simulate pressing the "down" key 97 times to scroll to the bottom
        for (int i = 0; i < 97; i++) {
            actions.sendKeys(Keys.DOWN).build().perform(); // Press down key
            try {
                Thread.sleep(500); // Wait for 500ms between key presses to observe the scroll
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Wait for a moment at the bottom
        try {
            Thread.sleep(2000); // Wait for 2 seconds at the bottom to observe
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Simulate pressing the "up" key 97 times to scroll back to the top
        for (int i = 0; i < 97; i++) {
            actions.sendKeys(Keys.UP).build().perform(); // Press up key
            try {
                Thread.sleep(500); // Wait for 500ms between key presses to observe the scroll
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Wait for a moment at the top
        try {
            Thread.sleep(2000); // Wait for 2 seconds at the top to observe
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished scrolling to the bottom and back to the top.");
    }

    



    

 // Method to click on all the links at the bottom (both text and image links) and navigate through the windows
    public void clickAllBottomLinksAndNavigate() {
        System.out.println("Attempting to click all bottom links and navigate...");

        // Get the current window handle (this will be the main page)
        String mainWindowHandle = driver.getWindowHandle();

        // Wait for the bottom links to be visible (ensure links are present on the page)
        wait.until(ExpectedConditions.visibilityOfAllElements(bottomLinks));

        // Iterate over each bottom text link and handle the navigation
        for (WebElement link : bottomLinks) {
            try {
                // Click the text-based link
                System.out.println("Clicking on text link: " + link.getText());
                link.click();

                // Wait for 30 seconds after clicking the link to observe the action
                Thread.sleep(2000); // 30 seconds wait to see the action

                // Wait for the new window or tab to open
                waitForNewWindow(mainWindowHandle);

                // Switch to the new window (the newly opened tab or window)
                Set<String> windowHandles = driver.getWindowHandles();
                String newWindowHandle = getNewWindowHandle(windowHandles, mainWindowHandle);

                driver.switchTo().window(newWindowHandle);
                System.out.println("Switched to new window/tab.");

                // Wait for 2 seconds after switching to the new window to observe the action
                Thread.sleep(2000); // 30 seconds wait to observe

                // After performing any actions in the new window, close it and return to the main window
                driver.close();
                driver.switchTo().window(mainWindowHandle);
                System.out.println("Returned to the main window.");

                // Wait before continuing to the next link (optional)
                Thread.sleep(2000); // 2 seconds wait to observe the return to the main window

            } catch (Exception e) {
                System.err.println("Error while processing text link: " + link.getText() + " - " + e.getMessage());
            }
        }

        // Now handle the image-based links
        List<WebElement> imageLinks = driver.findElements(By.xpath("//img[@alt='Image']"));

        // Iterate over each image link and handle the navigation
        for (WebElement imageLink : imageLinks) {
            try {
                // Click the image-based link
                System.out.println("Clicking on image link with alt text: " + imageLink.getAttribute("alt"));
                imageLink.click();

                // Wait for 2 seconds after clicking the image to observe the action
                Thread.sleep(2000); // 2 seconds wait to observe the action

                // Wait for the new window or tab to open
                waitForNewWindow(mainWindowHandle);

                // Switch to the new window (the newly opened tab or window)
                Set<String> windowHandles = driver.getWindowHandles();
                String newWindowHandle = getNewWindowHandle(windowHandles, mainWindowHandle);

                driver.switchTo().window(newWindowHandle);
                System.out.println("Switched to new window/tab.");

                // Wait for 2 seconds after switching to the new window to observe the action
                Thread.sleep(2000); // 30 seconds wait to observe

                // After performing any actions in the new window, close it and return to the main window
                driver.close();
                driver.switchTo().window(mainWindowHandle);
                System.out.println("Returned to the main window.");

                // Wait before continuing to the next image link (optional)
                Thread.sleep(2000); // 2 seconds wait to observe the return to the main window

            } catch (Exception e) {
                System.err.println("Error while processing image link: " + imageLink.getAttribute("alt") + " - " + e.getMessage());
            }
        }

        System.out.println("All bottom links and image links processed.");
    }

    // Helper method to wait for a new window or tab to open
    private void waitForNewWindow(String mainWindowHandle) {
        wait.until((driver) -> driver.getWindowHandles().size() > 1);
    }

    // Helper method to get the new window handle
    private String getNewWindowHandle(Set<String> windowHandles, String mainWindowHandle) {
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                return handle;
            }
        }
        return null; // In case no new window is found, but this should not happen
    }

 // Method to scroll and click the content option
    public void scrollAndClickContentOption(String option) {
        // Decide the number of scrolls based on whether it's the first, second, or subsequent times
        int scrollTimes = (scrollCount == 0) ? 20 : (scrollCount == 1) ? 5 : 0; // 20 for the first time, 5 for the second time, 0 for subsequent

        System.out.println("Scrolling slowly to the bottom...");

        // Create Actions instance to simulate key presses
        Actions actions = new Actions(driver);

        // Scroll the specified number of times
        for (int i = 0; i < scrollTimes; i++) {
            actions.sendKeys(Keys.DOWN).build().perform(); // Press down key
            try {
                Thread.sleep(500); // Wait for 500ms between key presses
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Finished scrolling " + scrollTimes + " times.");

        // Increment scroll count after performing the scroll
        scrollCount++;

        // Now call the clickContentOptions method to click the specified option
        System.out.println("Now clicking the content option: " + option);
        clickContentOptions(option);  // Click the option (after scrolling if needed)
    }

    public void clickContentOptions(String option) {
        try {
            // Create an explicit wait for elements to become clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for up to 10 seconds
            
            switch (option.toLowerCase()) {
                case "daredevil":
                    WebElement daredevilDiv = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[h6[text()='Daredevil']]")));
                    daredevilDiv.click();
                    System.out.println("Clicked on Daredevil div.");
                    break;

                case "addmylist":
                    WebElement addMyList = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                        "(//button[contains(@class, 'MuiButtonBase-root') and contains(@class, 'MuiButton-outlined') and contains(@style, 'background-image: linear-gradient')])[1]")));
                    addMyList.click();
                    System.out.println("Clicked on Add My List button.");
                    break;

//                case "share":
//                    WebElement shareButton = wait.until(ExpectedConditions.elementToBeClickable(
//                        By.xpath("(//button[contains(@class, 'MuiButtonBase-root') and contains(@class, 'MuiButton-outlined') and contains(@style, 'background-image: linear-gradient')])[3]")));
//                    shareButton.click();
//                    System.out.println("Clicked on Share button.");
//                    break;

//                case "closeButton":
//                    // Locate the close button
//                    WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(
//                        By.xpath("//*[@class='MuiButtonBase-root MuiIconButton-root jss676']")));
//                    
//                    // Scroll into view if not in viewport
//                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", closeButton);
//                    
//                    // Retry clicking after waiting a bit more if necessary
//                    closeButton.click();
//                    System.out.println("Clicked on Close button.");
//                    break;

                case "play":
                    WebElement playButton = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-outlinedSizeSmall MuiButton-sizeSmall'])[2]\n"
                        		+ ""))); // Adjust this XPath according to the "Play" button
                    playButton.click();
                    System.out.println("Clicked on Play button.");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error clicking option: " + option);
            e.printStackTrace();
        }
    }

                    
    
    

                    
//                case "closeButton":
//                    // Use your original XPath for Share button
//                    WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(
//                        By.xpath("//button[@aria-label='close']")));
//                    closeButton.click();
//                    
//                    System.out.println("Clicked on Share button.");
//                    break;
                    
                    
               
                    	
                    
                    
                    
                    

                    
                    
                    
                    
                    
                    
                    
                    
                    
//                  case "play":
//                 
//                  WebElement playButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'MuiButtonBase-root') and contains(@class, 'MuiButton-outlined')])[2]")));
//                  playButton.click();
//                  System.out.println("Clicked on Play button.");
//                  break;






    // Helper method to wait for UI changes after clicking "View All"
    private void waitForUIChange() {
        try {
            // You could replace this with a specific condition that checks the page's change, for example:
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("someChangedElement")));
            // For now, it waits for 1 minute using Thread.sleep to simulate the manual confirmation
            Thread.sleep(2000); // Wait for 1 minute
        } catch (InterruptedException e) {
            System.err.println("Waiting for UI change was interrupted: " + e.getMessage());
        }
    }

    // Method to verify if the profile icon is visible (indicating a successful login)
    public boolean isProfileIconVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOf(profileIcon));
            System.out.println("Profile icon is visible, user is logged in.");
            return true; // Return true if profile icon is visible
        } catch (Exception e) {
            System.err.println("Profile icon is not visible, login might have failed.");
            return false; // Return false if profile icon is not visible
        }
    }

    // Method to verify the presence of all required rails
    public void verifyAllRailsPresent() {
        // List of all rail elements for easy iteration
        List<WebElement> rails = List.of(premiumRailTitle, continueWatchingRailTitle, trendingRailTitle,
                                         scifiAndFantasyElement, crimeAndThrillerElement, blockBusterElement,
                                         mustWatchMoviesElement, watchAgainRailTitle, actionAdventuresRailTitle);

        System.out.println("Verifying the presence of all rails...");

        // Check each rail's presence and log the result
        for (WebElement rail : rails) {
            try {
                wait.until(ExpectedConditions.visibilityOf(rail));
                System.out.println("Rail is present: " + rail.getText());
            } catch (Exception e) {
                System.err.println("Rail is NOT present: " + rail.toString());
            }
        }
    }
}


