package com.qa.basetests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class DriverBase {

	private WebDriver driver;
	public Properties config;
	private String browser;

	@BeforeSuite
	public void loadConfiguration() throws IOException {
		config = new Properties();
		FileInputStream inputFile = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\configurationfiles\\config.properties");
		config.load(inputFile);
		inputFile.close();

		browser = config.getProperty("browser");
	}

	@BeforeTest
	public void initializeWebDriver() {
		if (browser.equalsIgnoreCase("Chrome")) {
			this.driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			this.driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("FIREFOX")) {
			this.driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("SAFARI")) {
			this.driver = new SafariDriver();
		} else {
			throw new Error("The browser name should be either Chrome, Firefox, Edge, or Safari!");
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	@AfterTest
	public void closeWebDriver() {
		driver.close();
	}
}
