package com.trulia.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.trulia.pages.HomePage;
import com.trulia.pages.SearchResultPage;
import com.trulia.utilities.BrowserUtils;
import com.trulia.utilities.TestBase;

public class TestIlyas extends TestBase{
	HomePage homePage = new HomePage();
	SearchResultPage searchResultPage = new SearchResultPage();
	
	@Test
	public void TC007() {
	// step1
	driver.manage().window().maximize();
	assertTrue(homePage.isAtURL());
	assertTrue(homePage.isAtTitle());
	//step2
	homePage.searchFieldIL.clear();
	homePage.searchFieldIL.sendKeys("Schaumburg, IL");
	homePage.searchButtonIL.click();
	BrowserUtils.waitFor(3);
	Assert.assertEquals(driver.getTitle(),"Schaumburg, IL Real Estate & Homes For Sale | Trulia");
	//Step3
	Actions actions = new Actions(driver);
	actions.moveToElement(searchResultPage.buyLink).perform();
	String actual = "";
	String expected = "Homes for Sale";
	for (WebElement a : searchResultPage.buyLinkMenu) {
		actual += a.getText() + " ";
	}
		assertTrue(actual.trim().contains(expected));
	//Step 4
	searchResultPage.homesForSaleButton.click();
	assertEquals(driver.getTitle(), "Schaumburg, IL Real Estate & Homes For Sale | Trulia");
	//Step 5
	searchResultPage.allHomeTypesButton.click();
	String actual2 = "";
 	String expected2 = "House Condo Townhome Multi-Family Land Mobile/Manufactured Other";
	for (WebElement b : searchResultPage.allHomeTypesMenu) {
		actual2 += b.getText() + " ";}

	assertTrue(actual2.trim().contains(expected2));
	
	//Step 6
	searchResultPage.condoButton.click();
	BrowserUtils.waitFor(1);
	searchResultPage.landButton.click();
	BrowserUtils.waitFor(1);
	searchResultPage.townHomeButton.click();
	
	int numHOmes=Integer.parseInt(searchResultPage.resultsColumn.getText().substring(0, 3));
	assertTrue(numHOmes>1);
	
	
}

	@Test
	public void TC008() {
	// step1
	driver.manage().window().maximize();
	homePage.searchFieldIL.clear();
	BrowserUtils.waitFor(2);
	assertTrue(homePage.isAtURL());
	assertTrue(homePage.isAtTitle());
	//step2
	Actions actions = new Actions(driver);
	
	BrowserUtils.waitFor(2);
	actions.moveToElement(searchResultPage.buyLink).perform();
	BrowserUtils.waitFor(2);
	assertTrue(homePage.AHMmenuBuyLink.isDisplayed());
	//Step3
	homePage.searchFieldIL.clear();
	BrowserUtils.waitFor(2);
	homePage.buyNewHomesLink.click();
	BrowserUtils.waitFor(2);
	assertTrue(driver.getTitle().contains("New Homes"));
	assertTrue(searchResultPage.AHMsearchBar.isDisplayed());
	//step4
	
	searchResultPage.AHMsearchBar.clear();
	BrowserUtils.waitFor(2);
	searchResultPage.AHMsearchBar.sendKeys("Windermere, FL");
	BrowserUtils.waitFor(4);
	searchResultPage.AHMsearchBtn.click();
	BrowserUtils.waitFor(2);
	searchResultPage.AHMsearchBtn.click();
	System.out.println(driver.getTitle());
	assertTrue(driver.getTitle().contains("Windermere, FL New Homes For Sale"));
		
	
}
	


}