package com.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;

	@FindBy(xpath = "//p[contains(text(),'SIGN IN')]")
	private WebElement signincta;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement validEmail;

	@FindBy(xpath = "//input[@id='pass']")
	private WebElement validPassword;

	@FindBy(xpath = "//span[contains(text(),'SIGN IN')]")
	private WebElement Login;

	@FindBy(xpath = "(//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[2]/div[1])[1]")
	private WebElement loginProfile;

	@FindBy(xpath = "//button[contains(text(),'SKIP')]")
	private WebElement vivreSkip;

	@FindBy(xpath = "//p[text()='Please enter valid email']")
	public WebElement validEmailErrorMessage;

	@FindBy(xpath = "//p[text()='Email is required']")
	public WebElement emailRequiredErrorMessage;

	@FindBy(xpath = "//p[text()='Password is required']")
	public WebElement passwordRequiredErrorMessage;

	@FindBy(xpath = "//p[text()='Please enter valid email']")
	private WebElement emailErrorMessage;
	
	 @FindBy(xpath = "//p[contains(text(), 'Please click the “Forgot Password” button.')]")
	 private WebElement passwordErrorMessage;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	
	public WebElement getPasswordErrorMessage() {
		return passwordErrorMessage;
	}


	public void setPasswordErrorMessage(WebElement passwordErrorMessage) {
		this.passwordErrorMessage = passwordErrorMessage;
	}


	public WebElement getValidEmailErrorMessage() {
		return validEmailErrorMessage;
	}


	public void setValidEmailErrorMessage(WebElement validEmailErrorMessage) {
		this.validEmailErrorMessage = validEmailErrorMessage;
	}


	public WebElement getEmailRequiredErrorMessage() {
		return emailRequiredErrorMessage;
	}


	public void setEmailRequiredErrorMessage(WebElement emailRequiredErrorMessage) {
		this.emailRequiredErrorMessage = emailRequiredErrorMessage;
	}


	public WebElement getPasswordRequiredErrorMessage() {
		return passwordRequiredErrorMessage;
	}


	public void setPasswordRequiredErrorMessage(WebElement passwordRequiredErrorMessage) {
		this.passwordRequiredErrorMessage = passwordRequiredErrorMessage;
	}


	public WebElement getEmailErrorMessage() {
		return emailErrorMessage;
	}


	public void setEmailErrorMessage(WebElement emailErrorMessage) {
		this.emailErrorMessage = emailErrorMessage;
	}


	public WebElement getVivreSkip() {
		return vivreSkip;
	}

	public void setVivreSkip(WebElement vivreSkip) {
		this.vivreSkip = vivreSkip;
	}

	public WebElement getLoginProfile() {
		return loginProfile;
	}

	public void setLoginProfile(WebElement loginProfile) {
		this.loginProfile = loginProfile;
	}

	public WebElement getSignincta() {
		return signincta;
	}

	public void setSignincta(WebElement signincta) {
		this.signincta = signincta;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getValidEmail() {
		return validEmail;
	}

	public void setValidEmail(WebElement validEmail) {
		this.validEmail = validEmail;
	}

	public WebElement getValidPassword() {
		return validPassword;
	}

	public void setValidPassword(WebElement validPassword) {
		this.validPassword = validPassword;
	}

	public WebElement getLogin() {
		return Login;
	}

	public void setLogin(WebElement login) {
		Login = login;
	}
}