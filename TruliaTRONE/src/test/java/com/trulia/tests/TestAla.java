package com.trulia.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.trulia.pages.HomePage;
import com.trulia.pages.SearchResultPage;
import com.trulia.utilities.BrowserUtils;
import com.trulia.utilities.TestBase;

public class TestAla extends TestBase{
	HomePage homePage = new HomePage();
	SearchResultPage searchResultPage = new SearchResultPage();
	
	@Test
	public void TC002() {
		// step1
		assertTrue(homePage.isAtURL());
		assertTrue(homePage.isAtTitle());
		// step2
		assertTrue(homePage.AHMmenuBuyLink.isDisplayed());
		Actions actions = new Actions(driver);
		actions.moveToElement(homePage.AHMmenuBuyLink).perform();
		// step3
		assertTrue(homePage.AHMmenuRecentlySoldLink.isDisplayed());
		homePage.AHMmenuRecentlySoldLink.click();
		assertTrue(searchResultPage.AHMh1.getText().contains("Recently Sold Homes"));
		// step4
		searchResultPage.AHMsearchBar.clear();
		searchResultPage.AHMsearchBar.sendKeys("Miami Beach, FL" + Keys.ENTER);
		BrowserUtils.waitFor(3);
		assertEquals(driver.getTitle(), "Miami Beach Recently Sold Properties | Trulia");
	}
}
