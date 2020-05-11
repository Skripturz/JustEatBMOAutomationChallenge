package com.demo.automation.testrunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/java/com/demo/automation/features",
	glue="com/demo/automation/stepdefinitions", tags="@SeleniumTest",
	plugin = { "com.cucumber.listener.ExtentCucumberFormatter:Report/report.html"})
public class TestRunner {
	
	
	@BeforeClass
	public static void setUp() {
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath("report.html");
	}

	@AfterClass
	 public static void writeExtentReport() {

	 }
		
}
