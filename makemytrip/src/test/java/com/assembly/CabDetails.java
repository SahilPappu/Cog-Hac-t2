package com.assembly;

import com.utils.Highlighter;
import com.utils.ReadProperties;
import com.utils.Screenshot;
import com.utils.WriteExcelDataFile;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CabDetails {

    WebDriver driver;
    WebElement element;

    Highlighter highlight = new Highlighter();
    Screenshot ss = new Screenshot();

    public static ReadProperties read;

    public void getCabDetails(WebDriver driver, WriteExcelDataFile writeData) throws Exception {

        read = new ReadProperties();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.documentElement.scrollHeight)");
        // Scroll down the webpage

        Thread.sleep(3000);

        element = driver.findElement(By.xpath(read.prop.getProperty("SUVCheckbox")));
        highlight.highlightElement(element, driver);// Highlight element
        ss.takeScreenshot(driver, 13);
        Thread.sleep(500);
        element.click();// Check SUV checkbox
        Thread.sleep(1000);
        highlight.removeHighlight(element, driver);// Remove highlight

        Thread.sleep(1500);

        System.out.println("\n The costs of the three packages available are: ");

        int[] prices = new int[3];

        element = driver.findElement(By.xpath(read.prop.getProperty("SUV1Price")));
        highlight.highlightElement(element, driver);// Highlight element
        ss.takeScreenshot(driver, 14);
        Thread.sleep(500);
        prices[0] = Integer.parseInt(element.getText().replaceAll("[^0-9]", ""));// Get the costs of SUV1
        highlight.removeHighlight(element, driver);// Remove highlight

        js.executeScript("window.scrollTo(0, document.documentElement.scrollHeight)");

        element = driver.findElement(By.xpath(read.prop.getProperty("SUV2Price")));
        highlight.highlightElement(element, driver);// Highlight element
        ss.takeScreenshot(driver, 15);
        Thread.sleep(500);
        prices[1] = Integer.parseInt(element.getText().replaceAll("[^0-9]", ""));// Get the costs of SUV2
        highlight.removeHighlight(element, driver);// Remove highlight

        js.executeScript("window.scrollTo(0, document.documentElement.scrollHeight)");

        element = driver.findElement(By.xpath(read.prop.getProperty("SUV3Price")));
        highlight.highlightElement(element, driver);// Highlight element
        ss.takeScreenshot(driver, 16);
        Thread.sleep(500);
        prices[2] = Integer.parseInt(element.getText().replaceAll("[^0-9]", ""));// Get the costs of SUV3
        highlight.removeHighlight(element, driver);// Remove highlight

        for (int i = 0; i < prices.length; i++) {
            System.out.println("\n ₹ " + prices[i]);
        }

        Thread.sleep(1500);

        int lowerPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lowerPrice) {
                lowerPrice = prices[i];
            }
        }

        String output = "The lowest priced SUV cab comes at ₹ " + lowerPrice + ".";
        System.out.println("\n " + output);

        writeData.setCellData(0, 0, output);
    }
}
