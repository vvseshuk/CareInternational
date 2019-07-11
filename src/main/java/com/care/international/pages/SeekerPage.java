package com.care.international.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeekerPage extends BasePage {

	public SeekerPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	@FindBy(name = "geoRegionSearch")
	private WebElement postCode_text_name;

	@FindBy(className = "tt-suggestion")
	private List<WebElement> suggestions;

	@FindBy(className = "registration-seeker")
	private WebElement iWantTo_radio_class;

	@FindBy(xpath = "//label[text()='Childcare']/span")
	private WebElement childCare_radio_xpath;

	@FindBy(xpath = "//label[contains(text(),'What kind of childcare?')]/following::label[1]")
	private WebElement babySitter_check_xpath;

	@FindBy(xpath = "//label[contains(text(),'Pick up / Drop off')]")
	private WebElement service_check_xpath;

	@FindBy(xpath = "//label[contains(text(),'1 child')]")
	private WebElement oneChild_check_xpath;

	@FindBy(id = "saveEnrollmentOptionsButton")
	private WebElement save_button_id;

	// next page
	@FindBy(name = "firstName")
	private WebElement firstName_text_name;

	@FindBy(name = "lastName")
	private WebElement lastName_text_name;

	@FindBy(name = "email")
	private WebElement email_text_name;

	@FindBy(name = "password")
	private WebElement password_text_name;

	@FindBy(xpath = "//span[contains(text(),'to receive updates')]")
	private WebElement accept_check_xpath;

	@FindBy(id = "memberInformationButton")
	private WebElement info_button_id;

	// child information
	@FindBy(name = "verticalDetailsValues[childName0]")
	private WebElement childName_text_name;

	@FindBy(name = "birthDate0_input")
	private WebElement childDob_text_name;

	@FindBy(xpath = "//label[contains(text(),'Non-smoker')]")
	private WebElement nonSmoker_check_xpath;

	@FindBy(id = "saveVerticalDetailsButton")
	private WebElement saveVerticalDetails_button_id;

	// next page - accept few providers
	@FindBy(xpath = "//span[@class='checkButton']")
	private List<WebElement> accepts_check_xpath;

	@FindBy(xpath = "//span[@class='checkButton']")
	private WebElement singleAccept_check_xpath;

	@FindBy(xpath = "//a[contains(text(),'Skip')]")
	private WebElement skip_button_xpath;

	// next page - job details
	@FindBy(id = "formAttributeValues[jobTimes]")
	private WebElement hours_select_id;

	@FindBy(xpath = "//table[@id='jobAvailabilityMatrix']/tbody/tr[1]/td[2]/label")
	private WebElement monMorning_radio_xpath;

	@FindBy(xpath = "//table[@id='jobAvailabilityMatrix']/tbody/tr[2]/td[2]/label")
	private WebElement monAfternoon_radio_xpath;

	@FindBy(xpath = "//table[@id='jobAvailabilityMatrix']/tbody/tr[3]/td[2]/label")
	private WebElement monEvening_radio_xpath;

	@FindBy(xpath = "//table[@id='jobAvailabilityMatrix']/tbody/tr[4]/td[2]/label")
	private WebElement monNight_radio_xpath;

	@FindBy(id = "jobScheduleButton")
	private WebElement jobSchedule_button_id;

	// next page - what i am looking for
	@FindBy(name = "title")
	private WebElement title_text_name;

	@FindBy(name = "description")
	private WebElement description_text_name;

	@FindBy(id = "showInFeeds")
	private WebElement feeds_check_id;

	@FindBy(id = "editJobDescriptionButton")
	private WebElement editJob_button_id;

	// next page - membership
	@FindBy(xpath = "//span[contains(text(), 'Limited')]")
	private WebElement limited_radio_xpath;

	@FindBy(id = "responsiveUpgradeSubmitButton")
	private WebElement member_button_id;

	@FindBy(id = "burgerMenu")
	private WebElement burgerMenu_button_id;

	@FindBy(xpath = "//a[contains(text(), 'Logout')]")
	private WebElement logout_anchor_xpath;

	@FindBy(xpath = "//a[@title='Close Banner']")
	private WebElement closeBanner_button_xpath;

	@FindBy(id = "responsiveUpgradeSubmitButton")
	private WebElement upgrade_button_id;

	@FindBy(xpath = "//a[contains(text(),'do this later')]")
	private WebElement later_anchor_xpath;

	// creating cases
	@FindBy(id = "inboxIcon")
	private WebElement inbox_anchor_id;

	@FindBy(xpath = "//ul[@id='messageThreadListings']/li")
	private List<WebElement> member_li_xpath;

	@FindBy(xpath = "//div[@class='providerSnippet fullDescription  noJsProviderSnippet']")
	private WebElement snippet_div_xpath;

	@FindBy(id = "messageTextArea")
	private WebElement message_text_id;

	@FindBy(id = "messagePostButton")
	private WebElement messageSend_button_id;

	/*
	 * public void createCase(int nthCase) {
	 * getWait().until(ExpectedConditions.elementToBeClickable(By.id("inboxIcon")));
	 * WebElement inbox = getDriver().findElement(By.id("inboxIcon"));
	 * JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
	 * jsExecutor.executeScript("arguments[0].click();", inbox);
	 * 
	 * List<WebElement> all =
	 * getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(
	 * By.xpath("//ul[@id='messageThreadListings']/li"))); all.get(nthCase).click();
	 * 
	 * getWait().until(ExpectedConditions.visibilityOfElementLocated(By.
	 * xpath("//div[@class='providerSnippet fullDescription  noJsProviderSnippet']")
	 * )); getDriver().findElement(By.id("messageTextArea")).
	 * sendKeys("This is a test salesforce case creation, " +
	 * "when member communication has wrong words like - sex, fuck.."); WebElement
	 * messagePost = getDriver().findElement(By.id("messagePostButton"));
	 * jsExecutor.executeScript("arguments[0].click();", messagePost); }
	 */

	public void selectPostCode() {
		postCode_text_name.sendKeys("WAL");
		try {
			getWait().until(ExpectedConditions.visibilityOfAllElements(suggestions));
		} catch (Exception e) {
			System.out.println("Trying to refresh the page, as it is not loading properly..");
			getDriver().navigate().refresh();
			postCode_text_name.sendKeys("WAL");
		}

		getWait().until(ExpectedConditions.visibilityOfAllElements(suggestions));
		suggestions.get(0).click();
	}

	public void clickOnSeeker() {
		getWait().until(ExpectedConditions.elementToBeClickable(iWantTo_radio_class));
		iWantTo_radio_class.click();
	}

	public void clickOnChildCare() {
		getWait().until(ExpectedConditions.elementToBeClickable(childCare_radio_xpath));
		childCare_radio_xpath.click();
	}

	public void createSeeker() {
		selectPostCode();
		clickOnSeeker();
		clickOnChildCare();
		getWait().until(ExpectedConditions.visibilityOf(babySitter_check_xpath));
		babySitter_check_xpath.click();
		closeCookieBanner();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
		jsExecutor.executeScript("arguments[0].click();", service_check_xpath);
		jsExecutor.executeScript("arguments[0].click();", oneChild_check_xpath);
		jsExecutor.executeScript("arguments[0].click();", save_button_id);
	}

	public void memberInfo(String firstName, String lastName, String email, String pwd) {
		getWait().until(ExpectedConditions.elementToBeClickable(firstName_text_name));
		firstName_text_name.sendKeys(firstName);
		lastName_text_name.sendKeys(lastName);
		email_text_name.sendKeys(email);
		password_text_name.sendKeys(pwd);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
		jsExecutor.executeScript("arguments[0].click();", accept_check_xpath);
		jsExecutor.executeScript("arguments[0].click();", info_button_id);
	}

	public void enterChildDetails(String childName, String dob) {
		getWait().until(ExpectedConditions.elementToBeClickable(childName_text_name));
		childName_text_name.sendKeys(childName);
		childDob_text_name.sendKeys(dob);
		nonSmoker_check_xpath.click();
		saveVerticalDetails_button_id.click();
	}

	public void acceptTwoProviders() {
		getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class='checkButton']")));
		accepts_check_xpath.get(0).click();
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 5);
			wait.until(ExpectedConditions.invisibilityOf(accepts_check_xpath.get(0)));
		} catch (TimeoutException e) {
			getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='transitionWrapper']")));
		}
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='transitionWrapper']")));
		singleAccept_check_xpath = getWait()
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='checkButton']")));
		System.out.println("dispalyed:" + singleAccept_check_xpath.isDisplayed());
		singleAccept_check_xpath.isEnabled();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
		jsExecutor.executeScript("arguments[0].click();", singleAccept_check_xpath);
		skip_button_xpath.click();
	}

	public void createJob() {
		getWait().until(ExpectedConditions.elementToBeClickable(hours_select_id));
		Select hours = new Select(hours_select_id);
		hours.selectByValue("1");
		monMorning_radio_xpath.click();
		monAfternoon_radio_xpath.click();
		monEvening_radio_xpath.click();
		monNight_radio_xpath.click();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
		jsExecutor.executeScript("arguments[0].click();", jobSchedule_button_id);
	}

	public void giveJobDescription() {
		getWait().until(ExpectedConditions.elementToBeClickable(feeds_check_id));
		feeds_check_id.click();
		editJob_button_id.click();
	}

	public void enroll() {
		getWait().until(ExpectedConditions.elementToBeClickable(limited_radio_xpath));
		limited_radio_xpath.click();
		member_button_id.click();
	}

	private void closeCookieBanner() {
		getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Close Banner']")));
		getWait().until(ExpectedConditions.elementToBeClickable(closeBanner_button_xpath));
		if (closeBanner_button_xpath.isDisplayed()) {
			closeBanner_button_xpath.click();
		}
	}

	public void logout() {
		try {
			new WebDriverWait(getDriver(), 2).until(ExpectedConditions.visibilityOf(upgrade_button_id));
		} catch (TimeoutException e) {
			getWait().until(ExpectedConditions.visibilityOf(later_anchor_xpath));
		}
		getWait().until(ExpectedConditions.elementToBeClickable(burgerMenu_button_id));
		burgerMenu_button_id.click();
		getWait().until(ExpectedConditions.visibilityOf(logout_anchor_xpath));
		getWait().until(ExpectedConditions.elementToBeClickable(logout_anchor_xpath));
		System.out.println("logout is clicking..");
		JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
		jsExecutor.executeScript("arguments[0].click();", logout_anchor_xpath);
	}

}
