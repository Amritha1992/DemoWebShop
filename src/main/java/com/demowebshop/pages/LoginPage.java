package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.utilities.TestHelperUtility;

public class LoginPage extends TestHelperUtility {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private final String _emailField = "Email";
	@FindBy(xpath = _emailField)
	private WebElement emailField;

	private final String _passwordField = "Password";
	@FindBy(xpath = _passwordField)
	private WebElement passwordField;

	private final String _loginButton = "//input[@value='Login in']";
	@FindBy(xpath = _loginButton)
	private WebElement loginButton;

	public void enterUserEmailId(String username) {
		page.enterText(emailField,username );
	}

	public void enterUserPassword(String password) {
		page.enterText(passwordField, password);
	}

	public UserAccountPage clickOnLoginButton() {
		page.clickOnElement(loginButton);
		return new UserAccountPage(driver);
	}
}
