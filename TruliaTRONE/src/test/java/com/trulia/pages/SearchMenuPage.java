package com.trulia.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trulia.utilities.Driver;

public class SearchMenuPage {

	private WebDriver driver;

	public SearchMenuPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "locationInputs")
	public WebElement menuSearchFieldIL; // locator from HoMePage

	@FindBy(id = "priceToggle")
	public WebElement searchFilterButtonAnyPriceIL;

	@FindBy(xpath = "//div[@id='priceForm']/ul/li[1]/span/div/div/span[1]")
	public WebElement anyPriceNoMinTextIL;

	@FindBy(xpath = "//div[@id='priceForm']/ul/li[3]/span/div/div/span[1]")
	public WebElement anyPriceNoMaxTextIL;

	@FindBy(id = "minPrice")
	public WebElement minPriceIL;

	@FindBy(id = "maxPrice")
	public WebElement maxPriceIL;

	public boolean isNoMin() {
		return anyPriceNoMinTextIL.getText().equals("No Min");
	}

	public boolean isNoMax() {
		return anyPriceNoMaxTextIL.getText().equals("No Max");
	}

	public boolean isInGivenPriceRange() {
		return searchFilterButtonAnyPriceIL.getText().equals("$10k - $20k");
	}
	// ---------------------

	@FindBy(xpath = "//div[@class='field mvn']")
	public WebElement keywordsDropdownWindowIL;

	@FindBy(id = "keywordsToggle")
	public WebElement searchFilterButtonKeywordsIL;

	@FindBy(id = "keywordInput")
	public WebElement keywordInputFieldIL;

	@FindBy(xpath = "//span[contains(text(),'parking garage')]")
	public WebElement filterParkingGarageIL;

	@FindBy(id = "homeTypeToggle")
	public WebElement searchFilterButtonAllHomeTypesIL;

	@FindBy(id = "homeTypesDropdown")
	public WebElement homeTypesDropdownWindowIL;

	@FindBy(xpath = "//div[@id='homeTypesDropdown']//label")
	public List<WebElement> elementsOfHomeTypesDropdownListIL;

	public boolean ListOfElementsIsDisplayed() {
		String str = null;
		for (WebElement element : elementsOfHomeTypesDropdownListIL) {
			str += element.getText() + ", ";
		}
		str = str.replace("null", "");
		int l = str.length() - 1;
		str = str.substring(0, l - 1);

		return str.equals("House, Condo, Townhome, Multi-Family, Land, Mobile/Manufactured, Other");
	}
	
}
