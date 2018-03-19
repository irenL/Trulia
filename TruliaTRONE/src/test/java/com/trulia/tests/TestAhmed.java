package com.trulia.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.trulia.pages.HomePage;
import com.trulia.pages.SearchResultPage;
import com.trulia.utilities.BrowserUtils;
import com.trulia.utilities.ConfigurationReader;
import com.trulia.utilities.TestBase;

public class TestAhmed extends TestBase {
	HomePage homePage = new HomePage();
	SearchResultPage searchResultPage = new SearchResultPage();

	@Test
	public void TC020() {
		// step1
		assertTrue(homePage.isAtURL());
		assertTrue(homePage.isAtTitle());
		// step2
		assertTrue(homePage.AHMmenuBuyLink.isDisplayed());
		Actions actions = new Actions(driver);
		actions.moveToElement(homePage.AHMmenuBuyLink).perform();
		assertTrue(!homePage.AHMmenuBuyList.isEmpty());
		// step3
		assertTrue(homePage.AHMmenuOpenHousesLink.isDisplayed());
		homePage.AHMmenuOpenHousesLink.click();
		// step4
		searchResultPage.AHMsearchBtn.click();
		assertTrue(searchResultPage.AHMsearchBar.isDisplayed());
		// step5
		BrowserUtils.waitFor(1);
		searchResultPage.AHMsearchBar.clear();
		searchResultPage.AHMsearchBar.sendKeys("Pittsburgh, PA" + Keys.ENTER);
		assertTrue(searchResultPage.AHMh1.getText().contains("Open Houses in Pittsburgh, PA"));
		// step6
		searchResultPage.AHMallBedsBtn.click();
		String actual = "";
		String expected = "Studio+ 1+ 2+ 3+ 4+";
		for (WebElement bed : searchResultPage.AHMallBedsOptions) {
			actual += bed.getText() + " ";
		}
		assertEquals(actual.trim(), expected);
		// step7
		searchResultPage.AHMallBedsOption4PLUS.click();
		assertEquals(searchResultPage.AHMh1.getText(), "Pittsburgh, PA 4 Bedroom Open Homes");
		ConfigurationReader.getProperty("email");
	}

	@Test
	public void TC0019() {
		// step1
		assertTrue(homePage.isAtURL());
		assertTrue(homePage.isAtTitle());
		// step2
		assertTrue(homePage.AHMmenuBuyLink.isDisplayed());
		Actions actions = new Actions(driver);
		actions.moveToElement(homePage.AHMmenuBuyLink).perform();
		assertTrue(!homePage.AHMmenuBuyList.isEmpty());
		// step3
		assertTrue(homePage.AHMmenuOpenHousesLink.isDisplayed());
		homePage.AHMmenuOpenHousesLink.click();
		// step5
		BrowserUtils.waitFor(1);
		searchResultPage.AHMsearchBar.clear();
		searchResultPage.AHMsearchBar.sendKeys("Pittsburgh, PA" + Keys.ENTER);
		assertTrue(searchResultPage.AHMh1.getText().contains("Open Houses in Pittsburgh, PA"));
		// step6
		searchResultPage.AHMallBedsBtn.click();
		String actual = "";
		String expected = "Studio+ 1+ 2+ 3+ 4+";
		for (WebElement bed : searchResultPage.AHMallBedsOptions) {
			actual += bed.getText() + " ";
		}
		assertEquals(actual.trim(), expected);
		// step7
		searchResultPage.AHMallBedsOption1PLUS.click();
		assertEquals(searchResultPage.AHMh1.getText(), "Pittsburgh, PA 1 Bedroom Open Homes");
	}
	@Test
	public void TC0018() {
		//step1
		assertTrue(homePage.isAtURL());
		assertTrue(homePage.isAtTitle());
		assertTrue(homePage.AHMlogoSVG.isDisplayed());
		//step2
		Actions actions = new Actions(driver);
		actions.moveToElement(homePage.AHMmenuLocalScoopLink).perform();
		assertTrue(BrowserUtils.getElementsText(By.xpath("//section[@data-reactid='201']//a")).contains("Market Trends"));
		//step3
		homePage.AHMmenuMarketTrendsLink.click();
		assertTrue(driver.getCurrentUrl().contains("/market-trends/"));
		assertTrue(driver.getTitle().contains("Real Estate Market Trends"));
	}
	@Test
	public void TC0017() {
		//step1
		assertTrue(homePage.isAtURL());
		assertTrue(homePage.isAtTitle());
		assertTrue(homePage.AHMlogoSVG.isDisplayed());
		//step2
		Actions actions = new Actions(driver);
		actions.moveToElement(homePage.AHMmenuLocalScoopLink).perform();
		assertTrue(BrowserUtils.getElementsText(By.xpath("//section[@data-reactid='201']//a")).contains("Schools"));
		//step3
		homePage.AHMmenuShoolsLink.click();
		assertTrue(driver.getCurrentUrl().contains("/schools/"));
		assertTrue(driver.getTitle().contains("Public & Private Schools"));
	}
}
