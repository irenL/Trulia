package com.trulia.pages;

import java.util.List;

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

}
