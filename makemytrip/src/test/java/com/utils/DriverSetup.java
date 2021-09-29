package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup { // Class to set up driver

	public static WebDriver driver; // creating driver
	public static ReadProperties read;

	public static WebDriver getWebDriver() throws Exception // function to initiate driver and choose a browser
	{
		read = new ReadProperties();
		String baseUrl = read.getUrl();

		// Scanner sc = new Scanner(System.in); // creating a scanner object to take
		// input
		// System.out.println("Enter your choice of browser: \n 1. Chrome\n 2. Firefox\n
		// 3. Edge\n");
		String choice = read.getBrowser(); // taking choice for browser

		if (choice.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Resources\\Drivers\\chromedriver.exe"); // path to chrome driver
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver(); // setting up and creating chrome driver

			driver.get(baseUrl); // open https://www.makemytrip.com/
			// sc.close(); // closing scanner object
			return driver; // return driver

		} else if (choice.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\Resources\\Drivers\\geckodriver.exe");
			// path to firefox driver
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver(); // setting up and creating firefox driver

			driver.get(baseUrl); // open https://www.makemytrip.com/
			// sc.close(); // closing scanner object
			return driver; // return driver

		} else if (choice.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "\\Resources\\Drivers\\msedgedriver.exe");
			// path to edge driver
			WebDriverManager.edgedriver().setup();
			WebDriver driver = new EdgeDriver(); // setting up and creating edge driver

			driver.get(baseUrl); // open https://www.makemytrip.com/
			// sc.close(); // closing scanner object
			return driver; // return driver

		} else {
			// sc.close(); // closing scanner object
			return driver; // return driver
		}

	}

}