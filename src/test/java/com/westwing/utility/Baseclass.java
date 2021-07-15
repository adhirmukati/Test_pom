package com.westwing.utility;

import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Baseclass {

	public static WebDriver driver;
	WebDriverWait wait;
	
	public WebDriver getdriver() {
		return driver;
	}
   

	public void launchBrowser(String browserName) {		
	       System.out.println(System.getProperty("os.name"));
	       String str = System.getProperty("os.name");

	if (browserName.equalsIgnoreCase("chrome") &&   str.equalsIgnoreCase("Mac OS X"))
{
			String path = System.getProperty("user.dir");
			System.out.println(path);
			System.setProperty("webdriver.chrome.driver", path + "//driver//chromedriver 2");
			driver = new ChromeDriver();
			wait = new WebDriverWait(driver, 30);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} else if (browserName.equalsIgnoreCase("chrome") && str.contains("Win")) {
			String path = System.getProperty("user.dir");
			System.out.println(path);
			System.setProperty("webdriver.chrome.driver", path + "//driver//chromedriver.exe");
			driver = new ChromeDriver();
			wait = new WebDriverWait(driver, 30);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else if (browserName.equalsIgnoreCase("safari") && str.equalsIgnoreCase("Mac OS X")) {

			String path = System.getProperty("user.dir");
			System.out.println(path);
			System.setProperty("webdriver.chrome.driver", path + "\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			wait = new WebDriverWait(driver, 30);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
		else if (browserName.equalsIgnoreCase("dockerChrome")) {

			DesiredCapabilities dc = DesiredCapabilities.chrome();
			try {
				URL url = new  URL("http://localhost:4444/wd/hub");
				driver = new RemoteWebDriver(dc);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//String path = System.getProperty("user.dir");
			//System.out.println(path);
			//System.setProperty("webdriver.chrome.driver", path + "\\driver\\chromedriver.exe");
			//driver = new ChromeDriver();
			wait = new WebDriverWait(driver, 30);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

	}



	public void launchURl(String URl, String title) {
		driver.get(URl);
		//assertEquals(title, driver.getTitle());
	}

	public boolean click(WebElement we ) {
		fluentWait(we,"10");
		we.click();
		return true;
	}
	
	public boolean typeText(WebElement we, String str ) {
		fluentWait(we,"10");
		we.clear();
		we.sendKeys(str);
		return true;

	}
	
	public boolean pressEnter(WebElement we) {
		fluentWait(we,"10");
		we.sendKeys(Keys.ENTER);
		return true;

	}

	private boolean fluentWait(WebElement we, String string) {
		// TODO Auto-generated method stub
		
		try {
			FluentWait <WebDriver> wait = new FluentWait<WebDriver>(driver);
				wait.withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofMillis(50));
				wait.until(ExpectedConditions.visibilityOf(we));
				return true;
		}
		catch(Exception e) {
			return false;
		}
		
		
		
	}
	
	
	public boolean isDisplayed(List<WebElement> el) {

	    for ( WebElement we: el) { 
	    	fluentWait(we,"10");
	        if ( we.isDisplayed() && el.size() > 1) {
	        	
	        	return true;
	        }
	    }
		return false;
	}
	
	public boolean actionClick()  {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		   Actions action = new Actions(driver);
           action.moveByOffset(0, 0).click().build().perform();
           System.out.println("passed clicked");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;

	}
	
	
	public boolean clickedonListofWebElmeent(List<WebElement> el, int a) {
int  count =0;
	    for ( WebElement we: el) { 
	    	fluentWait(we,"10");
	        if ( we.isDisplayed() &&  a== count) {
	        	we.click();
	        	count++;
	        	return true;
	        }
	    }
		return false;
	}



	public void waitForElementToVisible(WebElement we) {
		wait.until(ExpectedConditions
				.visibilityOf(we));			
	}



	public boolean getText(WebElement wishlistCounter) {
		fluentWait(wishlistCounter,"10");
		String str =wishlistCounter.getText();
		if (str.equals("1")) {
			return true;
		}
		return false;
		
	}
	public void actionHold(WebElement we) {
		Actions act = new Actions (driver);
		act.moveToElement(we).build().perform();
		act.clickAndHold();
	}
	
	public void hardWait(int a) {
		try {
			Thread.sleep(a);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String propertyFileReader(String value) {
		
		  String propertyFilePath= "configs//Configuration.properties";
		 Properties properties;
		   FileReader reader;
		   String str = null;
		try {
			reader = new FileReader("config.properties");
		
		      
		    properties =new Properties();  
		    properties.load(reader); 
		    str =properties.getProperty(value);
		   // return properties.getProperty(value);
		      
		   // System.out.println(properties.getProperty("user"));  
		  //  System.out.println(properties.getProperty("password"));  
		}
		    catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return str; 
		}  

}
