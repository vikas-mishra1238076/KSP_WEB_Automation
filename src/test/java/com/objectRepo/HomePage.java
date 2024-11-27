package com.objectRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericmethods.Base;


public class HomePage extends Base {

    private WebDriver driver;
    //private int scrollCount = 0; 

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
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public WebDriver getDriver() {
		return driver;
	}


	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement getSliderLeft() {
		return sliderLeft;
	}


	public void setSliderLeft(WebElement sliderLeft) {
		this.sliderLeft = sliderLeft;
	}


	public WebElement getPremiumRailTitle() {
		return premiumRailTitle;
	}


	public void setPremiumRailTitle(WebElement premiumRailTitle) {
		this.premiumRailTitle = premiumRailTitle;
	}


	public WebElement getContinueWatchingRailTitle() {
		return continueWatchingRailTitle;
	}


	public void setContinueWatchingRailTitle(WebElement continueWatchingRailTitle) {
		this.continueWatchingRailTitle = continueWatchingRailTitle;
	}


	public WebElement getTrendingRailTitle() {
		return trendingRailTitle;
	}


	public void setTrendingRailTitle(WebElement trendingRailTitle) {
		this.trendingRailTitle = trendingRailTitle;
	}


	public WebElement getScifiAndFantasyElement() {
		return scifiAndFantasyElement;
	}


	public void setScifiAndFantasyElement(WebElement scifiAndFantasyElement) {
		this.scifiAndFantasyElement = scifiAndFantasyElement;
	}


	public WebElement getCrimeAndThrillerElement() {
		return crimeAndThrillerElement;
	}


	public void setCrimeAndThrillerElement(WebElement crimeAndThrillerElement) {
		this.crimeAndThrillerElement = crimeAndThrillerElement;
	}


	public WebElement getBlockBusterElement() {
		return blockBusterElement;
	}


	public void setBlockBusterElement(WebElement blockBusterElement) {
		this.blockBusterElement = blockBusterElement;
	}


	public WebElement getMustWatchMoviesElement() {
		return mustWatchMoviesElement;
	}


	public void setMustWatchMoviesElement(WebElement mustWatchMoviesElement) {
		this.mustWatchMoviesElement = mustWatchMoviesElement;
	}


	public WebElement getProfileIcon() {
		return profileIcon;
	}


	public void setProfileIcon(WebElement profileIcon) {
		this.profileIcon = profileIcon;
	}


	public WebElement getWatchAgainRailTitle() {
		return watchAgainRailTitle;
	}


	public void setWatchAgainRailTitle(WebElement watchAgainRailTitle) {
		this.watchAgainRailTitle = watchAgainRailTitle;
	}


	public WebElement getActionAdventuresRailTitle() {
		return actionAdventuresRailTitle;
	}


	public void setActionAdventuresRailTitle(WebElement actionAdventuresRailTitle) {
		this.actionAdventuresRailTitle = actionAdventuresRailTitle;
	}


	public WebElement getSliderRight() {
		return sliderRight;
	}


	public void setSliderRight(WebElement sliderRight) {
		this.sliderRight = sliderRight;
	}


	public WebElement getSkipButton() {
		return skipButton;
	}


	public void setSkipButton(WebElement skipButton) {
		this.skipButton = skipButton;
	}


	public List<WebElement> getViewAllButtons() {
		return viewAllButtons;
	}


	public void setViewAllButtons(List<WebElement> viewAllButtons) {
		this.viewAllButtons = viewAllButtons;
	}


	public List<WebElement> getBottomLinks() {
		return bottomLinks;
	}


	public void setBottomLinks(List<WebElement> bottomLinks) {
		this.bottomLinks = bottomLinks;
	}


	public List<WebElement> getImageLinks() {
		return imageLinks;
	}


	public void setImageLinks(List<WebElement> imageLinks) {
		this.imageLinks = imageLinks;
	}


	public WebElement getDaredevilDiv() {
		return daredevilDiv;
	}


	public void setDaredevilDiv(WebElement daredevilDiv) {
		this.daredevilDiv = daredevilDiv;
	}


	public WebElement getAddMyList() {
		return addMyList;
	}


	public void setAddMyList(WebElement addMyList) {
		this.addMyList = addMyList;
	}


	public WebElement getPlayButton() {
		return playButton;
	}


	public void setPlayButton(WebElement playButton) {
		this.playButton = playButton;
	}


	public WebElement getShareButton() {
		return shareButton;
	}


	public void setShareButton(WebElement shareButton) {
		this.shareButton = shareButton;
	}


	public WebElement getCloseButton() {
		return closeButton;
	}


	public void setCloseButton(WebElement closeButton) {
		this.closeButton = closeButton;
	}

    
    
    
    
    }



