package com.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Highlighter { // Class to highlight element

    public void highlightElement(WebElement element, WebDriver driver) { // Setting style
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver; // Javascipt Executor object
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid black; background:lightblue')",
                element); // set border color to red and background coloe to yellow
    }

    public void removeHighlight(WebElement element, WebDriver driver) { // Removing Style
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver; // Javascipt Executor object
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'border: solid 2px white')", element);
        // set border color
    }
}
