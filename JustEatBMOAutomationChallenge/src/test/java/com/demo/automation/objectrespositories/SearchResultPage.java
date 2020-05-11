package com.demo.automation.objectrespositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	

	public WebDriver driver;
	Actions action;
	public SearchResultPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
	}
	
	/*****WebElement Locators*****/
	//Nav Bar
	@FindBy(xpath = "//span[text()='Just Eat']")
    private WebElement justEatLogo;

	@FindBy(xpath = "//li[@data-test-id='login']/a")
    private WebElement login;
	
	@FindBy(xpath = "//li[@data-test-id='support']/a")
    private WebElement help;
	
	//Search Bar
	@FindBy(xpath = "//input[@id='dish-search']")
    private WebElement searchDishOrRestaurant;
	
	@FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;
	
	@FindBy(xpath = "(//a[text()='change location'])[1]")
    private WebElement changeLocation;

	@FindBy(xpath = "(//span[@class='c-sortBy-icon'])[2]")
    private WebElement sortBy;
	
	@FindBy(xpath = "(//input[@class='o-formControl-input'])[1]")
    private WebElement bestMatch;
	
	@FindBy(xpath = "(//input[@class='o-formControl-input'])[2]")
    private WebElement distance;
	
	@FindBy(xpath = "(//input[@class='o-formControl-input'])[3]")
    private WebElement customerRating;
	
	@FindBy(xpath = "(//input[@class='o-formControl-input'])[4]")
    private WebElement minimumOrder;
	
	@FindBy(xpath = "(//input[@class='o-formControl-input'])[5]")
    private WebElement deliveryFee;
	
	@FindBy(xpath = "//span[@data-search-count='openrestaurants']")
    private WebElement openRestaurants;

	
	
	/*****WebElement Methods*****/
    public void clickJustEatLogo(){
       justEatLogo.click();
    }
    
    public void clickLogin(){
    	login.click();
     }
    
    public void clickHelp(){
    	help.click();
     }
    
    public void enterDish(String dish){
    	searchDishOrRestaurant.sendKeys(dish);
     }
    
    public void clickSearch(){
    	searchButton.click();
     }
    
    public void clickChangeLocation(){
    	changeLocation.click();
     }
    

	public void moveToSortBy() {
		action.moveToElement(sortBy).build().perform();
	}
	
	public void clickSortByBestMatch() {
		moveToSortBy();
		bestMatch.click();
	}
	
	public void clickSortByDistance() {
		moveToSortBy();
		distance.click();
	}
	
	public void clickSortByCustomerRating() {
		moveToSortBy();
		customerRating.click();
	}
	
	public void clickSortByMinimumOrder() {
		moveToSortBy();
		minimumOrder.click();
	}
	
	public void clickSortByDeliveryFee() {
		moveToSortBy();
		deliveryFee.click();
	}
	
	public int getOpenRestaurants() {
		return Integer.parseInt(openRestaurants.getText().replaceAll("[^0-9]", ""));
	}

}
