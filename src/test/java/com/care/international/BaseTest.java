package com.care.international;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver webDriver) {
		this.driver = webDriver;
	}
	public WebDriverWait getWait() {
		return wait;
	}
	public void setWait(WebDriverWait wait) {
		this.wait = wait;
	}
	
	@BeforeMethod
    public void setup () {
        //Create a Chrome driver. All test classes use this.
		System.setProperty("webdriver.chrome.driver", "C:\\browsers\\chromedriver.exe");
		driver = new ChromeDriver();   
		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "C:\\browsers\\geckodriver.exe"); driver = new FirefoxDriver();
		 */
        //Create a wait. All test classes use this.
        wait = new WebDriverWait(driver, 15);
 
        //Maximize Window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://intl-stg3.care.com/en-gb/join-now");
    }
 
    @AfterMethod
    public void teardown () {
        driver.quit();
    }
	
	

}
