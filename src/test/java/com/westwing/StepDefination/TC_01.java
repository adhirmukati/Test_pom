package com.westwing.StepDefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_01 {
	
		
		WebDriver driver;
		WebDriverWait wait;

		@BeforeClass
		public void setUpBrowser() {
			String path = System.getProperty("user.dir");
			System.out.println(path);
			;
			System.setProperty("webdriver.chrome.driver", path + "//driver//chromedriver 2");
			driver = new ChromeDriver();
			wait = new WebDriverWait(driver, 30);
		}

		@Test
		public void OpenUrl() {
			driver.get("https://www.westwingnow.de");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		@Test 
		public void search() throws InterruptedException {
			driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
			// driver.switchTo().frame("lo-cs-frame");
			Thread.sleep(5000);
		//	wait.until(ExpectedConditions
		//			.visibilityOfElementLocated(By.xpath("//input[@type='search'")));

			driver.findElement(By.xpath("//input[@type='search']")).sendKeys("möbel");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Keys.ENTER);

			
			driver.findElement(By.xpath("//h1[contains(.,'Möbel')]"));

		//	driver.findElement(By.xpath("//div[@role='search']/div/following-sibling::*")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("driver.findElement(By.xpath('//html')")).click();
		   Actions action = new Actions(driver);
           action.moveByOffset(0, 0).click().build().perform();
		Thread.sleep(2000);

		
		List <WebElement >  products = driver.findElements(By.xpath("//div[@data-testid='generic-product']"));
			
			List<WebElement> wishlistIcon = driver.findElements(By.xpath("//button[@data-testid='wishlist-icon']"));
				
			
				
		wishlistIcon.get(1).click();
		
		Thread.sleep(2000);

		wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//p[contains(.,'Neukunde?')]")));		
		
		driver.findElement(By.xpath("//button[@data-testid='login_reg_switch_btn']")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//p[contains(.,'Bereits registriert?')]")));
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("adhirmukati59@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Qait@1234");
		
		driver.findElement(By.xpath("//button[@data-testid='login_reg_submit_btn']")).click();
		
		
		
	String str=	driver.findElement(By.xpath("//span[@data-testid='wishlist-counter']")).getText();
	
		if(str.contains("1")) {
			System.out.println("passed ");
			
		}
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[contains(.,'Wunschliste')]")).click();
		Thread.sleep(2000);

		
		driver.findElement(By.xpath("//ul[@class='listProducts']/li/button")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[contains(.,'Mein Konto')]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[contains(.,'Abmelden')]")).click();
		}
		
		
		
	}


