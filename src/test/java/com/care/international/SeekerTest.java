package com.care.international;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.care.international.pages.SeekerPage;
import com.care.international.pages.WrongWordMessageCasePage;
import com.care.international.utils.ExcelUtil;

import jxl.read.biff.BiffException;

public class SeekerTest extends BaseTest {

	private SeekerPage seekerPage;

	@Test(dataProvider = "getSeekers")
	public void createSeeker(String mail, String password, String firstName, String lastName, String childName,
			String dob, String noOfCases) throws Exception {
		seekerPage = new SeekerPage(getDriver(), getWait());
		seekerPage.createSeeker();
		seekerPage.memberInfo(firstName, lastName, mail, password);
		seekerPage.enterChildDetails(childName, dob);
		seekerPage.acceptTwoProviders();
		seekerPage.createJob();
		seekerPage.giveJobDescription();
		seekerPage.enroll();
		// print member id...
		String pageSource = getDriver().getPageSource();
		int memberid = pageSource.indexOf("\"memberId\" : \"");
		System.out.println(pageSource.substring(memberid - 1, memberid + 23));
		for (int nthCase = 1; nthCase <= Integer.parseInt(noOfCases); nthCase++) {
			WrongWordMessageCasePage casePage = new WrongWordMessageCasePage(getDriver(), getWait());
			casePage.createCase(nthCase-1);
			casePage = null;
		}
		seekerPage.logout();		
	}	

	@DataProvider
	public Object[][] getSeekers() throws BiffException, IOException {
		return ExcelUtil.read("Enrolments.xls", "Seekers");
	}
}
