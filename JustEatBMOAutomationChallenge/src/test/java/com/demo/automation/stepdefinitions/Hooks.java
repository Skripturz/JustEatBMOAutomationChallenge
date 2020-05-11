package com.demo.automation.stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.demo.automation.base.BaseCucumber;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends BaseCucumber {

	@Before()
	public void initialize(Scenario scenario) throws IOException {

		// this.scenarioDef = scenario;
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

	}

	@After()
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");

		}
		System.out.println("Close Driver");
		driver.close();
	}
}
