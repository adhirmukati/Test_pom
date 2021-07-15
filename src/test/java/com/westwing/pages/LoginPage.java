package com.westwing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.westwing.utility.Baseclass;

public class LoginPage extends Baseclass {

	  public LoginPage(WebDriver driver) {
		    PageFactory.initElements(driver, this);

		  }
	  
	  @FindBy(xpath ="//p[contains(.,'Neukunde?')]")
	  public WebElement registrationPageHeader;
	  
	  @FindBy(xpath="//button[@data-testid='login_reg_switch_btn']")
	  public WebElement loginButton;
	  
	  @FindBy(xpath="//p[contains(.,'Bereits registriert?')]")
	  public WebElement registrationHead;
		
	  @FindBy(xpath="//input[@name='email']")
	  public WebElement email;
	  
	  
	  @FindBy(xpath="//input[@name='password']")
	  public WebElement password;
	  @FindBy(xpath="//button[@data-testid='login_reg_submit_btn']")
	  public WebElement submitButton;
	  
	
	  @FindBy(xpath="//span[@data-testid='wishlist-counter']")
	  public WebElement wishlistCounter;
	  
	  @FindBy(xpath="//span[contains(.,'Wunschliste')]")
	  public WebElement wishlistLink;	
	
	  @FindBy(xpath="//ul[@class='listProducts']/li/button")
	  public WebElement productListDeleteButton;	
	
	  @FindBy(xpath="//span[contains(.,'Mein Konto')]")
	  public WebElement meinKonto;
		
		
	  @FindBy(xpath="//span[contains(.,'Abmelden')]")
	  public WebElement signout;
	
		
	  
	  
	  
	  
	  
	  
	  
	
	
	

}
