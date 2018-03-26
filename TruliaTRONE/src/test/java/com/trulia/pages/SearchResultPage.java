package com.trulia.pages;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trulia.utilities.BrowserUtils;
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
	
	@FindBy(xpath="//*[@id=\"homeTypesDropdown\"]//div[1]/div[2]")
	public WebElement condoButton;
	
	@FindBy(xpath="//*[@id=\"homeTypesDropdown\"]//div[1]/div[3]")
	public WebElement townHomeButton;
	
	@FindBy(xpath="//*[@id=\"homeTypesDropdown\"]//div[2]/div[1]")
	public WebElement landButton;
	
	@FindBy(xpath="//*[@id=\"srpHeaderLeftColumn\"]//h2")
	public WebElement resultsColumn;
	
	@FindBy(xpath="//div[@id='bedroomsButtonGroup']//button[.='3+']")
	public WebElement AHMallBedsOption3PLUS;
	
	@FindBy(xpath="//li[@data-auto-test='beds']")
	public List<WebElement> listingNumberofBeds;
	
	//=========================================
	
	@FindBy(xpath="//a[@data-reactid='83']") 
	public WebElement menuBuyLink;
	
	@FindBy(linkText="Homes for Sale")//data-reactid="89"
	public WebElement homesForSale;
	
	@FindBy(id="homeTypeToggle")
	public WebElement homeTypesDropdown;
	
	public WebElement homeType0; // House
	public WebElement homeType1; // Condo
	public WebElement homeType2; // Townhome
	public WebElement homeType3; // Multi-Family
	public WebElement homeType4; // Land
	public WebElement homeType5; // Mobile/Manufactured
	public WebElement homeType6; // Other
	
	@FindBy(xpath="//*[@id=\"srpHeaderLeftColumn\"]//h2")
	public WebElement numberOfResultLine;
	
	//==========================================
	@FindBy(xpath="//*[@id=\'navbarContainer\']//section[1]/header/a")
	public WebElement ILYbuyLink;
	
	@FindBy(xpath="//*[@id=\'navbarContainer\']//section[1]/ul//a")
	public List<WebElement> ILYbuyLinkMenu;
	
	@FindBy(xpath="(//*[@id=\"navbarContainer\"]//section[1]/ul//a)[1]")
	public WebElement ILYhomesForSaleButton;
	
	@FindBy(id="homeTypeToggle")
	public WebElement ILYallHomeTypesButton;
	
	@FindBy(xpath="//*[@id=\"homeTypesDropdown\"]//label")
	public List<WebElement> ILYallHomeTypesMenu;
	
	@FindBy(xpath="//*[@id=\"homeTypesDropdown\"]//div[1]/div[1]/span")
	public WebElement ILYhouseButton;
	
	@FindBy(xpath="//*[@id=\"homeTypesDropdown\"]//div[1]/div[2]")
	public WebElement ILYcondoButton;
	
	@FindBy(xpath="//*[@id=\"homeTypesDropdown\"]//div[1]/div[3]")
	public WebElement ILYtownHomeButton;
	
	@FindBy(xpath="//*[@id=\"homeTypesDropdown\"]//div[2]/div[1]")
	public WebElement ILYlandButton;

	@FindBy(xpath="//*[@id=\"homeTypesDropdown\"]//div[4]//label")
	public WebElement ILYmultiFamilyButton;
	
	@FindBy(xpath="//*[@id=\"homeTypesDropdown\"]//div//div[2]//div[2]")
	public WebElement ILYmobileManufactureButton;
	
	@FindBy(xpath="//*[@id=\"homeTypesDropdown\"]//div/div[2]/div[3]")
	public WebElement ILYotherButton;
	
	@FindBy(xpath="//*[@id=\"srpHeaderLeftColumn\"]//h2")
	public WebElement ILYresultsColumn;
	
	@FindBy(xpath="//*[@id=\"resultsColumn\"]//li[1]//div[2]//span")
	public WebElement ILYfirstResultPriceValue;
	
	@FindBy(xpath="//*[@id=\"resultsColumn\"]//li[32]//div[2]//span")
	public WebElement ILYlastResultPriceValue;
	
	
	@FindBy(xpath = "//h2[@class='h6 typeLowlight pbs']")
	public WebElement resultTotalNumberHomesFoundIL;

	@FindBy(xpath = "//ul[@class='mvn row']/li[@class='xsCol12Landscape smlCol12 lrgCol8']/div/div/div[2]//span")
	public List<WebElement> listOfHomesPricesIL;

	@FindBy(xpath = "//div[@id='srpHeaderLeftColumn']//span[@class='pbm']")
	public WebElement filterParkingGarageIL;

	@FindBy(xpath = "//div[@class='ptm']")
	public WebElement filtersWindowIL;

	public boolean numberResultIsDisplayed() {
		boolean result;
		try {
			result = resultTotalNumberHomesFoundIL.isDisplayed();
		} catch (NoSuchElementException e) {
			result = false;
		}
		return result;
	}

	public boolean parkingGarageIsDisplayed() {
		boolean result;
		try {
			result = filterParkingGarageIL.isDisplayed();
		} catch (NoSuchElementException e) {
			result = false;
		}
		return result;
	}

	public boolean homePricesIsAtGivenRange(List<WebElement> elements, int rangeMin, int rangeMax) {
		
		for (WebElement eachElement : elements) {
			System.out.println(eachElement.getText());
			String str = eachElement.getText().replace("$", "");
			str = str.replace(",", "");
			BrowserUtils.waitFor(2);
			int inNumber = Integer.parseInt(str);
			
			if (rangeMin <= inNumber && inNumber <= rangeMax) {
			} else {
				return false;
			}
		}
		return true;
	}
	
	

	public boolean adjustFiltersIsDisplayed() {
		return filtersWindowIL.getText()
				.equals("Adjust filters to find more homes:\n" + "Price $10,000 Open Houses\n" + "Remove All Filters");
	}
	
	
	
	
}
