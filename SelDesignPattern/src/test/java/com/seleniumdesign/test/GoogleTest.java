package com.seleniumdesign.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.seleniumdesign.pages.GoogleMainPage;
import com.seleniumdesign.pages.GoogleResultsPage;

public class GoogleTest extends BaseTest{

	private GoogleMainPage googleMainPage;
	private GoogleResultsPage googleResultsPage;
	
	@BeforeTest
	public void setPages() {
		googleMainPage = new GoogleMainPage(driver);
		googleResultsPage = new GoogleResultsPage(driver);
	}
	
	@Test(dataProvider = "inputs")
	public void testGoogleSearch(String keyword, int index) {
		
//		String keyword = "Selenium";
//		int index = 4;
		
		googleMainPage.goToPage("https://www.google.com/");
		Assert.assertTrue(googleMainPage.getSearchWidget().isDisplayed());
		
		googleMainPage.getSearchWidget().enter(keyword);
		Assert.assertTrue(googleMainPage.getSearchSuggestion().isDisplayed());
		
		googleMainPage.getSearchSuggestion().chooseSuggestionByIndex(index);
		Assert.assertTrue(googleResultsPage.getNavigationBar().isDisplayed());
		
		googleResultsPage.getNavigationBar().gotoNewsTab();
		Assert.assertTrue(googleResultsPage.getResultStatus().isDisplayed());
		
		System.out.println(googleResultsPage.getResultStatus().getResult());
	}
	
	@DataProvider
	public Object[][] inputs(){
		return new Object[][] {
			{"Selenium", 4},
			{"Docker", 3}
		};
	}
}
