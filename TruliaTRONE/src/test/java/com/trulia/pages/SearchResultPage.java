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
}
