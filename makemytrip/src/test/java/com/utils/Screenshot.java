package com.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot { // Class to take screenshot

    public void takeScreenshot(WebDriver driver, int name) throws IOException {

        File s = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(s,
                new File(System.getProperty("user.dir") + "\\Screenshots\\" + "Screenshot" + name + ".jpg"));
        // Save the screenshots as Screenshot(i).jpg
    }

}