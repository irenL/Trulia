package com.trulia.pages;

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

	public boolean isAt() {
		return driver.getTitle().equals("Trulia: Real Estate Listings, Homes For Sale, Housing Data".trim());
	}

	@FindBy(xpath="//li/button[contains(text(),'Sign In')]")
	public WebElement AHMsignIn;

}
