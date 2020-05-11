package com.demo.automation.objectrespositories;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RestaurantPage {
	
	public WebDriver driver;
	Actions action;
	public RestaurantPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
	}
	
	/*****WebElement Locators*****/
	@FindBy(xpath = "//h1[@class='name']")
    private WebElement restaurantName;

	@FindBy(xpath = "//p[@class='cuisines']/span")
    private List<WebElement> cuisines;
	
	@FindBy(xpath = "//span[@id='postcode']")
    private WebElement postCode;
	
	//Search Bar
	@FindBy(xpath = "//a[text()='Menu']")
    private WebElement menu;
	
	@FindBy(xpath = "//a[text()='Reviews']")
    private WebElement reviews;
	
	@FindBy(xpath = "//a[text()='Info']")
    private WebElement info;

	
	
	/*****WebElement Methods*****/
    public String getRestaurantName(){
       return restaurantName.getText();
    }
    
    public ArrayList<String> getCuisines(){
    	
    	 ArrayList<String> typesOfCuisines = new ArrayList<String>();
    	 for(WebElement cu: cuisines) {
    		 typesOfCuisines.add(cu.getText());
    	 }

    	return typesOfCuisines;
     }
    
    public String getPostCode(){
    	return postCode.getText();
     }
    
    public void clickMenu(){
    	menu.click();
     }
    
    public void clickReviews(){
    	reviews.click();
     }
    
    public void clickInfo(){
    	info.click();
     }
    
}
