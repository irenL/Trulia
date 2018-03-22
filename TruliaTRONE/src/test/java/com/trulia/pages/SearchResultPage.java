package com.trulia.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trulia.utilities.Driver;

public class SearchResultPage {
	private WebDriver driver;
	public SearchResultPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="locationInputs")
	public WebElement AHMsearchBar;
	
	@FindBy(xpath="//button[@data-auto-test-id='searchButton']")
	public WebElement AHMsearchBtn;
	
	@FindBy(tagName="h1")
	public WebElement AHMh1;
	
	@FindBy(id="bedroomsToggle")
	public WebElement AHMallBedsBtn;
	
	@FindBy(xpath="//div[@id='bedroomsButtonGroup']//button")
	public List<WebElement> AHMallBedsOptions;
	
	@FindBy(xpath="//div[@id='bedroomsButtonGroup']//button[.='4+']")
	public WebElement AHMallBedsOption4PLUS;
	
	@FindBy(xpath="//div[@id='bedroomsButtonGroup']//button[.='1+']")
	public WebElement AHMallBedsOption1PLUS;

	@FindBy(xpath="//*[@id=\'navbarContainer\']//section[1]/header/a")
	public WebElement buyLink;
	
	@FindBy(xpath="//*[@id=\'navbarContainer\']//section[1]/ul//a")
	public List<WebElement> buyLinkMenu;
	
	@FindBy(xpath="(//*[@id=\"navbarContainer\"]//section[1]/ul//a)[1]")
	public WebElement homesForSaleButton;
	
	@FindBy(id="homeTypeToggle")
	public WebElement allHomeTypesButton;
	
	@FindBy(xpath="//*[@id=\"homeTypesDropdown\"]//label")
	public List<WebElement> allHomeTypesMenu;
	
	@FindBy(xpath="//*[@id=\"homeTypesDropdown\"]//div[1]/div[1]/span")
	public WebElement houseButton;
	
	@FindBy(xpath="//*[@id=\"homeTypesDropdown\"]//div[1]/div[2]")
	public WebElement condoButton;
	
	@FindBy(xpath="//*[@id=\"homeTypesDropdown\"]//div[1]/div[3]")
	public WebElement townHomeButton;
	
	@FindBy(xpath="//*[@id=\"homeTypesDropdown\"]//div[2]/div[1]")
	public WebElement landButton;
	
	@FindBy(xpath="//*[@id=\"homeTypesDropdown\"]//div[4]//label")
	public WebElement multiFamilyButton;
	
	@FindBy(xpath="//*[@id=\"homeTypesDropdown\"]//div//div[2]//div[2]")
	public WebElement mobileManufactureButton;
	
	@FindBy(xpath="//*[@id=\"homeTypesDropdown\"]//div/div[2]/div[3]")
	public WebElement otherButton;
	
	
	
	
	
	
	
	@FindBy(xpath="//*[@id=\"srpHeaderLeftColumn\"]//h2")
	public WebElement resultsColumn;
	
	@FindBy(xpath="//*[@id=\"resultsColumn\"]//li[1]//div[2]//span")
	public WebElement firstResultPriceValue;
	
	@FindBy(xpath="//*[@id=\"resultsColumn\"]//li[32]//div[2]//span")
	public WebElement lastResultPriceValue;
	

		
	


}
