package com.trulia.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
		assertTrue(driver.getTitle().contains("Windermere, FL New Homes For Sale"));
	//Step5
	searchResultPage.AHMallBedsBtn.click();
	String actual3 = "";
	String expected3 = "Studio+ 1+ 2+ 3+ 4+";
	for (WebElement f : searchResultPage.AHMallBedsOptions) {
		actual3 += f.getText() + " ";
	}
	
	assertEquals(actual3.trim(), expected3);
	//step6
	searchResultPage.AHMallBedsOption4PLUS.click();
	BrowserUtils.waitFor(3);
	assertEquals(searchResultPage.AHMh1.getText(), "Windermere, FL 4 Bedroom Homes For Sale");
	
	}
	
	@Test
	public void TC009() {
	// step1
	driver.manage().window().maximize();
	assertTrue(homePage.isAtURL());
	assertTrue(homePage.isAtTitle());
	//step2
	homePage.searchFieldIL.clear();
	BrowserUtils.waitFor(2);
	homePage.searchFieldIL.sendKeys("Pittsburg,PA");
	BrowserUtils.waitFor(2);
	System.out.println(homePage.searchFieldIL.getAttribute("value"));
	assertTrue(homePage.searchFieldIL.getAttribute("value").equals("Pittsburg,PA"));
	homePage.searchButtonIL.click();
	BrowserUtils.waitFor(2);
	
	//step3
	Actions actions = new Actions(driver);
	BrowserUtils.waitFor(2);
	actions.moveToElement(searchResultPage.buyLink).perform();
	BrowserUtils.waitFor(2);
	String actual4 = "";
	String expected4 = "Open Houses";
	for (WebElement g : homePage.AHMmenuBuyList) {
		actual4 += g.getText() + " ";
	}
	System.out.println(actual4);
	assertTrue(actual4.trim().contains(expected4));
	//step4
	homePage.AHMmenuOpenHousesLink.click();
	BrowserUtils.waitFor(3);
	assertTrue(driver.getTitle().contains("Pittsburgh, PA Open Houses"));
	assertTrue(homePage.priceToggle.isDisplayed());
	//step5
	homePage.priceToggle.click();
	BrowserUtils.waitFor(3);
	WebElement minPriceDropDown=driver.findElement(By.id("minPrice"));
	Select list=new Select(minPriceDropDown);	
	assertTrue(minPriceDropDown.isEnabled());
	WebElement maxPriceDropDown=driver.findElement(By.id("maxPrice"));
	Select list2=new Select(maxPriceDropDown);
	assertTrue(maxPriceDropDown.isEnabled());
	//step6
	homePage.minPriceLink.click();
	BrowserUtils.waitFor(2);
	list.selectByVisibleText("$50k");
	BrowserUtils.waitFor(3);
	homePage.maxPriceLink.click();
	BrowserUtils.waitFor(2);
	list2.selectByVisibleText("$250k");
	BrowserUtils.waitFor(3);
	
	BrowserUtils.waitFor(3);
	
	String firstValue=searchResultPage.firstResultPriceValue.getText();
	String lastValue=searchResultPage.lastResultPriceValue.getText();
	
	
	assertTrue(Integer.parseInt(firstValue.substring(1).replace(",",""))>50000);
	assertTrue(Integer.parseInt(lastValue.substring(1).replace(",",""))<250000);
	
	
	
	
}
















}