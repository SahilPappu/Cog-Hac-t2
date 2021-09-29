package com.assembly;

import com.utils.Highlighter;
import com.utils.ReadExcelDataFile;
import com.utils.ReadProperties;
import com.utils.Screenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchForCabs {

	WebDriver driver;
	WebElement element;

	Highlighter highlight = new Highlighter();
	Screenshot ss = new Screenshot();
	ReadExcelDataFile readData;
	ReadProperties read;

	public void inputTripData(WebDriver driver) throws Exception {

		read = new ReadProperties();
		readData = new ReadExcelDataFile();

		String fromCity, toCity;

		fromCity = readData.getStringCellData(0, 0);
		toCity = readData.getStringCellData(1, 0);

		ss.takeScreenshot(driver, 1);
		Thread.sleep(500);
		driver.manage().window().maximize();// Maximizes the window

		driver.findElement(By.xpath(read.prop.getProperty("ClickAnywhere"))).click();
		// Click anywhere in the page to close pop-up

		ss.takeScreenshot(driver, 2);
		Thread.sleep(500);

		element = driver.findElement(By.xpath(read.prop.getProperty("CabsNavigationButton")));
		highlight.highlightElement(element, driver);// Highlight element
		ss.takeScreenshot(driver, 3);
		Thread.sleep(500);
		element.click(); // Click "Cabs"
		highlight.removeHighlight(element, driver);// Remove highlight

		element = driver.findElement(By.id(read.prop.getProperty("FromCity")));
		highlight.highlightElement(element, driver);// Highlight element
		element.click();// Click the From-input bar
		highlight.removeHighlight(element, driver);// Remove highlight

		element = driver.findElement(By.xpath(read.prop.getProperty("FromCitySearchBar")));
		highlight.highlightElement(element, driver);// Highlight element
		element.sendKeys(fromCity);// Enter "Delhi" in the From-input bar
		ss.takeScreenshot(driver, 4);
		Thread.sleep(500);
		highlight.removeHighlight(element, driver);// Remove highlight

		Thread.sleep(1000);

		element = driver.findElement(By.xpath(read.prop.getProperty("FirstFromCitySearchOption")));
		highlight.highlightElement(element, driver);// Highlight element
		ss.takeScreenshot(driver, 5);
		Thread.sleep(500);
		highlight.removeHighlight(element, driver);// Remove highlight
		element.click();// Select "Delhi, India" from suggestions

		Thread.sleep(1000);

		element = driver.findElement(By.xpath(read.prop.getProperty("ToCitySearchBar")));
		highlight.highlightElement(element, driver);// Highlight element
		element.sendKeys(toCity);// Enter "Manali" in the To-input bar
		ss.takeScreenshot(driver, 6);
		Thread.sleep(500);
		highlight.removeHighlight(element, driver);// Remove highlight

		Thread.sleep(1000);

		element = driver.findElement(By.xpath(read.prop.getProperty("FirstToCitySearchOption")));
		highlight.highlightElement(element, driver);// Highlight element
		ss.takeScreenshot(driver, 7);
		Thread.sleep(500);
		highlight.removeHighlight(element, driver);// Remove highlight
		element.click();// Select "Manali, Himachal Pradesh, India" from suggestions

		Thread.sleep(1000);

		element = driver.findElement(By.xpath(read.prop.getProperty("ArrowMark")));
		highlight.highlightElement(element, driver);// Highlight element
		ss.takeScreenshot(driver, 8);
		Thread.sleep(500);
		element.click();// Click the arrow mark to navigate to the next months in Calendar
		element.click();// Click the arrow mark to navigate to the next months in Calendar
		ss.takeScreenshot(driver, 9);
		Thread.sleep(500);
		highlight.removeHighlight(element, driver);// Remove highlight

		Thread.sleep(1000);

		element = driver.findElement(By.xpath(read.prop.getProperty("DateSelection")));
		highlight.highlightElement(element, driver);// Highlight element
		ss.takeScreenshot(driver, 10);
		Thread.sleep(500);
		element.click();// Select December 23rd on the Calendar

		Thread.sleep(1000);

		element = driver.findElement(By.xpath(read.prop.getProperty("TimeSelection")));
		highlight.highlightElement(element, driver);// Highlight element
		ss.takeScreenshot(driver, 11);
		element.click();// Select 6:30 AM as pickup-time

		Thread.sleep(1000);

		element = driver.findElement(By.xpath(read.prop.getProperty("SearchButton")));
		highlight.highlightElement(element, driver);// Highlight element
		ss.takeScreenshot(driver, 12);
		Thread.sleep(500);
		element.click();// Click the "SEARCH" button
	}

}