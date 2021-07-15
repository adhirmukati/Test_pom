package com.westwing.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.westwing.utility.Baseclass;

public class HomePage  extends Baseclass{
	
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		 }
	
		 
		 @FindBy(xpath="//button[@id='onetrust-accept-btn-handler']")
		public WebElement acceptCookiesBtn;
		 
		 @FindBy(xpath="//input[@type='search']")
		 public WebElement searchInput;
		 
		 @FindBy(xpath="//h1[contains(.,'Möbel')]")
		public  WebElement headerTitle;
		 
		 
	
		 
		 
		 @FindBy(xpath="//div[@data-testid='generic-product']")
		 public List<WebElement> product_List; 

		 @FindBy(xpath="//button[@data-testid='wishlist-icon']")
		 public List<WebElement> wishlist;
		 
			public String verifyHomePageTitle(){
				return driver.getTitle();
			}
			
		 
		// driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
			// driver.switchTo().frame("lo-cs-frame");
		//	Thread.sleep(5000);
		//	wait.until(ExpectedConditions
		//			.visibilityOfElementLocated(By.xpath("//input[@type='search'")));

		//	driver.findElement(By.xpath("//input[@type='search']")).sendKeys("möbel");
		//	Thread.sleep(2000);
			
		//	driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Keys.ENTER);

			
		//	driver.findElement(By.xpath(""));

		//	driver.findElement(By.xpath("//div[@role='search']/div/following-sibling::*")).click();
	//	Thread.sleep(2000);
		//driver.findElement(By.xpath("driver.findElement(By.xpath('//html')")).click();
		//   Actions action = new Actions(driver);
    //    action.moveByOffset(0, 0).click().build().perform();
	//	Thread.sleep(2000);

}
