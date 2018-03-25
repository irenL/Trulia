package com.trulia.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.trulia.pages.HomePage;
import com.trulia.pages.SearchMenuPage;
import com.trulia.pages.SearchResultPage;
import com.trulia.utilities.BrowserUtils;
import com.trulia.utilities.ConfigurationReader;
import com.trulia.utilities.TestBase;


public class Tests extends TestBase {
	HomePage homePage = new HomePage();
	SearchResultPage searchResultPage = new SearchResultPage();
	SearchMenuPage searchMenuPage = new SearchMenuPage();

	@Test(enabled = true)
	public void TC001() {
		// Step 1
		assertTrue(homePage.isAtTitle(),
				"Actual title not equal 'Trulia : Real Estate Listing, Homes For Sale , Housing Date'");
		// Step 2
		Actions action = new Actions(driver);
		action.moveToElement(homePage.linkBuyIL).moveToElement(homePage.linkOpenHousesIL).click().perform();
		BrowserUtils.waitFor(1);
		// Step 3
		assertTrue(searchMenuPage.searchFilterButtonAnyPriceIL.isDisplayed());
		BrowserUtils.waitFor(1);
		// Step 4
		searchMenuPage.menuSearchFieldIL.clear();
		String windermere = "Windermere, FL";
		searchMenuPage.menuSearchFieldIL.sendKeys(windermere + Keys.ENTER);
		BrowserUtils.waitFor(1);
		assertTrue(driver.getTitle().contains(windermere));
		// Step 5
		searchMenuPage.searchFilterButtonAnyPriceIL.click();
		BrowserUtils.waitFor(1);
		assertTrue(searchMenuPage.isNoMin(), "Actual not equal 'No Min' ");
		assertTrue(searchMenuPage.isNoMax(), "Actual not equal 'No Max' ");
		// Step 6
		BrowserUtils.waitFor(1);
		Select selectPrice = new Select(searchMenuPage.minPriceIL);
		selectPrice.selectByValue("10000");
		selectPrice = new Select(searchMenuPage.maxPriceIL);
		selectPrice.selectByValue("10000");
		// Step 7
		BrowserUtils.waitFor(2);
		assertTrue(searchResultPage.adjustFiltersIsDisplayed());
	}

	@Test(enabled = true)
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
		BrowserUtils.waitFor(4);
		assertEquals(driver.getTitle(), "Miami Beach Recently Sold Properties | Trulia");
	}

	@Test(enabled = true)
	public void TC003() {
		// step1
		assertTrue(homePage.isAtURL());
		assertTrue(homePage.isAtTitle());
		// step2
		homePage.AHMsignInButton.click();
		assertTrue(homePage.AHMsignInOrRegisterText.getText().contains("Sign in or register"));
		// step3
		homePage.usernameField.sendKeys(ConfigurationReader.getProperty("email"));
		homePage.submitButton.click();
		assertTrue(homePage.enterPasswordText.getText().contains("Enter your password"));
		// step4
		homePage.passwordField.sendKeys(ConfigurationReader.getProperty("password"));
		homePage.submitButton.click();
		BrowserUtils.waitFor(2);
		try {
			assertTrue(!homePage.submitButton.isDisplayed());
		} catch (NoSuchElementException e) {
			assertTrue(true);
		}
		assertEquals(homePage.profileUserName.getText(), "Fast Furious");

	}

	@Test(enabled = true)
	public void TC004() {
		
		assertTrue(homePage.isAtURL());
		assertTrue(homePage.isAtTitle());

		assertTrue(homePage.menuBuyLink.isDisplayed());

		Actions actions = new Actions(driver);
		actions.moveToElement(homePage.menuBuyLink).perform();
		assertTrue(!homePage.menuBuyList.isEmpty());

		assertTrue((homePage.menuNewHomesLink).isDisplayed());
		homePage.menuNewHomesLink.click();

		homePage.buttonAnyPrice.click();
		WebElement minPriceDropDown = driver.findElement(By.id("minPrice"));
		assertTrue(minPriceDropDown.isEnabled());
		WebElement maxPriceDropDown = driver.findElement(By.id("maxPrice"));
		assertTrue(maxPriceDropDown.isEnabled());

	}

	@Test(enabled = true)
	public void TC005() {
		// step1
		assertTrue(homePage.isAtURL());
		assertTrue(homePage.isAtTitle());
		// step2
		Actions actions = new Actions(driver);
		actions.moveToElement(homePage.menuLocalScoopLink).perform();
		assertTrue(homePage.menuCrime.isDisplayed());
		// step3
		homePage.menuCrime.click();
		assertTrue(driver.getTitle().contains("Crime Data"));

	}

	@Test(enabled = true)
	public void TC006() {
		// step1
		driver.manage().window().maximize();
		assertTrue(homePage.isAtURL());
		assertTrue(homePage.isAtTitle());
		// step2
		homePage.searchBox.clear();
		homePage.searchBox.sendKeys("Schaumburg, IL" + Keys.ENTER);
		BrowserUtils.waitFor(3);

		assertEquals(driver.getTitle(), "Schaumburg, IL Real Estate & Homes For Sale | Trulia");
		// step3
		Actions actions = new Actions(driver);
		actions.moveToElement(searchResultPage.menuBuyLink).perform();
		// step4
		searchResultPage.homesForSale.click();
		assertEquals(driver.getTitle(), "Schaumburg, IL Real Estate & Homes For Sale | Trulia");
		// step5
		searchResultPage.homeTypesDropdown.click();
		assertTrue(searchResultPage.homeType0.isDisplayed()); // House
		assertTrue(searchResultPage.homeType1.isDisplayed()); // Condo
		assertTrue(searchResultPage.homeType2.isDisplayed()); // Townhome
		assertTrue(searchResultPage.homeType3.isDisplayed()); // Multi-Family
		assertTrue(searchResultPage.homeType4.isDisplayed()); // Land
		assertTrue(searchResultPage.homeType5.isDisplayed()); // Mobile/Manufactured
		assertTrue(searchResultPage.homeType6.isDisplayed()); // Other
		// step6
		searchResultPage.homeType4.click();
		assertTrue(searchResultPage.numberOfResultLine.getText().contains("homes available on Trulia"));
		assertFalse(searchResultPage.numberOfResultLine.getText().contains("0 Results."));

	}

	@Test(enabled = true)
	public void TC007() {
		// step1
		driver.manage().window().maximize();
		assertTrue(homePage.isAtURL());
		assertTrue(homePage.isAtTitle());
		// step2
		homePage.searchFieldIL.clear();
		homePage.searchFieldIL.sendKeys("Schaumburg, IL");
		homePage.searchButtonIL.click();
		BrowserUtils.waitFor(3);
		assertEquals(driver.getTitle(), "Schaumburg, IL Real Estate & Homes For Sale | Trulia");
		// Step3
		Actions actions = new Actions(driver);
		actions.moveToElement(searchResultPage.ILYbuyLink).perform();
		String actual = "";
		String expected = "Homes for Sale";
		for (WebElement a : searchResultPage.ILYbuyLinkMenu) {
			actual += a.getText() + " ";
		}
		assertTrue(actual.trim().contains(expected));
		// Step 4
		searchResultPage.ILYhomesForSaleButton.click();
		assertEquals(driver.getTitle(), "Schaumburg, IL Real Estate & Homes For Sale | Trulia");
		// Step 5
		searchResultPage.ILYallHomeTypesButton.click();
		String actual2 = "";
		String expected2 = "House Condo Townhome Multi-Family Land Mobile/Manufactured Other";
		for (WebElement b : searchResultPage.ILYallHomeTypesMenu) {
			actual2 += b.getText() + " ";
		}

		assertTrue(actual2.trim().contains(expected2));

		// Step 6
		searchResultPage.ILYcondoButton.click();
		BrowserUtils.waitFor(1);
		searchResultPage.ILYlandButton.click();
		BrowserUtils.waitFor(1);
		searchResultPage.ILYtownHomeButton.click();

		int numHOmes = Integer.parseInt(searchResultPage.ILYresultsColumn.getText().substring(0, 3));
		assertTrue(numHOmes > 1);

	}

	@Test(enabled = true)
	public void TC008() {
		// step1
		driver.manage().window().maximize();
		homePage.searchFieldIL.clear();
		BrowserUtils.waitFor(2);
		assertTrue(homePage.isAtURL());
		assertTrue(homePage.isAtTitle());
		// step2
		Actions actions = new Actions(driver);

		BrowserUtils.waitFor(2);
		actions.moveToElement(searchResultPage.ILYbuyLink).perform();
		BrowserUtils.waitFor(2);
		assertTrue(homePage.AHMmenuBuyLink.isDisplayed());
		// Step3
		homePage.searchFieldIL.clear();
		BrowserUtils.waitFor(2);
		homePage.ILYbuyNewHomesLink.click();
		BrowserUtils.waitFor(2);
		assertTrue(driver.getTitle().contains("New Homes"));
		assertTrue(searchResultPage.AHMsearchBar.isDisplayed());
		// step4

		searchResultPage.AHMsearchBar.clear();
		BrowserUtils.waitFor(2);
		searchResultPage.AHMsearchBar.sendKeys("Windermere, FL");
		BrowserUtils.waitFor(4);
		searchResultPage.AHMsearchBtn.click();
		BrowserUtils.waitFor(2);
		searchResultPage.AHMsearchBtn.click();
		assertTrue(driver.getTitle().contains("Windermere, FL New Homes For Sale"));
	}

	@Test(enabled = true)
	public void TC009() {
		// step1
		driver.manage().window().maximize();
		assertTrue(homePage.isAtURL());
		assertTrue(homePage.isAtTitle());
		// step2
		homePage.searchFieldIL.clear();
		BrowserUtils.waitFor(2);
		homePage.searchFieldIL.sendKeys("Pittsburg,PA");
		BrowserUtils.waitFor(2);
		assertTrue(homePage.searchFieldIL.getAttribute("value").equals("Pittsburg,PA"));
		homePage.searchButtonIL.click();
		BrowserUtils.waitFor(2);

		// step3
		Actions actions = new Actions(driver);
		BrowserUtils.waitFor(2);
		actions.moveToElement(searchResultPage.ILYbuyLink).perform();
		BrowserUtils.waitFor(2);
		String actual4 = "";
		String expected4 = "Open Houses";
		for (WebElement g : homePage.AHMmenuBuyList) {
			actual4 += g.getText() + " ";
		}

		assertTrue(actual4.trim().contains(expected4));
		// step4
		homePage.AHMmenuOpenHousesLink.click();
		BrowserUtils.waitFor(3);
		assertTrue(driver.getTitle().contains("Pittsburgh, PA Open Houses"));
		assertTrue(homePage.ILYpriceToggle.isDisplayed());
		// step5
		homePage.ILYpriceToggle.click();
		BrowserUtils.waitFor(3);
		WebElement minPriceDropDown = driver.findElement(By.id("minPrice"));
		Select list = new Select(minPriceDropDown);
		assertTrue(minPriceDropDown.isEnabled());
		WebElement maxPriceDropDown = driver.findElement(By.id("maxPrice"));
		Select list2 = new Select(maxPriceDropDown);
		assertTrue(maxPriceDropDown.isEnabled());
		// step6
		homePage.ILYminPriceLink.click();
		BrowserUtils.waitFor(2);
		list.selectByVisibleText("$50k");
		BrowserUtils.waitFor(3);
		homePage.ILYmaxPriceLink.click();
		BrowserUtils.waitFor(2);
		list2.selectByVisibleText("$250k");
		BrowserUtils.waitFor(5);

		String firstValue = searchResultPage.ILYfirstResultPriceValue.getText();
		String lastValue = searchResultPage.ILYlastResultPriceValue.getText();

		assertTrue(Integer.parseInt(firstValue.substring(1).replace(",", "")) > 50000);
		assertTrue(Integer.parseInt(lastValue.substring(1).replace(",", "")) < 250000);
	}

	@Test(enabled = true)
	public void TC010() {
		// step1
		driver.manage().window().maximize();
		assertTrue(homePage.isAtURL());
		assertTrue(homePage.isAtTitle());
		// step2
		Actions action = new Actions(driver);

		BrowserUtils.waitFor(2);
		action.moveToElement(searchResultPage.ILYbuyLink).perform();
		BrowserUtils.waitFor(2);
		assertTrue(homePage.AHMmenuOpenHousesLink.isDisplayed());
		// step3
		homePage.AHMmenuOpenHousesLink.click();
		BrowserUtils.waitFor(3);
		assertTrue(driver.getTitle().contains("Open Houses"));
		// step4
		searchResultPage.ILYallHomeTypesButton.click();
		BrowserUtils.waitFor(3);
		String actual2 = "";
		String expected2 = "House Condo Townhome Multi-Family Land Mobile/Manufactured Other";
		for (WebElement b : searchResultPage.ILYallHomeTypesMenu) {
			actual2 += b.getText() + " ";
		}
		assertTrue(actual2.trim().contains(expected2));
		// step5
		searchResultPage.ILYcondoButton.click();
		searchResultPage.ILYhouseButton.click();
		searchResultPage.ILYmultiFamilyButton.click();
		searchResultPage.ILYtownHomeButton.click();
		searchResultPage.ILYlandButton.click();
		searchResultPage.ILYmobileManufactureButton.click();
		searchResultPage.ILYotherButton.click();
		// step6 this step is incompatible with the former one
		BrowserUtils.waitFor(3);
		assertTrue(driver.getCurrentUrl().contains("MULTI-FAMILY"));

	}

	@Test(enabled = true)
	public void TC011() {
		// Step 1
		assertTrue(homePage.isAtTitle(),
				"Actual title not equal 'Trulia : Real Estate Listing, Homes For Sale , Housing Date'");
		// Step 2
		Actions action = new Actions(driver);
		action.moveToElement(homePage.linkBuyIL).moveToElement(homePage.linkOpenHousesIL).click().perform();
		BrowserUtils.waitFor(1);
		assertTrue(driver.getTitle().contains("Open Houses"), "Title does not contain 'Open Houses'");
		BrowserUtils.waitFor(1);
		searchMenuPage.searchFilterButtonAllHomeTypesIL.click();
		assertTrue(searchMenuPage.homeTypesDropdownWindowIL.isDisplayed(),
				"All Home Types drop down window is not appear");
		BrowserUtils.waitFor(1);
		assertTrue(searchMenuPage.ListOfElementsIsDisplayed());
		BrowserUtils.waitFor(1);
		assertTrue(searchResultPage.numberResultIsDisplayed(), "Your search does not match any homes");
	}

	@Test(enabled = true)
	public void TC012() {
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.trulia.com/";
		boolean resultHPUrl = BrowserUtils.getCurrentUrl(expectedUrl, actualUrl);
		assertTrue(resultHPUrl, "Expected url not equal ectual");
		BrowserUtils.waitFor(1);
		assertTrue(homePage.isAtTitle(), "Title is not equal expected");
		Actions action = new Actions(driver);
		action.moveToElement(homePage.linkBuyIL).moveToElement(homePage.linkHomesForSaleIL).click().perform();
		BrowserUtils.waitFor(2);
		searchMenuPage.searchFilterButtonAnyPriceIL.click();
		BrowserUtils.waitFor(1);
		assertTrue(driver.getTitle().contains("Homes For Sale"), "Title does not contain 'Homes For Sale'");
		BrowserUtils.waitFor(1);
		assertTrue(searchMenuPage.isNoMin(), "Actual not equal 'No Min' ");
		assertTrue(searchMenuPage.isNoMax(), "Actual not equal 'No Max' ");
		Select selectPrice = new Select(searchMenuPage.minPriceIL);
		selectPrice.selectByValue("10000");
		selectPrice = new Select(searchMenuPage.maxPriceIL);
		selectPrice.selectByValue("20000");
		BrowserUtils.waitFor(1);
		assertTrue(searchMenuPage.isInGivenPriceRange(), "Price range not equal given range");
		BrowserUtils.waitFor(1);
		assertTrue(searchResultPage.homePricesIsAtGivenRange(searchResultPage.listOfHomesPricesIL, 10000, 20000),
				"Any Price Filter does not sort by given range");

	}

	@Test(enabled = true)
	public void TC013() {
		
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		action.moveToElement(homePage.linkBuyIL).moveToElement(homePage.linkNewHomeIL).click().perform();
		BrowserUtils.waitFor(2);
		assertTrue(driver.getTitle().contains("New Homes For Sale"), "Title does not contain 'New Homes For Sale'");
		searchMenuPage.searchFilterButtonKeywordsIL.click();
		assertTrue(searchMenuPage.keywordsDropdownWindowIL.isDisplayed(), "Keyword drop down window is not displayed");
		BrowserUtils.waitFor(1);
		searchMenuPage.keywordInputFieldIL.sendKeys("parking garage" + Keys.ENTER);
		BrowserUtils.waitFor(1);
		assertTrue(searchResultPage.numberResultIsDisplayed(), "Your search does not match any homes");
		BrowserUtils.waitFor(1);
		assertTrue(searchResultPage.parkingGarageIsDisplayed(), "Filter 'parking garage' is not displayed");
	}

	@Test(enabled = true)
	public void TC014() {
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
		assertTrue(driver.getCurrentUrl().contains("https://www.trulia.com/sold/"));
		assertTrue(driver.getTitle().contains("Recently Sold Properties | Trulia"));
		for (WebElement sold : homePage.soldTexts) {
			assertTrue(sold.getText().contains("SOLD"));
		}
	}

	@Test(enabled = true)
	public void TC015() {
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
		assertTrue(driver.getCurrentUrl().contains("https://www.trulia.com/sold/"));
		assertTrue(driver.getTitle().contains("Recently Sold Properties | Trulia"));
		for (WebElement sold : homePage.soldTexts) {
			assertTrue(sold.getText().contains("SOLD"));
		}
		// step4
		searchResultPage.AHMallBedsBtn.click();
		searchResultPage.AHMallBedsOption3PLUS.click();
		assertTrue(searchResultPage.AHMh1.getText().contains("Recently Sold 3 Bedroom Homes"));
		assertTrue(driver.getTitle().contains("Recently Sold Properties | Trulia"));
		for (WebElement sold : homePage.soldTexts) {
			assertTrue(sold.getText().contains("SOLD"));
		}
		for (WebElement bed : searchResultPage.listingNumberofBeds) {
			int numberBeds = Integer.parseInt(bed.getText().substring(0, 1));
			assertTrue(numberBeds >= 3);
		}
	}

	@Test(enabled = true)
	public void TC016() {
		// step1
		assertTrue(homePage.isAtURL());
		assertTrue(homePage.isAtTitle());
		// step2
		assertTrue(homePage.AHMmenuBuyLink.isDisplayed());
		Actions actions = new Actions(driver);
		actions.moveToElement(homePage.AHMmenuBuyLink).perform();
		assertTrue(!homePage.AHMmenuBuyList.isEmpty());
		// step3
		homePage.AHMmenuNewHomesLink.click();
		assertTrue(searchResultPage.AHMsearchBar.isDisplayed());
		// step4
		searchResultPage.AHMsearchBar.clear();
		searchResultPage.AHMsearchBar.sendKeys("Pittsburgh, PA" + Keys.ENTER);
		BrowserUtils.waitFor(4);
		assertTrue(searchResultPage.AHMh1.getText().contains("For Sale in Pittsburgh, PA"));
		assertTrue(driver.getTitle().contains("Pittsburgh, PA New Homes For Sale"));
		// step5
		searchResultPage.AHMallBedsBtn.click();
		String actual = "";
		String expected = "Studio+ 1+ 2+ 3+ 4+";
		for (WebElement bed : searchResultPage.AHMallBedsOptions) {
			actual += bed.getText() + " ";
		}
		assertEquals(actual.trim(), expected);
		// step6
		searchResultPage.AHMallBedsOption3PLUS.click();
		assertTrue(searchResultPage.AHMh1.getText().contains("Pittsburgh, PA 3 Bedroom Homes For Sale"));

	}

	@Test(enabled = true)
	public void TC017() {
		// step1
		assertTrue(homePage.isAtURL());
		assertTrue(homePage.isAtTitle());
		assertTrue(homePage.AHMlogoSVG.isDisplayed());
		// step2
		Actions actions = new Actions(driver);
		actions.moveToElement(homePage.AHMmenuLocalScoopLink).perform();
		assertTrue(BrowserUtils.getElementsText(By.xpath("//section[@data-reactid='201']//a")).contains("Schools"));
		// step3
		homePage.AHMmenuShoolsLink.click();
		assertTrue(driver.getCurrentUrl().contains("/schools/"));
		assertTrue(driver.getTitle().contains("Public & Private Schools"));
	}

	@Test(enabled = true)
	public void TC018() {
		// step1
		assertTrue(homePage.isAtURL());
		assertTrue(homePage.isAtTitle());
		assertTrue(homePage.AHMlogoSVG.isDisplayed());
		// step2
		Actions actions = new Actions(driver);
		actions.moveToElement(homePage.AHMmenuLocalScoopLink).perform();
		assertTrue(
				BrowserUtils.getElementsText(By.xpath("//section[@data-reactid='201']//a")).contains("Market Trends"));
		// step3
		homePage.AHMmenuMarketTrendsLink.click();
		assertTrue(driver.getCurrentUrl().contains("/market-trends/"));
		assertTrue(driver.getTitle().contains("Real Estate Market Trends"));
	}

	@Test(enabled = true)
	public void TC019() {
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
		BrowserUtils.waitFor(2);
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
		BrowserUtils.waitFor(4);
		assertEquals(searchResultPage.AHMh1.getText(), "Pittsburgh, PA 1 Bedroom Open Homes");
	}

	@Test(enabled = true)
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

	

}
