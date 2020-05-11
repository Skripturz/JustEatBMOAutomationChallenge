package com.demo.automation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.demo.automation.objectrespositories.HomePage;
import com.demo.automation.objectrespositories.RestaurantPage;
import com.demo.automation.objectrespositories.SearchResultPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.demo.automation.constant.Constant;


public class BaseCucumber {
	
	public static WebDriver driver;
	public static Properties prop;
	protected HomePage homePage;
	protected SearchResultPage searchResultPage;
	protected RestaurantPage restaurantPage;
	
	
	static {
		prop= new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(Constant.PROPERTYFILEPATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static WebDriver initializeDriver() throws IOException {
		
		/*****Create & Load Properties File*****/
		String browserName = prop.getProperty("browser");
		
		/*****Check & Initiate Browser Driver*****/
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
					
		} else if(browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "resources/drivers/MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();	
		} 
		
		/*****Configure Driver*****/
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}


}
