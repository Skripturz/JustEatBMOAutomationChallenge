package com.demo.automation.stepdefinitions;

import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import com.demo.automation.base.BaseCucumber;
import com.demo.automation.objectrespositories.HomePage;
import com.demo.automation.objectrespositories.SearchResultPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

import static org.testng.Assert.assertTrue;

import org.junit.Assert;

@RunWith(Cucumber.class)
public class StepDefinition extends BaseCucumber {

	// private BaseCucumber base;

	String pc;
	int openRestaurants;

	@Given("^I want food in \"([^\"]*)\"$")
	public void i_want_food_in(String postCode) throws Throwable {
		System.out.println("I want food in " + postCode);
		homePage = new HomePage(driver);
		pc = postCode;
	}

	@When("^I search for restaurants$")
	public void i_search_for_restaurants() throws Throwable {

		System.out.println("Search for Restaurants");
		homePage.enterPostalCode(pc);
		homePage.clickSearch();
	}

	@Then("^I should see some restaurants in \"([^\"]*)\"$")
	public void i_should_see_some_restaurants_in(String arg1) throws Throwable {
		System.out.println("I see Restaurants");
		searchResultPage = new SearchResultPage(driver);
		openRestaurants = searchResultPage.getOpenRestaurants();
		System.out.println("There are " + openRestaurants + " Open restaurants");
		assertTrue(openRestaurants > 0);
	}

}
