package com.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VODPage {
	private WebDriver driver;
	
	@FindBy(xpath = "//input[@placeholder='Search…']")
	private WebElement search;
	
	@FindBy(xpath = "//button[contains(text(),'VOD')]")
	private WebElement VOD;
	
	@FindBy(xpath = "//button[contains(text(),'Home')]")
	private WebElement HomeScreen;
	
	@FindBy(xpath = "(//*[contains(text(),'Blue Beetle')])[1]")
    private WebElement assetBlueBeetle;
	
	@FindBy(xpath = "(//*[@class='MuiButton-label'])[1]")
	private WebElement addMylist;
	
	@FindBy(xpath = "(//*[@class='MuiButton-label'])[3]")
	private WebElement share;
	
	@FindBy(xpath = "//*[@aria-label='close']")
	private WebElement closeCDpagebtn;
	
	@FindBy(xpath = "(//*[@aria-label='close'])[2]")
	private WebElement closesharebtn;
	                                  
	@FindBy(xpath = "(//*[@class='MuiButton-label'])[2]")
	private WebElement playbtn;
	
	@FindBy(xpath = "//*[@class='playkit-icon playkit-icon-rewind-10']")
	private WebElement backward;
	
	@FindBy(xpath = "//*[@class='playkit-icon playkit-icon-forward-10']")
	private WebElement forward;
	
	@FindBy(xpath = "//*[@class='playkit-video-area']")
	private WebElement playerdoubleclick;
	
	@FindBy(xpath = "//h5[contains(text(),'Action Movies')]")
	private WebElement actionRail;
	
	@FindBy(xpath = "(//button[@aria-label='Go to next slide'])[1]")
	private WebElement originalNextslide;

	@FindBy(xpath = "(//button[@aria-label='Go to next slide'])[2]")
	private WebElement ActionGotoNextSlide;
	
	@FindBy(xpath = "(//button[@aria-label='Go to next slide'])[3]")
	private WebElement smallrailNextSlide;
	
	@FindBy(xpath = "(//button[@aria-label='Go to next slide'])[4]")
    private WebElement smallrailsecNextSlide;
	
	@FindBy(xpath = "//*[@class='slick-arrow slick-next']")
	private WebElement bannerNextSlide;
	
	@FindBy(xpath = "(//button[contains(text(),'View All')])[1]")
	private WebElement viewall;
	
	@FindBy(xpath = "//*[@class='MuiSvgIcon-root MuiSvgIcon-colorPrimary']")
	private WebElement backbtnplayerscreen;
	
	@FindBy(xpath = "//*[contains(text(),'Mute')]")
	private WebElement muteUnmute;
	
	@FindBy(xpath = "//*[contains(text(),'Settings')]")
	private WebElement settings;
	
	@FindBy(xpath = "//button[@aria-label='Picture in picture']")
	private WebElement pictureinPicture;
	
	@FindBy(xpath = "//i[@class='playkit-icon playkit-icon-picture-in-picture-stop']")
	private WebElement pipstop;
	
	@FindBy(xpath = "(//*[contains(text(),'Terminator: Dark Fate ')])[1]")
	private WebElement actionMovies;
	
	@FindBy(xpath = "(//li[@class='react-multi-carousel-item react-multi-carousel-item--active image-item  aspect-[16/9] h-[7rem]'])[3]")
	private WebElement VIPasset;
	
	@FindBy(xpath = "//i[@class='playkit-icon playkit-icon-maximize']")
	private WebElement maximize;

	@FindBy(xpath = "//i[@class='playkit-icon playkit-icon-minimize']")
	private WebElement minimize;
	
	
	
	public VODPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getHomeScreen() {
		return HomeScreen;
	}


	public void setHomeScreen(WebElement homeScreen) {
		HomeScreen = homeScreen;
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


	public WebElement getCloseCDpagebtn() {
		return closeCDpagebtn;
	}


	public void setCloseCDpagebtn(WebElement closeCDpagebtn) {
		this.closeCDpagebtn = closeCDpagebtn;
	}


	public WebElement getPipstop() {
		return pipstop;
	}


	public void setPipstop(WebElement pipstop) {
		this.pipstop = pipstop;
	}


	public WebElement getViewall() {
		return viewall;
	}


	public void setViewall(WebElement viewall) {
		this.viewall = viewall;
	}

	public WebElement getVIPasset() {
		return VIPasset;
	}


	public void setVIPasset(WebElement vIPasset) {
		VIPasset = vIPasset;
	}


	public WebElement getBannerNextSlide() {
		return bannerNextSlide;
	}


	public void setBannerNextSlide(WebElement bannerNextSlide) {
		this.bannerNextSlide = bannerNextSlide;
	}

	public WebElement getSmallrailNextSlide() {
		return smallrailNextSlide;
	}

	public void setSmallrailNextSlide(WebElement smallrailNextSlide) {
		this.smallrailNextSlide = smallrailNextSlide;
	}


	public WebElement getSmallrailsecNextSlide() {
		return smallrailsecNextSlide;
	}


	public void setSmallrailsecNextSlide(WebElement smallrailsecNextSlide) {
		this.smallrailsecNextSlide = smallrailsecNextSlide;
	}


	public WebElement getOriginalNextslide() {
		return originalNextslide;
	}


	public void setOriginalNextslide(WebElement originalNextslide) {
		this.originalNextslide = originalNextslide;
	}


	public WebElement getActionMovies() {
		return actionMovies;
	}


	public void setActionMovies(WebElement actionMovies) {
		this.actionMovies = actionMovies;
	}


	public WebElement getPictureinPicture() {
		return pictureinPicture;
	}


	public void setPictureinPicture(WebElement pictureinPicture) {
		this.pictureinPicture = pictureinPicture;
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


	public WebElement getBackbtnplayerscreen() {
		return backbtnplayerscreen;
	}


	public void setBackbtnplayerscreen(WebElement backbtnplayerscreen) {
		this.backbtnplayerscreen = backbtnplayerscreen;
	}


	public WebElement getActionGotoNextSlide() {
		return ActionGotoNextSlide;
	}


	public void setActionGotoNextSlide(WebElement actionGotoNextSlide) {
		ActionGotoNextSlide = actionGotoNextSlide;
	}


	public WebElement getActionRail() {
		return actionRail;
	}


	public void setActionRail(WebElement actionRail) {
		this.actionRail = actionRail;
	}


	public WebElement getPlayerdoubleclick() {
		return playerdoubleclick;
	}



	public void setPlayerdoubleclick(WebElement playerdoubleclick) {
		this.playerdoubleclick = playerdoubleclick;
	}



	public WebElement getForward() {
		return forward;
	}



	public void setForward(WebElement forward) {
		this.forward = forward;
	}



	public WebElement getBackward() {
		return backward;
	}


	public void setBackward(WebElement backward) {
		this.backward = backward;
	}


	public WebElement getShare() {
		return share;
	}

	public WebElement getPlaybtn() {
		return playbtn;
	}

	public void setPlaybtn(WebElement playbtn) {
		this.playbtn = playbtn;
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




	public WebElement getAddMylist() {
		return addMylist;
	}


	public void setAddMylist(WebElement addMylist) {
		this.addMylist = addMylist;
	}


	public WebElement getAssetBlueBeetle() {
		return assetBlueBeetle;
	}


	public void setAssetBlueBeetle(WebElement assetBlueBeetle) {
		this.assetBlueBeetle = assetBlueBeetle;
	}


	public WebElement getVOD() {
		return VOD;
	}


	public void setVOD(WebElement vOD) {
		VOD = vOD;
	}


	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSearch() {
		return search;
	}

	public void setSearch(WebElement search) {
		this.search = search;
	}
	
}
