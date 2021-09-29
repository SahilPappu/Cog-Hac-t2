package com.assembly;

import java.util.List;

import com.utils.Highlighter;
import com.utils.ReadProperties;
import com.utils.Screenshot;
import com.utils.WriteExcelDataFile;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HotelDetails {

    WebDriver driver;
    WebElement element;

    Highlighter highlight = new Highlighter();
    Screenshot ss = new Screenshot();

    public static ReadProperties read;

    public List<WebElement> getHotelPage(WebDriver driver, WriteExcelDataFile writeData) throws Exception {

        read = new ReadProperties();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");

        Thread.sleep(1500);

        element = driver.findElement(By.xpath(read.prop.getProperty("HotelsNavigationButton")));
        highlight.highlightElement(element, driver);// Highlight element
        ss.takeScreenshot(driver, 26);
        Thread.sleep(500);
        element.click();// Click "Hotels"
        highlight.removeHighlight(element, driver);// Remove highlight

        Thread.sleep(1500);

        element = driver.findElement(By.id(read.prop.getProperty("ClickRoomsAndGuests")));
        highlight.highlightElement(element, driver);// Highlight element
        ss.takeScreenshot(driver, 27);
        Thread.sleep(500);
        element.click();// Click "ROOMS & GUESTS"
        highlight.removeHighlight(element, driver);// Remove highlight

        Thread.sleep(1000);

        List<WebElement> adultNumbersList = driver
                .findElements(By.xpath(read.prop.getProperty("ListOfNumbersForAdults")));

        String[] outputs = new String[2];

        outputs[0] = "The numbers for Adult persons are: ";
        outputs[1] = "";

        writeData.setCellData(6, 0, outputs[0]);
        System.out.println("\n " + outputs[0] + "\n");

        for (WebElement e : adultNumbersList) {
            highlight.highlightElement(e, driver);// Highlight element
            outputs[1] += " " + e.getText();
            ss.takeScreenshot(driver, 28);
            highlight.removeHighlight(e, driver);// Remove highlight
        }

        System.out.print(outputs[1]);

        writeData.setCellData(7, 0, outputs[1]);

        ss.takeScreenshot(driver, 29);
        Thread.sleep(500);

        System.out.println("\n");

        Thread.sleep(1000);

        element = driver.findElement(By.xpath(read.prop.getProperty("ClickApply")));
        highlight.highlightElement(element, driver);// Highlight element
        ss.takeScreenshot(driver, 30);
        Thread.sleep(500);
        element.click();// Click "APPLY"

        return adultNumbersList;
    }
}
