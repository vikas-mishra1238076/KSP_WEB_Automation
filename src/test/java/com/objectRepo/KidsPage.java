package com.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KidsPage {
	private WebDriver driver;
	
	@FindBy(xpath = "//input[@placeholder='Search…']")
	private WebElement search;
	
	@FindBy(xpath = "(//*[contains(text(),'Kids')])[1]")
	private WebElement Kids;
	
	@FindBy(xpath = "//button[contains(text(),'Home')]")
	private WebElement HomeScreen;
	
	@FindBy(xpath = "//h6[contains(text(),'GOOSEBUMPS - Official Trailer (HD)')]")
	private WebElement assetclick;
	
	@FindBy(xpath = "(//*[@class='MuiButton-label'])[1]")
	private WebElement addmyList;
	
	@FindBy(xpath = "(//*[@class='MuiButton-label'])[3]")
	private WebElement share;
	
	@FindBy(xpath = "(//*[@aria-label='close'])[2]")
	private WebElement closesharebtn;
	
	@FindBy(xpath = "(//*[@class='MuiButton-label'])[2]")
	private WebElement play;
	
	@FindBy(xpath = "//*[@class='playkit-video-area']")
	private WebElement playerdoubleclick;
	
	@FindBy(xpath = "//*[@class='playkit-icon playkit-icon-rewind-10']")
	private WebElement backward;
	
	@FindBy(xpath = "//*[@class='playkit-icon playkit-icon-forward-10']")
	private WebElement forward;
	
	@FindBy(xpath = "//button[@aria-label='Mute']")
	private WebElement muteUnmute;
	
	@FindBy(xpath = "//*[contains(text(),'Settings')]")
	private WebElement settings;
	
	@FindBy(xpath = "//button[@aria-label='Picture in picture']")
	private WebElement pictureinPicture;
	
	@FindBy(xpath = "//i[@class='playkit-icon playkit-icon-picture-in-picture-stop']")
	private WebElement pipstop;
	
	@FindBy(xpath = "//i[@class='playkit-icon playkit-icon-maximize']")
	private WebElement maximize;
	
	@FindBy(xpath = "//i[@class='playkit-icon playkit-icon-minimize']")
	private WebElement minimize;
	
	@FindBy(xpath = "//*[@class='MuiSvgIcon-root MuiSvgIcon-colorPrimary']")
	private WebElement backbtnplayerscreen;
	
	@FindBy(xpath = "(//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeLarge'])[4]")
	private WebElement bannerslide;
	
	@FindBy(xpath = "(//button[@aria-label='Go to next slide'])[1]")
	private WebElement firstslide;
	
	@FindBy(xpath = "(//button[@aria-label='Go to next slide'])[2]")
	private WebElement secondslide;
	
	@FindBy(xpath = "(//button[@aria-label='Go to next slide'])[3]")
	private WebElement thirdslide;
	
	@FindBy(xpath = "(//button[@aria-label='Go to next slide'])[4]")
	private WebElement fourthslide;
	
	@FindBy(xpath = "(//button[@aria-label='Go to next slide'])[5]")
	private WebElement fifthslide;
	
	@FindBy(xpath = "(//button[@aria-label='Go to next slide'])[6]")
	private WebElement sixthslide;
	
	@FindBy(xpath = "(//button[@aria-label='Go to next slide'])[7]")
	private WebElement seventhslide;
	
	@FindBy(xpath = "(//button[@aria-label='Go to next slide'])[8]")
	private WebElement eightslide;
	
	@FindBy(xpath = "(//button[@aria-label='Go to next slide'])[9]")
	private WebElement ninthslide;
	

	public KidsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	
	public WebElement getHomeScreen() {
		return HomeScreen;
	}



	public void setHomeScreen(WebElement homeScreen) {
		HomeScreen = homeScreen;
	}



	public WebElement getSearch() {
		return search;
	}


	public void setSearch(WebElement search) {
		this.search = search;
	}



	public WebElement getEightslide() {
		return eightslide;
	}



	public void setEightslide(WebElement eightslide) {
		this.eightslide = eightslide;
	}



	public WebElement getNinthslide() {
		return ninthslide;
	}



	public void setNinthslide(WebElement ninthslide) {
		this.ninthslide = ninthslide;
	}



	public WebElement getBannerslide() {
		return bannerslide;
	}


	public void setBannerslide(WebElement bannerslide) {
		this.bannerslide = bannerslide;
	}



	public WebElement getFirstslide() {
		return firstslide;
	}



	public void setFirstslide(WebElement firstslide) {
		this.firstslide = firstslide;
	}


	public WebElement getSecondslide() {
		return secondslide;
	}


	public void setSecondslide(WebElement secondslide) {
		this.secondslide = secondslide;
	}


	public WebElement getThirdslide() {
		return thirdslide;
	}


	public void setThirdslide(WebElement thirdslide) {
		this.thirdslide = thirdslide;
	}


	public WebElement getFourthslide() {
		return fourthslide;
	}



	public void setFourthslide(WebElement fourthslide) {
		this.fourthslide = fourthslide;
	}


	public WebElement getFifthslide() {
		return fifthslide;
	}


	public void setFifthslide(WebElement fifthslide) {
		this.fifthslide = fifthslide;
	}


	public WebElement getSixthslide() {
		return sixthslide;
	}


	public void setSixthslide(WebElement sixthslide) {
		this.sixthslide = sixthslide;
	}


	public WebElement getSeventhslide() {
		return seventhslide;
	}


	public void setSeventhslide(WebElement seventhslide) {
		this.seventhslide = seventhslide;
	}


	public WebElement getBackbtnplayerscreen() {
		return backbtnplayerscreen;
	}


	public void setBackbtnplayerscreen(WebElement backbtnplayerscreen) {
		this.backbtnplayerscreen = backbtnplayerscreen;
	}


	public WebElement getMaximize() {
		return maximize;
	}


	public void setMaximize(WebElement maximize) {
		this.maximize = maximize;
	}


	public WebElement getMinimize() {
		return minimize;
	}


	public void setMinimize(WebElement minimize) {
		this.minimize = minimize;
	}


	public WebElement getPipstop() {
		return pipstop;
	}


	public void setPipstop(WebElement pipstop) {
		this.pipstop = pipstop;
	}


	public WebElement getMuteUnmute() {
		return muteUnmute;
	}


	public void setMuteUnmute(WebElement muteUnmute) {
		this.muteUnmute = muteUnmute;
	}


	public WebElement getSettings() {
		return settings;
	}


	public void setSettings(WebElement settings) {
		this.settings = settings;
	}


	public WebElement getPictureinPicture() {
		return pictureinPicture;
	}


	public void setPictureinPicture(WebElement pictureinPicture) {
		this.pictureinPicture = pictureinPicture;
	}


	public WebElement getPlayerdoubleclick() {
		return playerdoubleclick;
	}


	public void setPlayerdoubleclick(WebElement playerdoubleclick) {
		this.playerdoubleclick = playerdoubleclick;
	}


	public WebElement getBackward() {
		return backward;
	}


	public void setBackward(WebElement backward) {
		this.backward = backward;
	}


	public WebElement getForward() {
		return forward;
	}


	public void setForward(WebElement forward) {
		this.forward = forward;
	}


	public WebElement getAddmyList() {
		return addmyList;
	}


	public void setAddmyList(WebElement addmyList) {
		this.addmyList = addmyList;
	}


	public WebElement getShare() {
		return share;
	}


	public void setShare(WebElement share) {
		this.share = share;
	}


	public WebElement getClosesharebtn() {
		return closesharebtn;
	}


	public void setClosesharebtn(WebElement closesharebtn) {
		this.closesharebtn = closesharebtn;
	}


	public WebElement getPlay() {
		return play;
	}


	public void setPlay(WebElement play) {
		this.play = play;
	}


	public WebElement getAssetclick() {
		return assetclick;
	}


	public void setAssetclick(WebElement assetclick) {
		this.assetclick = assetclick;
	}


	public WebDriver getDriver() {
		return driver;
	}


	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement getKids() {
		return Kids;
	}


	public void setKids(WebElement kids) {
		Kids = kids;
	}
	
}
