package com.care.international.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WrongWordMessageCasePage {

	private WebDriver driver;
	private WebDriverWait wait;

	public WrongWordMessageCasePage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	}

	public void createCase(int nthCase) {
		WebElement inbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("inboxIcon")));
		Actions action = new Actions(driver);
		action.moveToElement(inbox).build().perform();
		//inbox.click();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", inbox);
		
		

		/*
		 * List<WebElement> all = wait.until(
		 * ExpectedConditions.visibilityOfAllElementsLocatedBy
		 * (By.xpath("//ul[@id='messageThreadListings']/li")));
		 * all.get(nthCase).click();
		 */

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='providerSnippet fullDescription  noJsProviderSnippet']")));
		driver.findElement(By.id("messageTextArea")).sendKeys("This is a test salesforce case creation, "
				+ "when member communication has wrong words like - sex, fuck..");
		WebElement messagePost = driver.findElement(By.id("messagePostButton"));
		jsExecutor.executeScript("arguments[0].click();", messagePost);

	}
}
