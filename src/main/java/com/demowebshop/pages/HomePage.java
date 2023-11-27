package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.utilities.TestHelperUtility;

public class HomePage extends TestHelperUtility
{
	public WebDriver driver;	
	public HomePage(WebDriver driver)
	{
        this.driver = driver;
        PageFactory.initElements(driver,this);
	}
	//input emailfield
	private final String _subEmailField="newsletter-email";//id is pasted
	@FindBy(id=_subEmailField)//if xpath is used rename id and given as xpath
	private WebElement subEmailField;
	
	//find subscribe button
	private final String _subButton="//input[@id='newsletter-subscribe-button']";
	@FindBy(xpath=_subButton)
	private WebElement subButton;
	
	private final String _subMessage="newsletter-result-block";
	@FindBy(id=_subButton)
	private WebElement subMessage;
	private final String _loginLink="//a[@class='ico-login']";
	@FindBy(xpath=_loginLink)
	private WebElement loginLink;
	public String getHomePageTitle()
	{
		String title=page.getPageTitle(driver);
		return title;
		
		}
	public void enterSubEmailID()//method of tc_002
	{
		String emailID=random.getRandomEmail();
		page.enterText(subEmailField, emailID);
	}
	//method to click subscribe button
	public void clickSubButton()
	{
		subButton.click();
	}
	//method to find message element
	public String getSubMessage()
	{
		//wait.waitForElementToBeVisible(driver,subMessage);
		wait.setHardWait();//to stop execution
		String subscribeMessage=page.getElementText(subMessage);
		return subscribeMessage;
		
	}
	public LoginPage clickOnLoginLink()
	{
		page.clickOnElement(loginLink);
		return new LoginPage(driver);
	}
	}
	

