package com.demo.automation.objectrespositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

	public WebDriver driver;
	Actions action;
	public HomePage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
	}
	
	/*****WebElement Locators*****/
	//Nav Bar
	@FindBy(xpath = "//a[@class='logo']")
    private WebElement justEatLogo;

	@FindBy(xpath = "//span[text()='For you']")
    private WebElement forYou;
	
	@FindBy(xpath = "//span[@class='header-link-text' and text()='Deliver with Just Eat']")
    private WebElement deliverWithjustEat;
	
	@FindBy(xpath = "//span[@class='header-link-text' and text()='Log in']")
    private WebElement login;
	
	@FindBy(xpath = "//span[@class='header-link-text' and text()='Help']")
    private WebElement help;
	
	//Search Bar
	@FindBy(xpath = "//input[@name='postcode']")
    private WebElement enterYourPostCodeField;
	
	@FindBy(xpath = "//span[text()='Search']")
    private WebElement searchButton;

	
	
	/*****WebElement Methods*****/
    public void clickJustEatLogo(){
       justEatLogo.click();
    }
    
    public void clickForYou(){
    	forYou.click();
     }
    
    public void clickDeliverWithjustEat(){
    	deliverWithjustEat.click();
     }
    
    public void clickLogin(){
    	login.click();
     }
    
    public void clickHelp(){
    	help.click();
     }
    
    public void enterPostalCode(String pc){
    	enterYourPostCodeField.sendKeys(pc);
     }
    
    public void clickSearch(){
    	searchButton.click();
     }
    
    
}
