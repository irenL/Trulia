package com.trulia.pages;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trulia.utilities.Driver;



public class HomePage {
	private WebDriver driver;

	public HomePage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	public boolean isAtTitle() {
		return driver.getTitle().equals("Trulia: Real Estate Listings, Homes For Sale, Housing Data");
	}
	public boolean isAtURL() {
		return driver.getCurrentUrl().equals("https://www.trulia.com/");
	}

	@FindBy(xpath="//a[@data-reactid='83']")
	public WebElement AHMmenuBuyLink;
	
	@FindBy(xpath="//section[@data-reactid='81']//a")
	public List<WebElement> AHMmenuBuyList;
	
	@FindBy(xpath="//section[@data-reactid='81']//a[text()='Open Houses']")
	public WebElement AHMmenuOpenHousesLink;
	
	@FindBy(xpath="//a[@data-reactid='203']")
	public WebElement AHMmenuLocalScoopLink;
	
	@FindBy(xpath="//section[@data-reactid='201']//a")
	public List<WebElement> AHMmenuLocalScoopList;
	
	@FindBy(xpath="//section[@data-reactid='201']//a[text()='Schools']")
	public WebElement AHMmenuShoolsLink;
	
	@FindBy(xpath="//section[@data-reactid='201']//a[text()='Market Trends']")
	public WebElement AHMmenuMarketTrendsLink;
	
	@FindBy(xpath="//*[@data-reactid='67']")
	public WebElement AHMlogoSVG;
	
	
	@FindBy(xpath = "//li/button[contains(text(),'Sign In')]")
	public WebElement signInButtonIL;
	
	@FindBy(xpath = "//form[@name='email_login_form']/div/div[1]")
	public WebElement popUpTitleIL;

	@FindBy(xpath = "//div[@class='fieldItem text pbm']/input ")
	public WebElement enterEmailAddressFieldIL;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public WebElement submitButtonIL;

	@FindBy(name = "password")
	public WebElement enterPasswordFieldIL;

	@FindBy(xpath = "//div[@class='field']/button")
	public WebElement signInPasswordButtonIL;

	@FindBy(xpath = "//a//span[contains(text(),'Irinatestapp')]")
	public WebElement accountLinkIL;

	@FindBy(id = "searchBox")
	public WebElement searchFieldIL;

	@FindBy(xpath = "//i[@class='css-13qxxkb iconSearch']")
	public WebElement searchButtonIL;

	@FindBy(xpath = "//a[@href='/logout/']")
	public WebElement logOutOfAccountIL;
	
	// Ahmed please DO NOT DELETE this method because smoke will not work 
	public boolean signInIsDisplayed() {
		boolean signin;

		try {
			signin = signInButtonIL.isDisplayed();
		} catch (NoSuchElementException e) {
			signin = false;
		}
		return signin;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
