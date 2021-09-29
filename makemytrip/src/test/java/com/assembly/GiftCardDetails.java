package com.assembly;

import com.utils.Highlighter;
import com.utils.ReadExcelDataFile;
import com.utils.ReadProperties;
import com.utils.Screenshot;
import com.utils.WriteExcelDataFile;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GiftCardDetails {

    WebDriver driver;
    WebElement element;

    Highlighter highlight = new Highlighter();
    Screenshot ss = new Screenshot();
    ReadExcelDataFile readData;

    public static ReadProperties read;

    public void getGiftCards(WebDriver driver, WriteExcelDataFile writeData) throws Exception {

        read = new ReadProperties();
        readData = new ReadExcelDataFile();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");

        String name, phNo, emailId;

        name = readData.getStringCellData(3, 0);
        phNo = String.valueOf(readData.getNumericCellData(4, 0));
        emailId = readData.getStringCellData(5, 0);

        element = driver.findElement(By.xpath(read.prop.getProperty("ClickMore")));
        highlight.highlightElement(element, driver);// Highlight element
        ss.takeScreenshot(driver, 17);
        Thread.sleep(500);
        element.click();// Click "More"
        highlight.removeHighlight(element, driver);// Remove highlight

        Thread.sleep(1000);

        element = driver.findElement(By.xpath(read.prop.getProperty("GiftCards")));
        highlight.highlightElement(element, driver);// Highlight element
        ss.takeScreenshot(driver, 18);
        Thread.sleep(500);
        element.click();// Click "Gift Cards"

        Thread.sleep(1000);

        element = driver.findElement(By.xpath(read.prop.getProperty("ElementForScroll1")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        Thread.sleep(1500);

        element = driver.findElement(By.xpath(read.prop.getProperty("CorporateGiftCard")));
        highlight.highlightElement(element, driver);// Highlight element
        ss.takeScreenshot(driver, 19);
        Thread.sleep(500);
        element.click();// Click "Corporate Gift Card"

        Thread.sleep(1500);

        element = driver.findElement(By.xpath(read.prop.getProperty("ElementForScroll2")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        Thread.sleep(1000);

        element = driver.findElement(By.xpath(read.prop.getProperty("SenderNameInputBar")));
        highlight.highlightElement(element, driver);// Highlight element
        element.sendKeys(name);// Enter "John Doe" in the "SENDER'S NAME" input bar
        ss.takeScreenshot(driver, 20);
        Thread.sleep(500);
        highlight.removeHighlight(element, driver);// Remove highlight

        Thread.sleep(1000);

        element = driver.findElement(By.xpath(read.prop.getProperty("SenderPhNoInputBar")));
        highlight.highlightElement(element, driver);// Highlight element
        element.sendKeys(phNo);// Enter "8341108644" in the "SENDER'S MOBILE NUMBER" input bar
        ss.takeScreenshot(driver, 21);
        Thread.sleep(500);
        highlight.removeHighlight(element, driver);// Remove highlight

        Thread.sleep(1000);

        element = driver.findElement(By.xpath(read.prop.getProperty("SenderEmailIdInputBar")));
        highlight.highlightElement(element, driver);// Highlight element
        element.sendKeys(emailId);// Enter "JohnDoe.com" in the "SENDER'S E-MAIL ID" input bar
        ss.takeScreenshot(driver, 22);
        Thread.sleep(500);
        highlight.removeHighlight(element, driver);// Remove highlight

        Thread.sleep(1000);

        element = driver.findElement(By.xpath(read.prop.getProperty("BuyNowButton")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        // Scroll to the top of webpage

        Thread.sleep(1000);

        highlight.highlightElement(element, driver);// Highlight element
        ss.takeScreenshot(driver, 23);
        Thread.sleep(500);
        element.click();// Click the "BUY NOW" button
        highlight.removeHighlight(element, driver);// Remove highlight

        String[] errorMessage = new String[2];

        element = driver.findElement(By.xpath(read.prop.getProperty("ErrorMessage1")));
        highlight.highlightElement(element, driver);// Highlight element
        ss.takeScreenshot(driver, 24);
        Thread.sleep(500);
        errorMessage[0] = element.getText();// Get error message 1
        highlight.removeHighlight(element, driver);// Remove highlight

        Thread.sleep(1000);

        element = driver.findElement(By.xpath(read.prop.getProperty("ErrorMessage2")));
        highlight.highlightElement(element, driver);// Highlight element
        ss.takeScreenshot(driver, 25);
        Thread.sleep(500);
        errorMessage[1] = element.getText();// Get error message 2
        highlight.removeHighlight(element, driver);// Remove highlight

        String[] outputs = new String[3];

        outputs[0] = "ERROR MESSAGES DISPLAYED ARE: ";
        outputs[1] = "1. " + errorMessage[0];
        outputs[2] = "2. " + errorMessage[1];

        for (int i = 0; i < outputs.length; i++) {

            System.out.println("\n " + outputs[i]);
        }

        for (int i = 2; i < 5; i++) {
            writeData.setCellData(i, 0, outputs[i - 2]);
        }
    }
}
