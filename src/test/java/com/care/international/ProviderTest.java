package com.care.international;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.care.international.pages.ProviderPage;
import com.care.international.utils.ExcelUtil;

import jxl.read.biff.BiffException;

public class ProviderTest extends BaseTest {
	
	private ProviderPage providerPage; 
	
	@Test(dataProvider = "getProviders")
	public void createProvider(String mail, String password, String firstName, String lastName, String dob) throws Exception {		
		providerPage = new ProviderPage(getDriver(), getWait());
		providerPage.selectPostCode();
		providerPage.clickOnProvider();
		providerPage.clickOnChildCare();
		providerPage.clickOnNext();
		//sign-up
		providerPage.signup(mail, password);
		// next page provider info
		providerPage.giveInfo(firstName, lastName, dob);
		//profile
		providerPage.createProfile();
		//why provider
		providerPage.whyProvider();
		//biography
		providerPage.createBiography();
		//get start
		providerPage.getStart();
		//apply jobs
		providerPage.applyTwoJobs();
		//photo upload
		providerPage.doPhotoUploadLater();
		//membership selection
		providerPage.membership();
		providerPage.iAmDone();
		//qualifications
		providerPage.fileQualifications();
		//print member id...
		String pageSource = getDriver().getPageSource();
		int memberid = pageSource.indexOf("\"memberId\" : \"");
		System.out.println(pageSource.substring(memberid-1, memberid+23));
		//logout
		providerPage.logout();
		Thread.sleep(5000);
		//getDriver().findElement(By.xpath("//span[contains(text(),'Sign Up')]")).click();				
		
	}
	
	@DataProvider
	public Object[][] getProviders() throws BiffException, IOException {
		return ExcelUtil.read("Enrolments.xls", "Providers");
	}

}
