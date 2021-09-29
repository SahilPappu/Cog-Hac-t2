package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

	public Properties prop = new Properties();// properties object created
	InputStream readFile = null;// initialize read file to null

	public ReadProperties() throws Exception {
		// Obtain data from property file
		try {
			readFile = new FileInputStream(System.getProperty("user.dir") + "\\Resources\\config.properties");
			prop.load(readFile);
		} catch (IOException io) {
			io.printStackTrace();
		}
		// finally block to close the input.Properties file
		finally {
			if (readFile != null) {
				try {
					readFile.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
	}

	// To retrieve url from property file
	public String getUrl() throws Exception {
		String url = prop.getProperty("URL");
		return url;
	}

	// To obtain choice of Browser - Chrome or FireFox
	public String getBrowser() throws Exception {
		String browser = prop.getProperty("Browser");
		return browser;
	}

}