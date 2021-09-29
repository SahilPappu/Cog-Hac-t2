package com.hackathon.testCases;

import com.assembly.TripBooking;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.ITestResult;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;
import com.utils.WriteExcelDataFile;

public class MakeMyTripTestCase {

	static ExtentTest test;
	static ExtentReports report;

	@BeforeTest
	public static void startTest() {
		report = new ExtentReports(System.getProperty("user.dir") + "\\test-output\\ExtentReport.html");
	}

	@Test
	public static void test() throws Exception {
		TripBooking tripBooking = new TripBooking();
		WebDriver driver = tripBooking.createDriver();
		WriteExcelDataFile writeData = new WriteExcelDataFile();

		test = report.startTest("MakeMyTrip Testing");
		test.log(LogStatus.INFO, "Initializing the Browser");

		tripBooking.searchCabs(driver);
		test.log(LogStatus.INFO, "Searching for one way outstation cabs from Delhi to Manali giving date and time");
		Thread.sleep(1000);

		tripBooking.getCabsData(driver, writeData);
		test.log(LogStatus.PASS, "Selecting SUV as car type and  displaying the lowest charges");
		Thread.sleep(1000);

		tripBooking.getGiftCardsData(driver, writeData);
		test.log(LogStatus.PASS,
				"Finding Corporate Gifting in Gift Cards, filling the details with an invalid email, capturing and displaying the error message");
		Thread.sleep(1000);

		String result = tripBooking.getHotelData(driver, writeData);
		test.log(LogStatus.PASS,
				"Extracting all the numbers for Adult persons from the Hotel Booking page, storing it in a list and displaying the same");
		Thread.sleep(5000);

		assertEquals(result, "Passed");

		tripBooking.closeBrowser(driver);
		test.log(LogStatus.INFO, "Closed the Browser");
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			test.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}
	}

	@AfterTest
	public void endReport() {
		report.flush();
	}
}
