package com.assembly;

import java.util.List;

import com.utils.DriverSetup;
import com.utils.Screenshot;
import com.utils.WriteExcelDataFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TripBooking {

    Screenshot ss = new Screenshot();

    public WebDriver createDriver() throws Exception {
        WebDriver driver = DriverSetup.getWebDriver();// Calls getWebDriver method
        return driver;
    }

    public void searchCabs(WebDriver driver) throws Exception {
        SearchForCabs search = new SearchForCabs();
        search.inputTripData(driver);// Calls inputTripData method
    }

    public void getCabsData(WebDriver driver, WriteExcelDataFile writeData) throws Exception {
        CabDetails details = new CabDetails();
        details.getCabDetails(driver, writeData);// Calls getCabDetails method
    }

    public void getGiftCardsData(WebDriver driver, WriteExcelDataFile writeData) throws Exception {
        GiftCardDetails gift = new GiftCardDetails();
        gift.getGiftCards(driver, writeData);// Calls getGiftCards method
    }

    public String getHotelData(WebDriver driver, WriteExcelDataFile writeData) throws Exception {
        HotelDetails hotels = new HotelDetails();
        List<WebElement> elements = hotels.getHotelPage(driver, writeData);// Calls getHotelPage method

        if (elements != null) {
            return "Passed";
        } else {
            return "Failed";
        }
    }

    public void closeBrowser(WebDriver driver) {
        driver.close();// Close the browser
    }

}