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
	
	@FindBy(xpath="//section[@data-reactid='81']//a[text()='Recently Sold']")
	public WebElement AHMmenuRecentlySoldLink;
	
	@FindBy(xpath="//section[@data-reactid='81']//a[text()='New Homes']")
	public WebElement AHMmenuNewHomesLink;
	
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
	
	@FindBy(xpath="//*[@data-reactid='306']")
	public WebElement AHMsignInButton;
	
	@FindBy(xpath="//div[@class='mbs txtC h3 typeEmphasize']")
	public WebElement AHMsignInOrRegisterText;
	
	@FindBy(name="email")
	public WebElement usernameField;
	
	@FindBy(xpath="//button[@data-action='submit']")
	public WebElement submitButton;
	
	@FindBy(xpath="//div[@class='txtC h3 typeEmphasize']")
	public WebElement enterPasswordText;
	
	@FindBy(name="password")
	public WebElement passwordField;
	
	@FindBy(xpath="//span[@class='typeTruncate menu-personalized__userEmail___RajK']")
	public WebElement profileUserName;
	
	@FindBy(xpath="//*[@class='typeWarning typeCaps']/..")
	public List <WebElement> soldTexts;
	
	//==========================================================
	
	@FindBy(xpath="//a[@data-reactid='83']") 
	public WebElement menuBuyLink;
	
	@FindBy(xpath="//section[@data-reactid='81']//a")
	public List<WebElement> menuBuyList;
	
	@FindBy(xpath="//section[@data-reactid='81']//a[text()='Open Houses']")
	public WebElement menuOpenHousesLink;

	@FindBy(xpath="//a[@data-reactid='99']")
	public WebElement menuNewHomesLink;
	
	@FindBy(id="priceToggle")
	public WebElement buttonAnyPrice;
	
	@FindBy(id="minPrice")
	public WebElement displayNoMin;
	
	@FindBy(id="maxPrice")
	public WebElement displayNoMax;
	
	@FindBy(xpath="//a[@data-reactid='203']")
    public WebElement menuLocalScoopLink;
	
	@FindBy(xpath="//a[@data-reactid='224']")
	public WebElement menuCrime;

	 @FindBy(id="searchBox")
	public WebElement searchBox;
	 
	 //=====================================
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
		
		@FindBy(xpath="//*[@id=\"navbarContainer\"]//section[1]/ul/li[1]/ul/li[3]/a")
		public WebElement ILYbuyNewHomesLink;
		
		@FindBy(id="priceToggle")
		public WebElement ILYpriceToggle;
		
		@FindBy(id="minPrice")
		public WebElement ILYminPriceLink;

		
		@FindBy(id="maxPrice")
		public WebElement ILYmaxPriceLink;
		
		// ====================================== 
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
