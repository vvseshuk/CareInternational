package com.care.international.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProviderPage extends BasePage {
	
	public ProviderPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);		
	}
	
	@FindBy(name = "geoRegionSearch")
	private WebElement postCode_text_name;
	
	@FindBy(className = "tt-suggestion")
	private List<WebElement> suggestions;
	
	@FindBy(className = "registration-provider")
	private WebElement iWantTo_radio_class;
	
	@FindBy(xpath = "//label[text()='Childcare']/span")
	private WebElement childCare_radio_xpath;
	
	@FindBy(id = "saveEnrollmentOptionsButton")
	private WebElement save_button_id;
	
	//next pashr
	@FindBy(name = "email")
	private WebElement email_text_name;
	
	@FindBy(name = "password")
	private WebElement password_text_name;

	@FindBy(id = "memberSignUpButton")
	private WebElement signup_button_id;
	
	//next page
	@FindBy(name = "firstName")
	private WebElement firstName_text_name;
	
	@FindBy(name = "lastName")
	private WebElement lastName_text_name;
	
	@FindBy(name = "gender")
	private WebElement gender_select_name;
	
	@FindBy(name = "birthDate_input")
	private WebElement dob_text_name;

	@FindBy(xpath =  "//span[contains(text(),'to receive updates')]")
	private WebElement accept_check_xpath;
	
	@FindBy(id = "memberInformationButton")
	private WebElement info_button_id;
	
	//child care profile	
	@FindBy(xpath = "//label[@id='nannyLabel']")
	private WebElement nanny_radio_xpath;
	
	@FindBy(name = "numberChildren")
	private WebElement childrens_select_name;
	
	@FindBy(id = "services_cookingMealPreplabel")
	private WebElement cooking_check_id;
	
	@FindBy(xpath = "//span[contains(text(),'How much experience do you have?')]")
	private WebElement experience_select_xpath;
	
	@FindBy(xpath = "//span[contains(text(),'4 years experience')]")
	private WebElement fourYears_select_xpath;
	
	@FindBy(id = "ageGroups_newBornlabel")
	private WebElement ageGroup_check_id;
	
	@FindBy(id = "saveVerticalInformationButton")
	private WebElement saveVertical_button_id;
	
	//why provider
	@FindBy(xpath = "//label[contains(text(),'Not sure yet')]")
	private WebElement notSure_radio_xpath;
	
	@FindBy(xpath = "//input[@value='Next']")
	private WebElement whyProviderSave_button_xpath;
	
	
	
	//biography
	@FindBy(name = "experienceSummary")
	private WebElement experience_text_name;
	
	@FindBy(id = "profileTitle")
	private WebElement profile_text_id;
	
	@FindBy(id = "saveBiographyButton")
	private WebElement bioGraphySave_button_id;
	
	//get started	
	@FindBy(xpath = "//a[text()='Get Started!']")
	private WebElement getStart_button_xpath;

	//applications
	@FindBy(xpath = "//span[text()='Apply']")
	private WebElement apply_button_xpath;
	
	
	@FindBy(xpath = "//span[contains(text(),'Finish Instant Boost')]")
	private WebElement finish_button_xpath;
	
	@FindBy(xpath = "//a[contains(text(),'Yes, Please Stop')]")
	private WebElement yes_button_xpath;

	//photo upload
	@FindBy(xpath = "//a[contains(text(),'Upload Profile Pic')]")
	private WebElement uploadPic_button_xpath;

	@FindBy(xpath = "//a[contains(text(),' do this later')]")
	private WebElement later_button_xpath;

	//billing
	@FindBy(xpath = "//span[contains(text(),'Limited')]")
	private WebElement limited_radio_xpath;

	@FindBy(id = "responsiveUpgradeSubmitButton")
	private WebElement upgrade_button_id;

	//verify contacts
	@FindBy(xpath = "//a[contains(text(),'done, please continue')]")
	private WebElement done_button_xpath;

	//qualifications
	@FindBy(xpath = "//span[contains(text(),'Education Level')]")
	private WebElement eduLevel_select_xpath;
	
	@FindBy(xpath = "//span[contains(text(),'BTEC')]")
	private WebElement btec_select_xpath;
	
	@FindBy(xpath = "//span[contains(text(),'Native Language')]")
	private WebElement nativeLang_select_xpath;
	
	@FindBy(xpath = "//span[contains(text(),'English')]")
	private List<WebElement> english_select_xpath;
	
	@FindBy(xpath = "//span[contains(text(),'Other Language')]")
	private WebElement otherLang_select_xpath;
	
	@FindBy(xpath = "//div[contains(text(),'Experience with special needs')]")
	private WebElement specialNeeds_check_xpath;
	
	@FindBy(xpath = "//div[contains(text(),'CPR Certificate')]")
	private WebElement cpr_check_xpath;

	@FindBy(id = "saveEnrollmentOptionsButton")
	private WebElement saveEnrolOptions_button_id;
	
	//trying logout
	@FindBy(xpath = "//span[@class='listingTitle']")
	private WebElement page_loaded_xpath;
	
	@FindBy(id = "burgerMenu")
	private WebElement burgerMenu_button_id;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	private WebElement logout_button_xpath;
	
	@FindBy(xpath = "//a[@title='Close Banner']")
	private WebElement closeBanner_button_xpath;
	
	

	public void clickOnProvider() {		
		getWait().until(ExpectedConditions.presenceOfElementLocated(By.className("registration-provider")));
		iWantTo_radio_class.click();
	}
	
	public void clickOnChildCare() {
		getWait().until(ExpectedConditions.elementToBeClickable(childCare_radio_xpath));
		childCare_radio_xpath.click();
	}
	
	public void clickOnNext() {
		save_button_id.click();
	}
	
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
	
	public void enterEmail(String emailId) {
		getWait().until(ExpectedConditions.elementToBeClickable(email_text_name));
		email_text_name.sendKeys(emailId);
	}
	
	public void enterPwd(String pwd) {
		password_text_name.sendKeys(pwd);
	}
	
	public void signup(String email, String pwd) {
		enterEmail(email);
		enterPwd(pwd);
		signup_button_id.click();
	}
	
	public void giveInfo(String firstName, String lastName, String dob) {
		getWait().until(ExpectedConditions.elementToBeClickable(firstName_text_name));
		firstName_text_name.sendKeys(firstName);
		lastName_text_name.sendKeys(lastName);
		Select gender = new Select(gender_select_name);
		gender.selectByValue("Male");
		dob_text_name.sendKeys(dob);
		closeCookieBanner();
		getWait().until(ExpectedConditions.elementToBeClickable(accept_check_xpath));
		JavascriptExecutor executor = (JavascriptExecutor)getDriver();
		executor.executeScript("arguments[0].click();", accept_check_xpath);
		executor.executeScript("arguments[0].click();", info_button_id);		
	}
	
	public void createProfile() {
		getWait().until(ExpectedConditions.elementToBeClickable(nanny_radio_xpath));
		nanny_radio_xpath.click();
		Select noOfChildrens = new Select(childrens_select_name);
		noOfChildrens.selectByValue("1");
		cooking_check_id.click();
		experience_select_xpath.click();
		getWait().until(ExpectedConditions.elementToBeClickable(fourYears_select_xpath));
		fourYears_select_xpath.click();
		Actions action = new Actions(getDriver());
		action.moveToElement(ageGroup_check_id);
		ageGroup_check_id.click();
		JavascriptExecutor jsExecutor = (JavascriptExecutor)getDriver();
		jsExecutor.executeScript("arguments[0].click();", saveVertical_button_id);				
	}

	public void whyProvider() {
		getWait().until(ExpectedConditions.elementToBeClickable(notSure_radio_xpath));
		notSure_radio_xpath.click();
		whyProviderSave_button_xpath.click();
	}
	
	public void createBiography() {
		getWait().until(ExpectedConditions.elementToBeClickable(experience_text_name));
		experience_text_name.sendKeys("I am good. I am good. I am good. I am good. "
				+ "I am good. I am good. I am good. I am good. I am good. "
				+ "I am good. I am good. I am good. I am good. I am good. ");
		profile_text_id.sendKeys("I am good. I am good. I am good. I am good. "
				+ "I am good. I am good. I am good. I am good. I am good.");
		bioGraphySave_button_id.click();
	}
	
	public void getStart() {
		getWait().until(ExpectedConditions.elementToBeClickable(getStart_button_xpath));
		getStart_button_xpath.click();
	}
	
	public void doPhotoUploadLater() {
		getWait().until(ExpectedConditions.elementToBeClickable(uploadPic_button_xpath));
		uploadPic_button_xpath.click();			
		getWait().until(ExpectedConditions.elementToBeClickable(later_button_xpath));
		later_button_xpath.click();		
	}
	
	public void applyTwoJobs() {
		try {
			getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Apply']")));
			getWait().until(ExpectedConditions.elementToBeClickable(apply_button_xpath));
		} catch (TimeoutException e) {
			System.out.println("Trying to refresh the page, as it is not loading properly..");
			getDriver().navigate().refresh();
		}
		getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Apply']")));
		apply_button_xpath.click();
		getWait().until(ExpectedConditions.elementToBeClickable(apply_button_xpath));
		apply_button_xpath.click();		
		finish_button_xpath.click();
		getWait().until(ExpectedConditions.elementToBeClickable(yes_button_xpath));
		yes_button_xpath.click();		
	}
	
	public void iAmDone() {
		getWait().until(ExpectedConditions.elementToBeClickable(done_button_xpath));
		JavascriptExecutor jsExecutor = (JavascriptExecutor)getDriver();
		jsExecutor.executeScript("arguments[0].click();", done_button_xpath);
	}
	
	public void membership() {
		getWait().until(ExpectedConditions.elementToBeClickable(limited_radio_xpath));
		JavascriptExecutor jsExecutor = (JavascriptExecutor)getDriver();
		jsExecutor.executeScript("arguments[0].click();", limited_radio_xpath);
		jsExecutor.executeScript("arguments[0].click();", upgrade_button_id);
	}
	
	public void fileQualifications() {
		getWait().until(ExpectedConditions.elementToBeClickable(eduLevel_select_xpath));
		eduLevel_select_xpath.click();
		btec_select_xpath.click();
		nativeLang_select_xpath.click();
		getWait().until(ExpectedConditions.elementToBeClickable(english_select_xpath.get(0)));		
		english_select_xpath.get(0).click();
		otherLang_select_xpath.click();
		getWait().until(ExpectedConditions.elementToBeClickable(english_select_xpath.get(2)));		
		english_select_xpath.get(2).click();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
		jsExecutor.executeScript("arguments[0].click();", specialNeeds_check_xpath);
		jsExecutor.executeScript("arguments[0].click();", cpr_check_xpath);
		jsExecutor.executeScript("arguments[0].click();", saveEnrolOptions_button_id);
	}
	
	public void logout() {
		getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h3[@class='h3 title']"))); 
		getWait().until(ExpectedConditions.elementToBeClickable(burgerMenu_button_id));
		burgerMenu_button_id.click();
		getWait().until(ExpectedConditions.visibilityOf(logout_button_xpath));
		getWait().until(ExpectedConditions.elementToBeClickable(logout_button_xpath));
		System.out.println("logout is clicking..");
		JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
		jsExecutor.executeScript("arguments[0].click();", logout_button_xpath);
	}
	
	private void closeCookieBanner() {
		getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Close Banner']"))); 
		getWait().until(ExpectedConditions.elementToBeClickable(closeBanner_button_xpath));
		if (closeBanner_button_xpath.isDisplayed()) {
			closeBanner_button_xpath.click();
		}
	}
	
	
}
