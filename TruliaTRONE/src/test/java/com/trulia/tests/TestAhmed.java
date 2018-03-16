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
import com.trulia.utilities.TestBase;

public class TestAhmed extends TestBase{
	HomePage homePage = new HomePage();
	SearchResultPage searchResultPage = new SearchResultPage();
	
	@Test
	public void TC020() {
		//step1
		assertTrue(homePage.isAtURL());
		assertTrue(homePage.isAtTitle());
		//step2
		assertTrue(homePage.AHMmenuBuyLink.isDisplayed());
		Actions actions = new Actions(driver);
		actions.moveToElement(homePage.AHMmenuBuyLink).perform();
		assertTrue(!homePage.AHMmenuBuyList.isEmpty());
		//step3
		assertTrue(homePage.AHMmenuOpenHousesLink.isDisplayed());
		homePage.AHMmenuOpenHousesLink.click();
		//step4
		searchResultPage.AHMsearchBtn.click();
		assertTrue(searchResultPage.AHMsearchBar.isDisplayed());
		//step5
		BrowserUtils.waitFor(1);
		searchResultPage.AHMsearchBar.clear();
		searchResultPage.AHMsearchBar.sendKeys("Pittsburgh, PA"+Keys.ENTER);
		assertTrue(searchResultPage.AHMh1.getText().contains("Open Houses in Pittsburgh, PA"));
		//step6
		searchResultPage.AHMallBedsBtn.click();
		String actual="";
		String expected="Studio+ 1+ 2+ 3+ 4+";
		for(WebElement bed : searchResultPage.AHMallBedsOptions) {
			actual+=bed.getText()+" ";
		}
		assertEquals(actual.trim(), expected);
		//step7
		searchResultPage.AHMallBedsOption4PLUS.click();
		assertEquals(searchResultPage.AHMh1.getText(),"Pittsburgh, PA 4 Bedroom Open Homes");
		
	}
}
