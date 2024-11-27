package com.objectRepo;

	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericmethods.Base;

	public class SignUpPage extends Base {

	    @FindBy(xpath = "(//button[@type='button' and @aria-haspopup='true'])[1]")
	    public WebElement profileIcon;

//	    @FindBy(xpath = "(//p[contains(@class, 'MuiTypography-root') and contains(@class, 'MuiTypography-body1')])[2]")
//	    public WebElement signInOption;
	    
	    @FindBy(xpath = "//p[contains(text(),'SIGN IN')]")
		private WebElement signincta;

	    @FindBy(xpath = "//p[text()='SIGN UP']")
	    public WebElement signUpOption;

	    @FindBy(id = "firstName")
	    public WebElement firstNameInput;

	    @FindBy(id = "lastName")
	    public WebElement lastNameInput;

	    @FindBy(id = "email")
	    public WebElement emailInput;

	    @FindBy(id = "pass")
	    public WebElement passwordInput;

	    @FindBy(xpath = "//span[text()='SIGN UP']")
	    public WebElement signUpButton;

	    @FindBy(xpath = "//p[contains(@class, 'MuiFormHelperText-root') and contains(@class, 'Mui-error') and text()[normalize-space() = 'FirstName is required']]")
	    private WebElement firstNameErrorMessage;

	    @FindBy(xpath = "//p[contains(@class, 'MuiFormHelperText-root') and contains(@class, 'Mui-error') and text()[normalize-space() = 'LastName is required']]")
	    private WebElement lastNameErrorMessage;

	    @FindBy(xpath = "//p[contains(@class, 'MuiFormHelperText-root') and contains(@class, 'Mui-error') and text()[normalize-space() = 'Email is required']]")
	    private WebElement emailErrorMessage;

	    @FindBy(xpath = "//p[contains(@class, 'MuiFormHelperText-root') and text() = ' Use 8 or more characters which contains alphanumeric characters.']")
	    private WebElement passwordErrorMessage;
	    
	    public SignUpPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);

}

	    
		public WebElement getSignincta() {
			return signincta;
		}


		public void setSignincta(WebElement signincta) {
			this.signincta = signincta;
		}


		public WebElement getProfileIcon() {
			return profileIcon;
		}

		public void setProfileIcon(WebElement profileIcon) {
			this.profileIcon = profileIcon;
		}

		public WebElement getSignUpOption() {
			return signUpOption;
		}

		public void setSignUpOption(WebElement signUpOption) {
			this.signUpOption = signUpOption;
		}

		public WebElement getFirstNameInput() {
			return firstNameInput;
		}

		public void setFirstNameInput(WebElement firstNameInput) {
			this.firstNameInput = firstNameInput;
		}

		public WebElement getLastNameInput() {
			return lastNameInput;
		}

		public void setLastNameInput(WebElement lastNameInput) {
			this.lastNameInput = lastNameInput;
		}

		public WebElement getEmailInput() {
			return emailInput;
		}

		public void setEmailInput(WebElement emailInput) {
			this.emailInput = emailInput;
		}

		public WebElement getPasswordInput() {
			return passwordInput;
		}

		public void setPasswordInput(WebElement passwordInput) {
			this.passwordInput = passwordInput;
		}

		public WebElement getSignUpButton() {
			return signUpButton;
		}

		public void setSignUpButton(WebElement signUpButton) {
			this.signUpButton = signUpButton;
		}

		public WebElement getFirstNameErrorMessage() {
			return firstNameErrorMessage;
		}

		public void setFirstNameErrorMessage(WebElement firstNameErrorMessage) {
			this.firstNameErrorMessage = firstNameErrorMessage;
		}

		public WebElement getLastNameErrorMessage() {
			return lastNameErrorMessage;
		}

		public void setLastNameErrorMessage(WebElement lastNameErrorMessage) {
			this.lastNameErrorMessage = lastNameErrorMessage;
		}

		public WebElement getEmailErrorMessage() {
			return emailErrorMessage;
		}

		public void setEmailErrorMessage(WebElement emailErrorMessage) {
			this.emailErrorMessage = emailErrorMessage;
		}

		public WebElement getPasswordErrorMessage() {
			return passwordErrorMessage;
		}

		public void setPasswordErrorMessage(WebElement passwordErrorMessage) {
			this.passwordErrorMessage = passwordErrorMessage;
		}
	    
	    
	}
	
