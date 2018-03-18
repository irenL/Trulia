package com.trulia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trulia.utilities.Driver;

public class SearchPageBaltimore {

	private WebDriver driver;

	public SearchPageBaltimore() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);

	}

	public boolean isAt() {
		return driver.getTitle().equals("Baltimore, MD Real Estate & Homes For Sale | Trulia");
	}

	@FindBy(id = "bedroomsToggle")
	public WebElement allBedsDropdownIL;

	@FindBy(xpath = "//div[@id='bedroomsButtonGroup']/div/div/div/button[3]")
	public WebElement selectTwoPlusFromDropdownIL;

	@FindBy(id = "homeTypeToggle")
	public WebElement allHomeTypesDropdownIL;

	@FindBy(id = "homeType0")
	public WebElement selectHouseFromDropdownIL;

	@FindBy(id = "moreToggle")
	public WebElement moreDropdownIL;

	@FindBy(id = "recentlyReduced")
	public WebElement priceReducedFromDropdownIL;

	@FindBy(xpath = "//span[@id='filterToggles']/div/span/button")
	public WebElement saveSearchButtonIL;

	public boolean updatedTitle() {
		return driver.getTitle().equals("Baltimore, MD 2 Bed Single Family Homes For Sale | Trulia");
	}

}
