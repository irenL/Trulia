package com.trulia.tests;

import org.testng.annotations.Test;

import com.trulia.pages.HomePage;

public class TestAhmed {
	HomePage homePage = new HomePage();
	
	@Test
	public void test1() {
		homePage.AHMsignIn.click();
	}
}
