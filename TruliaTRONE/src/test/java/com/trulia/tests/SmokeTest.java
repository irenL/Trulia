package com.trulia.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.trulia.pages.HomePage;
import com.trulia.pages.SearchPageBaltimore;
import com.trulia.utilities.BrowserUtils;
import com.trulia.utilities.ConfigurationReader;
import com.trulia.utilities.TestBase;


public class SmokeTest extends TestBase {

	HomePage homePage = new HomePage();
	SearchPageBaltimore baltimore = new SearchPageBaltimore();

	String expectedUrlHomePage = "https://www.trulia.com/";
	String accountName = "Irinatestapp";
	String searchCity = "Baltimore";
	String popUpTitle = "Sign in or register\n" + "to save your favorite homes";
	String urlSearchBaltimore = "https://www.trulia.com/MD/Baltimore/";

	@Test
	public void smokeTest() {

		// STEP 1
		// Checking if expected Url equal to actual Url
		String actualUrlHomePage = driver.getCurrentUrl();
		boolean resultHPUrl = BrowserUtils.getCurrentUrl(expectedUrlHomePage, actualUrlHomePage);
		assertTrue(resultHPUrl, "Expected url not equal ectual");
		// Checking if expected Title equal actual Title
		assertTrue(homePage.isAtTitle());

		// STEP 2
		// Click on Sign In button at the top right corner
		homePage.signInButtonIL.click();
		// Waiting for Visibility of pop-up title
		BrowserUtils.waitForVisibility(homePage.popUpTitleIL, 1000);
		// Checking expected Pop-up Title is equal to actual Pop-up Title
		assertEquals(popUpTitle, homePage.popUpTitleIL.getText());

		// STEP 3
		// Entering email
		homePage.enterEmailAddressFieldIL.sendKeys(ConfigurationReader.getProperty("emailli"));
		// Clicking submit button
		homePage.submitButtonIL.click();
		// Entering password
		homePage.enterPasswordFieldIL.sendKeys(ConfigurationReader.getProperty("passwordli"));
		// Clicking Sign In button
		homePage.signInPasswordButtonIL.click();
		// Checking Url
		assertTrue(resultHPUrl, "Expected url not equal ectual");
		// Checking if expected Title equal actual Title
		assertTrue(homePage.isAtTitle());
		// Waiting for Visibility of account link
		BrowserUtils.waitForVisibility(homePage.accountLinkIL, 1000);
		// Checking if button Sign In is not displayed when customer log in to account
		assertFalse(homePage.signInIsDisplayed(), "button Sign In is displayed when customer sign in to account");
		// Checking if account linkText equal to accountName
		assertEquals(accountName, homePage.accountLinkIL.getText());

		// STEP 4
		// Entering to search field - Baltimore
		homePage.searchFieldIL.clear();
		homePage.searchFieldIL.sendKeys(searchCity);
		// Clicking search button
		homePage.searchButtonIL.click();
		BrowserUtils.waitFor(3);
		// Checking if expected Title equal actual Title
		assertTrue(baltimore.isAt());

		// STEP 5
		// Checking Url
		String actualBaltimoreUrl = driver.getCurrentUrl();
		boolean resultBaltimoreUrl = BrowserUtils.getCurrentUrl(urlSearchBaltimore, actualBaltimoreUrl);
		assertTrue(resultBaltimoreUrl, "Expected url not equal ectual");
		// Selecting 2+ from All Beds
		baltimore.allBedsDropdownIL.click();
		baltimore.selectTwoPlusFromDropdownIL.click();
		// Selecting House from All Home Types
		baltimore.allHomeTypesDropdownIL.click();
		baltimore.selectHouseFromDropdownIL.click();
		// Selecting Price Reduced from More
		baltimore.moreDropdownIL.click();
		baltimore.priceReducedFromDropdownIL.click();
		// Clicking Save Search button
		baltimore.saveSearchButtonIL.click();

		// STEP 6
		// Checking if updated page title equals to the expected
		assertTrue(baltimore.updatedTitle());
		// Log out of Account
		Actions action = new Actions(driver);
		action.moveToElement(homePage.accountLinkIL).moveToElement(homePage.logOutOfAccountIL).click().perform();
		BrowserUtils.waitFor(2);
		// Checking if Log In button displayed instead account name
		assertTrue(homePage.signInIsDisplayed());

	}

}
