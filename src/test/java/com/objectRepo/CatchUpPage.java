package com.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatchUpPage {
	private WebDriver driver;
	
@FindBy(xpath = "//button[contains(text(),'CatchUp')]")
private WebElement catchupscreen;

@FindBy(xpath = "//button[contains(text(),'Home')]")
private WebElement HomeScreen;

@FindBy(xpath = "//button[@class='slick-arrow slick-next']")
private WebElement bannernextslide;

@FindBy(xpath = "//button[@class='slick-arrow slick-prev']")
private WebElement bannernPrevslide;

@FindBy(xpath = "(//*[@class='MuiButtonBase-root MuiIconButton-root custom-right-arrow-right'])[1]")
private WebElement firstNextSlide;

@FindBy(xpath = "(//*[@class='MuiButtonBase-root MuiIconButton-root custom-right-arrow-left'])[1]")
private WebElement firstpreviousslide;

@FindBy(xpath = "(//*[@class='MuiButtonBase-root MuiIconButton-root custom-right-arrow-right'])[2]")
private WebElement secondNextSlide;

@FindBy(xpath = "(//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeLarge'])[4]")
private WebElement secondpreviousslide;

@FindBy(xpath = "(//*[@class='MuiButtonBase-root MuiIconButton-root custom-right-arrow-right'])[3]")
private WebElement thirdNextSlide;

@FindBy(xpath = "(//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeLarge'])[5]")
private WebElement thirdpreviousslide;

@FindBy(xpath = "(//*[@class='MuiButtonBase-root MuiIconButton-root custom-right-arrow-right'])[4]")
private WebElement fourthslide;

@FindBy(xpath = "(//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeLarge'])[6]")
private WebElement fourthpreviousslide;
 
@FindBy(xpath = "(//*[@class='MuiButtonBase-root MuiIconButton-root custom-right-arrow-right'])[5]")
private WebElement fifthslide;

@FindBy(xpath = "(//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeLarge'])[7]")
private WebElement fifthpreviousslide;

@FindBy(xpath = "(//*[@class='MuiButtonBase-root MuiIconButton-root custom-right-arrow-right'])[6]")
private WebElement sixthslide;

@FindBy(xpath = "(//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeLarge'])[8]")
private WebElement sixthpreviousslide;

@FindBy(xpath = "//h6[contains(text(),'AFLHigh3 - Mini-Match _ Brisbane v Western Bulldog')]")
private WebElement catchupasset;

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



public CatchUpPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}


public WebElement getHomeScreen() {
	return HomeScreen;
}


public void setHomeScreen(WebElement homeScreen) {
	HomeScreen = homeScreen;
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


public WebElement getPipstop() {
	return pipstop;
}


public void setPipstop(WebElement pipstop) {
	this.pipstop = pipstop;
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


public WebElement getBackbtnplayerscreen() {
	return backbtnplayerscreen;
}


public void setBackbtnplayerscreen(WebElement backbtnplayerscreen) {
	this.backbtnplayerscreen = backbtnplayerscreen;
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


public WebElement getMuteUnmute() {
	return muteUnmute;
}


public void setMuteUnmute(WebElement muteUnmute) {
	this.muteUnmute = muteUnmute;
}


public WebElement getCatchupasset() {
	return catchupasset;
}


public void setCatchupasset(WebElement catchupasset) {
	this.catchupasset = catchupasset;
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


public WebElement getFifthpreviousslide() {
	return fifthpreviousslide;
}


public void setFifthpreviousslide(WebElement fifthpreviousslide) {
	this.fifthpreviousslide = fifthpreviousslide;
}


public WebElement getSixthpreviousslide() {
	return sixthpreviousslide;
}


public void setSixthpreviousslide(WebElement sixthpreviousslide) {
	this.sixthpreviousslide = sixthpreviousslide;
}


public WebElement getFourthpreviousslide() {
	return fourthpreviousslide;
}


public void setFourthpreviousslide(WebElement fourthpreviousslide) {
	this.fourthpreviousslide = fourthpreviousslide;
}


public WebElement getFirstpreviousslide() {
	return firstpreviousslide;
}


public void setFirstpreviousslide(WebElement firstpreviousslide) {
	this.firstpreviousslide = firstpreviousslide;
}


public WebElement getSecondpreviousslide() {
	return secondpreviousslide;
}


public void setSecondpreviousslide(WebElement secondpreviousslide) {
	this.secondpreviousslide = secondpreviousslide;
}


public WebElement getThirdpreviousslide() {
	return thirdpreviousslide;
}


public void setThirdpreviousslide(WebElement thirdpreviousslide) {
	this.thirdpreviousslide = thirdpreviousslide;
}


public WebElement getBannernextslide() {
	return bannernextslide;
}


public WebElement getFirstNextSlide() {
	return firstNextSlide;
}


public void setFirstNextSlide(WebElement firstNextSlide) {
	this.firstNextSlide = firstNextSlide;
}


public WebElement getSecondNextSlide() {
	return secondNextSlide;
}


public void setSecondNextSlide(WebElement secondNextSlide) {
	this.secondNextSlide = secondNextSlide;
}


public WebElement getThirdNextSlide() {
	return thirdNextSlide;
}


public void setThirdNextSlide(WebElement thirdNextSlide) {
	this.thirdNextSlide = thirdNextSlide;
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


public void setBannernextslide(WebElement bannernextslide) {
	this.bannernextslide = bannernextslide;
}


public WebElement getBannernPrevslide() {
	return bannernPrevslide;
}


public void setBannernPrevslide(WebElement bannernPrevslide) {
	this.bannernPrevslide = bannernPrevslide;
}


public WebDriver getDriver() {
	return driver;
}


public void setDriver(WebDriver driver) {
	this.driver = driver;
}


public WebElement getCatchupscreen() {
	return catchupscreen;
}


public void setCatchupscreen(WebElement catchupscreen) {
	this.catchupscreen = catchupscreen;
}



}
